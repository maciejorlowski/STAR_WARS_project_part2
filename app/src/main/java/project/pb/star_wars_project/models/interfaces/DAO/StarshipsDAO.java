package project.pb.star_wars_project.models.interfaces.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import project.pb.star_wars_project.models.interfaces.models.Species;
import project.pb.star_wars_project.models.interfaces.models.Starships;

import java.util.List;



@Dao
public interface StarshipsDAO {

        @Update
        void update(Starships starships);

        @Delete
        void delete(Starships starships);

        @Insert
        void insert(Starships starships);

        @Query("SELECT * from starships")
        LiveData<List<Starships>> getAll();

        @Query("SELECT * FROM starships WHERE name LIKE :search")
        LiveData<List<Starships>> findStarshipsByNameLike(String search);

        @Query("SELECT * FROM starships WHERE model LIKE :search")
        LiveData<List<Starships>> findStarshipsByModelLike(String search);

        @Query("SELECT * FROM starships WHERE manufacturer LIKE :search")
        LiveData<List<Starships>> findStarshipsByManufacturerLike(String search);

        @Query("SELECT * FROM starships WHERE cost_in_credits LIKE :search")
        LiveData<List<Starships>> findStarshipsByCostLike(String search);

        @Query("SELECT * FROM starships WHERE length LIKE :search")
        LiveData<List<Starships>> findStarshipsByLengthLike(String search);

        @Query("SELECT * FROM starships WHERE max_atmosphering_speed LIKE :search")
        LiveData<List<Starships>> findStarshipsByMaxSpeedlLike(String search);

        @Query("SELECT * FROM starships WHERE crew LIKE :search")
        LiveData<List<Starships>> findStarshipsByCrewLike(String search);

        @Query("SELECT * FROM starships WHERE passengers LIKE :search")
        LiveData<List<Starships>> findStarshipsByPassengersLike(String search);

        @Query("SELECT * FROM starships WHERE cargo_capacity LIKE :search")
        LiveData<List<Starships>> findStarshipsByCaargoCapacitylLike(String search);

        @Query("SELECT * FROM starships WHERE consumables LIKE :search")
        LiveData<List<Starships>> findStarshipsByConsumablesLike(String search);

        @Query("SELECT * FROM starships WHERE hyperdrive_rating LIKE :search")
        LiveData<List<Starships>> findStarshipsByHyperdriveRatingLike(String search);

        @Query("SELECT * FROM starships WHERE MGLT LIKE :search")
        LiveData<List<Starships>> findStarshipsByMGLTLike(String search);

        @Query("SELECT * FROM starships WHERE starship_class LIKE :search")
        LiveData<List<Starships>> findStarshipsByStarshipClassLike(String search);


}
