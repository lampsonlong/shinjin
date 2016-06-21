package org.apache.struts.gps.action;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.gps.model.Position;
import org.apache.struts.gps.service.GpsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GpsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
    private static double CURRENT_RANGE = 0.200;
    
    private Position position;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		String ip = request.getLocalAddr();
		String ip2 = request.getRemoteAddr();
		String accuracy = request.getParameter("accuracy");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String datetime = request.getParameter("datetime");
		String timezone = request.getParameter("timezone");
		
		position = new Position();
		position.setAccuracy(new BigDecimal(accuracy));
		position.setLatitude(Double.valueOf(latitude).doubleValue());
		position.setLongitude(Double.valueOf(longitude).doubleValue());
		position.setDatetime(datetime);
		position.setTimezone(timezone);
		position.setIp(ip2);
		
		GpsService gpsService = new GpsService();
		position.setDst(gpsService.geodeticTransform(position));
		
		if(position.getDst() <= CURRENT_RANGE){
			
		}
		
		//response.setHeader("content-type", "text/html;charset=UTF-8");
		//response.setCharacterEncoding("UTF-8");
		//PrintWriter out = response.getWriter();
		//out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		//out.write(String.valueOf(dst));
		return SUCCESS;
	}
	
    public Position getPosition() {
        return position;
    }
 
    public void setPosition(Position position) {
        this.position = position;
    }
}
