package org.apache.struts.gps.action;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.gps.model.Position;
import org.apache.struts.gps.service.GpsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GpsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
    private static double CURRENT_RANGE = 0.200;
    
    private Position position;
    
    private String errMsg;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		HttpSession session = request.getSession();
		
		if(session.isNew()){
			
		}
		
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
			return SUCCESS;
			//return ERROR;
		} else {
			if (dst <= CURRENT_RANGE){
				// ok
			} else {
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
}
