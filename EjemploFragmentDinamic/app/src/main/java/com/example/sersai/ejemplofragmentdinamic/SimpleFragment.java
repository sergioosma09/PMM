package com.example.sersai.ejemplofragmentdinamic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleFragment extends Fragment {
    int mNum;

    static SimpleFragment newInstance(int number) {
        SimpleFragment f = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt("num", number);
        f.setArguments(args);
        return f;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = null;
        if (mNum % 2 == 0) {
            v = inflater.inflate(R.layout.activity_simple_fragment, container, false);
            View tv = v.findViewById(R.id.text);
        } else {
            v = inflater.inflate(R.layout.activity_simple_fragment2, container, false);
            View tv = v.findViewById(R.id.text2);

            ((TextView) tv).setText("Fragmento nÃºmero #" + mNum);}
            return v;
        }
    }

