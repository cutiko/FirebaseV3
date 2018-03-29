package cl.cutiko.firebaseuitesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //THERE IS A JSON FILE INSIDE THE MAIN FOLDER

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Movie> options = new FirebaseRecyclerOptions.Builder<Movie>()
                .setQuery(new Nodes().movies(), Movie.class)
                .setLifecycleOwner(this)
                .build();

        MovieAdapter movieAdapter = new MovieAdapter(options);
        recyclerView.setAdapter(movieAdapter);

    }
}
