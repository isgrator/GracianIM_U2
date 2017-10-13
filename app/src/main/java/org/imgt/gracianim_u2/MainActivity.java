package org.imgt.gracianim_u2;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Resources res= getResources();
        String titleTab1= res.getString(R.string.asteroides);
        String titleTab2= res.getString(R.string.constraintlayout);
        String titleTab3= res.getString(R.string.bot_n_personalizado);
        String titleTab4= res.getString(R.string.calculadora);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup(this,
                getSupportFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(titleTab1),
                Tab1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator(titleTab2),
                Tab2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator(titleTab3),
                Tab3.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator(titleTab4),
                Tab4.class, null);
    }
}
