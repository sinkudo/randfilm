package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.example.myapplication.Film;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    List<Film>filmlist;
    Button button;
    TextView name, year, country, dur, kinopoisk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.filmButton);
        name = (TextView) findViewById(R.id.filmname);
        country = (TextView) findViewById(R.id.filmcountry);
        dur = (TextView) findViewById(R.id.filmduration);
        year = (TextView) findViewById(R.id.filmyear);
        kinopoisk = (TextView) findViewById(R.id.filmrate);
        Resources r = getResources();
        InputStream stream = r.openRawResource(R.raw.films);
        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Film>>(){}.getType();
        filmlist = gson.fromJson(reader, listType);
    }
    public void click(View view){
        if (filmlist.size()== 0) {
            button.setText("No more films");
//            (Button)findViewById(R.id.filmButton)
            name.setText("");
            year.setText("");
            country.setText("");
            country.setText("");
            kinopoisk.setText("");
            dur.setText("");
            return;
        }
        int ind = (int) (Math.random() * filmlist.size());
        Film randfilm = filmlist.get(ind);
        name.setText(String.format("name: %s", randfilm.name));
        year.setText(String.format("year: %s", randfilm.year));
        country.setText(String.format("country: %s", randfilm.country));
        dur.setText(String.format("dur: %s min", randfilm.duration));
        kinopoisk.setText(String.format("rating: %s", randfilm.kinopoisk));
//        Toast.makeText(this, randfilm, Toast.LENGTH_SHORT).show();

        filmlist.remove(ind);
    }
}