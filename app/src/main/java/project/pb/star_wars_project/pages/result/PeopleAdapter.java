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
        View view = inflater.inflate(R.layout.people_list_item,null);
        return new PeopleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewHolder peopleViewHolder, int i) {

        People people = peopleList.get(i);
        peopleViewHolder.name.setText(people.getName());
        peopleViewHolder.height.setText(people.getHeight());
        peopleViewHolder.mass.setText(people.getMass());
        peopleViewHolder.hair_color.setText(people.getHair_color());
        peopleViewHolder.skin_color.setText(people.getSkin_color());
        peopleViewHolder.eye_color.setText(people.getEye_color());
        peopleViewHolder.birth_year.setText(people.getBirth_year());
        peopleViewHolder.gender.setText(people.getGender());
        peopleViewHolder.homeworld.setText(people.getHomeworld());
       // filmsList=people.getFilms();

    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    class PeopleViewHolder extends RecyclerView.ViewHolder{

        TextView name,height,mass,hair_color,skin_color,eye_color,birth_year,gender,homeworld;
        Button films,vehicles,starships,species;

        public PeopleViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.r_name);
            height=itemView.findViewById(R.id.r_height);
            name=itemView.findViewById(R.id.r_name);
            mass=itemView.findViewById(R.id.r_mass);
            hair_color=itemView.findViewById(R.id.r_hair_color);
            skin_color=itemView.findViewById(R.id.r_skin_color);
            eye_color=itemView.findViewById(R.id.r_eye_color);
            birth_year=itemView.findViewById(R.id.r_birth_year);
            gender=itemView.findViewById(R.id.r_gender);
            homeworld=itemView.findViewById(R.id.r_homeworld);
            films=itemView.findViewById(R.id.r_films);
            vehicles=itemView.findViewById(R.id.r_vehicles);
            starships=itemView.findViewById(R.id.r_starships);
            species=itemView.findViewById(R.id.r_species);
        }
    }
}
