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

import project.pb.star_wars_project.models.interfaces.models.Starships;

import java.util.List;

public class StarshipFavoriteAdapter extends RecyclerView.Adapter<StarshipFavoriteAdapter.StarshipFavoriteViewHolder> {

    Context myContext;
    List<Starships> starshipsList;

    public StarshipFavoriteAdapter(Context myContext, List<Starships> starshipsList)
    {
        this.myContext = myContext;
        this.starshipsList = starshipsList;
    }

    @NonNull
    @Override
    public StarshipFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View view = inflater.inflate(R.layout.favorite_planet_card, null);
        return  new StarshipFavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarshipFavoriteViewHolder starshipFavoriteViewHolder, int i) {
        Starships starships = starshipsList.get(i);
        starshipFavoriteViewHolder.name.setText(starships.getName());
        starshipFavoriteViewHolder.imageView.setImageResource(R.drawable.logo);
    }

    @Override
    public int getItemCount() {
        return starshipsList.size();
    }

    public class StarshipFavoriteViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView imageView;
        public StarshipFavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.fav_starship_name);
            imageView = itemView.findViewById(R.id.fav_starship_image);
        }
    }

}
