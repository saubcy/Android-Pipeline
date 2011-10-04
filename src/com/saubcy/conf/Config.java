package com.saubcy.conf;

import com.saubcy.pipeline.ads.AdsManager;
import com.saubcy.pipeline.gold.GoldManager;
import com.saubcy.pipeline.stat.StatManager;

public class Config
{
	public static GoldManager gm = new GoldManager();
	
	public static AdsManager.Offers AdOffer = AdsManager.Offers.NONE;
	
	public static GoldManager.Offers GoldOffer = GoldManager.Offers.NONE;
	
	public static StatManager.Offers StatOffer = StatManager.Offers.UMENG;
	
    public static boolean getLOGGING() {
    	return true;
    }
    
    public static boolean getTESTMODE() {
    	return false;
    }
     
    public static AdsManager.Offers getOffer() {
    	return AdOffer;
    }
    
    public static GoldManager.Offers getGoldOffer() {
    	return GoldOffer;
    }
    
    public static StatManager.Offers getStatOffer() {
    	return StatOffer;
    }
    
    // AD OFFSER IDS
    public static String getAdwo_PID() {
    	return "${config.ads.adwo.pid}";
    }
    
    public static String getAdMob_PID() {
    	return "${config.ads.admob.pid}";
    }
    
    public static String getYoumi_APPID() {
    	return "${config.ads.youmi.appid}";
    }
    
    public static String getYoumi_APPSEC() {
    	return "${config.ads.youmi.appsec}";
    }
    
    public static String getAppMedia_PID() {
    	return "${config.ads.appmedia.pid}";
    }
    
    // GOLD OFFER IDS
    public static String getYoumi_Gold_APPID() {
    	return "${config.gold.youmi.appid}";
    }
    
    public static String getYoumi_Gold_APPSEC() {
    	return "${config.gold.youmi.appsec}";
    }
    
    public static String getWiyun_Gold_APPID() {
    	return "${config.gold.wiyun.appid}";
    }
    
    public static String getWiyun_Gold_APPSEC() {
    	return "${config.gold.wiyun.appsec}";
    }
    
    public static String getTapjoy_Gold_APPID() {
    	return "${config.gold.tapjoy.appid}";
    }
    
    public static String getTapjoy_Gold_APPSEC() {
    	return "${config.gold.tapjoy.appsec}";
    }
}