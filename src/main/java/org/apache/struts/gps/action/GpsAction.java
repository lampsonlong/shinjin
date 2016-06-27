package org.apache.struts.gps.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.gps.model.Position;
import org.apache.struts.gps.service.GpsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GpsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
    private static double CURRENT_RANGE = 0.500;
    
    private static List<String> ticketIpList;
    
    private Position position;
    
    private String errMsg;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		HttpSession session = request.getSession();
		
		String ip2 = request.getRemoteAddr();
		String accuracy = request.getParameter("accuracy");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String datetime = request.getParameter("datetime");
		
		if(ip2 == null ||
		    accuracy == null ||
			latitude == null ||
			longitude == null ||
			datetime == null) {
			errMsg = "Error : Session Timeout! Please Try Again!";
		}
		
		position = new Position();
		position.setAccuracy(new BigDecimal(accuracy));
		position.setLatitude(Double.valueOf(latitude).doubleValue());
		position.setLongitude(Double.valueOf(longitude).doubleValue());
		position.setDatetime(datetime);
		position.setIp(ip2);
		
		GpsService gpsService = new GpsService();
		
		double dst = 0;
		dst = gpsService.geodeticTransform(position);
		
		
		if(dst == -1){
			errMsg = "Error : No Master Data! Please Wait A Moment And Try Again!";
			position = null;
		} else {
			if (dst <= CURRENT_RANGE){
				List<String> tIpList = getTicketIpList();
				if(tIpList == null){
					tIpList = new ArrayList<String>();
				}
				if(tIpList.size() > 0 && tIpList.contains(ip2)){
					// have already got
					position.setDst(dst);
					errMsg = "Sorry, You Have Already Got The Ticket!";
					return SUCCESS;
				}
				
				// check OK
				boolean hasTicket = GpsService.getMasterTicketMinus();
				if(hasTicket){
					errMsg = "Congratulations! You Get The Ticket!";
					tIpList.add(ip2);
					setTicketIpList(tIpList);
				} else {
					errMsg = "Sorry, No Ticket!";
				}
				
			} else {
				errMsg = "Out Of Range!";
				// out of range
			}
			
			position.setDst(dst);
		}
		
		return SUCCESS;
	}
	
    public Position getPosition() {
        return position;
    }
 
    public void setPosition(Position position) {
        this.position = position;
    }

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public static List<String> getTicketIpList() {
		return ticketIpList;
	}

	public static void setTicketIpList(List<String> ticketIpList) {
		GpsAction.ticketIpList = ticketIpList;
	}
}
