package project.pb.star_wars_project.pages.result;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import project.pb.star_wars_project.R;
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
        View view = inflater.inflate(R.layout.species_list_item,null);
        return new SpeciesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesViewHolder speciesViewHolder, int i) {

        Species specie=speciesList.get(i);
        speciesViewHolder.name.setText(specie.getName());
        speciesViewHolder.height.setText(specie.getAverage_height());
        speciesViewHolder.classification.setText(specie.getClassification());
        speciesViewHolder.hair_color.setText(specie.getHair_colors());
        speciesViewHolder.skin_color.setText(specie.getSkin_colors());
        speciesViewHolder.eye_color.setText(specie.getEye_colors());
        speciesViewHolder.avarage_lifespan.setText(specie.getAverage_lifespan());
        speciesViewHolder.language.setText(specie.getLanguage());
        speciesViewHolder.designation.setText(specie.getDesignation());
        speciesViewHolder.homeworld.setText(specie.getHomeworld());
    }

    @Override
    public int getItemCount() {
        return speciesList.size();
    }

    public class SpeciesViewHolder extends RecyclerView.ViewHolder {

        TextView name,height,classification,hair_color,skin_color,eye_color,avarage_lifespan,language,designation,homeworld;
        public SpeciesViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.sp_name);
            height=itemView.findViewById(R.id.sp_height);
            classification=itemView.findViewById(R.id.sp_classification);
            avarage_lifespan=itemView.findViewById(R.id.sp_av_lifespan);
            language=itemView.findViewById(R.id.sp_language);
            skin_color=itemView.findViewById(R.id.sp_skin_color);
            eye_color=itemView.findViewById(R.id.sp_eye_color);
            hair_color=itemView.findViewById(R.id.sp_hair_color);
            designation=itemView.findViewById(R.id.sp_designation);
            homeworld=itemView.findViewById(R.id.sp_homeworld);
        }
    }
}
