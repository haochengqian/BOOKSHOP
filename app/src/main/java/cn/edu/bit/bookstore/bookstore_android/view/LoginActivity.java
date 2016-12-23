package cn.edu.bit.bookstore.bookstore_android.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import cn.edu.bit.bookstore.bookstore_android.R;
import cn.edu.bit.bookstore.bookstore_android.databinding.ActivityLoginBinding;
import cn.edu.bit.bookstore.bookstore_android.model.UserLogin;
import cn.edu.bit.bookstore.bookstore_android.viewmodel.LoginHandler;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private static LoginHandler handler = null;
    private static UserLogin loginUser = null;

//    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        loginUser = new UserLogin("","","");
        handler = new LoginHandler(loginUser);
        binding.setUserLogin(loginUser);
        binding.setLoginHandler(handler);

    }
}
