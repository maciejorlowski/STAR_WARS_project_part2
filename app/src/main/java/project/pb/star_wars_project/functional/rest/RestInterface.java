package project.pb.star_wars_project.functional.rest;

import project.pb.star_wars_project.models.interfaces.models.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;


public interface RestInterface {

    @GET("people")
    Call<ResultsPeople> getAllPeople(@Query("page") int page);

    @GET("people")
    Call<People> getSearchPeople(@Query("search") String search);

    @GET("films")
    Call<ResultsFilms> getAllFilms(@Query("page") int page);

    @GET("films")
    Call<ResultsFilms> getSearchFilm(@Query("search") String search);

    @GET("starships")
    Call<ResultsStarships> getAllStarships(@Query("page") int page);

    @GET("starships")
    Call<Starships> getSearchStarship(@Query("search") String search);

    @GET("vehicles")
    Call<ResultsVehicles> getAllVehicles(@Query("page") int page);

    @GET("vehicles")
    Call<Vehicles> getSearchVehicle(@Query("search") String search);

    @GET("species")
    Call<ResultsSpecies> getAllSpecies(@Query("page") int page);

    @GET("species")
    Call<Species> getSearchSpecies(@Query("search") String search);

    @GET("planets")
    Call<ResultsPlanets> getAllPlanets(@Query("page") int page);

    @GET("planets")
    Call<Planets> getSearchPlanet(@Query("search") String search);



}
