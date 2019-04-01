package project.pb.star_wars_project.pages.favorite;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.models.interfaces.models.Planets;

import java.util.List;

public class PlanetsFavoriteAdapter extends RecyclerView.Adapter<PlanetsFavoriteAdapter.PlanetsFavoriteViewHolder> {


    Context myContext;
    List<Planets> planetLst;

    public PlanetsFavoriteAdapter(Context myContext, List<Planets> planetLst)
    {
        this.myContext = myContext;
        this.planetLst = planetLst;
    }
    @NonNull
    @Override
    public PlanetsFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View view = inflater.inflate(R.layout.favorite_planet_card, null);
        return new PlanetsFavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetsFavoriteViewHolder planetsFavoriteViewHolder, int i) {
        Planets planets = planetLst.get(i);
        planetsFavoriteViewHolder.name.setText(planets.getName());
        planetsFavoriteViewHolder.imageView.setImageResource(R.drawable.logo);
    }

    @Override
    public int getItemCount() {
        return planetLst.size();
    }

    public class PlanetsFavoriteViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;
        public PlanetsFavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            name  = itemView.findViewById(R.id.fav_planet_name);
            imageView = itemView.findViewById(R.id.fav_planet_image);
        }
    }
}
