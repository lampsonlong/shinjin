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
    
    private int ret = -9999;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		CommonUtil util = new CommonUtil();
		
		String ip = util.getIpAddr(request);
		String latitude = request.getParameter("position.latitude");
		String longitude = request.getParameter("position.longitude");
		String nowTimeGMT = String.valueOf(util.getGMTMillis());
		
		Map<String, Position> ipList = GpsConstant.getTicketIpList();
		if (ipList != null) {
			if(ipList.size() > 0 && ipList.containsKey(ip)){
				position = new Position();
				setPosition(ipList.get(ip));
				setRet(1);
				return SUCCESS;
			}
		}
		
		if (latitude == null || longitude == null) {
			setRet(9);
			return SUCCESS;
		} else {
			position = new Position();
			
			try{
			position.setLatitude(Double.valueOf(latitude).doubleValue());
			position.setLongitude(Double.valueOf(longitude).doubleValue());
			} catch (Exception e){
				return SUCCESS;
			}
			
			position.setDatetime(nowTimeGMT);
			position.setIp(ip);
			
			
			GpsService gpsService = new GpsService();
			
			double dst = 0;
			dst = gpsService.geodeticTransform(position);
			
			if(dst == -1){
				setRet(-1);
				position = null;
			} else {
				if (dst <= GpsConstant.getMasterPoint().getRadius()/1000){
					Map<String, Position> tIpList = GpsConstant.getTicketIpList();
					if(tIpList == null){
						tIpList = new HashMap<String,Position>();
					}
					
					String kbcode = GpsConstant.getMasterTicketMinus(nowTimeGMT);
					
					if(kbcode != null){
						// check OK
						position.setKbcode(kbcode);
						setRet(0);
						tIpList.put(ip, position);
						GpsConstant.setTicketIpList(tIpList);
					} else {
						// no code
						setRet(-2);
					}
					
				} else {
					// out of range
					dst = new BigDecimal(dst - GpsConstant.getMasterPoint().getRadius()*0.001).setScale(4, BigDecimal.ROUND_CEILING).doubleValue();
					setRet(-3);
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

	public int getRet() {
		return ret;
	}


	public void setRet(int ret) {
		this.ret = ret;
	}
}
