package com.example.emptyact;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;

public class SecondActivity extends Activity {
    Button btn; EditText edd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edd=findViewById(R.id.editTextText1);
        btn=findViewById(R.id.button2);



        //intent
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             /*   Intent intt=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intt);*/

                String nn= edd.getText().toString();


                // In your main activity or wherever you want to trigger the notification
                NotificationUtils.simpleNotification(getApplicationContext(), "Amir", nn);


               /* NotificationCompat.Builder builder;
                builder = new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.tiger))
                        .setContentTitle("Amir")
                        .setContentText("hhh")
                        .setAutoCancel(true)
                        .setDefaults(NotificationCompat.DEFAULT_ALL);


                Uri path= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(path);
                NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


                if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
                    String channelId="your id";
                    NotificationChannel channel=new NotificationChannel(channelId,"chennel human read",NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(channel);
                    builder.setChannelId(channelId);

                }
                notificationManager.notify(0,builder.build());    */

            }
        });

    }
}