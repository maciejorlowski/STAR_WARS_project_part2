package project.pb.star_wars_project.models.interfaces.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;


@Entity
public class People {
    @PrimaryKey public final String name;
    public final String height;
    public final String mass;
    public final String hair_color;
    public final String skin_color;
    public final String eye_color;
    public final String birth_year;
    public final String gender;

    public final String homeworld; //Planets.name
    public final List<String> films; //Films.title
    public final List<String> species; //Species.
    public final List<String> vehicles; //Vehicles.name
    public final List<String> starships; //Starships.name


    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public List<String> getStarships() {
        return starships;
    }

    public People(String name, String height, String mass, String hair_color, String skin_color,
                  String eye_color, String birth_year, String gender, String homeworld, List<String> films,
                  List<String> species, List<String> vehicles, List<String> starships)
    {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;

        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld =homeworld;
        this.films =films;
        this.species = species;
        this.vehicles = vehicles;
        this.starships = starships;
    }

}
