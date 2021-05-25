package com.utkarsh.wedmist_test_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class ProductActivity extends AppCompatActivity {
    ImageView productImage;
    TextView productName,productPrice,productRating,productQty;
    CardView cardView;
    Button addtocart,buynow;
    private String Channel_id="channelID";
    private String Channel_name="channelName";
    private final int Notification_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        productImage=findViewById(R.id.productImage);
        productName=findViewById(R.id.productName);
        productQty=findViewById(R.id.productQty);
        productPrice=findViewById(R.id.productPricee);
        productRating=findViewById(R.id.productRating);
        cardView =findViewById(R.id.backCard);
        buynow=findViewById(R.id.buynow);
        addtocart=findViewById(R.id.addttocart);




        int pos=0;
        List<Integer>product=MainActivity.images;
        List<String>Name=MainActivity.title;
        List<String>Qty=MainActivity.title2;
        List<String>Price=MainActivity.title3;
        List<String>Rating=MainActivity.title4;
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            pos=bundle.getInt("position");
        }
        productImage.setImageResource(product.get(pos));
        productName.setText(Name.get(pos));
        productPrice.setText(Price.get(pos));
        productRating.setText(Rating.get(pos));
        productQty.setText(Qty.get(pos));

        createNotificationChannel();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,Channel_id)
                .setSmallIcon(R.drawable.shopping)
                .setContentTitle(Name.get(pos))
                .setContentText("Has been added to cart")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);


        NotificationManagerCompat notificationManagerCompat= NotificationManagerCompat.from(this);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManagerCompat.notify(Notification_ID,builder.build());
            }
        });

        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Option Not Available Now",Toast.LENGTH_SHORT).show();
            }
        });


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ProductActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
    public void createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel=new NotificationChannel(Channel_id,Channel_name, NotificationManager.IMPORTANCE_DEFAULT);
//            notificationChannel.shouldVibrate();
//            notificationChannel.enableLights(true);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}