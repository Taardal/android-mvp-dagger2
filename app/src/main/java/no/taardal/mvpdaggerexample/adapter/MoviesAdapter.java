package no.taardal.mvpdaggerexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import no.taardal.mvpdaggerexample.R;
import no.taardal.mvpdaggerexample.movie.Movie;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieItemViewHolder> {

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
        Movie movie = movies.get(position);
        movieItemViewHolder.titleTextView.setText(movie.getTitle());
        if (movie.getReleaseDate() != null) {
            movieItemViewHolder.releaseDateTextView.setText(movie.getReleaseDate());
        }
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

    class MovieItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_movie_item_title)
        TextView titleTextView;

        @BindView(R.id.text_view_movie_item_release_date)
        TextView releaseDateTextView;

        MovieItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
