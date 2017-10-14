package ourgames.kwarapay;

/**
 * Created by User on 7/24/2017.
 */

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QTWebView extends Activity implements View.OnTouchListener,Handler.Callback{

    //FOR ONTOUCH SUPPORT
    private static final int CLICK_ON_WEBVIEW = 1;
    private static final int CLICK_ON_URL = 2;
    private final Handler handler = new Handler(this);
    private WebView webView;
    private WebViewClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewz);

        webView = (WebView) findViewById(R.id.web1);
        webView.setOnTouchListener(this);

        client = new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                handler.sendEmptyMessage(CLICK_ON_URL);
                return
                        false;
            }
        };
        webView.setWebViewClient(client);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);

        //optional javascript
        webSettings.setJavaScriptEnabled(true);


        //optional progress bar

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        // WebChromeClient reports in range 0-100
        final TextView titleTextView = (TextView) findViewById(R.id.titleTextView);

        webView.setWebChromeClient(new WebChromeClient() {
                                       public void onProgressChanged(WebView webView, int progress) {
                                           if (progress == 100){
                                               progressBar.setVisibility(View.INVISIBLE);
                                           } else

                                           {
                                               progressBar.setVisibility(View.VISIBLE);
                                               progressBar.setProgress(progress);
                                           }
                                       }

                                       public void onReceivedTitle(WebView webView, String title) {
                                           titleTextView.setText(title);
                                       }
                                   }
        );


        webView.loadUrl("https://www.quickteller.com");
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if
                (v.getId() == R.id.web1 && event.getAction() == MotionEvent.ACTION_DOWN) {
            handler.sendEmptyMessageDelayed(CLICK_ON_WEBVIEW, 500);
        }
        return
                false;
    }
    @Override
    public boolean handleMessage(Message msg){
        if
                (msg.what==CLICK_ON_URL) {
            handler.removeMessages(CLICK_ON_WEBVIEW);
            return
                    true;
        }
        if (msg.what==CLICK_ON_WEBVIEW) {
            Toast.makeText(this, "WebView clicked", Toast.LENGTH_SHORT).show();
            return
                    true;
        }
        return
                false;

    }
    //FOR BACK KEY
    @Override
    public void onBackPressed(){
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        }
        else{
            finish();
        }
    }

}


