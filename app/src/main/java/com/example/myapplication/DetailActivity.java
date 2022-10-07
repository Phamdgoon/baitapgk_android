package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView image;
    TextView playerName, playerDetail, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        image = (ImageView) findViewById(R.id.img);
        playerName = (TextView) findViewById(R.id.playerName);
        playerDetail = (TextView) findViewById(R.id.detail);
        back = (TextView) findViewById(R.id.back);

        String name = getIntent().getStringExtra("playerName");
        String detail = getIntent().getStringExtra("detail");
        Bundle bundle = getIntent().getExtras();
        int img = bundle.getInt("img");

        playerName.setText(name);
        playerDetail.setText(detail);
        image.setImageResource(img);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, ListPlayer.class);
                startActivity(intent);
            }
        });
    }
}