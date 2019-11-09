package mike.emptyclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Thursday extends AppCompatActivity {
private AdView adv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thursday);
        adv5=(AdView)findViewById(R.id.adView4);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6710974821067422~5213432195");
        AdRequest adRequest4 = new AdRequest.Builder()
                .build();
        adv5.loadAd(adRequest4);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.homeButton:
                Intent goHome=new Intent(Thursday.this, chooseDay.class);
                startActivity(goHome);
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        if (adv5 != null) {
            adv5.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adv5 != null) {
            adv5.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adv5 != null) {
            adv5.destroy();
        }
        super.onDestroy();
    }
}
