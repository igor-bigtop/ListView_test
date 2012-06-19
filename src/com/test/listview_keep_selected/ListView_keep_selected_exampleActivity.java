package com.test.listview_keep_selected;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView_keep_selected_exampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ListView lv = (ListView)findViewById(R.id.listViewTest);
        //lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        
        String[] stringArray = {"aaaa", "bbbb", "cccc", "ddd", "eee"};
        
        lv.setAdapter(new CustomAdapter<String>(this, R.id.listViewTest,
                R.layout.list_item, stringArray));

    }
}