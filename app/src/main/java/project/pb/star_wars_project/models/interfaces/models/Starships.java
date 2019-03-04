package project.pb.star_wars_project.models.interfaces.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity
public class Starships {
    @PrimaryKey public final String name;
    public final String model;
    public final String manufacturer;
    public final String cost_in_credits;
    public final String length;
    public final String max_atmosphering_speed;
    public final String crew;
    public final String passengers;
    public final String cargo_capacity;
    public final String consumables;
    public final String hyperdrive_rating;
    public final String MGLT;
    public final String starship_class;

    public final List<String> pilots;
    public final List<String> films;

    Starships(String name, String model, String manufacturer, String cost_in_credits, String length,
              String max_atmosphering_speed, String crew, String passengers, String cargo_capacity,
              String consumables, String hyperdrive_rating, String MGLT, String starship_class, List<String> films, List<String> pilots)
    {
        this.name=name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.cost_in_credits = cost_in_credits;
        this.length = length;
        this.max_atmosphering_speed= max_atmosphering_speed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargo_capacity = cargo_capacity;
        this. consumables = consumables;
        this.hyperdrive_rating = hyperdrive_rating;
        this.MGLT = MGLT;
        this.starship_class = starship_class;
        this.films = films;
        this.pilots = pilots;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public String getLength() {
        return length;
    }

    public String getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public String getHyperdrive_rating() {
        return hyperdrive_rating;
    }

    public String getMGLT() {
        return MGLT;
    }

    public String getStarship_class() {
        return starship_class;
    }

    public List<String> getPilots() {
        return pilots;
    }

    public List<String> getFilms() {
        return films;
    }
}
