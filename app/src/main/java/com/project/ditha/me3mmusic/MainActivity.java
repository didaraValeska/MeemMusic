package com.project.ditha.me3mmusic;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.action4);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        browser = (WebView) findViewById(R.id.webView);
        browser.setWebChromeClient(new WebChromeClient());
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setDomStorageEnabled(true);
        browser.getSettings().setAllowFileAccessFromFileURLs(true);
        browser.getSettings().setAllowUniversalAccessFromFileURLs(true);
        browser.loadUrl("http://www.youtube.com/channel/UCrWwpoNZgczbh0f2LOOsTRw");
        browser.setWebViewClient(new WebViewClient(){
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Toast.makeText(getApplicationContext(), "Loading page...", Toast.LENGTH_SHORT).show();
                browser.setVisibility(View.GONE);
            }
            @Override
            public void onPageFinished(WebView view, String url){
                Toast.makeText(getApplicationContext(), "page is Loaded.", Toast.LENGTH_SHORT).show();
                browser.setVisibility(View.VISIBLE);
            }
            public void onReceivedError(WebView webView, int i, String s, String s1){
                Toast.makeText(getApplicationContext(), "Internet Tidak Tersambung...", Toast.LENGTH_SHORT).show();
            }
        });


//        public boolean onCreateOptionsMenu(Menu menu){
//            MenuInflater inflater = getMenuInflater();
//            inflater.inflate(R.menu.optionmenu, menu);
//            return true;
//        }
//
//        public boolean onOptionsItemSelected(MenuItem item){
//            if (item.getItemid()==R.id.facebook){
//
//            }
//        }
    }
}
