package com.saubcy.ads;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.saubcy.conf.Config;

public class AdsFactory {

	private static final String TAG = "TRACE_AdsFactory_";
	
	private static boolean isYoumiInit = false;
	private static boolean isAppMediaInit = false;

	public enum Offers {
		NONE, ADMOB, ADWO, YOUMI, APPMEDIA
	};

	public static void showAds(Offers offer, 
			Activity content, 
			LinearLayout layout, 
			View adView) {
		switch (offer) {
		case ADMOB:
			showADMOB(content, layout, adView);
			break;
		case ADWO:
			showADWO(content, layout, adView);
			break;
		case YOUMI:
			showYOUMI(content, layout, adView);
			break;
		case APPMEDIA:
			showAPPMEDIA(content, layout, adView);
			break;
		}
	}

	public static void destoryAds(View adView) {

	}

	private static void showADWO(Activity content, 
			LinearLayout layout, 
			View adView) {
		String TAG_USE = TAG + "showADWO";

		if ( Config.LOGGING ) {
			Log.d(TAG_USE, "add adwo pid: "+Config.Adwo_PID);
		}
		try {
			Class<?> AdwoAdView = 
					Class.forName("com.adwo.adsdk.AdwoAdView");

			Object[] args = new Object[6];
			args[0] = content.getApplicationContext();
			args[1] = Config.Adwo_PID;
			args[2] = 0x0040080;
			args[3] = 0x00FF0000;
			args[4] = Config.TESTMODE;
			args[5] = 30;

			Class<?>[] argsClass = new Class[args.length];
			argsClass[0] = android.content.Context.class;
			argsClass[1] = java.lang.String.class;
			argsClass[2] = int.class;
			argsClass[3] = int.class;
			argsClass[4] = boolean.class;
			argsClass[5] = int.class;

			if ( Config.LOGGING ) {
				for (int i=0; i<args.length; ++i) {
					Log.d(TAG_USE, "input param name: " 
							+ argsClass[i].getName());
				}
				Constructor<?>[] conslist = AdwoAdView.getConstructors();
				for (int i=0; i<conslist.length; ++i) {
					Log.d(TAG_USE, "constructor name: " + conslist[i].getName());
					Class<?>[] params = conslist[i].getParameterTypes();
					for (int j=0; j<params.length; ++j) {
						Log.d(TAG_USE, "param name: " + params[j].getName());
					}
				}
			}

			Constructor<?> cons = AdwoAdView.getConstructor(argsClass);
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "Constructor get successful");
			}
			adView = (View) cons.newInstance(args);
			if ( null == adView ) {
				if ( Config.LOGGING ) {
					Log.d(TAG_USE, "ads instance get failed");
				}
			} else {
				layout.addView(adView, new LayoutParams(LayoutParams.FILL_PARENT,
						LayoutParams.WRAP_CONTENT) );
			}
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
				Log.d(TAG, "NoSuchMethodException");
			}
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
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

	private static void showADMOB(Activity content, 
			LinearLayout layout, 
			View adView) {
		String TAG_USE = TAG + "showADMOB";

		if ( Config.LOGGING ) {
			Log.d(TAG_USE, "add AdMob PID: "+Config.AdMob_PID);
		}
		try {
			Class<?> AdView = 
					Class.forName("com.google.ads.AdView");
			Class<?> AdSize = 
					Class.forName("com.google.ads.AdSize");
			Class<?> AdRequest =
					Class.forName("com.google.ads.AdRequest");

			Field field = AdSize.getField("BANNER");

			Object[] args = new Object[3];
			args[0] = content;
			args[1] = field.get(AdSize);;
			args[2] = Config.AdMob_PID;
			//
			Class<?>[] argsClass = new Class[args.length];
			argsClass[0] = android.app.Activity.class;
			argsClass[1] = AdSize;
			argsClass[2] = java.lang.String.class;

			if ( Config.LOGGING ) {
				for (int i=0; i<args.length; ++i) {
					Log.d(TAG_USE, "input param name: " 
							+ argsClass[i].getName());
				}
				Constructor<?>[] conslist = AdView.getConstructors();
				Log.d(TAG_USE, "constructor number: " + conslist.length);
				for (int i=0; i<conslist.length; ++i) {
					Log.d(TAG_USE, "constructor name: " + conslist[i].getName());
					Class<?>[] params = conslist[i].getParameterTypes();
					for (int j=0; j<params.length; ++j) {
						Log.d(TAG_USE, "param name: " + params[j].getName());
					}
				}
			}

			Constructor<?> cons = AdView.getConstructor(argsClass);
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "Constructor get successful");
			}
			adView = (View) cons.newInstance(args);
			if ( null == adView ) {
				if ( Config.LOGGING ) {
					Log.d(TAG_USE, "ads instance get failed");
				}
			} else {
				layout.addView(adView, new LayoutParams(LayoutParams.FILL_PARENT,
						LayoutParams.WRAP_CONTENT) );
			}

			args = new Object[1];
			args[0] = AdRequest.newInstance();
			argsClass = new Class[args.length];
			argsClass[0] = AdRequest;
			if ( Config.LOGGING ) {
				Method[] methods = AdView.getMethods();
				for (int i=0; i<methods.length; ++i) {
					Log.d(TAG_USE, "method name: " + methods[i].getName());
					Class<?>[] params = methods[i].getParameterTypes();
					for (int j=0; j<params.length; ++j) {
						Log.d(TAG_USE, "param name: " + params[j].getName());
					}
				}
			}

			Method method = AdView.getMethod("loadAd", argsClass);
			method.invoke(adView, args);
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
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "IllegalArgumentException");
			}
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	private static void showYOUMI(Activity content, 
			LinearLayout layout, 
			View adView) {
		initYOUMI();
		String TAG_USE = TAG + "showYOUMI";

		if ( Config.LOGGING ) {
			Log.d(TAG_USE, "add youmi");
		}
		try {
			Class<?> AdView = 
					Class.forName("net.youmi.android.AdView");

			Object[] args = new Object[1];
			args[0] = content;

			Class<?>[] argsClass = new Class[args.length];
			argsClass[0] = android.app.Activity.class;

			Constructor<?> cons = AdView.getConstructor(argsClass);
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "Constructor get successful");
			}
			adView = (View) cons.newInstance(args);
			if ( null == adView ) {
				if ( Config.LOGGING ) {
					Log.d(TAG_USE, "ads instance get failed");
				}
			} else {
				layout.addView(adView, new LayoutParams(LayoutParams.FILL_PARENT,
						LayoutParams.WRAP_CONTENT) );
			}
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
				Log.d(TAG, "NoSuchMethodException");
			}
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
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
	
	private static void initYOUMI() {
		if ( isYoumiInit ) {
			return;
		}
		String TAG_USE = TAG + "initYOUMI";

		if ( Config.LOGGING ) {
			Log.d(TAG_USE, "init youmi appid: "+Config.Youmi_APPID);
			Log.d(TAG_USE, "init youmi appsec: "+Config.Youmi_APPSEC);
		}
		try {
			Class<?> AdManager = 
					Class.forName("net.youmi.android.AdManager");

			Object[] args = new Object[4];
			args[0] = Config.Youmi_APPID;
			args[1] = Config.Youmi_APPSEC;
			args[2] = 30;
			args[3] = Config.TESTMODE;

			Class<?>[] argsClass = new Class[args.length];
			argsClass[0] = java.lang.String.class;
			argsClass[1] = java.lang.String.class;
			argsClass[2] = int.class;
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
				Log.d(TAG, "NoSuchMethodException");
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
	
	private static void showAPPMEDIA(Activity content, 
			LinearLayout layout, 
			View adView) {
		initAPPMEDIA();
		String TAG_USE = TAG + "showAPPMEDIA";

		if ( Config.LOGGING ) {
			Log.d(TAG_USE, "add appmedia");
		}
		try {
			Class<?> BannerAdView = 
					Class.forName("cn.appmedia.ad.BannerAdView");

			Object[] args = new Object[1];
			args[0] = content;

			Class<?>[] argsClass = new Class[args.length];
			argsClass[0] = android.content.Context.class;

			Constructor<?> cons = BannerAdView.getConstructor(argsClass);
			if ( Config.LOGGING ) {
				Log.d(TAG_USE, "Constructor get successful");
			}
			adView = (View) cons.newInstance(args);
			if ( null == adView ) {
				if ( Config.LOGGING ) {
					Log.d(TAG_USE, "ads instance get failed");
				}
			} else {
				layout.addView(adView, new LayoutParams(LayoutParams.FILL_PARENT,
						LayoutParams.WRAP_CONTENT) );
			}
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
				Log.d(TAG, "NoSuchMethodException");
			}
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
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
	
	private static void initAPPMEDIA() {
		String TAG_USE = TAG + "initAPPMEDIA";
		if ( isAppMediaInit ) {
			Log.d(TAG_USE, "already inited");
			return;
		}

		if ( Config.LOGGING ) {
			Log.d(TAG_USE, "init appmedia pid: "+Config.AppMedia_PID);
		}
		try {
			Class<?> AdManager = 
					Class.forName("cn.appmedia.ad.AdManager");

			Object[] args = new Object[1];
			args[0] = Config.AppMedia_PID;

			Class<?>[] argsClass = new Class[args.length];
			argsClass[0] = java.lang.String.class;

			Method method = AdManager.getMethod("setAid", argsClass);
			method.invoke(null, args);
			isAppMediaInit = true;
			
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
				Log.d(TAG, "NoSuchMethodException");
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
}
