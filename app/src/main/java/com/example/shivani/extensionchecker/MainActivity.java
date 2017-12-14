package com.example.shivani.extensionchecker;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyAdapter adapter;
    private ArrayList<String> myList=new ArrayList<>();
    private ArrayList<String> imageArray=new ArrayList<>();
    private ArrayList<String> videoArray=new ArrayList<>();
    private ArrayList<String> audioArray=new ArrayList<>();
    private ArrayList<String> textArray=new ArrayList<>();
    private ArrayList<String> appArray= new ArrayList<>();
    private ArrayList<String> othersArray=new ArrayList<>();
    private GridView gridView;
    private String fileExtension,mimeType;
    private ListView listView;
    private ArrayAdapter listAdapter;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        myList.add("abc.txt");
        myList.add("def.doc");
        myList.add("ghi.pdf");
        myList.add("jkl.wav");
        myList.add("mno.png");
        myList.add("pqr.jpg");
        myList.add("stu.apk");
        myList.add("vwx.rar");
        myList.add("abcd.mp4");
        myList.add("efgh.mp3");
        myList.add("ijkl.bmp");
        myList.add("mnop.gif");
        
        listView=(ListView)findViewById(android.R.id.list);
       
        gridView=(GridView)findViewById(R.id.grid);
        
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int devicewidth = displaymetrics.widthPixels/(5/2);
        gridView.setColumnWidth(devicewidth);
        
        adapter=new MyAdapter(MainActivity.this);
        gridView.setAdapter(adapter);
        for(int i = 0;i<myList.size();i++) {
            fileExtension = MimeTypeMap.getFileExtensionFromUrl(myList.get(i));
            mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension);


            Log.d("MIME", "FileExtension: " + fileExtension + " MimeType: " + mimeType + " Position : " + i);

           String fileType = mimeType.substring(0, mimeType.indexOf('/'));
            if (fileType.equals("image")) {
                String myFile = myList.get(i);
                imageArray.add(myFile);
            }
            else  if (fileType.equals("audio")) {
                String myFile = myList.get(i);
                audioArray.add(myFile);
            }
            else  if (fileType.equals("video")) {
                String myFile = myList.get(i);
                videoArray.add(myFile);
            }
            else  if (fileType.equals("text")) {
                String myFile = myList.get(i);
                textArray.add(myFile);
            } else  if (fileType.equals("application")) {
                String myFile = myList.get(i);
                appArray.add(myFile);
            }
            
        }
        Log.d("TAG", String.valueOf(imageArray)+String.valueOf(audioArray)+String.valueOf(videoArray)+
                String.valueOf(textArray)+String.valueOf(appArray));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    gridView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    String[] arr1 = new String[imageArray.size()];
                    arr1= imageArray.toArray(arr1);
                        listAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.list_items,arr1);
                        listView.setAdapter(listAdapter);
                        listAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        gridView.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        String[] arr2 = new String[audioArray.size()];
                        arr2= audioArray.toArray(arr2);
                        listAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.list_items,arr2);
                        listView.setAdapter(listAdapter);
                        listAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        gridView.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        String[] arr3 = new String[videoArray.size()];
                        arr3= videoArray.toArray(arr3);
                        listAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.list_items,arr3);
                        listView.setAdapter(listAdapter);
                        listAdapter.notifyDataSetChanged();
                        break;
                    case 3:
                        gridView.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        String[] arr4 = new String[textArray.size()];
                        arr4= textArray.toArray(arr4);
                        listAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.list_items,arr4);
                        listView.setAdapter(listAdapter);
                        listAdapter.notifyDataSetChanged();
                        break;
                    case 4:
                        listView.setVisibility(View.VISIBLE);
                        gridView.setVisibility(View.GONE);
                        String[] arr5 = new String[appArray.size()];
                        arr5= appArray.toArray(arr5);
                        listAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.list_items,arr5);
                        listView.setAdapter(listAdapter);
                        listAdapter.notifyDataSetChanged();
                        break;
                    case 5:
                        break;
                }
               
            }
        });
        
    }

    @Override
    public void onBackPressed() {
       if(gridView.getVisibility()==View.VISIBLE){
           super.onBackPressed();
       }else{
           listView.setVisibility(View.GONE);
           gridView.setVisibility(View.VISIBLE);
       }
    }
}
