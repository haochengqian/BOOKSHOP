package cn.edu.bit.bookstore.bookstore_android.view;

import android.app.Application;
import cn.edu.bit.bookstore.bookstore_android.utils.DisplayUtil;


public class MaterialApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
//        AppClient.initAppClient();
        DisplayUtil.init(this);
    }
}
