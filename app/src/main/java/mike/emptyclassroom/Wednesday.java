package mike.emptyclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Wednesday extends AppCompatActivity {
private AdView adv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wednesday);
        adv4=(AdView)findViewById(R.id.adView3);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6710974821067422~5213432195");
        AdRequest adRequest3 = new AdRequest.Builder()
                .build();
        adv4.loadAd(adRequest3);
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
                Intent goHome=new Intent(Wednesday.this, chooseDay.class);
                startActivity(goHome);
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPause() {
        if (adv4 != null) {
            adv4.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adv4 != null) {
            adv4.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adv4 != null) {
            adv4.destroy();
        }
        super.onDestroy();
    }

}
