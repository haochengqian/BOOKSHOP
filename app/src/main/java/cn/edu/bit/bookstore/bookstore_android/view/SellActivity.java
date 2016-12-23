package cn.edu.bit.bookstore.bookstore_android.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import cn.edu.bit.bookstore.bookstore_android.R;

/**
 * Created by haochengqian on 16/12/23.
 */

public class SellActivity extends AppCompatActivity{
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_selloldbook);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title_oldbook);
        setSupportActionBar(toolbar);
        final Button button = (Button) findViewById(R.id.btn_addbook);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        button.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               //此处添加代码
                finish();
           }
        });
    }
}
