package com.example.len.last;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapter extends AppCompatActivity {

    private String animals[]={"lion","tiger","monkey","dog","cat","elephant"};
    private int images[]={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,
            R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<animals.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("picture",images[i]);
            listItem.put("name",animals[i]);
            listItems.add(listItem);
        }
        android.widget.SimpleAdapter simpleAdapter=new android.widget.SimpleAdapter(this,listItems,R.layout.simple_list2,
                new String[]{"name","picture"},
                new int[] {R.id.name,R.id.picture});
        ListView list=(ListView) findViewById(R.id.mylist2);
        list.setAdapter(simpleAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //使用Toast显示选中项目
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(SimpleAdapter.this, animals[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
