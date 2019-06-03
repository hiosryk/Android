package com.example.myapplication;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MyListView extends ListView {

    public MyListView(Context context) {
        super(context);

    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


     class OnLongItemClickListenerImpl implements OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.i("LongItemClickImpl", "MyListView clicked...");
            return false;
        }
    }

}
