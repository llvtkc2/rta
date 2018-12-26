package rta.abc.com.rta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRate();
    }
    private void initRate(){
        RateThisApp.Config config = new RateThisApp.Config(1, 5);
        String urlRate = "https://play.google.com/store/apps/details?id="+BuildConfig.APPLICATION_ID;
        config.setUrl(urlRate);
        RateThisApp.init(config);
        RateThisApp.onCreate(this);

        try {
            RateThisApp.showRateDialogIfNeeded(this,R.style.Translucent);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void onBackPressed() {
        if(!RateThisApp.isRate(this)){
            RateThisApp.showRateDialogOnBack(this);
        }else {
            super.onBackPressed();
        }

    }
}
