package com.example.myapplication;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabHostActivity extends TabActivity {//AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);
        tabHost.addTab(tabSpecSong);
/*
        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("ARTIST별");
        tabSpecSong.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("ALBUM별");
        tabSpecSong.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);*/
    }
}
