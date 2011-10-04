package com.saubcy.conf;

import com.saubcy.pipeline.ads.AdsManager;
import com.saubcy.pipeline.gold.GoldManager;
import com.saubcy.pipeline.stat.StatManager;

public class Config
{
	public static GoldManager gm = new GoldManager();
	
	public static AdsManager.Offers AdOffer = @CONFIG.OFFER@;
	
	public static GoldManager.Offers GoldOffer = @CONFIG.GOLD@;
	
	public static StatManager.Offers StatOffer = @CONFIG.STAT@;
	
    public static boolean getLOGGING() {
    	return @CONFIG.LOGGING@;
    }
    
    public static boolean getTESTMODE() {
    	return @CONFIG.TESTMODE@;
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
    	return "@CONFIG.ADS.ADWO.PID@";
    }
    
    public static String getAdMob_PID() {
    	return "@CONFIG.ADS.ADMOB.PID@";
    }
    
    public static String getYoumi_APPID() {
    	return "@CONFIG.ADS.YOUMI.APPID@";
    }
    
    public static String getYoumi_APPSEC() {
    	return "@CONFIG.ADS.YOUMI.APPSEC@";
    }
    
    public static String getAppMedia_PID() {
    	return "@CONFIG.ADS.APPMEDIA.PID@";
    }
    
    // GOLD OFFER IDS
    public static String getYoumi_Gold_APPID() {
    	return "@CONFIG.GOLD.YOUMI.APPID@";
    }
    
    public static String getYoumi_Gold_APPSEC() {
    	return "@CONFIG.GOLD.YOUMI.APPSEC@";
    }
    
    public static String getWiyun_Gold_APPID() {
    	return "@CONFIG.GOLD.WIYUN.APPID@";
    }
    
    public static String getWiyun_Gold_APPSEC() {
    	return "@CONFIG.GOLD.WIYUN.APPSEC@";
    }
    
    public static String getTapjoy_Gold_APPID() {
    	return "@CONFIG.GOLD.TAPJOY.APPID@";
    }
    
    public static String getTapjoy_Gold_APPSEC() {
    	return "@CONFIG.GOLD.TAPJOY.APPSEC@";
    }
}