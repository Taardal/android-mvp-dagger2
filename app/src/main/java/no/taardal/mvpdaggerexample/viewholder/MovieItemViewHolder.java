package no.taardal.mvpdaggerexample.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import no.taardal.mvpdaggerexample.R;

public class MovieItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_view_movie_item_title)
    TextView movieTitleTextView;

    public MovieItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public TextView getMovieTitleTextView() {
        return movieTitleTextView;
    }
}
