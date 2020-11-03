package com.example.graphicalappsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView guiListView = findViewById(R.id.guiListView);

        GuiListAdapter adapter = new GuiListAdapter(this, R.layout.gui_list);
        this.addGuiItem(adapter);

        guiListView.setAdapter(adapter);
        guiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (view.isEnabled()){
                    transFragment(position);
                }
            }
        });
    }

    private void transFragment(int position){
        Fragment sampleViewFragment = SampleViewFragment.newInstance(position);

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(
                R.id.rootFrame,
                sampleViewFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
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