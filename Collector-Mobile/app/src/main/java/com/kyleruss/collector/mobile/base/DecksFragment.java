//-------------------------------------------
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//-------------------------------------------

package com.kyleruss.collector.mobile.base;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyleruss.collector.mobile.R;


public class DecksFragment extends Fragment
{
    public DecksFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().getActionBar().setTitle("Decks");
        return inflater.inflate(R.layout.fragment_decks, container, false);
    }
}
