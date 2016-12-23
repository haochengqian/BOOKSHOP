package cn.edu.bit.bookstore.bookstore_android.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.edu.bit.bookstore.bookstore_android.R;
import cn.edu.bit.bookstore.bookstore_android.user.UserLogin;
import cn.edu.bit.bookstore.bookstore_android.user.UserValidation;
import cn.edu.bit.bookstore.bookstore_android.utils.BookShopService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private BookShopService service = BookShopApplication.applicationInstance.czwfunService;
    private Button loginButton = null;
    private UserLogin currentUser = null;


    private int doLogin(final UserLogin user){

        Call<UserValidation> loginCall = service.login(user);
        try {
            loginCall.enqueue(new Callback<UserValidation>() {
                @Override
                public void onResponse(Call<UserValidation> call, Response<UserValidation> response) {
                    if (response.isSuccessful()) {
                        if(response.body().getStatus()==1){
                            finish();
                            LoginActivity.this.currentUser = user;
                            BookShopApplication.applicationInstance.user = user;
                            Toast.makeText(LoginActivity.this, "登陆成功,"+"欢迎"+user.getUserid(), Toast.LENGTH_SHORT).show();
                        }
                        else{
                            LoginActivity.this.currentUser = null;
                            BookShopApplication.applicationInstance.user = null;
                            Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        // error response, no access to resource?
                    }
                }

                @Override
                public void onFailure(Call<UserValidation> call, Throwable t) {
                    // something went completely south (like no internet connection)

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }


    private View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText edtUserid = (EditText)findViewById(R.id.input_userid);
            EditText edtPasswd = (EditText)findViewById(R.id.input_password);
            String userid = edtUserid.getText().toString();
            String passwd = edtPasswd.getText().toString();
            UserLogin user = new UserLogin(userid,passwd,"");

            doLogin(user);

        }
    };

//    @Bind(R.id.input_email) EditText _emailText;
//    @Bind(R.id.input_password) EditText _passwordText;
//    @Bind(R.id.btn_login) Button _loginButton;
//    @Bind(R.id.link_signup) TextView _signupLink;
//    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button)findViewById(R.id.btn_login);
        loginButton.setOnClickListener(loginListener);

    }

}
