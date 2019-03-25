package project.pb.star_wars_project.pages.result;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.functional.navigation.NavManager;
import project.pb.star_wars_project.models.interfaces.models.Films;
import project.pb.star_wars_project.models.interfaces.models.People;
import project.pb.star_wars_project.pages.searching.SearchingFragment;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>{

    private Context mContext;
    private List<People> peopleList;
    private List<Films> filmsList;

    public PeopleAdapter(Context mContext, List<People> peopleList) {
        this.mContext = mContext;
        this.peopleList = peopleList;
    }

    @NonNull
    @Override
    public PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.people_single_item,null);
        return new PeopleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewHolder peopleViewHolder, int i) {

        final People people = peopleList.get(i);
        peopleViewHolder.name.setText(people.getName());
        peopleViewHolder.birth_year.setText(people.getBirth_year());
        peopleViewHolder.imageView.setImageResource(R.drawable.logo);
       /* peopleViewHolder.height.setText(people.getHeight());
        peopleViewHolder.mass.setText(people.getMass());
        peopleViewHolder.hair_color.setText(people.getHair_color());
        peopleViewHolder.skin_color.setText(people.getSkin_color());
        peopleViewHolder.eye_color.setText(people.getEye_color());
        peopleViewHolder.gender.setText(people.getGender());
        peopleViewHolder.homeworld.setText(people.getHomeworld());*/
        peopleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Recycle Click", Toast.LENGTH_SHORT).show();
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setPeople(people);
                detailFragment.setSelect(1);
                NavManager navManager = new NavManager((FragmentActivity) mContext);
                navManager.navigate(detailFragment, true);
            }
        });

    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    class PeopleViewHolder extends RecyclerView.ViewHolder{

        TextView name,birth_year;
        //Button films,vehicles,starships,species;
        ImageView imageView;

        public PeopleViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.people_name);
            birth_year=itemView.findViewById(R.id.people_birth_year_label);
            imageView=itemView.findViewById(R.id.people_image_view);
           /* height=itemView.findViewById(R.id.r_height);
            mass=itemView.findViewById(R.id.r_mass);
            hair_color=itemView.findViewById(R.id.r_hair_color);
            skin_color=itemView.findViewById(R.id.r_skin_color);
            eye_color=itemView.findViewById(R.id.r_eye_color);
            gender=itemView.findViewById(R.id.r_gender);
            homeworld=itemView.findViewById(R.id.r_homeworld);
            films=itemView.findViewById(R.id.r_films);
            vehicles=itemView.findViewById(R.id.r_vehicles);
            starships=itemView.findViewById(R.id.r_starships);
            species=itemView.findViewById(R.id.r_species);*/
        }
    }
}
