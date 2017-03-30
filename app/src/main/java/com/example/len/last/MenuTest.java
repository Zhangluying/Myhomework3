package com.example.len.last;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MenuTest extends AppCompatActivity {


    private TextView txt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        txt=(TextView) findViewById(R.id.mytxt);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflator=new MenuInflater(this);
        inflator.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem mi){
        if(mi.isCheckable()){
            mi.setChecked(true);
        }
        switch(mi.getItemId()){
            case R.id.font_10:
                txt.setTextSize(10*2);
                break;
            case R.id.font_16:
                txt.setTextSize(16*2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                break;
            case R.id.black_font:
                txt.setTextColor(Color.BLACK);
                break;
            case R.id.plain_item:
                Toast toast= Toast.makeText(MenuTest.this,"您点击了普通菜单",Toast.LENGTH_LONG);
                toast.show();
                break;

        }
        return true;
    }
}
