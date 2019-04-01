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
import android.widget.Toast;
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
        /*speciesViewHolder.height.setText(specie.getAverage_height());
        speciesViewHolder.hair_color.setText(specie.getHair_colors());
        speciesViewHolder.skin_color.setText(specie.getSkin_colors());
        speciesViewHolder.eye_color.setText(specie.getEye_colors());
        speciesViewHolder.avarage_lifespan.setText(specie.getAverage_lifespan());
        speciesViewHolder.language.setText(specie.getLanguage());
        speciesViewHolder.designation.setText(specie.getDesignation());
        speciesViewHolder.homeworld.setText(specie.getHomeworld());*/
        speciesViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Recycle Click", Toast.LENGTH_SHORT).show();
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
           /* height=itemView.findViewById(R.id.sp_height);
            avarage_lifespan=itemView.findViewById(R.id.sp_av_lifespan);
            language=itemView.findViewById(R.id.sp_language);
            skin_color=itemView.findViewById(R.id.sp_skin_color);
            eye_color=itemView.findViewById(R.id.sp_eye_color);
            hair_color=itemView.findViewById(R.id.sp_hair_color);
            designation=itemView.findViewById(R.id.sp_designation);
            homeworld=itemView.findViewById(R.id.sp_homeworld);*/
        }
    }
}
