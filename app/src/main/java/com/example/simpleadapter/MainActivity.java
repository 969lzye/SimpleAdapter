package com.example.simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private SimpleAdapter adapter;
    private ListView listView;
    private String[] content = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};

    private int[] imageViews={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> lists=new ArrayList<Map<String,Object>>();
        for(int i=0;i<content.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("content",content[i]);
            map.put("image",imageViews[i]);
            lists.add(map);
        }
        adapter=new SimpleAdapter(MainActivity.this,lists,R.layout.animal_item
                ,new String[]{"content","image"}
                ,new int[]{R.id.animal_name,R.id.animal_image});
        listView=(ListView) findViewById(R.id.list_view);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = (String) ((TextView)view.findViewById(R.id.animal_name)).getText();
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
            }
        });

    }

}