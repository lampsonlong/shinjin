package org.apache.struts.gps.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.common.util.CommonUtil;
import org.apache.struts.gps.constant.GpsConstant;
import org.apache.struts.gps.model.MasterPoint;
import org.apache.struts.gps.model.Position;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private MasterPoint masterPoint;
	
	private int ret;
	
	private Map<String, Position> ipMap;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		CommonUtil util = new CommonUtil();
		HttpSession session = request.getSession();
		
		String latitude = request.getParameter("masterPoint.latitude");
		String longitude = request.getParameter("masterPoint.longitude");
		String ticketnumber = request.getParameter("masterPoint.allTicket");
		String radius = request.getParameter("masterPoint.radius");
		
		if(util.isNullOrEmpty(latitude)
				|| util.isNullOrEmpty(longitude) 
				|| util.isNullOrEmpty(ticketnumber)
				|| util.isNullOrEmpty(radius)) {
			return "mlogin";
		}
		
		try {
			masterPoint = new MasterPoint();
			masterPoint.setLatitude(Double.valueOf(latitude).doubleValue());
			masterPoint.setLongitude(Double.valueOf(longitude).doubleValue());
			masterPoint.setTicket(Integer.parseInt(ticketnumber));
			masterPoint.setAllTicket(Integer.parseInt(ticketnumber));
			masterPoint.setRadius(Double.valueOf(radius).doubleValue());
		} catch (Exception e){
			ret = -1;
			return SUCCESS;
		}
		
		GpsConstant.setMasterPoint(masterPoint);
		session.setAttribute("setMaster", "OK");
		ret = 0;
		// reset ipList
		GpsConstant.setTicketIpList(null);
		
		return SUCCESS;
	}
	
	public String mview() throws Exception {
		masterPoint = new MasterPoint();
		setIpMap(new HashMap<String, Position>());
		
		setIpMap(GpsConstant.getTicketIpList());
		setMasterPoint(GpsConstant.getMasterPoint());
		
		if(masterPoint == null){
			return "master";
		}
		
		return SUCCESS;
	}
	
	public String mview2master() throws Exception {
		masterPoint = new MasterPoint();
		
		setMasterPoint(GpsConstant.getMasterPoint());
		
		return SUCCESS;
	}


	public MasterPoint getMasterPoint() {
		return masterPoint;
	}

	public void setMasterPoint(MasterPoint masterPoint) {
		this.masterPoint = masterPoint;
	}

	public Map<String, Position> getIpMap() {
		return ipMap;
	}

	public void setIpMap(Map<String, Position> ipMap) {
		this.ipMap = ipMap;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}
}
