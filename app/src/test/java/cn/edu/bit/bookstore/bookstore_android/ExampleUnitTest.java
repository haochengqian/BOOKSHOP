package cn.edu.bit.bookstore.bookstore_android;

import cn.edu.bit.bookstore.bookstore_android.book.Book;
import cn.edu.bit.bookstore.bookstore_android.utils.BookShopService;
import cn.edu.bit.bookstore.bookstore_android.user.UserLogin;
import okhttp3.ResponseBody;
import org.junit.Test;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void reqTest() throws IOException {
        BookShopService bs = BookShopService.Factory.create();
        Call<List<Book>> bookRepo = bs.listBooks(1,100);
        /*List<Book> books = bookRepo.execute().body();
        for(Book b:books){
            System.out.println(b.getPrice());
        }*/

        Call<ResponseBody> loginCall = bs.login(new UserLogin("uu","asd","asd"));
        System.out.println(loginCall.request().body().toString());
        System.out.println(loginCall.execute().body());

        Call<ResponseBody> regCall = bs.register(new UserLogin("uunb","dsa","mac is bullshit"));
        regCall.execute();
    }
}