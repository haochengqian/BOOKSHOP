package cn.edu.bit.bookstore.bookstore_android.model;


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
