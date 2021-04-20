package com.example.rishabh.glitz;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Rishabh on 8/18/2017.
 */

public class Day2 extends Fragment implements AdapterView.OnItemClickListener{

public ListView listView2;
public LayoutInflater inflater;
public TextView text2;
String[] eventNamesDay2;
String[] eventTimesDay2;
String[] eventVenuesDay2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.day_2, container, false);
        listView2 = rootview.findViewById(R.id.listviewday2);

        Resources res = getResources();
        eventNamesDay2 = res.getStringArray(R.array.EventNamesDay2);
        eventTimesDay2 = res.getStringArray(R.array.EventTimesDay2);
        eventVenuesDay2 = res.getStringArray(R.array.EventVenuesDay2);

        Day2Adapter adapter2 = new Day2Adapter(getActivity(),eventNamesDay2, eventTimesDay2, eventVenuesDay2);
        listView2.setAdapter(adapter2);

        listView2.setOnItemClickListener(this);
        return rootview;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Bundle args = new Bundle();
//        args.putString("position",i+"");



        Intent intent = new Intent(getActivity(), EventExpandedDetails.class);
        intent.putExtra("position",i+"");
        intent.putExtra("day","2");
        startActivity(intent);
    }
}

class Day2Adapter extends ArrayAdapter<String>
{
    Context context;
    String [] EventName;
    String [] EventTime;
    String [] EventVenue;

    Day2Adapter(Context c, String[] names, String[] times,  String[] venues )
    {
        super(c, R.layout.list_item_layout,R.id.EventHeadingTextView, names);
        this.context = c;
        this.EventName = names;
        this.EventTime = times;
        this.EventVenue = venues;
    }

    //    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item_layout, parent, false);

        TextView Event=(TextView) row.findViewById(R.id.EventHeadingTextView);
        TextView Time=(TextView) row.findViewById(R.id.TimeTextView);
        TextView Venue=(TextView) row.findViewById(R.id.VenueTextView);

        Event.setText(EventName[position]);
        Time.setText(EventTime[position]);
        Venue.setText(EventVenue[position]);

        return row;
    }
}