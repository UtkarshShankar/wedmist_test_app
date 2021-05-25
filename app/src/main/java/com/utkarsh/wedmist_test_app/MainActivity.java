package com.utkarsh.wedmist_test_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.CamcorderProfile;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ImageView imageView1;
    CardView cardView;
    public static List<Integer>images=new ArrayList<>();
    public static List<String> title=new ArrayList<>();
    public static List<String> title2=new ArrayList<>();
    public static List<String> title3=new ArrayList<>();
    public static List<String> title4=new ArrayList<>();
    private String Channel_id="channelID";
    private String Channel_name="channelName";
    private final int Notification_ID=200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        listView=findViewById(R.id.listview);
        imageView1=findViewById(R.id.favicon);

//        //notification building
//        createNotificationChannel();
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
//
//        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
//
//        long nowTime=System.currentTimeMillis();
//
//        long seconds=1000*2;
//        alarmManager.set(AlarmManager.RTC_WAKEUP,nowTime+seconds,pendingIntent);



        title.add("Saffola Masala Oats");
        title.add("Asshirwaad Aata");
        title.add("Dabur Pure Honey");
        title.add("Red Label Tea");
        title.add("Amul Taza Dhoodh");
        title.add("Good Day Butter Cookies");
        title.add("Cadbury Silk Special Edition");

        title2.add("500g, Pouch");
        title2.add("5kg, Packet");
        title2.add("500g, Bottle");
        title2.add("500g, Pouch");
        title2.add("1ltr, Pouch");
        title2.add("100g, Packet");
        title2.add("30g, Pack");

        title3.add("Rs 167");
        title3.add("Rs 213");
        title3.add("Rs 395");
        title3.add("Rs 235");
        title3.add("Rs 64");
        title3.add("Rs 20");
        title3.add("Rs 100");

        title4.add("2.4");
        title4.add("1.7");
        title4.add("3.5");
        title4.add("4.5");
        title4.add("4.3");
        title4.add("5.0");
        title4.add("5.0");

        images.add(R.drawable.saffola);
        images.add(R.drawable.aata);
        images.add(R.drawable.honey);
        images.add(R.drawable.red);
        images.add(R.drawable.amul);
        images.add(R.drawable.butter_cookies);
        images.add(R.drawable.cadbury);

        //building after initializing


        MyAdapter myAdapter=new MyAdapter(this,title,title2,title3,title4,images);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent2 =new Intent(getApplicationContext(),ProductActivity.class);
            intent2.putExtra("position",i);
            startActivity(intent2);
        });
    }
//    public void createNotificationChannel(){
//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
//        {
//            NotificationChannel notificationChannel=new NotificationChannel(Channel_id,Channel_name, NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager notificationManager=getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(notificationChannel);
//        }
//    }
}