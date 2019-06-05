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
import project.pb.star_wars_project.models.interfaces.models.Species;

import java.util.List;

public class SpeciesAdapter extends RecyclerView.Adapter<SpeciesAdapter.SpeciesViewHolder>{

    private Context mContext;
    private List<Species> speciesList;

    public SpeciesAdapter(Context mContext, List<Species> speciesList) {
        this.mContext = mContext;
        this.speciesList = speciesList;
    }

    @NonNull
    @Override
    public SpeciesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.species_single_item,null);
        return new SpeciesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesViewHolder speciesViewHolder, int i) {

        final Species specie=speciesList.get(i);
        speciesViewHolder.name.setText(specie.getName());
        speciesViewHolder.classification.setText(specie.getClassification());
        speciesViewHolder.imageView.setImageResource(R.drawable.logo);
        speciesViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setSpecie(specie);
                detailFragment.setSelect(5);
                NavManager navManager = new NavManager((FragmentActivity) mContext);
                navManager.navigate(detailFragment, true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return speciesList.size();
    }

    public class SpeciesViewHolder extends RecyclerView.ViewHolder {

        TextView name,classification;
        ImageView imageView;
        public SpeciesViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.specie_name);
            classification=itemView.findViewById(R.id.specie_classification_label);
            imageView=itemView.findViewById(R.id.specie_image_view);
        }
    }
}
