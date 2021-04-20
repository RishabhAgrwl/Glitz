package com.example.rishabh.glitz;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        setTitle("Campus Map");
        ImageView Map = (ImageView) findViewById(R.id.map);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.mapfab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(getResources().getString(R.string.mapaudi)));
                startActivity(intent);

            }
        });

        final Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(R.drawable.campus_map)
                + '/' + getResources().getResourceTypeName(R.drawable.campus_map) + '/' + getResources().getResourceEntryName(R.drawable.campus_map) );

//        Map.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.setDataAndType(Uri.parse(imageUri, "image/*");
//                startActivity(intent);
//
//            }
//        });

    }
}
