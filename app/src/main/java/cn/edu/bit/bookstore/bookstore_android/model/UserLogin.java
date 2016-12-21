package cn.edu.bit.bookstore.bookstore_android.model;

/**
 * Created by satjd on 2016/12/20.
 */
public class UserLogin {

    String userid;
    String passwd;
    String mac;

    public UserLogin(String userid, String passwd, String mac) {
        this.userid = userid;
        this.passwd = passwd;
        this.mac = mac;
    }
}
