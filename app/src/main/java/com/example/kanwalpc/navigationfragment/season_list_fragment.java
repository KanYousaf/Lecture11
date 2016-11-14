package com.example.kanwalpc.navigationfragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kanwal on 12/11/2016.
 */
public class season_list_fragment extends Fragment {
    ListView list_of_season;
    String[] myFavSeasonArray;
    int[] myFavSeasonImageArray;
    ArrayList<String> season_names_al;
    ArrayList<Integer> season_images_al;
    myOwnListAdapter adapter;

    public static season_list_fragment newInstance() {
        season_list_fragment fragment=new season_list_fragment();
        return fragment;
    }

    public season_list_fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rowView=inflater.inflate(R.layout.seasonlistfragment, container, false);
        list_of_season=(ListView)rowView.findViewById(R.id.display_season_names);

        myFavSeasonArray=new String[]{"Silicon Valley", "Game of Thrones", "Big Bang Theory",
                "Prison Break", "Citizen Khan", "Divinci Demons", "Mr. Robot",
                "House of Cards", "Sherlock Holmes"};

        season_names_al=new ArrayList<>(Arrays.asList(myFavSeasonArray));

        myFavSeasonImageArray=new int[]{R.drawable.siliconvalley, R.drawable.gameofthrones,
                R.drawable.bigbangtheory, R.drawable.prisonbreak, R.drawable.citizenkhan,
                R.drawable.divincidemons, R.drawable.mrrobot, R.drawable.houseofcards,
                R.drawable.sherlockholmes};

        season_images_al=new ArrayList<>();
        for(int i=0; i< myFavSeasonImageArray.length; i++){
            season_images_al.add(myFavSeasonImageArray[i]);
        }
        adapter=new myOwnListAdapter(getActivity(), season_names_al, season_images_al);

        list_of_season.setAdapter(adapter);
        list_of_season.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String season_name_to_pass = list_of_season.getItemAtPosition(position).toString();
                //pass data using bundle
                Bundle send_args = new Bundle();
                //open another fragment
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                season_detail_fragment detail_of_season = new season_detail_fragment();
                send_args.putString("season_name", season_name_to_pass);
                send_args.putInt("season_id", position);
                detail_of_season.setArguments(send_args);

                if (getResources().getConfiguration().orientation ==
                        Configuration.ORIENTATION_PORTRAIT) {

                    transaction.replace(R.id.frame_container, detail_of_season);
                } else {
                    transaction.replace(R.id.details_to_show, detail_of_season);
                }
                transaction.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return rowView;
    }
}
