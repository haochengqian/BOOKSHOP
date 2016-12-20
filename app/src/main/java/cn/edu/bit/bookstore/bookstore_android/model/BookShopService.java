package cn.edu.bit.bookstore.bookstore_android.model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by satjd on 2016/12/20.
 */
public interface BookShopService {

    @FormUrlEncoded
    @POST("/login")
    Call<ResponseBody> login(@Field("userid") String userid,@Field("password") String password,
                             @Field("mac") String mac);

    @GET("getbooklist")
    Call<List<Book>> listBooks(@Query("from") int from,@Query("count") int count);

    class Factory{
        public static BookShopService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.51.30.47:32768/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(BookShopService.class);
        }
    }

}
