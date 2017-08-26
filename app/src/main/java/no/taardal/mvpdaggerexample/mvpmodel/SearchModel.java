package no.taardal.mvpdaggerexample.mvpmodel;

import no.taardal.mvpdaggerexample.mvppresenter.SearchPresenter;

public interface SearchModel {

    void search(String query, SearchPresenter searchPresenter);

}
