package com.lixin.diskmonitor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    public static boolean editIsOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editIsOn = true;
        final LocalStorage localStorage = new LocalStorage(this,"app");
        final EditText editText = findViewById(R.id.edit_phone);
        final EditText editText2 =  findViewById(R.id.edit_table_num);
        final EditText editText3 =  findViewById(R.id.edit_web_num);
        final EditText editText4 =  findViewById(R.id.edit_gameID);
        final EditText editText5 =  findViewById(R.id.editText);
        final EditText editText6 =  findViewById(R.id.editMar);
        final EditText editText7 =  findViewById(R.id.editSpeed);

        editText.setText(localStorage.getStr("p_num", "+85568520718"));
        editText2.setText(localStorage.getStr("dk", "FT1"));
        editText3.setText(localStorage.getStr("groupId", "1"));
        editText4.setText(localStorage.getStr("gameId", "101"));
        editText5.setText(localStorage.getStr("IP", "ws://202.134.97.140"));
        editText6.setText(localStorage.getStr("mar", "欢迎您的来电  亚洲最佳娱乐平台"));
        editText7.setText(localStorage.getInt("marSped", 1000) + "");

        Button button = findViewById(R.id.confirm_btn);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                localStorage.putStr("p_num", editText.getText().toString().trim());
                localStorage.putStr("dk", editText2.getText().toString().trim());
                localStorage.putStr("groupId", editText3.getText().toString().trim());
                localStorage.putStr("gameId", editText4.getText().toString().trim());
                localStorage.putStr("IP", editText5.getText().toString().trim());
                localStorage.putStr("mar", editText6.getText().toString().trim());
                localStorage.putInt("marSped", Integer.parseInt(editText7.getText().toString().trim()));
                gogo();
            }
        });
    }

    private void gogo(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        editIsOn = false;
    }
}