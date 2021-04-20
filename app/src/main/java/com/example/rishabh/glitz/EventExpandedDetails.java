package com.example.rishabh.glitz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EventExpandedDetails extends AppCompatActivity {

    TextView expandedHeadingTV, expandedVenueTV, expandedTimeTV, expandedDescriptionTV, expandedEventCoordinator1, expandedEventCoordinator2, expandedEventNumber1, expandedEventNumber2;
    ImageButton callButton;
    LinearLayout person1, person2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_expanded_details);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitleTextColor(getColor(R.color.colorPrimaryDark);
//        toolbar.setLogo(R.drawable.ic_action_glitz1_dark);
//        getSupportActionBar().setLogo(R.drawable.ic_action_glitz1_dark);

        expandedHeadingTV = (TextView) findViewById(R.id.ExpandedHeadingTV);
        expandedVenueTV = (TextView) findViewById(R.id.ExpandedVenueTV);
        expandedTimeTV = (TextView) findViewById(R.id.ExpandedTimeTV);
        expandedDescriptionTV = (TextView) findViewById(R.id.ExpandedDescrptionTV);
        expandedEventCoordinator1 = (TextView) findViewById(R.id.ExpandedEventCorrdinator1);
        expandedEventCoordinator2 = (TextView) findViewById(R.id.ExpandedEventCorrdinator2);
        expandedEventNumber1 = (TextView) findViewById(R.id.ExpandedEventNumber1);
        expandedEventNumber2 = (TextView) findViewById(R.id.ExpandedEventNumber2);
        person1 = (LinearLayout) findViewById(R.id.Person1);
        person2 = (LinearLayout) findViewById(R.id.Person2);
        callButton = (ImageButton) findViewById(R.id.callButton);

        String stringPosition = getIntent().getStringExtra("position");
        final int intPosition = Integer.parseInt(stringPosition);

        String stringDay = getIntent().getStringExtra("day");
        final int intDay = Integer.parseInt(stringDay);

//        String[] EventCoordinatorsNumbersArray = getResources().getStringArray(R.array.EventCoordinatorsNumbersDay1);


        switch (intDay) {
            case 1: {


                String[] HeadingsArray = getResources().getStringArray(R.array.EventNamesDay1);
                expandedHeadingTV.setText(HeadingsArray[intPosition]);
                setTitle(HeadingsArray[intPosition]);


                String[] VenuesArray = getResources().getStringArray(R.array.EventVenuesDay1);
                expandedVenueTV.setText(VenuesArray[intPosition]);

                String[] TimesArray = getResources().getStringArray(R.array.EventTimesDay1);
                expandedTimeTV.setText(TimesArray[intPosition]);

                String[] DescriptionsArray = getResources().getStringArray(R.array.EventDetailsDay1);
                expandedDescriptionTV.setText(DescriptionsArray[intPosition]);

//call
                String[] EventCoordinators1Array = getResources().getStringArray(R.array.EventCoordinatorsNames1Day1);
                expandedEventCoordinator1.setText(EventCoordinators1Array[intPosition]);

                String[] EventCoordinators2Array = getResources().getStringArray(R.array.EventCoordinatorsNames2Day1);
                expandedEventCoordinator2.setText(EventCoordinators2Array[intPosition]);


                final String[] EventNumbers1Array = getResources().getStringArray(R.array.EventCoordinatorsNumbers1Day1);
                expandedEventNumber1.setText(EventNumbers1Array[intPosition]);

                final String[] EventNumbers2Array = getResources().getStringArray(R.array.EventCoordinatorsNumbers2Day1);
                expandedEventNumber2.setText(EventNumbers2Array[intPosition]);

                person1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:" + (EventNumbers1Array[intPosition])));
                        startActivity(call);
                    }
                });

                person2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:" + (EventNumbers2Array[intPosition])));
                        startActivity(call);
                    }
                });



//                EventCoordinatorsNumbersArray = getResources().getStringArray(R.array.EventCoordinatorsNumbersDay1);
                break;
            }
            case 2: {
                String[] HeadingsArray = getResources().getStringArray(R.array.EventNamesDay2);
                expandedHeadingTV.setText(HeadingsArray[intPosition]);
                setTitle(HeadingsArray[intPosition]);


                String[] VenuesArray = getResources().getStringArray(R.array.EventVenuesDay2);
                expandedVenueTV.setText(VenuesArray[intPosition]);

                String[] TimesArray = getResources().getStringArray(R.array.EventTimesDay2);
                expandedTimeTV.setText(TimesArray[intPosition]);

                String[] DescriptionsArray = getResources().getStringArray(R.array.EventDetailsDay2);
                expandedDescriptionTV.setText(DescriptionsArray[intPosition]);

//call

                String[] EventCoordinators1Array = getResources().getStringArray(R.array.EventCoordinatorsNames1Day2);
                expandedEventCoordinator1.setText(EventCoordinators1Array[intPosition]);

                String[] EventCoordinators2Array = getResources().getStringArray(R.array.EventCoordinatorsNames2Day2);
                expandedEventCoordinator2.setText(EventCoordinators2Array[intPosition]);


                final String[] EventNumbers1Array = getResources().getStringArray(R.array.EventCoordinatorsNumbers1Day2);
                expandedEventNumber1.setText(EventNumbers1Array[intPosition]);

                final String[] EventNumbers2Array = getResources().getStringArray(R.array.EventCoordinatorsNumbers2Day2);
                expandedEventNumber2.setText(EventNumbers2Array[intPosition]);


                person1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:" + (EventNumbers1Array[intPosition])));
                        startActivity(call);
                    }
                });

                person2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:" + (EventNumbers2Array[intPosition])));
                        startActivity(call);
                    }
                });

//                EventCoordinatorsNumbersArray = getResources().getStringArray(R.array.EventCoordinatorsNumbersDay2);
                break;
            }
        }

//
//        final String[] finalEventCoordinatorsNumbersArray = EventCoordinatorsNumbersArray;
//        callButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent call = new Intent(Intent.ACTION_DIAL);
//                call.setData(Uri.parse("tel:" + (finalEventCoordinatorsNumbersArray[intPosition])));
//                startActivity(call);
//            }
//        });
//


        expandedVenueTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intPosition == 6) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.mapcanteen)));
                    startActivity(intent);
                }
                if (intPosition != 6) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.mapaudi)));
                    startActivity(intent);
                }
            }
        });

    }
}
