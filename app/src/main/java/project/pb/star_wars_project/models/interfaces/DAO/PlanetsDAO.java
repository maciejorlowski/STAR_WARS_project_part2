package project.pb.star_wars_project.models.interfaces.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import project.pb.star_wars_project.models.interfaces.models.Films;
import project.pb.star_wars_project.models.interfaces.models.People;
import project.pb.star_wars_project.models.interfaces.models.Planets;

import java.util.List;

@Dao
public interface PlanetsDAO {

    @Update
    void update(Planets planets);

    @Delete
    void delete(Planets planets);

    @Insert
    void insert(Planets planets);

    @Query("SELECT * from planets")
    LiveData<List<Planets>> getAll();

    @Query("SELECT * FROM planets WHERE name LIKE :search")
    LiveData<List<Planets>> findPlanetByNameLike(String search);

    @Query("SELECT * FROM planets WHERE rotation_period LIKE :search")
    LiveData<List<Planets>> findPlanetByRotationPeriodLike(String search);

    @Query("SELECT * FROM planets WHERE orbital_period LIKE :search")
    LiveData<List<Planets>> findPlanetByOrbitalPeriodLike(String search);

    @Query("SELECT * FROM planets WHERE diameter LIKE :search")
    LiveData<List<Planets>> findPlanetByDiameterLike(String search);

    @Query("SELECT * FROM planets WHERE gravity LIKE :search")
    LiveData<List<Planets>> findPlanetByGravityLike(String search);

    @Query("SELECT * FROM planets WHERE terrain LIKE :search")
    LiveData<List<Planets>> findPlanetByTerrainLike(String search);

    @Query("SELECT * FROM planets WHERE surface_water LIKE :search")
    LiveData<List<Planets>> findPlanetSurfaceWaterLike(String search);

    @Query("SELECT * FROM planets WHERE population LIKE :search")
    LiveData<List<Planets>> findPlanetByPopulationLike(String search);

}
