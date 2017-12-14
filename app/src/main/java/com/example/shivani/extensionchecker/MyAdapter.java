
package com.example.shivani.extensionchecker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    
    
     

    // Constructor
    public MyAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mContext.getResources().getStringArray(R.array.titles).length;
    }

    @Override
    public Object getItem(int position) {
        return mContext.getResources().getStringArray(R.array.titles)[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int devicewidth = displaymetrics.widthPixels/(5/2);
        int deviceheight = displaymetrics.heightPixels / 3;
        TextView textView = new TextView(mContext);
        textView.setText(mContext.getResources().getStringArray(R.array.titles)[position]);
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setTextColor(Color.GRAY);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textView.setElevation(6);
        }
        textView.setBackgroundDrawable(ContextCompat.getDrawable(mContext,R.drawable.background));
        textView.setLayoutParams(new GridView.LayoutParams(devicewidth,deviceheight));
        return textView;
    }

}
