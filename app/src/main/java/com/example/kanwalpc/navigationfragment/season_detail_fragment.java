package com.example.kanwalpc.navigationfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kanwal on 12/11/2016.
 */
public class season_detail_fragment extends Fragment {
    private TextView received_season_tv,display_details_season_tv;

    public static season_detail_fragment newInstance(){
        season_detail_fragment fragment=new season_detail_fragment();
        return fragment;
    }

    public season_detail_fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rowView=inflater.inflate(R.layout.seasondetailfragment, container, false);

        String[] Season_Details=new String[]{"Silicon Valley","Silicon Valley is about Richard Henricks and his company named pied piper",
                "Game of Thrones","Game of Thrones is a fantasy drama",
                "Big Bang Theory","Big Bang Theory is scientific sci-fi drama",
                "Prison Break","Prison Break is about the story of Micheal Scofield and his brother",
                "Citizen Khan","Citizen Khan: Mr. Khan , a pakistani citizen living abroad in UK",
                "Divinci Demons","Divinci Demons: Story about Leonardo Divinci",
                "Mr. Robot","Mr. Robot is about hacker's story and how he wants to take revenge on society",
                "House of Cards","House of Cards is about underwood and his compaign to become president of USA",
                "Sherlock Holmes","Sherlock Holmes: Detective to solve crimes"
        };

        display_details_season_tv=(TextView)rowView.findViewById(R.id.display_season_detail);
        received_season_tv=(TextView)rowView.findViewById(R.id.display_season_received);
        Bundle receiver=getArguments();
        if(receiver!=null){
            String season_name_received=receiver.getString("season_name");
            received_season_tv.setText("You Chose " +season_name_received);
            for(int i=0; i< Season_Details.length; i+=2) {
                if (season_name_received.equals(Season_Details[i])){
                    display_details_season_tv.setText(Season_Details[i + 1]);
                }
            }
        }else{
            display_details_season_tv.setText("Can;t find");
            Toast.makeText(getActivity(), "not found", Toast.LENGTH_SHORT).show();
        }

       return rowView;
    }

}
