package com.example.mynews.layFragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OnlyVidio extends Fragment {
    VideoView vidioView;





    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public OnlyVidio() {
    }


    public static OnlyVidio newInstance(String param1, String param2) {
        OnlyVidio fragment = new OnlyVidio();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_only_vidio2, container, false);
        vidioView = (VideoView)rootView.findViewById(R.id.videoView);
        playVidio();

        return rootView;
    }



    public  void playVidio(){

        MediaController mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(vidioView);
        vidioView.setMediaController(mediaController);
        vidioView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" +
                R.raw.newsvidio));
        vidioView.start();

    }
}