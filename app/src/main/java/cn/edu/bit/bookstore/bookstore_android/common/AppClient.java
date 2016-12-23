package cn.edu.bit.bookstore.bookstore_android.common;

import java.util.Map;

import cn.edu.bit.bookstore.bookstore_android.book.BookResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by erfli on 6/14/16.
 */
public class AppClient {
    public interface HttpService {
        @GET("https://api.douban.com/v2/book/search")
        Call<BookResponse> getBooks(@QueryMap Map<String, String> options);
    }

    public static HttpService httpService;

    public static void initAppClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.30.47:32768/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        httpService = retrofit.create(HttpService.class);
    }

}
