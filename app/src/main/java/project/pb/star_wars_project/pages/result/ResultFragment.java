package project.pb.star_wars_project.pages.result;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.base.BaseFragment;
import project.pb.star_wars_project.models.interfaces.models.*;

import java.util.ArrayList;
import java.util.List;

public class ResultFragment extends BaseFragment {

    RecyclerView recyclerView;
    PeopleAdapter peopleAdapter;
    PlanetAdapter planetAdapter;
    FilmAdapter filmAdapter;
    VehiclesAdapter vehiclesAdapter;
    StarshipsAdapter starshipsAdapter;
    SpeciesAdapter speciesAdapter;
    ArrayList<People> peopleList;
    ArrayList<Planets> planetList;
    ArrayList<Films> filmsList;
    ArrayList<Starships> starshipsList;
    ArrayList<Vehicles> vehiclesList;
    ArrayList<Species> speciesList;
    int select=0;

    public void setFilmsList(ArrayList<Films> filmsArrayList) {
        this.filmsList = filmsArrayList;
    }
    public void setPlanetList(ArrayList<Planets> planetList) {
        this.planetList = planetList;
    }

    public void setSpeciesList(ArrayList<Species> speciesList) {
        this.speciesList = speciesList;
    }

    public void setVehiclesList(ArrayList<Vehicles> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }

    public void setStarshipsList(ArrayList<Starships> starshipsList) {
        this.starshipsList = starshipsList;
    }

    public void setSelect(int select) {
        this.select = select;
    }
    private static ResultFragment resultInstance=null;

      public void setPeopleList(ArrayList<People> peopleList) {
        this.peopleList = peopleList;
    }

    public static ResultFragment getResultInstance(){
          if(resultInstance==null){
              resultInstance=new ResultFragment();
          }
          return resultInstance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.result_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=getView().findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if(select==1) {
            peopleAdapter = new PeopleAdapter(getContext(), peopleList);
            recyclerView.setAdapter(peopleAdapter);
        }
        else if(select==2){
            planetAdapter = new PlanetAdapter(getContext(),planetList);
            recyclerView.setAdapter(planetAdapter);
            Log.e("planetlist size",String.valueOf(planetList.size()));
        }
        else if(select==3){
            filmAdapter = new FilmAdapter(getContext(),filmsList);
            recyclerView.setAdapter(filmAdapter);
        }
        else if(select==4){
            starshipsAdapter = new StarshipsAdapter(getContext(),starshipsList);
            recyclerView.setAdapter(starshipsAdapter);
        }
        else if(select==5){
            vehiclesAdapter = new VehiclesAdapter(getContext(),vehiclesList);
            recyclerView.setAdapter(vehiclesAdapter);
        }
        else if(select==6){
            speciesAdapter = new SpeciesAdapter(getContext(),speciesList);
            recyclerView.setAdapter(speciesAdapter);
        }
    }
}
