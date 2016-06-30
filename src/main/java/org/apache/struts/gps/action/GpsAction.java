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
    
    private int errCode = -9999;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		CommonUtil util = new CommonUtil();
		
		String ip = util.getIpAddr(request);
		String accuracy = request.getParameter("position.accuracy");
		String latitude = request.getParameter("position.latitude");
		String longitude = request.getParameter("position.longitude");
		String nowtimeNoSlash = util.getNow("yyyyMMddHHmmss");
		String nowtimeSlash = util.getNow("yyyy-MM-dd HH:mm:ss");
		
		Map<String, Position> ipList = GpsConstant.getTicketIpList();
		if (ipList != null) {
			if(ipList.size() > 0 && ipList.containsKey(ip)){
				position = new Position();
				setPosition(ipList.get(ip));
				setErrCode(1);
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
			position.setDatetime(nowtimeSlash);
			position.setIp(ip);
			
			GpsService gpsService = new GpsService();
			
			double dst = 0;
			dst = gpsService.geodeticTransform(position);
			
			
			if(dst == -1){
				setErrCode(-1);
				position = null;
			} else {
				if (dst <= GpsConstant.getMasterPoint().getRadius()/1000){
					Map<String, Position> tIpList = GpsConstant.getTicketIpList();
					if(tIpList == null){
						tIpList = new HashMap<String,Position>();
					}
					
					// check OK
					String kbcode = GpsConstant.getMasterTicketMinus(nowtimeNoSlash);
					
					if(kbcode != null){
						position.setKbcode(kbcode);
						setErrCode(0);
						tIpList.put(ip, position);
						GpsConstant.setTicketIpList(tIpList);
					} else {
						setErrCode(-2);
					}
					
				} else {
					dst = dst - GpsConstant.getMasterPoint().getRadius()/1000;
					setErrCode(-3);
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


	public int getErrCode() {
		return errCode;
	}


	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
}
