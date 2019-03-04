package project.pb.star_wars_project.models.interfaces.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity
public class Species {
    @PrimaryKey public final  String name;
    public final String classification;
    public final String designation;
    public final String average_height;
    public final String skin_colors;
    public final String hair_colors;
    public final String eye_colors;
    public final String average_lifespan;
    public final String homeworld;
    public final String language;


    public final List<String> people; //People.name
    public final List<String> films; // Films.name


    public Species(String name, String classification, String designation, String average_height, String skin_colors,
                   String hair_colors, String eye_colors, String average_lifespan, String homeworld, String language, List<String> people, List<String> films)
    {
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.average_height =average_height;
        this.skin_colors = skin_colors;
        this.hair_colors = hair_colors;
        this.eye_colors = eye_colors;
        this.average_lifespan = average_lifespan;
        this.homeworld = homeworld;
        this.language = language;
        this.people = people;
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public String getClassification() {
        return classification;
    }

    public String getDesignation() {
        return designation;
    }

    public String getAverage_height() {
        return average_height;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public String getAverage_lifespan() {
        return average_lifespan;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getLanguage() {
        return language;
    }

    public List<String> getPeople() {
        return people;
    }

    public List<String> getFilms() {
        return films;
    }
}
