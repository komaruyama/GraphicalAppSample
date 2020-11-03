package com.example.graphicalappsample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        // set parameter
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // load parameter
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_fragmanet, container, false);

        ListView guiListView = view.findViewById(R.id.guiListView);


        GuiListAdapter adapter = new GuiListAdapter(getContext(), R.layout.gui_list);
        this.addGuiItem(adapter);

        guiListView.setAdapter(adapter);
        guiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (view.isEnabled()){
                    MainActivity activity = (MainActivity) getActivity();
                    activity.transFragment(position);
                }
            }
        });

        return view;
    }

    private void addGuiItem(GuiListAdapter adapter){
        for (int i=0; i<GuiViewInformation.information.length; i++){
            ListItemClass item =new ListItemClass();
            GuiViewInfoItem info = GuiViewInformation.information[i];
            item.name = info.name;
            item.description = info.description;
            adapter.add(item);
        }
    }
}