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
        peopleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        }
    }
}
