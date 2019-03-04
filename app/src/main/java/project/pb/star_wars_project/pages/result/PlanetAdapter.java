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
import project.pb.star_wars_project.models.interfaces.models.People;
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
        View view = inflater.inflate(R.layout.planet_list_item,null);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.PlanetViewHolder planetViewHolder, int i) {
        Planets planet = planetsList.get(i);
        planetViewHolder.name.setText(planet.getName());
        planetViewHolder.rotation_period.setText(planet.getRotation_period());
        planetViewHolder.orbital_period.setText(planet.getOrbital_period());
        planetViewHolder.diameter.setText(planet.getDiameter());
        planetViewHolder.climate.setText(planet.getClimate());
        planetViewHolder.gravity.setText(planet.getGravity());
        planetViewHolder.terrain.setText(planet.getTerrain());
        planetViewHolder.surface_water.setText(planet.getSurface_water());
        planetViewHolder.population.setText(planet.getPopulation());
    }

    @Override
    public int getItemCount() {
        return planetsList.size();
    }

    public class PlanetViewHolder extends RecyclerView.ViewHolder {

        TextView name,rotation_period,orbital_period,diameter,climate,gravity,terrain,surface_water,population;
        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.pl_name);
            rotation_period=itemView.findViewById(R.id.pl_rotation_per);
            orbital_period=itemView.findViewById(R.id.pl_orbital_per);
            diameter=itemView.findViewById(R.id.pl_diameter);
            climate=itemView.findViewById(R.id.pl_climate);
            gravity=itemView.findViewById(R.id.pl_gravity);
            terrain=itemView.findViewById(R.id.pl_terrain);
            surface_water=itemView.findViewById(R.id.pl_surface_water);
            population=itemView.findViewById(R.id.pl_population);

        }
    }
}
