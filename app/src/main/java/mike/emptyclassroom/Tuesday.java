package mike.emptyclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Tuesday extends AppCompatActivity {
private AdView adv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tuesday);
adv3=(AdView)findViewById(R.id.adView2);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6710974821067422~5213432195");
        AdRequest adRequest2 = new AdRequest.Builder()
                .build();
        adv3.loadAd(adRequest2);

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
                Intent goHome=new Intent(Tuesday.this, chooseDay.class);
                startActivity(goHome);
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPause() {
        if (adv3 != null) {
            adv3.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adv3 != null) {
            adv3.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adv3 != null) {
            adv3.destroy();
        }
        super.onDestroy();
    }

}
