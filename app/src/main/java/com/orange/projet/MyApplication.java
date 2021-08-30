package com.orange.projet;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    private static List<Movie> movieList = new ArrayList<Movie>();
    private static int nextId = 10;

    public MyApplication() {
        fillMovieList();
    }

    private void fillMovieList() {
        movieList.add(new Movie(0, "Malcom&Marie", 2021, "https://media.senscritique.com/media/000019812954/150/Malcolm_Marie.jpg"));
        movieList.add(new Movie(1, "To All The Boys", 2020, "https://media.senscritique.com/media/000019813287/150/A_tous_les_garcons_Pour_toujours_et_a_jamais.jpg"));
        movieList.add(new Movie(2, "Coming2 America", 2021, "https://media.senscritique.com/media/000019823671/150/Un_prince_a_New_York_2.jpg"));
        movieList.add(new Movie(3,"Cherry",2021,"https://media.senscritique.com/media/000019914896/150/Cherry.jpg"));
        movieList.add(new Movie(4,"Sacrées Sorcières",2021,"https://media.senscritique.com/media/000019960770/150/Sacrees_sorcieres.jpg"));
        movieList.add(new Movie(5, "Wonder Woman 1984",1984,"https://media.senscritique.com/media/000020028869/150/Wonder_Woman_1984.jpg"));
        movieList.add(new Movie(6,"Monster Hunter",2021,"https://media.senscritique.com/media/000019860764/150/Monster_Hunter.jpg"));
        movieList.add(new Movie(7,"Godzilla Vs Kong",2021,"https://media.senscritique.com/media/000020010058/150/Godzilla_vs_Kong.jpg"));
        movieList.add(new Movie(8,"Mortal Kombat",2021,"https://media.senscritique.com/media/000020027194/150/Mortal_Kombat.jpg"));
        movieList.add(new Movie(9,"The Woman in the Window",2021,"https://media.senscritique.com/media/000020012721/150/La_Femme_a_la_fenetre.jpg"));

    }

    public static List<Movie> getMovieList() {
        return movieList;
    }

    public static void setMovieList(List<Movie> movieList) {
        MyApplication.movieList = movieList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
