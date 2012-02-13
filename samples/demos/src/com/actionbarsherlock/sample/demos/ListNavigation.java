package com.actionbarsherlock.sample.demos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

public class ListNavigation extends SherlockActivity implements ActionBar.OnNavigationListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(SampleList.THEME); //Used for theme switching in samples
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        //NOTE: It is very important that you use 'sherlock_spinner_item' here
        //      and NOT 'simple_spinner_item' or you will see text color problems
        ArrayAdapter<CharSequence> list = ArrayAdapter.createFromResource(this, R.array.locations, R.layout.sherlock_spinner_item);
        list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getSupportActionBar().setListNavigationCallbacks(list, this);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        ((TextView)findViewById(R.id.text)).setText("Selected: " + itemPosition);
        return true;
    }
}
