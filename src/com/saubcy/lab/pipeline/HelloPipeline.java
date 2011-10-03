package com.saubcy.lab.pipeline;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saubcy.ads.AdsFactory;
import com.saubcy.conf.Config;
import com.saubcy.gold.GoldFactory;

public class HelloPipeline extends Activity {
	private View adView = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		loadViews();
	}

	private void loadViews() {
		setContentView(R.layout.main);

		LinearLayout adLayout = 
				(LinearLayout)findViewById(R.id.AdLinearLayout);
		TextView tv = (TextView)findViewById(R.id.goldinfo);
		AdsFactory.showAds(Config.offer, this, adLayout, adView);

		GoldFactory.init(Config.offerG, this);
		tv.setText("gold is: "+GoldFactory.getGold());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, 0, 0, "walls");
		menu.add(0, 1, 1, "spend 10");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			GoldFactory.showOffer(Config.offerG, this);
			return true;
		case 1:
			GoldFactory.spendGold(Config.offerG, this, 10);
			return true;
		}
		
		return false;
	}

	
}