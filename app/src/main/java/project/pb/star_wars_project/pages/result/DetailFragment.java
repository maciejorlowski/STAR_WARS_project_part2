package project.pb.star_wars_project.pages.result;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.base.BaseFragment;
import project.pb.star_wars_project.functional.navigation.NavManager;
import project.pb.star_wars_project.functional.rest.Rest;
import project.pb.star_wars_project.functional.rest.RestSingleton;
import project.pb.star_wars_project.models.interfaces.models.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends BaseFragment {

    public ConstraintLayout filmLayout;
    public ConstraintLayout peopleLayout;
    public ConstraintLayout planetLayout;
    public ConstraintLayout starshipLayout;
    public ConstraintLayout vehicleLayout;
    public ConstraintLayout specieLayout;

    private Button peopleAdapt;
    private Button vehiclesAdapt;
    private Button starshipsAdapt;
    private Button speciesAdapt;
    private Button filmsAdapt;
    private Button planetsAdapt;


    private TextView title, episode_id, director, producer, release_date;
    private TextView name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld;
    private TextView rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population;
    private TextView classification, designation, language, avarage_life_span;
    private TextView model, cost, length, max_speed, crew, passengers, cargo, consumables, manufacturer, v_class;
    private TextView hyper, mglt;

    private Films films;
    private People people;
    private Planets planet;
    private Starships starship;
    private Vehicles vehicle;
    private Species specie;
    private int select = 0;

    public void setPeople(People people) {
        this.people = people;
    }

    public void setPlanet(Planets planet) {
        this.planet = planet;
    }

    public void setStarship(Starships starship) {
        this.starship = starship;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public void setSpecie(Species specie) {
        this.specie = specie;
    }

    public void setFilms(Films films) {
        this.films = films;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViews();


        switch (select) {
            case 1:
                viewPeople();
                break;
            case 2:
                viewFilm();
                break;
            case 3:
                viewStarship();
                break;
            case 4:
                viewVehicle();
                break;
            case 5:
                viewSpecie();
                break;
            case 6:
                viewPlanet();
                break;
        }
        back = view.findViewById(R.id.button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActions().getNavManager().goBack();
            }
        });

    }

    private void findViews() {

        filmLayout = getView().findViewById(R.id.Films);
        peopleLayout = getView().findViewById(R.id.People);
        planetLayout = getView().findViewById(R.id.Planets);
        starshipLayout = getView().findViewById(R.id.Starships);
        vehicleLayout = getView().findViewById(R.id.Vehicles);
        specieLayout = getView().findViewById(R.id.Species);

        peopleAdapt = getView().findViewById(R.id.btn_people_adapt);
        filmsAdapt = getView().findViewById(R.id.btn_films_adapt);
        starshipsAdapt = getView().findViewById(R.id.btn_starships_adapt);
        vehiclesAdapt = getView().findViewById(R.id.btn_vehicles_adapt);
        speciesAdapt = getView().findViewById(R.id.btn_species_adapt);
        planetsAdapt = getView().findViewById(R.id.btn_planet_adapt);

    }

    private void viewFilm() {
        goneAll();
        filmLayout.setVisibility(View.VISIBLE);
        title = filmLayout.findViewById(R.id.f_title);
        episode_id = filmLayout.findViewById(R.id.f_episode_id);
        director = filmLayout.findViewById(R.id.f_director);
        producer = filmLayout.findViewById(R.id.f_producer);
        release_date = filmLayout.findViewById(R.id.f_release_date);
        episode_id.setText(films.getEpisode_id());
        director.setText(films.getDirector());
        producer.setText(films.getProducer());
        release_date.setText(films.getRelease_date());
        title.setText(films.getTitle());

        if (!films.characters.isEmpty()) {
            peopleAdapt.setVisibility(View.VISIBLE);
            peopleAdapt.setOnClickListener(v -> fetchPeople(films.characters));
        }
        if (!films.vehicles.isEmpty()) {
            vehiclesAdapt.setVisibility(View.VISIBLE);
            vehiclesAdapt.setOnClickListener(v -> fetchVehicules(films.vehicles));
        }
        if (!films.starships.isEmpty()) {
            starshipsAdapt.setVisibility(View.VISIBLE);
            starshipsAdapt.setOnClickListener(v -> fetchStarships(films.starships));

        }
        if (!films.species.isEmpty()) {
            speciesAdapt.setVisibility(View.VISIBLE);
            speciesAdapt.setOnClickListener(v -> fetchSpecies(films.species));
        }
        if (!films.planets.isEmpty()) {
            planetsAdapt.setVisibility(View.VISIBLE);
            planetsAdapt.setOnClickListener(v -> fetchPlanets(films.planets));
        }

        filmsAdapt.setVisibility(View.GONE);

    }

    private void viewPeople() {
        goneAll();
        peopleLayout.setVisibility(View.VISIBLE);

        name = peopleLayout.findViewById(R.id.r_name);
        height = peopleLayout.findViewById(R.id.r_height);
        mass = peopleLayout.findViewById(R.id.r_mass);
        hair_color = peopleLayout.findViewById(R.id.r_hair_color);
        skin_color = peopleLayout.findViewById(R.id.r_skin_color);
        birth_year = peopleLayout.findViewById(R.id.r_birth_year);
        homeworld = peopleLayout.findViewById(R.id.r_homeworld);
        gender = peopleLayout.findViewById(R.id.r_gender);
        eye_color = peopleLayout.findViewById(R.id.r_eye_color);

        name.setText(people.getName());
        height.setText(people.getHeight());
        mass.setText(people.getMass());
        hair_color.setText(people.getHair_color());
        skin_color.setText(people.getSkin_color());
        birth_year.setText(people.getBirth_year());
        homeworld.setText(people.getHomeworld());
        gender.setText(people.getGender());
        eye_color.setText(people.getEye_color());

        if (!people.films.isEmpty()) {
            filmsAdapt.setVisibility(View.VISIBLE);
            filmsAdapt.setOnClickListener(v -> fetchFilms(people.films));
        }
        if (!people.vehicles.isEmpty()) {
            vehiclesAdapt.setVisibility(View.VISIBLE);
            vehiclesAdapt.setOnClickListener(v -> fetchVehicules(people.vehicles));
        }
        if (!people.starships.isEmpty()) {
            starshipsAdapt.setVisibility(View.VISIBLE);
            starshipsAdapt.setOnClickListener(v -> fetchStarships(people.starships));
        }
        if (!people.species.isEmpty()) {
            speciesAdapt.setVisibility(View.VISIBLE);
            speciesAdapt.setOnClickListener(v -> fetchSpecies(people.species));
        }
        planetsAdapt.setVisibility(View.GONE);
        peopleAdapt.setVisibility(View.GONE);

    }

    private void viewPlanet() {
        goneAll();
        planetLayout.setVisibility(View.VISIBLE);
        name = planetLayout.findViewById(R.id.pl_name_pl);
        rotation_period = planetLayout.findViewById(R.id.pl_rotation_per_pl);
        orbital_period = planetLayout.findViewById(R.id.pl_orbital_per_pl);
        diameter = planetLayout.findViewById(R.id.pl_diameter_pl);
        climate = planetLayout.findViewById(R.id.pl_climate_pl);
        gravity = planetLayout.findViewById(R.id.pl_gravity_pl);
        terrain = planetLayout.findViewById(R.id.pl_terrain_pl);
        surface_water = planetLayout.findViewById(R.id.pl_surface_water_pl);
        population = planetLayout.findViewById(R.id.population_label_pl);

        name.setText(planet.getName());
        rotation_period.setText(planet.getRotation_period());
        orbital_period.setText(planet.getOrbital_period());
        diameter.setText(planet.getDiameter());
        climate.setText(planet.getClimate());
        gravity.setText(planet.getGravity());
        terrain.setText(planet.getTerrain());
        surface_water.setText(planet.getSurface_water());
        population.setText(planet.getPopulation());

        peopleAdapt.setVisibility(View.VISIBLE);
        filmsAdapt.setVisibility(View.VISIBLE);
        vehiclesAdapt.setVisibility(View.VISIBLE);
        starshipsAdapt.setVisibility(View.VISIBLE);
        speciesAdapt.setVisibility(View.GONE);

        if (!planet.residents.isEmpty()) {
            peopleAdapt.setVisibility(View.VISIBLE);
            peopleAdapt.setOnClickListener(v -> fetchPeople(planet.residents));
        }
        if (!planet.films.isEmpty()) {
            filmsAdapt.setVisibility(View.VISIBLE);
            filmsAdapt.setOnClickListener(v -> fetchFilms(planet.films));
        }
        vehiclesAdapt.setVisibility(View.GONE);
        starshipsAdapt.setVisibility(View.GONE);
        speciesAdapt.setVisibility(View.GONE);
        planetsAdapt.setVisibility(View.GONE);

    }

    private void viewSpecie() {
        goneAll();
        specieLayout.setVisibility(View.VISIBLE);
        name = specieLayout.findViewById(R.id.sp_name);
        height = specieLayout.findViewById(R.id.sp_height);
        classification = specieLayout.findViewById(R.id.sp_classification);
        hair_color = specieLayout.findViewById(R.id.sp_hair_color);
        skin_color = specieLayout.findViewById(R.id.sp_skin_color);
        designation = specieLayout.findViewById(R.id.sp_designation);
        homeworld = specieLayout.findViewById(R.id.sp_homeworld);
        language = specieLayout.findViewById(R.id.sp_language);
        eye_color = specieLayout.findViewById(R.id.sp_eye_color);
        avarage_life_span = specieLayout.findViewById(R.id.sp_av_lifespan);

        name.setText(specie.getName());
        height.setText(specie.getAverage_height());
        classification.setText(specie.getClassification());
        hair_color.setText(specie.getHair_colors());
        skin_color.setText(specie.getSkin_colors());
        designation.setText(specie.getDesignation());
        homeworld.setText(specie.getHomeworld());
        language.setText(specie.getLanguage());
        eye_color.setText(specie.getEye_colors());
        avarage_life_span.setText(specie.getAverage_lifespan());

        if (!specie.people.isEmpty()) {
            peopleAdapt.setVisibility(View.VISIBLE);
            peopleAdapt.setOnClickListener(v -> fetchPeople(specie.people));
        }
        if (!specie.films.isEmpty()) {
            filmsAdapt.setVisibility(View.VISIBLE);
            filmsAdapt.setOnClickListener(v -> fetchFilms(specie.films));
        }
        vehiclesAdapt.setVisibility(View.GONE);
        starshipsAdapt.setVisibility(View.GONE);
        speciesAdapt.setVisibility(View.GONE);
        planetsAdapt.setVisibility(View.GONE);
    }

    private void viewVehicle() {
        goneAll();
        vehicleLayout.setVisibility(View.VISIBLE);

        name = vehicleLayout.findViewById(R.id.v_name);
        model = vehicleLayout.findViewById(R.id.v_model);
        cost = vehicleLayout.findViewById(R.id.v_cost);
        length = vehicleLayout.findViewById(R.id.v_length);
        max_speed = vehicleLayout.findViewById(R.id.v_speed);
        crew = vehicleLayout.findViewById(R.id.v_crew);
        passengers = vehicleLayout.findViewById(R.id.v_passengers);
        cargo = vehicleLayout.findViewById(R.id.v_cargo_capacity);
        consumables = vehicleLayout.findViewById(R.id.v_comsumables);
        manufacturer = vehicleLayout.findViewById(R.id.v_manufacturer);
        v_class = vehicleLayout.findViewById(R.id.v_class);

        name.setText(vehicle.getName());
        model.setText(vehicle.getModel());
        cost.setText(vehicle.getCost_in_credits());
        length.setText(vehicle.getLength());
        max_speed.setText(vehicle.getMax_atmosphering_speed());
        crew.setText(vehicle.getCrew());
        passengers.setText(vehicle.getPassengers());
        cargo.setText(vehicle.getCargo_capacity());
        consumables.setText(vehicle.getConsumables());
        manufacturer.setText(vehicle.getManufacturer());
        v_class.setText(vehicle.getVehicle_class());

        if (!vehicle.pilots.isEmpty()) {
            peopleAdapt.setVisibility(View.VISIBLE);
            peopleAdapt.setOnClickListener(v -> fetchPeople(vehicle.pilots));
        }
        if (!vehicle.films.isEmpty()) {
            filmsAdapt.setVisibility(View.VISIBLE);
            filmsAdapt.setOnClickListener(v -> fetchFilms(vehicle.films));
        }
        vehiclesAdapt.setVisibility(View.GONE);
        starshipsAdapt.setVisibility(View.GONE);
        speciesAdapt.setVisibility(View.GONE);
        planetsAdapt.setVisibility(View.GONE);
    }

    private void viewStarship() {
        goneAll();
        starshipLayout.setVisibility(View.VISIBLE);
        name = starshipLayout.findViewById(R.id.st_name);
        model = starshipLayout.findViewById(R.id.st_model);
        cost = starshipLayout.findViewById(R.id.st_cost);
        length = starshipLayout.findViewById(R.id.st_length);
        max_speed = starshipLayout.findViewById(R.id.st_speed);
        crew = starshipLayout.findViewById(R.id.st_crew);
        passengers = starshipLayout.findViewById(R.id.st_passengers);
        cargo = starshipLayout.findViewById(R.id.st_cargo_capacity);
        consumables = starshipLayout.findViewById(R.id.st_comsumables);
        manufacturer = starshipLayout.findViewById(R.id.st_manufacturer);
        v_class = starshipLayout.findViewById(R.id.st_class);
        hyper = starshipLayout.findViewById(R.id.st_hyper);
        mglt = starshipLayout.findViewById(R.id.st_mglt);

        name.setText(starship.getName());
        model.setText(starship.getModel());
        cost.setText(starship.getCost_in_credits());
        length.setText(starship.getLength());
        max_speed.setText(starship.getMax_atmosphering_speed());
        crew.setText(starship.getCrew());
        passengers.setText(starship.getPassengers());
        cargo.setText(starship.getCargo_capacity());
        consumables.setText(starship.getConsumables());
        manufacturer.setText(starship.getManufacturer());
        v_class.setText(starship.getStarship_class());
        hyper.setText(starship.getHyperdrive_rating());
        mglt.setText(starship.getMGLT());

        if (!starship.pilots.isEmpty()) {
            peopleAdapt.setVisibility(View.VISIBLE);
            peopleAdapt.setOnClickListener(v -> fetchPeople(starship.pilots));
        }
        if (!starship.films.isEmpty()) {
            filmsAdapt.setVisibility(View.VISIBLE);
            filmsAdapt.setOnClickListener(v -> fetchFilms(starship.films));
        }
        vehiclesAdapt.setVisibility(View.GONE);
        starshipsAdapt.setVisibility(View.GONE);
        speciesAdapt.setVisibility(View.GONE);
        planetsAdapt.setVisibility(View.GONE);

    }

    private void goneAll() {
        peopleLayout.setVisibility(View.GONE);
        planetLayout.setVisibility(View.GONE);
        specieLayout.setVisibility(View.GONE);
        starshipLayout.setVisibility(View.GONE);
        vehicleLayout.setVisibility(View.GONE);
        filmLayout.setVisibility(View.GONE);
    }

    private void fetchFilms(List<String> urls) {
        ArrayList newData = new ArrayList<Films>();
        for (int i = 0; i < urls.size(); i++) {
            int finalI = i;
            RestSingleton.getInstance().getApi().getSingleFilm(urls.get(i)).enqueue(new Callback<Films>() {

                @Override
                public void onResponse(Call<Films> call, Response<Films> response) {
                    newData.add(response.body());
                    if (finalI == urls.size() - 1) {
                        navigateNextFilms(newData);
                    }
                }

                @Override
                public void onFailure(Call<Films> call, Throwable t) {
                    Toast.makeText(requireContext(), "Error Occured", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void navigateNextFilms(ArrayList<Films> list) {
        ResultFragment resultFragment = new ResultFragment();
        resultFragment.setFilmsList(list);
        resultFragment.setSelect(3);
        getActions().getNavManager().navigate(resultFragment, true);
    }

    private void fetchPeople(List<String> urls) {
        ArrayList newData = new ArrayList<People>();
        for (int i = 0; i < urls.size(); i++) {
            int finalI = i;
            RestSingleton.getInstance().getApi().getSinglePerson(urls.get(i)).enqueue(new Callback<People>() {

                @Override
                public void onResponse(Call<People> call, Response<People> response) {
                    newData.add(response.body());
                    if (finalI == urls.size() - 1) {
                        navigateNextPeople(newData);
                    }
                }

                @Override
                public void onFailure(Call<People> call, Throwable t) {
                    Toast.makeText(requireContext(), "Error Occured", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void navigateNextPeople(ArrayList<People> list) {
        ResultFragment resultFragment = new ResultFragment();
        resultFragment.setPeopleList(list);
        resultFragment.setSelect(1);
        getActions().getNavManager().navigate(resultFragment, true);
    }

    private void fetchStarships(List<String> urls) {
        ArrayList newData = new ArrayList<Starships>();
        for (int i = 0; i < urls.size(); i++) {
            int finalI = i;
            RestSingleton.getInstance().getApi().getSingleStarship(urls.get(i)).enqueue(new Callback<Starships>() {

                @Override
                public void onResponse(Call<Starships> call, Response<Starships> response) {
                    newData.add(response.body());
                    if (finalI == urls.size() - 1) {
                        navigateNextStarships(newData);
                    }
                }

                @Override
                public void onFailure(Call<Starships> call, Throwable t) {
                    Toast.makeText(requireContext(), "Error Occured", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void navigateNextStarships(ArrayList<Starships> list) {
        ResultFragment resultFragment = new ResultFragment();
        resultFragment.setStarshipsList(list);
        resultFragment.setSelect(4);
        getActions().getNavManager().navigate(resultFragment, true);
    }

    private void fetchVehicules(List<String> urls) {
        ArrayList newData = new ArrayList<Vehicles>();
        for (int i = 0; i < urls.size(); i++) {
            int finalI = i;
            RestSingleton.getInstance().getApi().getSingleVehicle(urls.get(i)).enqueue(new Callback<Vehicles>() {

                @Override
                public void onResponse(Call<Vehicles> call, Response<Vehicles> response) {
                    newData.add(response.body());
                    if (finalI == urls.size() - 1) {
                        navigateNextVehicles(newData);
                    }
                }

                @Override
                public void onFailure(Call<Vehicles> call, Throwable t) {
                    Toast.makeText(requireContext(), "Error Occured", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void navigateNextVehicles(ArrayList<Vehicles> list) {
        ResultFragment resultFragment = new ResultFragment();
        resultFragment.setVehiclesList(list);
        resultFragment.setSelect(5);
        getActions().getNavManager().navigate(resultFragment, true);
    }

    private void fetchPlanets(List<String> urls) {
        ArrayList newData = new ArrayList<Planets>();
        for (int i = 0; i < urls.size(); i++) {
            int finalI = i;
            RestSingleton.getInstance().getApi().getSinglePlanet(urls.get(i)).enqueue(new Callback<Planets>() {

                @Override
                public void onResponse(Call<Planets> call, Response<Planets> response) {
                    newData.add(response.body());
                    if (finalI == urls.size() - 1) {
                        navigateNextPlanets(newData);
                    }
                }

                @Override
                public void onFailure(Call<Planets> call, Throwable t) {
                    Toast.makeText(requireContext(), "Error Occured", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void navigateNextPlanets(ArrayList<Planets> list) {
        ResultFragment resultFragment = new ResultFragment();
        resultFragment.setPlanetList(list);
        resultFragment.setSelect(2);
        getActions().getNavManager().navigate(resultFragment, true);
    }

    private void fetchSpecies(List<String> urls) {
        ArrayList newData = new ArrayList<Species>();
        for (int i = 0; i < urls.size(); i++) {
            int finalI = i;
            RestSingleton.getInstance().getApi().getSingleSpecie(urls.get(i)).enqueue(new Callback<Species>() {

                @Override
                public void onResponse(Call<Species> call, Response<Species> response) {
                    newData.add(response.body());
                    if (finalI == urls.size() - 1) {
                        navigateNextSpecies(newData);
                    }
                }

                @Override
                public void onFailure(Call<Species> call, Throwable t) {
                    Toast.makeText(requireContext(), "Error Occured", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void navigateNextSpecies(ArrayList<Species> list) {
        ResultFragment resultFragment = new ResultFragment();
        resultFragment.setSpeciesList(list);
        resultFragment.setSelect(6);
        getActions().getNavManager().navigate(resultFragment, true);
    }
}
