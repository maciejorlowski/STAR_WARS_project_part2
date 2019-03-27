package project.pb.star_wars_project.pages.searching;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.base.BaseFragment;
import project.pb.star_wars_project.functional.rest.Rest;
import project.pb.star_wars_project.functional.rest.RestInterface;
import project.pb.star_wars_project.models.interfaces.models.People;
import project.pb.star_wars_project.models.interfaces.models.ResultsPeople;
import project.pb.star_wars_project.pages.dialogs.RetryConnectionDialog;
import project.pb.star_wars_project.pages.result.ResultFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SearchingFragment extends BaseFragment  implements AdapterView.OnItemSelectedListener, RetryConnectionDialog.RetryConnection {



    public int selectedCategory;
    public EditText name;
    public EditText title;
    public EditText model;
    public EditText birth_year;
    public EditText object_class;
    public EditText length;
    public EditText classification;
    public EditText homeworld;
    public EditText diameter;
    public EditText gravity;
    public EditText population;
    public Spinner gender;
    public ArrayAdapter<CharSequence> genders;
    public String the_name;
    public String the_title;
    public String the_model;
    public String the_birth_year;
    public String the_gender;
    public String the_class;
    public String the_length;
    public String the_classification;
    public String the_homeworld;
    public String the_diameter;
    public String the_gravity;
    public String the_population;
    public Button search;
    public ArrayList<People> people;
    private static SearchingFragment sInstance;

    public static SearchingFragment getsInstance(){
        if(sInstance==null){
            sInstance=new SearchingFragment();
        }
        return sInstance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_searching, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(!getActions().isNetworkAvailable()){
            retryConnection();
        }


         name = getView().findViewById(R.id.name);
         title = getView().findViewById(R.id.title);
         model = getView().findViewById(R.id.model);
         birth_year = getView().findViewById(R.id.birth_year);
         object_class = getView().findViewById(R.id.object_class);
         length = getView().findViewById(R.id.length);
         classification = getView().findViewById(R.id.classification);
         homeworld = getView().findViewById(R.id.homeworld);
         diameter = getView().findViewById(R.id.diameter);
         gravity = getView().findViewById(R.id.gravity);
         population = getView().findViewById(R.id.population);
         gender = getView().findViewById(R.id.gender_spinner);
         genders = ArrayAdapter.createFromResource(getContext(),R.array.gender,android.R.layout.simple_spinner_item);
         search = getView().findViewById(R.id.button);
        //tutaj piszesz kod
        Spinner categories_spinner = getView().findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> categories_adapter = ArrayAdapter.createFromResource(getContext(),R.array.categories,android.R.layout.simple_spinner_item);
        categories_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categories_spinner.setAdapter(categories_adapter);
        categories_spinner.setOnItemSelectedListener(this);
        categories_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCategory=(int)id+1;
                switch (selectedCategory){
                    case 1:
                        //people
                        clearArea();
                        showForPeople();
                        break;
                    case 2:
                        //films
                        clearArea();
                        showForFilms();
                        break;
                    case 3:
                        //starships
                        clearArea();
                        showForStarships();
                        break;
                    case 4:
                        //vehicls
                        clearArea();
                        showForVehicles();
                        break;
                    case 5:
                        //species
                        clearArea();
                        showForSpecies();
                        break;
                    case 6:
                        //planets
                        clearArea();
                        showForPlanets();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
    }

    private void retryConnection(){
        RetryConnectionDialog dialog = new RetryConnectionDialog();
        dialog.setTargetFragment(this, 300);
        dialog.setCancelable(false);
        dialog.show(getFragmentManager(), "dialog");
    }

    @Override
    public void onFinishConnection(boolean success) {
        if (success) {
            getActions().getNavManager().navigate(new SearchingFragment(), false);
        } else {
            getActions().getNavManager().goBack();
        }
    }

    public void clearArea(){
        name.setVisibility(View.GONE);
        title.setVisibility(View.GONE);
        model.setVisibility(View.GONE);
        gender.setVisibility(View.GONE);
        birth_year.setVisibility(View.GONE);
        object_class.setVisibility(View.GONE);
        length.setVisibility(View.GONE);
        classification.setVisibility(View.GONE);
        homeworld.setVisibility(View.GONE);
        diameter.setVisibility(View.GONE);
        gravity.setVisibility(View.GONE);
        population.setVisibility(View.GONE);
        name.getText().clear();
        title.getText().clear();
        model.getText().clear();
        birth_year.getText().clear();
        object_class.getText().clear();
        length.getText().clear();
        homeworld.getText().clear();
        classification.getText().clear();
        diameter.getText().clear();
        gravity.getText().clear();
        population.getText().clear();

    }
    public void showForPeople(){
        name.setVisibility(View.VISIBLE);
        genders.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genders);
        gender.setVisibility(View.VISIBLE);
        birth_year.setVisibility(View.VISIBLE);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                the_gender=genders.getItem(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void showForFilms(){
        title.setVisibility(View.VISIBLE);
    }
    public void showForStarships(){
        name.setVisibility(View.VISIBLE);
        model.setVisibility(View.VISIBLE);
        object_class.setVisibility(View.VISIBLE);
        length.setVisibility(View.VISIBLE);
    }
    public void showForVehicles(){
        name.setVisibility(View.VISIBLE);
        model.setVisibility(View.VISIBLE);
        object_class.setVisibility(View.VISIBLE);
        length.setVisibility(View.VISIBLE);
    }
    public void showForSpecies(){
        name.setVisibility(View.VISIBLE);
        classification.setVisibility(View.VISIBLE);
        homeworld.setVisibility(View.VISIBLE);
    }
    public void showForPlanets(){
        name.setVisibility(View.VISIBLE);
        diameter.setVisibility(View.VISIBLE);
        gravity.setVisibility(View.VISIBLE);
        population.setVisibility(View.VISIBLE);
    }
    public void search(){
        Log.i("click","click");
        switch (selectedCategory){
            case 1:
                //people
                searchPeople();
                break;
            case 2:
                //films
                searchFilms();
                break;
            case 3:
                //starships
                searchStarships();
                break;
            case 4:
                //vehicls
                searchVehicles();
                break;
            case 5:
                //species
               searchSpecies();
                break;
            case 6:
                //planets
                searchPlanets();
                break;
        }
    }

    public void searchPlanets() {
        the_name=name.getText().toString();
        the_diameter=diameter.getText().toString();
        the_gravity=gravity.getText().toString();
        the_population=population.getText().toString();

        SearchPlanet spl = new SearchPlanet();
        spl.plSearch(1,the_name,the_diameter,the_gravity,the_population);
    }

    public void searchSpecies() {
        the_name=name.getText().toString();
        the_classification=classification.getText().toString();
        the_homeworld=homeworld.getText().toString();

        SearchSpecies ss = new SearchSpecies();
        ss.spSearch(1,the_name,the_classification,the_homeworld);
    }

    public void searchVehicles() {
        the_name=name.getText().toString();
        the_model=model.getText().toString();
        the_class=object_class.getText().toString();
        the_length=length.getText().toString();

        SearchVehicle sv = new SearchVehicle();
        sv.vSearch(1,the_name,the_model,the_class,the_length);

    }

    public void searchStarships() {
        the_name=name.getText().toString();
        the_model=model.getText().toString();
        the_class=object_class.getText().toString();
        the_length=length.getText().toString();

        SearchStarship ss = new SearchStarship();
        ss.ssSearch(1,the_name,the_model,the_class,the_length);
    }

    public void searchFilms() {
        the_title=title.getText().toString();

        SearchFilm sf = new SearchFilm();
        sf.fSearch(1, the_title);
    }

    public void searchPeople() {
        the_name=name.getText().toString();
        the_birth_year=birth_year.getText().toString();
        Log.i("name",the_name);
        Log.i("birth",the_birth_year);
        Log.i("gender",the_gender);

        SearchPeople sp = new SearchPeople();
        sp.pSearch(1,the_name,the_birth_year,the_gender);
    }

    public void executeResult(){
        getActions().getNavManager().navigate(ResultFragment.getResultInstance(), true);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

