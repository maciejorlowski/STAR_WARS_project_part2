package project.pb.star_wars_project.pages.favorite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.models.interfaces.models.Films;

import java.util.List;

public class FilmFavoriteAdapter extends RecyclerView.Adapter<FilmFavoriteAdapter.FilmFavoriteViewHolder> {

    Context myContext;
    List<Films> filmList;
    public FilmFavoriteAdapter(Context myContext, List<Films> filmList)
    {
        this.myContext = myContext;
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public FilmFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View view = inflater.inflate(R.layout.favorite_film_card,null);
        return new FilmFavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmFavoriteViewHolder filmFavoriteViewHolder, int i) {
        Films films = filmList.get(i);
        filmFavoriteViewHolder.name.setText(films.getTitle());
        filmFavoriteViewHolder.imageView.setImageResource(R.drawable.logo);
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public class FilmFavoriteViewHolder extends RecyclerView.ViewHolder
    {

        TextView name;
        ImageView imageView;
        public FilmFavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.fav_film_name);
            imageView = itemView.findViewById(R.id.fav_film_image);
        }
    }
}


