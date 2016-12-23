package cn.edu.bit.bookstore.bookstore_android.viewmodel;

import android.view.View;
import cn.edu.bit.bookstore.bookstore_android.model.BookShopService;
import cn.edu.bit.bookstore.bookstore_android.model.UserLogin;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;

/**
 * Created by satjd on 2016/12/22.
 */
public class LoginHandler {

    private UserLogin currentUser = null;

    public LoginHandler(UserLogin currentUser) {
        this.currentUser = currentUser;
    }

    public void onClickLogin(View v){
        BookShopService bs = BookShopService.Factory.create();

        currentUser = new UserLogin("","","");

        //登录请求
        Call<ResponseBody> loginCall = bs.login(currentUser);
        System.out.println("click");

        try {
            loginCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
