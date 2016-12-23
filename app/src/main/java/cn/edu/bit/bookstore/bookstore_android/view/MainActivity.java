package cn.edu.bit.bookstore.bookstore_android.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import cn.edu.bit.bookstore.bookstore_android.R;
import cn.edu.bit.bookstore.bookstore_android.book.BooksFragment;
import cn.edu.bit.bookstore.bookstore_android.widget.BackHandledFragment;

public class MainActivity extends AppCompatActivity implements BackHandledFragment.BackHandlerInterface {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private BackHandledFragment selectedFragment;
    private NavigationView mNavigationView;

    private static final int ANIM_DURATION_TOOLBAR = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("售书申请");
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(onMenuItemClick);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(mNavigationView);

        //profile Image
        setUpProfileImage();


        switchToBook();
    }

    private void touchSellBook(){
        Intent intent = new Intent();
        intent.setClass(this,SellActivity.class);
        startActivity(intent);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_settings:
                    touchSellBook();
                    break;
            }

            if(!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    private void switchToBook() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new BooksFragment()).commit();
        mToolbar.setTitle(R.string.navigation_book);
    }

    private void switchToExample() {
        //       getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new LoginFragment()).commit();
        Intent intent = new Intent();
        intent.setClass(this,LoginActivity.class);
        startActivity(intent);
    }

    private void switchToBlog() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new BlogFragment()).commit();
        mToolbar.setTitle(R.string.navigation_my_blog);
    }


    private void switchToAbout() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new AboutFragment()).commit();
        mToolbar.setTitle(R.string.navigation_about);
    }


    private void setUpProfileImage() {
        View headerView=  mNavigationView.inflateHeaderView(R.layout.navigation_header);
        View profileView = headerView.findViewById(R.id.profile_image);
        if (profileView != null) {
            profileView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchToBlog();
                    mDrawerLayout.closeDrawers();
                    mNavigationView.getMenu().getItem(1).setChecked(true);
                }
            });
        }

    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

                            case R.id.navigation_item_book:
                                switchToBook();
                                break;
                            case R.id.navigation_item_example:
                                switchToExample();
                                break;
                            case R.id.navigation_item_blog:
                                switchToBlog();
                                break;
                            case R.id.navigation_item_about:
                                switchToAbout();
                                break;

                        }
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setSelectedFragment(BackHandledFragment backHandledFragment) {
        this.selectedFragment = backHandledFragment;
    }


    private long exitTime = 0;

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if (selectedFragment == null || !selectedFragment.onBackPressed()) {
            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                doExitApp();
            }
        }

    }
}