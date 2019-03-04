package project.pb.star_wars_project.models.interfaces.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import project.pb.star_wars_project.models.interfaces.models.Starships;
import project.pb.star_wars_project.models.interfaces.models.Vehicles;

import java.util.List;

@Dao
public interface VehiclesDAO {

    @Update
    void update(Vehicles vehicles);

    @Delete
    void delete(Vehicles vehicles);

    @Insert
    void insert(Vehicles vehicles);

    @Query("SELECT * from vehicles")
    LiveData<List<Vehicles>> getAll();

    @Query("SELECT * FROM vehicles WHERE name LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByNameLike(String search);

    @Query("SELECT * FROM vehicles WHERE model LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByModelLike(String search);

    @Query("SELECT * FROM vehicles WHERE manufacturer LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByManufacturerLike(String search);

    @Query("SELECT * FROM vehicles WHERE cost_in_credits LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByCostInCreditsLike(String search);

    @Query("SELECT * FROM vehicles WHERE length LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByLengthLike(String search);

    @Query("SELECT * FROM vehicles WHERE max_atmosphering_speed LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByMaxSpeedLike(String search);

    @Query("SELECT * FROM vehicles WHERE crew LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByCrewLike(String search);

    @Query("SELECT * FROM vehicles WHERE passengers LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByPassengersLike(String search);

    @Query("SELECT * FROM vehicles WHERE cargo_capacity LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByCargoCapacityLike(String search);

    @Query("SELECT * FROM vehicles WHERE consumables LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByConsumablesLike(String search);

    @Query("SELECT * FROM vehicles WHERE vehicle_class LIKE :search")
    LiveData<List<Vehicles>> findVehiclesByVehicleClassLike(String search);

}
