package com.saubcy.conf;

import com.saubcy.ads.AdsFactory;
import com.saubcy.gold.GoldFactory;

public class Config
{
    public final static boolean LOGGING = true;
    
    public final static boolean TESTMODE = true;
     
    public final static AdsFactory.Offers offer = AdsFactory.Offers.NONE;
    
    public final static GoldFactory.Offers offerG = GoldFactory.Offers.YOUMI;
    
    // AD OFFSER IDS
    public final static String Adwo_PID = "${config.ads.adwo.pid}";
    
    public final static String AdMob_PID = "${config.ads.admob.pid}";
    
    public final static String Youmi_APPID = "${config.ads.youmi.appid}";
    public final static String Youmi_APPSEC = "${config.ads.youmi.appsec}";
    
    public final static String AppMedia_PID = "${config.ads.appmedia.pid}";
    
    // GOLD OFFER IDS
    public final static String Youmi_Gold_APPID = "your youmi gold appid";
    public final static String Youmi_Gold_APPSEC = "your youmi gold appsec";
}