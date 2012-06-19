package com.test.listview_keep_selected;

import android.app.Activity;
import android.app.LauncherActivity.ListItem;
import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CustomAdapter<T> extends ArrayAdapter<T> {

    private Context m_cContext;
    final ListView listView;

    public CustomAdapter(Activity activity, int listViewId, int textViewResourceId, 
            T[] objects) {

        super(activity, textViewResourceId, objects);
        this.m_cContext = activity;
        this.listView=(ListView)activity.findViewById(listViewId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View returnView = super.getView(position, convertView, parent);
        
        returnView.setOnClickListener(new OnClickListener(
                ) {


            @Override
            public void onClick(View v) {
                for(int i = 0; i< listView.getChildCount(); i++)
                    listView.getChildAt(i).setSelected(false);
                StateListDrawable states = new StateListDrawable();
                states.addState(new int[] {android.R.attr.state_selected},
                        m_cContext.getResources().getDrawable(R.drawable.list_pressed));
                states.addState(new int[] { },
                        m_cContext.getResources().getDrawable(R.drawable.list_altered));
                v.setBackgroundDrawable(states);
                v.setSelected(true);
            }
        });
        return returnView;
    }

}
