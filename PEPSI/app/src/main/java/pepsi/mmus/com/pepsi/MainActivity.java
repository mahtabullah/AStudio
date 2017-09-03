package pepsi.mmus.com.pepsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=(WebView)  findViewById(R.id.webviewID);

        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("http://www.tbldurbin.com/home/home_page");

    }

    @Override
    public void onBackPressed() {
       if(webView.canGoBack()){
           webView.goBack();

       }else{
           super.onBackPressed();
       }
    }
}
