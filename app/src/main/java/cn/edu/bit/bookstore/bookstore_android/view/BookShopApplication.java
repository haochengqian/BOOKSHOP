package cn.edu.bit.bookstore.bookstore_android.view;

import android.app.Application;
import cn.edu.bit.bookstore.bookstore_android.user.UserLogin;
import cn.edu.bit.bookstore.bookstore_android.utils.BookShopService;
import cn.edu.bit.bookstore.bookstore_android.utils.DisplayUtil;


public class BookShopApplication extends Application{

    public static BookShopApplication applicationInstance;
    public final BookShopService czwfunService = BookShopService.Factory.create();
    public UserLogin user = null;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationInstance = this;
        DisplayUtil.init(this);
    }
}
