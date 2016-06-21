package org.apache.struts.gps.action;

import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.gps.model.Position;
import org.apache.struts.gps.service.GpsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GpsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
    private static double CURRENT_RANGE = 0.200;
	
	public void gps() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		
		String ip = request.getLocalAddr();
		String accuracy = request.getParameter("accuracy");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String datetime = request.getParameter("datetime");
		String timezone = request.getParameter("timezone");
		
		Position pos = new Position();
		pos.setAccuracy(new BigDecimal(accuracy));
		pos.setLatitude(Double.valueOf(latitude).doubleValue());
		pos.setLongitude(Double.valueOf(longitude).doubleValue());
		pos.setDatetime(datetime);
		pos.setTimezone(timezone);
		pos.setIp(ip);
		
		GpsService gpsService = new GpsService();
		double dst = gpsService.geodeticTransform(pos);
		
		if(dst <= CURRENT_RANGE){
			
		}
		
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		out.write(String.valueOf(dst));
	}
}
