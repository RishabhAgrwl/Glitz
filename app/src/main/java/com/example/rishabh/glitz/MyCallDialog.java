package com.example.rishabh.glitz;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.Channels;

/**
 * Created by Rishabh on 9/3/2017.
 */

public class MyCallDialog extends DialogFragment{

    TextView name1, name2, number1, number2;
    LinearLayout person1, person2;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final AlertDialog.Builder alert= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_call,null);

        name1 = (TextView) view.findViewById(R.id.name1);
        number1 = (TextView) view.findViewById(R.id.number1);
        name2 = (TextView) view.findViewById(R.id.name2);
        number2 = (TextView) view.findViewById(R.id.number2);
        person1 = (LinearLayout) view.findViewById(R.id.person1);
        person2 = (LinearLayout) view.findViewById(R.id.person2);

        int intDay = getArguments().getInt("day");
        int intPosition = getArguments().getInt("position");

//        if (intDay==0) {
            name1.setText(R.string.headCoordinatorName1);
            number1.setText(R.string.headCoordinatorNumber1);
            name2.setText(R.string.headCoordinatorName2);
            number2.setText(R.string.headCoordinatorNumber2);

            person1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent call = new Intent(Intent.ACTION_DIAL);
                    call.setData(Uri.parse("tel:" + (number1.getText())));
                    startActivity(call);
                }
            });

            person2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent call = new Intent(Intent.ACTION_DIAL);
                    call.setData(Uri.parse("tel:" + (number2.getText())));
                    startActivity(call);
                }
            });

//        }


//        if (intDay==1) {
//            String[] CoordinatorNamesArray = getResources().getStringArray(R.array.EventCoordinatorsNames1Day1);
//            name1.setText(CoordinatorNamesArray[intPosition]);
//
//            String[] CoordinatorNumbersArray = getResources().getStringArray(R.array.EventCoordinatorsNumbersDay1);
//            name1.setText(CoordinatorNumbersArray[intPosition]);
//        }
//
//        if (intDay==2) {
//            String[] CoordinatorNamesArray = getResources().getStringArray(R.array.EventCoordinatorsNamesDay2);
//            name1.setText(CoordinatorNamesArray[intPosition]);
//
//            String[] CoordinatorNumbersArray = getResources().getStringArray(R.array.EventCoordinatorsNumbersDay2);
//            name1.setText(CoordinatorNumbersArray[intPosition]);
//        }



        alert.setTitle("Contact Coordinators");
        alert.setIcon(R.drawable.ic_call_black_48dp);
        alert.setView(view);

        return alert.create();

    }
}
