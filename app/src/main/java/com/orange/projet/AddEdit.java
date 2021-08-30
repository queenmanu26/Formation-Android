package com.orange.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.lights.LightState;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEdit extends AppCompatActivity {

    Button btn_ok, btn_cancel;
    List<Movie> movieList;
    EditText et_movDate, et_movName, et_movImageURL;
    TextView tv_movId;
    int id;

    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        movieList =myApplication.getMovieList();

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_movDate = findViewById(R.id.et_datePublication);
        et_movName = findViewById(R.id.et_movieName);
        et_movImageURL = findViewById(R.id.et_imageURL);
        tv_movId = findViewById(R.id.tv_id);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        Movie movie = null;

        // ajout d'un movie
        if (id >= 0){
            for (Movie m: movieList) {
                if (m.getId() == id) {
                    movie = m;

                }
            }
                et_movName.setText(movie.getNom());
                et_movDate.setText(String.valueOf(movie.getDatePublication()));
                et_movImageURL.setText(movie.getImageURL());
                tv_movId.setText(String.valueOf(id));

        }
        else {

        }

        btn_ok.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if(id >= 0) {
                    // update
                    Movie updatedMovie = new Movie(id, et_movName.getText().toString(), Integer.parseInt(et_movDate.getText().toString()), et_movImageURL.getText().toString());
                     movieList.set(id, updatedMovie);
                }
                else {
                    //creation d'un objet movie
                    int nextId = myApplication.getNextId();
                    Movie newMovie = new Movie(nextId, et_movName.getText().toString(), Integer.parseInt(et_movDate.getText().toString()),et_movImageURL.getText().toString());
                    // ajout des movies dans la liste globale
                    movieList.add(newMovie);
                    myApplication.setNextId(nextId++);


                }





                Intent intent = new Intent(AddEdit.this, MainActivity.class );
                startActivity(intent);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEdit.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }
}