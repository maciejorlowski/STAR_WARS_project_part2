package project.pb.star_wars_project.pages.result;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.functional.navigation.NavManager;
import project.pb.star_wars_project.models.interfaces.models.Planets;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>{

    private Context mContext;

    public PlanetAdapter(Context mContext, List<Planets> planetsList) {
        this.mContext = mContext;
        this.planetsList = planetsList;
    }

    private List<Planets> planetsList;

    @NonNull
    @Override
    public PlanetAdapter.PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.planet_single_item,null);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.PlanetViewHolder planetViewHolder, int i) {
        final Planets planet = planetsList.get(i);
        planetViewHolder.name.setText(planet.getName());
        planetViewHolder.population.setText(planet.getPopulation());
        planetViewHolder.imageView.setImageResource(R.drawable.logo);
        planetViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setPlanet(planet);
                detailFragment.setSelect(6);
                NavManager navManager = new NavManager((FragmentActivity) mContext);
                navManager.navigate(detailFragment, true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return planetsList.size();
    }

    public class PlanetViewHolder extends RecyclerView.ViewHolder {

        TextView name,population;
        ImageView imageView;
        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.planet);
            population=itemView.findViewById(R.id.planet_population_label);
            imageView=itemView.findViewById(R.id.planet_image_view);

        }
    }
}
