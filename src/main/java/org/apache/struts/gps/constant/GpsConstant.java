package org.apache.struts.gps.constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts.common.util.CommonUtil;
import org.apache.struts.gps.model.MasterPoint;
import org.apache.struts.gps.model.Position;

public class GpsConstant {
    
    private static Map<String, Position> ticketIpList;
    
    private static MasterPoint masterPoint;
	
	private static final String pwd = "a123";
	
	private static String userInfo = "bPfeWr1!asd53K0";
	
	private static List<String> kubunCodeList;

	public static Map<String, Position> getTicketIpList() {
		return ticketIpList;
	}

	public static void setTicketIpList(Map<String, Position> ticketIpList) {
		GpsConstant.ticketIpList = ticketIpList;
	}

	public static MasterPoint getMasterPoint() {
		return masterPoint;
	}

	public static void setMasterPoint(MasterPoint masterPoint) {
		GpsConstant.masterPoint = masterPoint;
	}
	
	public static String getMasterTicketMinus(String cd){
		int mt = masterPoint.getTicket();
		if(mt > 0){
			mt --;
			String kubuncd = cd + String.valueOf(mt);
			kubuncd = CommonUtil.base10to62(Long.valueOf(kubuncd),0);
			
			if(kubunCodeList == null){
				kubunCodeList = new ArrayList<String>();
			}
			kubunCodeList.add(kubuncd);
			masterPoint.setTicket(mt);
			return kubuncd;
		} else {
			return null;
		}
	}

	public static String getPwd() {
		return pwd;
	}

	public static String getUserinfo() {
		return userInfo;
	}

	public static void setUserinfo(String userInfo) {
		GpsConstant.userInfo = userInfo;
	}

	public static List<String> getKubunCodeList() {
		return kubunCodeList;
	}

	public static void setKubunCodeList(List<String> kubunCodeList) {
		GpsConstant.kubunCodeList = kubunCodeList;
	}
}
