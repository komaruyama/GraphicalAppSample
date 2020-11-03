package com.example.graphicalappsample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SampleViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SampleViewFragment extends Fragment {

    private static final String ARG_ITEM_POSITION = "position";

    private int position;

    public SampleViewFragment() {
        // Required empty public constructor
    }

    public static SampleViewFragment newInstance(int position) {
        SampleViewFragment fragment = new SampleViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ITEM_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_ITEM_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View screen = inflater.inflate(R.layout.fragment_sample_view, container, false);
        TextView titleText = screen.findViewById(R.id.title);

        GuiViewInfoItem itemInfo = GuiViewInformation.information[position];

        titleText.setText(itemInfo.name);
        return screen;
    }
}