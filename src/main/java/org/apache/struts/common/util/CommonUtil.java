package org.apache.struts.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.gps.constant.GpsConstant;


public class CommonUtil {
	
	private static char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

	public boolean isNullOrEmpty(String str){
		boolean ret = false;
		
		if(str == null || str.isEmpty()){
			ret = true;
		}
		
		return ret;
	}
	
	public boolean isLogin(HttpSession session){
		boolean ret = false;
		
		Object userInfo = session.getAttribute("userInfo");
		
		if(userInfo != null){
			if(userInfo.toString().equals(GpsConstant.getUserinfo())){
				ret = true;
			}
		}
		
		return ret;
	}
	
	public long getGMTMillis(){
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		long millis = date.getTime();
		
		return millis;
	}
	
	public static String base10to62(long number, int length){
        Long rest=number;
        Stack<Character> stack=new Stack<Character>();
        StringBuilder result=new StringBuilder(0);
        while(rest!=0){
            stack.add(charSet[new Long((rest-(rest/62)*62)).intValue()]);
            rest=rest/62;
        }
        for(;!stack.isEmpty();){
            result.append(stack.pop());
        }
        int result_length = result.length();
        StringBuilder temp0 = new StringBuilder();
        for(int i = 0; i < length - result_length; i++){
            temp0.append('0');
        }
        
        return temp0.toString() + result.toString();
    }
	
	public  String getIpAddr(HttpServletRequest request)  {
	  String ip  =  request.getHeader("x-forwarded-for");
	  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	      ip  =  request.getHeader("Proxy-Client-IP ");
	  }   
	  if (ip == null || ip.length() == 0 || "unknown ".equalsIgnoreCase(ip)) {
	      ip  =  request.getHeader("WL-Proxy-Client-IP");
	  }   
	  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	     ip  =  request.getRemoteAddr();
	  }   
	  return  ip;
    }  
}
