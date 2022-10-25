package jp.ac.ecc.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent intent = getIntent();
        int age = intent.getIntExtra("age",25);
        Toast.makeText(this,"年齢"+age, Toast.LENGTH_SHORT).show();

        TextView TextProfile = findViewById(R.id.TextProfile);
        EditText NameText = findViewById(R.id.NameText);
        EditText PassText = findViewById(R.id.PassText);
        Button ClearButton1 = findViewById(R.id.ClearButton1);
        Button ClearButton2 = findViewById(R.id.ClearButton2);
        Button CheckButton = findViewById(R.id.CheckButton);
        CheckBox Check10 = findViewById(R.id.Check10);
        CheckBox Check20 = findViewById(R.id.Check20);
        CheckBox Check30 = findViewById(R.id.Check30);
        RadioButton CheckMale = findViewById(R.id.CheckMale);
        RadioButton CheckFemale = findViewById(R.id.CheckFemale);

        ClearButton1.setOnClickListener((View.OnClickListener) this);
        ClearButton2.setOnClickListener((View.OnClickListener) this);
        CheckButton.setOnClickListener((View.OnClickListener) this);

        ClearButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setTitle(PassText.getText());

                return false;
            }
        });

        CheckButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (CheckMale.isChecked()==true) {
                    Toast.makeText(getApplicationContext(),"男",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"女",Toast.LENGTH_LONG).show();
                }

                finish();
                return false;
            }
        });
    }

        @Override
        public void onClick(View view){
        EditText NameText = findViewById(R.id.NameText);
        EditText PassText = findViewById(R.id.PassText);
        switch(view.getId()) {
            case R.id.ClearButton1:
                NameText.setText("");
                break;

            case R.id.ClearButton2:
                PassText.setText("");
                setTitle(R.string.app_name);
                break;

            case R.id.CheckButton:
                Toast.makeText(this,NameText.getText(),Toast.LENGTH_SHORT).show();
                break;

        }
        }
    }