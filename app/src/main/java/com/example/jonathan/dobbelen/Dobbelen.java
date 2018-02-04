package com.example.jonathan.dobbelen;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class Dobbelen extends AppCompatActivity {
    private ImageView dobbelsteenView1;
    private ImageView dobbelsteenView2;

    /**
     * "An Activity is not fully initialized and ready to look up views until after setContentView(...) is called in onCreate()."
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dobbelen);

        Button dobbelButton = findViewById(R.id.btnRoll);
        dobbelsteenView2 = findViewById(R.id.dobbelsteen2);
        dobbelsteenView1 = findViewById(R.id.dobbelsteen1);

//        ImageView dobbelsteenView1 = findViewById(R.id.dobbelsteen1);
//        ImageView dobbelsteenView2 = findViewById(R.id.dobbelsteen2);

        dobbelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                updateDobbelstenen(dobbelsteenView1, r.nextInt(6) + 1);
                updateDobbelstenen(dobbelsteenView2, r.nextInt(6) + 1);
            }
        });
    }

    private void updateDobbelstenen(ImageView v, int randomNumber) {
        String uri = "@drawable/die" + randomNumber;  // where myresource (without the extension) is the file
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        v.setImageDrawable(res);

        //first attempt
//        Bitmap bmImg = BitmapFactory.decodeFile("drawable/die" + randomNumber + ".png");
//        v.setImageDrawable(Drawable.createFromPath() randomNumber + ".png"));
//        v.setImageDrawable(Drawable.createFromPath("drawable/die" + randomNumber + ".png"));
    }


}
