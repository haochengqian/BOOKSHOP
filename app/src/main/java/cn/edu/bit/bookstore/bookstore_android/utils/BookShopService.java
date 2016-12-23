package cn.edu.bit.bookstore.bookstore_android.utils;

import cn.edu.bit.bookstore.bookstore_android.book.Book;
import cn.edu.bit.bookstore.bookstore_android.user.UserLogin;
import cn.edu.bit.bookstore.bookstore_android.user.UserValidation;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface BookShopService {

    @POST("login")
    Call<UserValidation> login(@Body UserLogin login);

    @POST("signup")
    Call<UserValidation> register(@Body UserLogin login);

    @GET("getbooklist")
    Call<List<Book>> listBooks(@Query("from") int from, @Query("count") int count);

    @GET("getbooklist")
    Call<List<Book>> listBooks(@QueryMap Map<String,String> map);

    class Factory{
        public static BookShopService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://czwfun.cn:32768/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(BookShopService.class);
        }
    }

}
