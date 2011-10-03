package com.saubcy.conf;

import com.saubcy.ads.AdsFactory;
import com.saubcy.gold.GoldFactory;

public class Config
{
    public final static boolean LOGGING = @CONFIG.LOGGING@;
    
    public final static boolean TESTMODE = @CONFIG.TESTMODE@;
     
    public final static AdsFactory.Offers offer = @CONFIG.OFFER@;
    
    public final static GoldFactory.Offers offerG = @CONFIG.GOLD@;
    
    // AD OFFSER IDS
    public final static String Adwo_PID = "@CONFIG.ADS.ADWO.PID@";
    
    public final static String AdMob_PID = "@CONFIG.ADS.ADMOB.PID@";
    
    public final static String Youmi_APPID = "@CONFIG.ADS.YOUMI.APPID@";
    public final static String Youmi_APPSEC = "@CONFIG.ADS.YOUMI.APPSEC@";
    
    public final static String AppMedia_PID = "@CONFIG.ADS.APPMEDIA.PID@";
    
    // GOLD OFFER IDS
    public final static String Youmi_Gold_APPID = "@CONFIG.GOLD.YOUMI.APPID@";
    public final static String Youmi_Gold_APPSEC = "@CONFIG.GOLD.YOUMI.APPSEC@";
}