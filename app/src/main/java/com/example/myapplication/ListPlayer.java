package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListPlayer extends AppCompatActivity {
    ListView lvPlayer;
    ArrayList<Player> arrayPlayer;
    PlayersAdapter adapter;
    TextView back;


    int vitri = -1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_player);

        lvPlayer = (ListView) findViewById(R.id.lvPlayer);
        back = (TextView) findViewById(R.id.back);

        mapping();

        adapter = new PlayersAdapter(this, R.layout.activity_item, arrayPlayer);
        lvPlayer.setAdapter(adapter);

        ArrayAdapter adapter = new ArrayAdapter(
                ListPlayer.this,
                android.R.layout.simple_list_item_1,
                arrayPlayer
        );

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListPlayer.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lvPlayer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Player course = arrayPlayer.get(position);
                Intent intent = new Intent(ListPlayer.this, DetailActivity.class);

                intent.putExtra("img", course.getImage());
                intent.putExtra("playerName", course.getName());
                intent.putExtra("detail", course.getDetail());

                startActivity(intent);
            }
        });

    }
    private void mapping() {
        lvPlayer = (ListView) findViewById(R.id.lvPlayer);
        arrayPlayer = new ArrayList<>();

        arrayPlayer.add(new Player("Ronaldo", "Xuất sắc nhất thế giới" , R.drawable.cr7, "Cristiano Ronaldo dos Santos Aveiro ( born 5 February 1985)  is a Portuguese professional footballer who plays as a forward for Premier League club Manchester United and captains the Portugal national team.Widely regarded as one of the greatest players of all time, Ronaldo has won five Ballon d'Or award and four European Golden Shoes, the most by a European player. "));
        arrayPlayer.add(new Player("Messi", "Đi bộ vuốt râu" , R.drawable.m10, "Lionel Andrés Messi  born 24 June 1987 also known as Leo Messi, is an Argentine professional footballer who plays as a forward for Ligue 1 club Paris Saint-Germain and captains the Argentina national team."));
        arrayPlayer.add(new Player("Casemero", "Tam tấu los blancos" , R.drawable.mero,"Carlos Henrique Casimiro (born 23 February 1992), known as Casemiro,[4] is a Brazilian professional footballer who plays as a defensive midfielder for Premier League club Manchester United and the Brazil national team. He is widely regarded as one of the best defensive midfielders in the world."));
        arrayPlayer.add(new Player("Toni Kroos", "Tam tấu los blancos" , R.drawable.kroos,"Toni Kroos (born 4 January 1990) is a German professional footballer who plays as a midfielder for La Liga club Real Madrid. Kroos plays mainly as a central midfielder, but has also been deployed as a deep-lying playmaker in his career. He is known for his vision, passing, creativity, crossing and set-piece ability, and is widely regarded as one of the greatest midfielders of all time."));
        arrayPlayer.add(new Player("Luca Modric", "Tam tấu los blancos", R.drawable.dric,"Luka Modrić (Croatian pronunciation: [lûːka mǒːdritɕ]; born 9 September 1985) is a Croatian professional footballer who plays as a midfielder for La Liga club Real Madrid and captains the Croatia national team. He plays mainly as a central midfielder, but can also play as an attacking midfielder or as a defensive midfielder."));
    }


}