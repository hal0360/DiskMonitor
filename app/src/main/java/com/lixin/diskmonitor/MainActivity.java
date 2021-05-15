package com.lixin.diskmonitor;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.LocalDateTime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity implements MyListener{


    TextView phone;


    private LocalStorage localStorage;
    public String p_num = "+85568520718";

    /* access modifiers changed from: private */
    public String tmp;
    MarqueeTxt tv_marquee;

    int year, month, day, hour, min;
    TextView datetxt;
    public String dk = "";
    public String gameId = "101";
    public String groupId = "1";
    public String jno = "";
    public String ip_adder;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.getWindow().getDecorView().setSystemUiVisibility(getSystemUiFlags());
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.phone_numba);

        CallService.listener = this;


        year = LocalDateTime.now().getYear();
        month = LocalDateTime.now().getMonthValue();
        day = LocalDateTime.now().getDayOfMonth();
        hour = LocalDateTime.now().getHour();
        min = LocalDateTime.now().getMinute();
        datetxt = findViewById(R.id.dateTxt);
        datetxt.setText(year + "/" + month + "/" + day + " " + hour + ":" + min);


        localStorage = new LocalStorage(this, "app");
        p_num = localStorage.getStr("p_num", "+85568520718");
        dk = localStorage.getStr("dk", "+85568520718");
        gameId = localStorage.getStr("gameId", "101");
        groupId = localStorage.getStr("groupId", "1");
        ip_adder = localStorage.getStr("IP","ws://202.134.97.140");

        tv_marquee =  findViewById(R.id.tv_marquee);
        updateTheTextView();

        ImageView btn = findViewById(R.id.setting_btn);
        btn.setOnClickListener(v -> blueEvent());

    }

    public void blueEvent() {
        // closeConn();
        startActivity(new Intent(this, EditActivity.class));
        finish();
    }

    public void updateTheTextView() {
        tv_marquee.setText(localStorage.getStr("mar", "欢迎您的来电 亚洲最佳娱乐平台"));
        tv_marquee.start(localStorage.getInt("marSped", 1000));
        tv_marquee.getAnime().addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }
            @Override
            public void onAnimationEnd(Animator animation) { }
            @Override
            public void onAnimationCancel(Animator animation) { }
            @SuppressLint("NewApi")
            @Override
            public void onAnimationRepeat(Animator animation) {
                year = LocalDateTime.now().getYear();
                month = LocalDateTime.now().getMonthValue();
                day = LocalDateTime.now().getDayOfMonth();
                hour = LocalDateTime.now().getHour();
                min = LocalDateTime.now().getMinute();
                datetxt.setText(year + "/" + month + "/" + day + " " + hour + ":" + min);
            }
        });
    }


    private static int getSystemUiFlags() {
        return View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
    }

    @Override
    public void setValue(String packageName) {
       // Toast.makeText(this,packageName, Toast.LENGTH_SHORT).show();
        phone.setText(packageName);
    }
}