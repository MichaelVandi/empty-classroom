package mike.emptyclassroom;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Friday extends AppCompatActivity {
private AdView adv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friday);
        adv6=(AdView)findViewById(R.id.adView5);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6710974821067422~5213432195");
        AdRequest adRequest5 = new AdRequest.Builder()
                .build();
        adv6.loadAd(adRequest5);

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
                Intent goHome=new Intent(Friday.this, chooseDay.class);
                startActivity(goHome);
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPause() {
        if (adv6 != null) {
            adv6.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adv6 != null) {
            adv6.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adv6 != null) {
            adv6.destroy();
        }
        super.onDestroy();
    }
}
