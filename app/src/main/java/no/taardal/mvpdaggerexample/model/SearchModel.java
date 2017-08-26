package no.taardal.mvpdaggerexample.model;

import no.taardal.mvpdaggerexample.presenter.SearchPresenter;

public interface SearchModel {

    void search(String query, SearchPresenter searchPresenter);

}
