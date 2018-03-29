package cl.cutiko.firebaseuitesting;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MovieAdapter extends FirebaseRecyclerAdapter<Movie, MovieAdapter.MovieHolder> {


    public MovieAdapter(@NonNull FirebaseRecyclerOptions<Movie> options) {
        super(options);
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull MovieHolder holder, int position, @NonNull Movie movie) {
        holder.name.setText(movie.getName());
        holder.score.setText(movie.getScore());
    }



    class MovieHolder extends RecyclerView.ViewHolder {

        private TextView name, score;

        public MovieHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTv);
            score = itemView.findViewById(R.id.scoreTv);
        }
    }

}
