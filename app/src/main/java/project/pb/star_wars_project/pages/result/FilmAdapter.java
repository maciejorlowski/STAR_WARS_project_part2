package project.pb.star_wars_project.pages.result;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.models.interfaces.models.Films;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder>{

    private Context mContext;
    private List<Films> filmsList;

    public FilmAdapter(Context mContext, List<Films> filmsList) {
        this.mContext = mContext;
        this.filmsList = filmsList;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.film_list_item,null);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder filmViewHolder, int i) {
        Films film = filmsList.get(i);
        filmViewHolder.title.setText(film.getTitle());
        filmViewHolder.episode_id.setText(film.getEpisode_id());
        filmViewHolder.director.setText(film.getDirector());
        filmViewHolder.producer.setText(film.getProducer());
        filmViewHolder.release_date.setText(film.getRelease_date());

    }

    @Override
    public int getItemCount() {
        return filmsList.size();
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder {

        TextView title,episode_id,director,producer,release_date;
        Button planets,characters,vehicles,starships,species;
        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.f_title);
            episode_id=itemView.findViewById(R.id.f_episode_id);
            director=itemView.findViewById(R.id.f_director);
            producer=itemView.findViewById(R.id.f_producer);
            release_date=itemView.findViewById(R.id.f_release_date);
        }
    }
}
