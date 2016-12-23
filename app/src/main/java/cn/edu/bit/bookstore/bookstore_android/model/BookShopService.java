package cn.edu.bit.bookstore.bookstore_android.model;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BookShopService {

    @POST("login")
    Call<ResponseBody> login(@Body UserLogin login);

    @POST("signup")
    Call<ResponseBody> register(@Body UserLogin login);

    @GET("getbooklist")
    Call<List<Book>> listBooks(@Query("from") int from,@Query("count") int count);

    class Factory{
        public static BookShopService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.51.30.47:32768/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(BookShopService.class);
        }
    }

}
