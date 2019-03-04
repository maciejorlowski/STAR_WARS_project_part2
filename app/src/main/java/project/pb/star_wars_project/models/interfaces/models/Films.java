package project.pb.star_wars_project.models.interfaces.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.List;

@Entity
public class Films {
@PrimaryKey public final String title;
public final String episode_id;
public final String opening_crawl;
public final String director;
public final String producer;
public final String release_date;

public final List<String> characters;//People.name
public final List<String> planets; //Planets.name
public final List<String> starships; //Starships.name
public final List<String> vehicles; //Vehicles.name
public final List<String> species; //Species.name

public Films(String title, String episode_id, String opening_crawl, String director,
             String producer, String release_date, List<String> characters, List<String> planets,
             List<String> starships, List<String> vehicles, List<String> species)
    {
        this.title = title;
        this.episode_id = episode_id;
        this.opening_crawl = opening_crawl;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
        this.characters = characters;
        this.planets = planets;
        this.starships = starships;
        this.vehicles = vehicles;
        this.species = species;
    }

    public String getTitle() {
        return title;
    }

    public String getEpisode_id() {
        return episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public List<String> getPlanets() {
        return planets;
    }

    public List<String> getStarships() {
        return starships;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public List<String> getSpecies() {
        return species;
    }
}

