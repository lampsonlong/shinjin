package org.apache.struts.gps.service;

import org.apache.struts.gps.model.MasterPoint;
import org.apache.struts.gps.model.Position;
import org.apache.struts.gps.util.GeodeticTransformUtil;

public class GpsService {
	
	private static double EARTH_RADIUS = 6378.137;
	
	public static MasterPoint masterpoint;

    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

	public double geodeticTransform(Position pPos){
		double plat;
        double plon;
        double mlat = 31.176012;
        double mlon = 121.408798;
        double dst;
        
        if (masterpoint != null) {
        	mlat = masterpoint.getLatitude();
        	mlon = masterpoint.getLongitude();
        } else {
        	return -1;
        }
        
        plat = pPos.getLatitude();
        plon = pPos.getLongitude();
        		
        Position pos = new Position();
        GeodeticTransformUtil gtUtil = new GeodeticTransformUtil();
        
		pos = gtUtil.transform2Mars(plat, plon, pos);
        pos = gtUtil.bd_encrypt(pos.getLatitude(), pos.getLongitude(), pos);
        
        dst = GetDistance(mlat, mlon, pos.getLatitude(), pos.getLongitude());
        
        return dst;
	}
	
	public static double GetDistance(double lat1, double lng1, double lat2, double lng2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
            Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000);
        s = s / 10000;
        return s;
    }
}
