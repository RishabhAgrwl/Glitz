package com.example.rishabh.glitz;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rishabh on 9/3/2017.
 */

public class MyDialogFragment extends android.support.v4.app.DialogFragment {

    TextView mEventHeadingDialogTextView;
    TextView mEventDetailsDialogTextView;
    Button mCallButtonDialog;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle mArgs = getArguments();
        String position = mArgs.getString("position");

        final AlertDialog.Builder alert= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_detail_info,null);

        mEventHeadingDialogTextView = (TextView) view.findViewById(R.id.EventHeadingDialogTextView);
        mEventDetailsDialogTextView = (TextView) view.findViewById(R.id.EventDetailsDialogTextView);
        mCallButtonDialog = (Button) view.findViewById(R.id.CallButtonDialog);

        int intPosition = Integer.parseInt(position);

        String[] NamesArray = getResources().getStringArray(R.array.EventNamesDay1);
        mEventHeadingDialogTextView.setText(NamesArray[intPosition]);

/*
        alternative single line code ↓
        mEventHeadingDialogTextView.setText((getResources().getStringArray(R.array.EventNamesDay1))[intPosition]);
*/


        String[] DetailsArray = getResources().getStringArray(R.array.EventDetailsDay1);
        mEventDetailsDialogTextView.setText(DetailsArray[intPosition]);


        alert.setView(view);

        alert.setNeutralButton("OK", null);
        alert.setPositiveButton("CALL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


//                Toast.makeText(getActivity(), R.string.Heatz_Info, Toast.LENGTH_SHORT).show();

//                Toast.makeText(getActivity(), position, Toast.LENGTH_SHORT).show();


            }
        });

        return alert.create();

//        return super.onCreateDialog(savedInstanceState);
    }
}
