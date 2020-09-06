package com.rawesomestudios.location;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    private Button nearestTestingButton;
    private Button maskReminderButton;
    private Button rssFeedButton;
    private Button cdcGuidelines;
    private Button worldometers;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nearestTestingButton = (Button) findViewById(R.id.closest_testing);
        maskReminderButton = (Button) findViewById(R.id.mask_reminder);
        rssFeedButton = (Button) findViewById(R.id.rss_feed);
        worldometers = (Button) findViewById(R.id.worldometers);
        cdcGuidelines = (Button) findViewById(R.id.cdc);

        nearestTestingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, PermissionsActivity.class);
                //
                startActivity(intent);

            }
        });

        maskReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MaskReminder.class);
                startActivity(intent);

            }
        });

        rssFeedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RSSCorona.class);
                startActivity(intent);
            }
        });

        cdcGuidelines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/prevention.html"));
                //browserIntent.setPackage("com.android.chrome"); // Whatever browser you are using
                try{
                    startActivity(browserIntent);
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/prevention.html")));
                }

            }
        });

        worldometers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.worldometers.info/coronavirus/"));
                //browserIntent.setPackage("com.android.chrome"); // Whatever browser you are using
                try{
                    startActivity(browserIntent);
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.worldometers.info/coronavirus/")));
                }

            }
        });


    }
}
