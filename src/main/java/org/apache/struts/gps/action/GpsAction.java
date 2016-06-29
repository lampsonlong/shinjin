package org.apache.struts.gps.action;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.common.util.CommonUtil;
import org.apache.struts.gps.constant.GpsConstant;
import org.apache.struts.gps.model.Position;
import org.apache.struts.gps.service.GpsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GpsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
    
    private Position position;
    
    private String errMsg;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		CommonUtil util = new CommonUtil();
		
		String ip = util.getIpAddr(request);
		String accuracy = request.getParameter("position.accuracy");
		String latitude = request.getParameter("position.latitude");
		String longitude = request.getParameter("position.longitude");
		String nowtime = util.getNow();
		
		Map<String, Position> ipList = GpsConstant.getTicketIpList();
		if (ipList != null) {
			if(ipList.size() > 0 && ipList.containsKey(ip)){
				position = new Position();
				setPosition(ipList.get(ip));
				errMsg = "You Got The Ticket!";
				return SUCCESS;
			}
		}
		
		if (accuracy == null ||
				latitude == null ||
				longitude == null) {
			return SUCCESS;
		} else {
			position = new Position();
			position.setAccuracy(new BigDecimal(accuracy));
			position.setLatitude(Double.valueOf(latitude).doubleValue());
			position.setLongitude(Double.valueOf(longitude).doubleValue());
			position.setDatetime(nowtime);
			position.setIp(ip);
			
			GpsService gpsService = new GpsService();
			
			double dst = 0;
			dst = gpsService.geodeticTransform(position);
			
			
			if(dst == -1){
				errMsg = "Error : No Master Data! Please Wait A Moment And Try Again!";
				position = null;
			} else {
				if (dst <= GpsConstant.getMasterPoint().getRadius()/1000){
					Map<String, Position> tIpList = GpsConstant.getTicketIpList();
					if(tIpList == null){
						tIpList = new HashMap<String,Position>();
					}
					
					// check OK
					String kbcode = GpsConstant.getMasterTicketMinus(nowtime);
					
					if(kbcode != null){
						position.setKbcode(kbcode);
						errMsg = "Congratulations! You Get The Ticket!";
						tIpList.put(ip, position);
						GpsConstant.setTicketIpList(tIpList);
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
	}
	
    
    public String init() throws Exception {
    	HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
    	
    	String ip = request.getRemoteAddr();
    	position = new Position();
    	
    	Map<String, Position> tIpList = GpsConstant.getTicketIpList();
		if(tIpList != null){
			if(tIpList.size() > 0 && tIpList.containsKey(ip)){
				setPosition(tIpList.get(ip));
			}
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
}
