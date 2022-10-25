package jp.ac.ecc.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        //このアプリのを保存
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);

        //変数宣言
        //String thoughtsSt = pref.getString("memo","");
        EditText thoughtsText = findViewById(R.id.thoughtsText);
        Button saveBt = findViewById(R.id.saveButton);
        Button cancelBt = findViewById(R.id.cancelButton);
        Button resetBt= findViewById(R.id.resetButton);
        //カレーごとにプリファレンスを分ける
        String menu[]={"dry","cutlet","cheese","soup","memo"};

        //受け取り情報の宣言
        Intent intent = getIntent();
        int curry = intent.getIntExtra("curry",4);

        //設定
        String thoughtsSt = pref.getString(menu[curry],"");
        thoughtsText.setText(thoughtsSt);
        SharedPreferences.Editor editor=pref.edit();
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=pref.edit();
                editor.putString(menu[curry],thoughtsText.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(),"保存しました",Toast.LENGTH_SHORT).show();
            }
        });

        cancelBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"終了します",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        resetBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("memo",null);
                editor.apply();
                Toast.makeText(getApplicationContext(),"リセットしました",Toast.LENGTH_SHORT).show();

                thoughtsText.setText(null);

            }
        });
    }
}