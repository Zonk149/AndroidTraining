package jp.ac.ecc.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_const);
      //  setContentView(R.layout.activity_const2);


       // setTitle("Sub Activity");
        TextView nameLabel = findViewById(R.id.nameLabel);
        EditText nameText = findViewById(R.id.nameText2);
        Button clearButton = findViewById(R.id.clearButton);
        Button confirmButton = findViewById(R.id.confirmButton);
        Button sendButton = findViewById((R.id.sendButton));
        nameLabel.setText ("Name");
        sendButton.setOnClickListener(this);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
            }
        });

    }

public void onClick(View view){
    Intent intent = new Intent(this,EventActivity.class);

    switch(view.getId())
    {
        case R.id.confirmButton:
            setTitle("確認ButtonClicked");
            Toast.makeText(this,"確認クリック",Toast.LENGTH_SHORT).show();
            break;
        case R.id.sendButton:
            setTitle("送信ButtonClicked");
            Toast.makeText(this,"送信クリック",Toast.LENGTH_SHORT).show();
            startActivity(intent);

            intent.putExtra("age",19);
            break;

    }
    }
}