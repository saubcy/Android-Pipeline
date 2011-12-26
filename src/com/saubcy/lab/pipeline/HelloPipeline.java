package com.saubcy.lab.pipeline;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.saubcy.conf.Config;
import com.saubcy.pipeline.ads.AdsManager;
import com.saubcy.pipeline.gold.GoldNotifier;
import com.saubcy.pipeline.stat.StatManager;

public class HelloPipeline extends Activity 
implements GoldNotifier{
	private View adView = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
		loadViews();
	}
	
	private void init() {
		StatManager.onInit(Config.getStatOffer(), this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		StatManager.onPause(Config.getStatOffer(), this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		StatManager.onResume(Config.getStatOffer(), this);
	}

	private void loadViews() {
		setContentView(R.layout.main);

		LinearLayout adLayout = 
				(LinearLayout)findViewById(R.id.AdLinearLayout);
		AdsManager.showAds(Config.getOffer(), this, adLayout, adView);

		Config.gm.setIcon(R.drawable.icon);
		Config.gm.init(Config.getGoldOffer(), this);
		Config.gm.refreshGold(Config.getGoldOffer(), this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, 0, 0, "walls");
		menu.add(0, 1, 1, "spend 1");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			Config.gm.showOffer(Config.getGoldOffer(), this);
			return true;
		case 1:
			Config.gm.spendGold(Config.getGoldOffer(), this, 1);
			return true;
		}

		return false;
	}

	@Override
	public void notifyUpdate(int num) {
		Log.d("trace", "gold change: "+num
				+" gold have: "+Config.gm.getGold());
	}

	@Override
	public void notifyFailed(String reason) {
		if ( Config.getLOGGING() ) {
			Log.d("trace", "failed: "+reason);
		}
	}

	@Override
	protected void onDestroy() {
		AdsManager.destoryAds(Config.getOffer(), adView, this);
		super.onDestroy();
	}
}