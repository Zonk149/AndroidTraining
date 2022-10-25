package jp.ac.ecc.sys1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import java.net.URI;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();
        final int CAMERA_RESULT = 100;
        Bitmap bitmap = data.getParcelableExtra("data");
                ImageView.setImageBitmap(bitmap);
                ImageView.setImageURI(IntentActivity.imageUri);
        ImageView ImageView = findViewById(R.id.imageView);
    }
}