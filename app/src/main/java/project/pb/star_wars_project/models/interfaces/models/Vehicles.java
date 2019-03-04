package project.pb.star_wars_project.models.interfaces.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity
public class Vehicles {
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
    public final String vehicle_class;

    public final List<String> films;
    public final List<String> pilots;

    public Vehicles(String name, String model, String manufacturer, String cost_in_credits, String length, String max_atmosphering_speed,
                    String crew, String passengers, String cargo_capacity, String consumables, String vehicle_class, List<String> films, List<String> pilots)
    {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.cost_in_credits = cost_in_credits;
        this.length = length;
        this.max_atmosphering_speed = max_atmosphering_speed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargo_capacity = cargo_capacity;
        this.consumables = consumables;
        this.vehicle_class = vehicle_class;
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

    public String getVehicle_class() {
        return vehicle_class;
    }

    public List<String> getFilms() {
        return films;
    }

    public List<String> getPilots() {
        return pilots;
    }
}
