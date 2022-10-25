package jp.ac.ecc.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import kotlin.text.UStringsKt;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String[] curryList ={"ドライカレー","カツカレー","チーズカレー","スープカレー"};


        //変数宣言
        ListView listView = findViewById(R.id.currylist);
        Intent intentPref = new Intent(this,PreferenceActivity.class);
        //アダプター設定
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,curryList);

        //設定
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView)view;
                String st = (String)adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(),(String) adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
                //画面の何番目?
                intentPref.putExtra("curry",i);
                        startActivity(intentPref);

            }
        });
    }
}