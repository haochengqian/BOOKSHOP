package cn.edu.bit.bookstore.bookstore_android.common;

import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void initView();
    protected abstract void initRepository();
}
