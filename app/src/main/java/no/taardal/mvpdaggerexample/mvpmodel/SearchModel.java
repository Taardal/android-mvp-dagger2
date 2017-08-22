package no.taardal.mvpdaggerexample.mvpmodel;

import no.taardal.mvpdaggerexample.listener.MovieListener;

public interface SearchModel {

    void search(String query, MovieListener movieListener);

}
