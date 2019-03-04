package project.pb.star_wars_project.models.interfaces.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity
public class Planets {
    @PrimaryKey public final String name;
    public final String rotation_period;
    public final String orbital_period;
    public final String diameter;
    public final String climate;
    public final String gravity;
    public final String terrain;
    public final String surface_water;
    public final String population;


    public final List<String> residents; //People.name
    public final List<String> films; //Films.name

    public String getName() {
        return name;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getClimate() {
        return climate;
    }

    public String getGravity() {
        return gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public String getPopulation() {
        return population;
    }

    public List<String> getResidents() {
        return residents;
    }

    public List<String> getFilms() {
        return films;
    }

    public Planets(String name, String rotation_period, String orbital_period, String diameter, String climate,
                   String gravity, String terrain, String surface_water, String population, List<String> residents, List<String> films)
    {
        this.name = name;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.diameter = diameter;

        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surface_water = surface_water;
        this.population = population;
        this.residents = residents;
        this.films = films;

    }
}
