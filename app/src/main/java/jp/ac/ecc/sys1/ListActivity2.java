package jp.ac.ecc.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity2 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        String[] arrayList = {};

        //
        Intent intentSub = new Intent(this,SubActivity.class);
        Intent intentEvent = new Intent(this,EventActivity.class);


        ListView listView = findViewById(R.id.arrayList);
        EditText EditText = findViewById(R.id.EditText);
        Button button1 = findViewById(R.id.button1);

        //
        ArrayList<String> dataList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tT = EditText.getText().toString();
                if (!tT.equals("")) {
                    dataList.add(tT);
//                    listView.setAdapter(adapter);
                    EditText.setText("");
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i%2){
                    case 1:
                        startActivity(intentEvent);
                        break;
                    case 0:
                        startActivity(intentSub);
                        break;
                }
            }
        });
    }
}

