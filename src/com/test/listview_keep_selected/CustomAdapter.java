package com.test.listview_keep_selected;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CustomAdapter<T> extends ArrayAdapter<T> {

    private Context m_cContext;

    public CustomAdapter(Context context, int textViewResourceId,
            T[] objects) {

        super(context, textViewResourceId, objects);
        this.m_cContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View returnView = super.getView(position, convertView, parent);
        final ListView listView  = (ListView) ((Activity) m_cContext).findViewById(R.id.listViewTest);
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
