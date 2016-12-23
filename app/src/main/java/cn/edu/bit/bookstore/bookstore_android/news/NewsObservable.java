package cn.edu.bit.bookstore.bookstore_android.news;

import com.google.android.agera.BaseObservable;

/**
 * Created by erfli on 6/15/16.
 */
public class NewsObservable extends BaseObservable {

    NewsSupplier supplier;
    public NewsObservable(NewsSupplier supplier){
        this.supplier = supplier;
    }
    public void refreshNews(String key){
        supplier.setNewsKey(key);
        dispatchUpdate();
    }
}
