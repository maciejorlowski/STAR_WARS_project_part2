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
import project.pb.star_wars_project.models.interfaces.models.Species;

import java.util.List;

public class SpeciesFavoriteAdapter extends RecyclerView.Adapter<SpeciesFavoriteAdapter.SpeciesFavoriteViewHolder> {

    Context myContext;
    List<Species> speciesList;

    public SpeciesFavoriteAdapter(Context myContext, List<Species> speciesList)
    {
        this.myContext = myContext;
        this.speciesList = speciesList;
    }

    @NonNull
    @Override
    public SpeciesFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View view = inflater.inflate(R.layout.favorite_species_card, null);
        return new SpeciesFavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesFavoriteViewHolder speciesFavoriteViewHolder, int i) {
    Species species = speciesList.get(i);
    speciesFavoriteViewHolder.name.setText(species.getName());
    speciesFavoriteViewHolder.imageView.setImageResource(R.drawable.logo);
    }

    @Override
    public int getItemCount() {
        return speciesList.size();
    }

    public class SpeciesFavoriteViewHolder extends  RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;
        public SpeciesFavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.fav_species_name);
            imageView  = itemView.findViewById(R.id.fav_species_image);
        }
    }
}
