package com.example.windows.retrofit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
{
    ImageView iv_hero, iv_hero0, iv_hero1, iv_hero2; //variabel global
    Button btn_kamera, maps;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_hero0 = (ImageView)findViewById(R.id.iv_hero0); //akses id iv_hero pada layout activity main
        iv_hero1 = (ImageView)findViewById(R.id.iv_hero1); //akses id iv_hero1 pada layout activity main
        iv_hero2 = (ImageView)findViewById(R.id.iv_hero2); //akses id iv_hero2 pada layout activity main
        String imageUri = "http://senpuu.com.br/wpcontent/uploads/2013/03/1172317494990.jpg";
        String imageUri1 = "http://orig13.deviantart.net/e215/f/2014/023/d/4/anonymous_facebook_profil_by_24eri-d73cu1y.jpg";
        String imageUri2 = "http://senpuu.com.br/wp-content/uploads/2013/03/1172317494990.jpg";
        Picasso.with(this).load(imageUri).placeholder(R.drawable.profil).error(R.drawable.error).into(iv_hero0);
        Picasso.with(this).load(imageUri1).resize(100,100).into(iv_hero1);
        Picasso.with(this).load(imageUri2).rotate(180).into(iv_hero2);

        //....................................................................................
        iv_hero = (ImageView)findViewById(R.id.iv_hero); //akses id iv_hero pada layout activity main
        btn_kamera = (Button)findViewById(R.id.btn1); // akses id btn1 pada variabel btn_kamera
        btn_kamera.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,1);
            }
        });
        //.....................................................................................
        maps = (Button)findViewById(R.id.btn0); //akses id btn0 pada variabel maps
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, MapsActivity.class); //Berpindah ke class MapsActivity
                startActivity(in);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(1 == requestCode && resultCode == RESULT_OK)
        {
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            iv_hero.setImageBitmap(bitmap);
        }
    }
}
