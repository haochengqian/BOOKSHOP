package cn.edu.bit.bookstore.bookstore_android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.bit.bookstore.bookstore_android.R;
import cn.edu.bit.bookstore.bookstore_android.widget.BackHandledFragment;
import cn.edu.bit.bookstore.bookstore_android.widget.ProgressWebView;

/**
 * Created by Chenyc on 15/6/27.
 */
public class BlogFragment extends BackHandledFragment {

    private ProgressWebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_blog, null);
        mWebView = (ProgressWebView) view.findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://gitlab.com/Touristsss/BookStore-Android");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public String getTagText() {
        return null;
    }

    @Override
    public boolean onBackPressed() {
        if(mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }

        return false;
    }
}
