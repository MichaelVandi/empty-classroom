package mike.emptyclassroom;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class chooseDay extends AppCompatActivity {
    private AdView adv1;
ListView listDaysAndOptions;
    ArrayAdapter<String> listAdapter;
    String[] listOptions={"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "REAL-TIME UPDATES"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_day);
        listDaysAndOptions=(ListView)findViewById(R.id.listChooseDay);
        adv1=(AdView)findViewById(R.id.adView);



        String android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        Log.d("Android","Android ID : "+android_id);

listAdapter=new ArrayAdapter<String>(this, R.layout.activity_item_layout,R.id.exampleDay,listOptions);
        listDaysAndOptions.setAdapter(listAdapter);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6710974821067422~5213432195");

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        adv1.loadAd(adRequest);


        listDaysAndOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent openMonday=new Intent(chooseDay.this, Monday.class);
                    startActivity(openMonday);
                }
                if (position==1){
                    Intent openTuesday=new Intent (chooseDay.this, Tuesday.class);
                    startActivity(openTuesday);
                }
                if (position==2){
                    Intent openWednesday=new Intent(chooseDay.this, Wednesday.class);
                    startActivity(openWednesday);
                }
                if(position==3){
                    Intent openThursday=new Intent (chooseDay.this, Thursday.class);
                    startActivity(openThursday);
                }
                if(position==4){
                    Intent openFriday=new Intent (chooseDay.this, Friday.class);
                    startActivity(openFriday);

                }
                if(position==5){
                    Intent openRealtime =new Intent(chooseDay.this, realtimeUpdates.class);
                    startActivity(openRealtime);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.exit:
                AlertDialog exit=new AlertDialog.Builder(this).
                        setTitle("\tUSEFUL??")
                        .setCancelable(true)
                        .setPositiveButton ("RATE 5 STARS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com"));
                                startActivity(browserIntent);

                            }
                        })
                        .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        }).create();
                exit.show();
                break;
            case R.id.about:

                AlertDialog about=new AlertDialog.Builder(this).
                        setTitle("\tABOUT APP")
                        .setCancelable(true)
                        .setIcon(R.drawable.empyt_class)
                        .setMessage("Displays empty classrooms at Limkokwing University.\nHelps staff and students easily locate empty rooms " +
                                "for other coursework." +
                                "\n\n" +
                                "Developer: Michael Vandi" +
                                "\nBSEM 203 (2017)Limkokwing University.").create();
                about.show();
                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPause() {
        if (adv1 != null) {
            adv1.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adv1 != null) {
            adv1.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adv1 != null) {
            adv1.destroy();
        }
        super.onDestroy();
    }


}
