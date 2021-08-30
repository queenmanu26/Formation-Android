package com.orange.projet;

import java.util.Comparator;

public class Movie {
    private int id;
    private String nom;
    private int datePublication;
    private String imageURL;

    public Movie(int id, String nom, int datePublication, String imageURL) {
        this.id = id;
        this.nom = nom;
        this.datePublication = datePublication;
        this.imageURL = imageURL;
    }
     public static Comparator<Movie> MovieNameAZComparator = new Comparator<Movie>() {
         @Override
         public int compare(Movie m1, Movie m2) {
             return m1.getNom().compareTo(m2.getNom());
         }
     };

    public static Comparator<Movie> MovieNameZAComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            return m2.getNom().compareTo(m1.getNom());
        }
    };

    public static Comparator<Movie> MovieDateAscendingComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            return m1.getDatePublication() - m2.getDatePublication();
        }
    };

    public static Comparator<Movie> MovieDateDescendingComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            return m2.getDatePublication() - m1.getDatePublication();
        }
    };
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", datePublication=" + datePublication +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(int datePublication) {
        this.datePublication = datePublication;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
