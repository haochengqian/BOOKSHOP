package cn.edu.bit.bookstore.bookstore_android.book;

import android.support.annotation.NonNull;
import cn.edu.bit.bookstore.bookstore_android.utils.BookShopService;
import cn.edu.bit.bookstore.bookstore_android.view.BookShopApplication;
import com.google.android.agera.Result;
import com.google.android.agera.Supplier;
import okhttp3.OkHttpClient;
import retrofit2.Call;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksSupplier implements Supplier<Result<List<Book>>> {

    public String key;

    private BookShopService service = BookShopApplication.applicationInstance.czwfunService;

    public void setKey(String key) {
        this.key = key;
    }

    public BooksSupplier(String key) {
        this.key = key;
    }

    OkHttpClient client = new OkHttpClient();

    private static final String BASE_URL = "http://czwfun.cn:32768/api/";

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }


    private List<Book> getBooks() {

        //发送GET请求获取信息
        Map<String, String > params = new HashMap<>();
        params.put("from","0");
        params.put("count","15");
        try {
            Call<List<Book>> bookRepo = service.listBooks(params);
            List<Book> books = bookRepo.execute().body();

//            ArrayList<Book> books;
//            books = new ArrayList<Book>();
//            books.add(new Book());
//            books.add(new Book());
//
//            return books;
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @NonNull
    @Override
    public Result<List<Book>> get() {
        List<Book> books = getBooks();
        if (books == null) {
            return Result.failure();
        } else {
            return Result.success(books);
        }
    }
}
