package cn.edu.bit.bookstore.bookstore_android.view;

import android.app.Application;

import cn.edu.bit.bookstore.bookstore_android.common.AppClient;
import cn.edu.bit.bookstore.bookstore_android.utils.DisplayUtil;

/**
 * Created by erfli on 6/14/16.
 */
public class MaterialApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AppClient.initAppClient();
        DisplayUtil.init(this);
    }
}
