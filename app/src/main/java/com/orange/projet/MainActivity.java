package com.orange.projet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Movies App" ;
    Button btn_add;

    MyApplication myApplication = (MyApplication) this.getApplication();

    List<Movie> movieList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = myApplication.getMovieList();

        Log.d(TAG, "onCreate:" +movieList.toString());
        Toast.makeText(this, "movies count = " +movieList.size(), Toast.LENGTH_SHORT).show();

        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEdit.class );
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.lv_movieList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerviewAdapter(movieList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.menu_aToz:
                Collections.sort(movieList, Movie.MovieNameAZComparator);
                Toast.makeText(MainActivity.this, "A à Z", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menu_zToa:
                Collections.sort(movieList, Movie.MovieNameZAComparator);
                Toast.makeText(MainActivity.this, "Z à A", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menu_dateAscending:
                Collections.sort(movieList, Movie.MovieDateAscendingComparator);
                Toast.makeText(MainActivity.this, "Date descending", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menu_dateDescending:
                Collections.sort(movieList, Movie.MovieDateDescendingComparator);
                Toast.makeText(MainActivity.this, "Date descending", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}