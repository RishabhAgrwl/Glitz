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

public class Day1 extends Fragment implements AdapterView.OnItemClickListener{

public ListView listView1;
public LayoutInflater inflater;
public TextView text1;
String[] eventNamesDay1;
String[] eventTimesDay1;
String[] eventVenuesDay1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.day_1,container,false);

        listView1 = rootview.findViewById(R.id.listviewday1);

        Resources res = getResources();
        eventNamesDay1 = res.getStringArray(R.array.EventNamesDay1);
        eventTimesDay1 = res.getStringArray(R.array.EventTimesDay1);
        eventVenuesDay1 = res.getStringArray(R.array.EventVenuesDay1);

        Day1Adapter adapter1 = new Day1Adapter(getActivity(),eventNamesDay1, eventTimesDay1, eventVenuesDay1);
        listView1.setAdapter(adapter1);

        listView1.setOnItemClickListener(this);

        return rootview;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        TextView temp = (TextView) view;

//        Bundle args = new Bundle();
//        args.putString("position",i+"");

        Intent intent = new Intent(getActivity(), EventExpandedDetails.class);
        intent.putExtra("position",i+"");
        intent.putExtra("day","1");
        startActivity(intent);

//        Toast.makeText(getActivity(), i+"" , Toast.LENGTH_SHORT).show();

/*      MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.setArguments(args);
        myDialogFragment.show(getFragmentManager(),"Diag");
*/

    }
}


class Day1Adapter extends ArrayAdapter<String>
{
    Context context;
    String [] EventName;
    String [] EventTime;
    String [] EventVenue;

    Day1Adapter(Context c, String[] names, String[] times,  String[] venues )
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