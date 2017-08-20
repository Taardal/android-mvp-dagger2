package no.taardal.mvpdaggerexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import no.taardal.mvpdaggerexample.R;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.viewholder.MovieItemViewHolder;

public class MoviesAdapter extends RecyclerView.Adapter<MovieItemViewHolder> {

    private List<Movie> movies;

    public MoviesAdapter() {
        movies = new ArrayList<>();
    }

    public MoviesAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MovieItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View movieItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new MovieItemViewHolder(movieItemView);
    }

    @Override
    public void onBindViewHolder(MovieItemViewHolder movieItemViewHolder, int position) {
        movieItemViewHolder.getMovieTitleTextView().setText(movies.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        if (!this.movies.isEmpty()) {
            this.movies.clear();
        }
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

}
