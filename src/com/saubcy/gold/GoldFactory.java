package com.saubcy.gold;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.saubcy.conf.Config;

import android.app.Activity;
import android.util.Log;

public class GoldFactory {

	private static final String TAG = "TRACE_GoldFactory_";

	public enum Offers {
		NONE, YOUMI
	};

	private static int golds = 0;
	
	private static boolean isYoumiInit = false;

	public static int getGold() {
		return golds;
	}

	public static void init(Offers offer, 
			Activity content) {
		switch (offer) {
		case YOUMI:
			initYOUMI(content);
			break;
		}
	}

	public static void showOffer(Offers offer, 
			Activity content) {
		switch (offer) {
		case YOUMI:
			showOfferYOUMI(content);
			break;
		}
	}

	public static void refreshGold(Offers offer, 
			Activity content) {
		switch (offer) {
		case YOUMI:
			refreshYOUMI(content);
			break;
		}
	}
	
	public static boolean spendGold(Offers offer, 
			Activity content, int amount) {
		
		switch (offer) {
		case YOUMI:
			return spendGoldYOUMI(content, amount);
		}
		return false;
	}

	private static void initYOUMI(Activity content) {
		String TAG_USE = TAG + "initYOUMI";

		if ( Config.LOGGING ) {
			Log.d(TAG_USE, "init youmi pid: "+Config.Youmi_Gold_APPID);
			Log.d(TAG_USE, "init youmi sec: "+Config.Youmi_Gold_APPSEC);
		}
		try {
			Class<?> AdManager = 
					Class.forName("net.youmi.android.appoffers.AppOffersManager");

			Object[] args = new Object[4];
			args[0] = content;
			args[1] = Config.Youmi_Gold_APPID;
			args[2] = Config.Youmi_Gold_APPSEC;
			args[3] = Config.TESTMODE;

			Class<?>[] argsClass = new Class[args.length];
			argsClass[0] = android.app.Activity.class;
			argsClass[1] = java.lang.String.class;
			argsClass[2] = java.lang.String.class;
			argsClass[3] = boolean.class;

			Method method = AdManager.getMethod("init", argsClass);
			method.invoke(null, args);
			
			isYoumiInit = true;

		} catch (ClassNotFoundException e) {
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "ClassNotFoundException");
			}
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "NoSuchMethodException");
			}
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private static void showOfferYOUMI(Activity content) {
		String TAG_USE = TAG + "showOfferYOUMI";

		if ( !isYoumiInit ) {
			return;
		}
		
		try {
			Class<?> AdManager = 
					Class.forName("net.youmi.android.appoffers.AppOffersManager");

			Object[] args = new Object[1];
			args[0] = content;

			Class<?>[] argsClass = new Class[args.length];
			argsClass[0] = android.content.Context.class;

			Method method = AdManager.getMethod("showAppOffers", argsClass);
			method.invoke(null, args);

		} catch (ClassNotFoundException e) {
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "ClassNotFoundException");
			}
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "NoSuchMethodException");
			}
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private static void refreshYOUMI(Activity content) {
		String TAG_USE = TAG + "showOfferYOUMI";

		if ( !isYoumiInit ) {
			return;
		}
		
		try {
			Class<?> AdManager = 
					Class.forName("net.youmi.android.appoffers.AppOffersManager");

			Object[] args = new Object[1];
			args[0] = content;

			Class<?>[] argsClass = new Class[args.length];
			argsClass[0] = android.content.Context.class;

			Method method = AdManager.getMethod("getPoints", argsClass);
			golds = Integer.parseInt(method.invoke(null, args).toString());

		} catch (ClassNotFoundException e) {
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "ClassNotFoundException");
			}
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "NoSuchMethodException");
			}
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private static boolean spendGoldYOUMI(Activity content, 
			int amount) {
		String TAG_USE = TAG + "spendGoldYOUMI";
		
		if ( !isYoumiInit ) {
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "youmi is not init");
			}
			return false;
		}
		
		if ( golds < amount ) {
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "gold is not enough");
			}
			return false;
		}
		
		try {
			Class<?> AdManager = 
					Class.forName("net.youmi.android.appoffers.AppOffersManager");

			Object[] args = new Object[2];
			args[0] = content;
			args[1] = amount;

			Class<?>[] argsClass = new Class[args.length];
			argsClass[0] = android.content.Context.class;
			argsClass[1] = int.class;

			Method method = AdManager.getMethod("spendPoints", argsClass);
			return ((Boolean)method.invoke(null, args)).booleanValue();

		} catch (ClassNotFoundException e) {
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "ClassNotFoundException");
			}
			e.printStackTrace();
			return false;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (NoSuchMethodException e) {
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "NoSuchMethodException");
			}
			e.printStackTrace();
			return false;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}
}
