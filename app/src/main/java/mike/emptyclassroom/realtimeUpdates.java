package mike.emptyclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class realtimeUpdates extends AppCompatActivity {
    ListView classList;
    ProgressBar updateProgress;

private AdView adv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realtime_updates);
        Firebase.setAndroidContext(this);
        classList=(ListView)findViewById(R.id.listRealtime);
        updateProgress=(ProgressBar)findViewById(R.id.updateProgress);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6710974821067422~5213432195");

        final ArrayList<String> updateList=new ArrayList<>();
        final ArrayAdapter<String> realTimeList=new ArrayAdapter<String>(this, R.layout.itemgeneral, R.id.txt_topic_name, updateList);
        classList.setAdapter(realTimeList);
adv7=(AdView)findViewById(R.id.adView6);

        AdRequest adRequest6 = new AdRequest.Builder()
                .build();
        adv7.loadAd(adRequest6);

        Firebase listUpdates=new Firebase("https://campusnews-4f12d.firebaseio.com/RealTime Updates");
        listUpdates.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String updateValue=dataSnapshot.getValue(String.class);
                updateList.add(updateValue);
                realTimeList.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
    @Override
    public void onPause() {
        if (adv7 != null) {
            adv7.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adv7 != null) {
            adv7.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adv7 != null) {
            adv7.destroy();
        }
        super.onDestroy();
    }
}
