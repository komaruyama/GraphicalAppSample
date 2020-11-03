package com.example.graphicalappsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class GuiListAdapter extends ArrayAdapter<ListItemClass> {
    private final LayoutInflater mmInflater;
    private final int listId;

    public GuiListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.mmInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listId = resource;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        View view;
        if (contentView != null) {
            view = contentView;
        } else {
            view = mmInflater.inflate(this.listId, null);
        }
        ListItemClass item = getItem(position);
        TextView guiName = (TextView) view.findViewById(R.id.guiName);
        TextView guiDescription = (TextView) view.findViewById(R.id.guiDescription);
        guiName.setText(item.name);
        guiDescription.setText(item.description);

        return view;
    }
}
