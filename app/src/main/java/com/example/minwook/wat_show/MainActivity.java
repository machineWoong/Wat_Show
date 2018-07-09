package com.example.minwook.wat_show;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // 네비게이션 드로워와, 액션바
    public DrawerLayout mainDraw;
    public ActionBarDrawerToggle mainToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void setMainDraw(){
        mainDraw = (DrawerLayout)findViewById(R.id.main_drawer);
        mainToggle = new ActionBarDrawerToggle(MainActivity.this,mainDraw,R.string.open,R.string.close);

        mainDraw.addDrawerListener(mainToggle);
        mainToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 툴바 활성화
    }

    public void setNaviClickEvent(){

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.main_navi_view);
        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
        }

    }

    //------------------------------------ 네비게이션, 드로어 활성화 ------------------------------
    //  이걸 넣어줘야지 네이게이션 메뉴가 드로워가 활성화 된다.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mainToggle.onOptionsItemSelected(item)){
            return true;
        }


        // ...  에있는 항목들.
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_navi_setting_menu, menu);
        return true;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
