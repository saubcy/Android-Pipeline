package com.saubcy.conf;

import com.saubcy.pipeline.ads.AdsManager;
import com.saubcy.pipeline.gold.GoldManager;
import com.saubcy.pipeline.stat.StatManager;

public class Config
{
	public static GoldManager gm = new GoldManager();
	
	public static AdsManager.Offers AdOffer = AdsManager.Offers.MOMARK;
	
	public static GoldManager.Offers GoldOffer = GoldManager.Offers.NONE;
	
	public static StatManager.Offers StatOffer = StatManager.Offers.NONE;
	
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
    
    public static String getWIYUN_WIADID() {
		return "${config.ads.wiyun.wiadid}";
	}
    
    public static String getADULTMODA_BANNER_ZONEID() {
		return "${config.ads.adultmoda.banner.zoneid}";
	}
	
	public static String getADULTMODA_TEXT_ZONEID() {
		return "${config.ads.adultmoda.text.zoneid}";
	}
	
	public static String getMOMARK_APPID() {
		return "e4eae2f6bb40540a";
	}
	
	public static String getMOMARK_DEVID() {
		return "db0aef70f73ad480";
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
    
    public static String getMiidi_APPID() {
		return "${config.ads.miidi.appid}";
	}
	
	public static String getMiidi_APPSEC() {
		return "${config.ads.miidi.appsec}";
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
    
    public static String getMiidi_Gold_APPID() {
		return "${config.gold.miidi.appid}";
	}
	
	public static String getMiidi_Gold_APPSEC() {
		return "${config.gold.miidi.appsec}";
	}
}