
package com.example.len.last;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actionmode extends AppCompatActivity {

    private ActionMode actionMode;
    private String items[]=new String[]{"One","Two","Three","Four","Five"};
    private int image=R.drawable.ic_launcher;
    private View v;
    private int color;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionmode);
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<items.length;i++){
            Map<String,Object> listitem=new HashMap<String,Object>();
            listitem.put("pic",image);
            listitem.put("txt",items[i]);
            listItems.add(listitem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_list,
                new String[] {"pic","txt"},new int[]{R.id.pic,R.id.txt});
        final ListView list=(ListView)findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (actionMode!=null)
                    return false;
                actionMode=startSupportActionMode(mActionModeCallback);
                actionMode.setSubtitle(position+1+"  selected");
                color=view.getSolidColor();//保存初始颜色
                view.setBackgroundColor(Color.parseColor("#0000ff"));
                view.setSelected(true);
                v=view;
                return true;
            }
        });


    }

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {


        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return true;
        }


        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }


        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.select:
                    Toast.makeText(getApplicationContext(), "Select", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    break;
                case R.id.delete:
                    Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    break;
                default:
                    break;
            }
            return false;
        }




        public void onDestroyActionMode(ActionMode mode) {
            if(v!=null){
                v.setBackgroundColor(color);
            }
            actionMode = null;
        }
    };
}

