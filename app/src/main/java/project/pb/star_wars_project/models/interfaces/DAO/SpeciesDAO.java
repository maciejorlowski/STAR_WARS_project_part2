package project.pb.star_wars_project.models.interfaces.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import project.pb.star_wars_project.models.interfaces.models.Planets;
import project.pb.star_wars_project.models.interfaces.models.Species;

import java.util.List;

@Dao
public interface SpeciesDAO {

    @Update
    void update(Species species);

    @Delete
    void delete(Species species);

    @Insert
    void insert(Species species);

    @Query("SELECT * from species")
    LiveData<List<Species>> getAll();

    @Query("SELECT * FROM species WHERE name LIKE :search")
    LiveData<List<Species>> findSpeciesByNameLike(String search);

    @Query("SELECT * FROM species WHERE classification LIKE :search")
    LiveData<List<Species>> findSpeciesByClassificationLike(String search);

    @Query("SELECT * FROM species WHERE designation LIKE :search")
    LiveData<List<Species>> findSpeciesByDesignationLike(String search);

    @Query("SELECT * FROM species WHERE average_height LIKE :search")
    LiveData<List<Species>> findSpeciesByAverageHeightLike(String search);

    @Query("SELECT * FROM species WHERE skin_colors LIKE :search")
    LiveData<List<Species>> findSpeciesBySkinColorLike(String search);

    @Query("SELECT * FROM species WHERE hair_colors LIKE :search")
    LiveData<List<Species>> findSpeciesByHairColorsLike(String search);

    @Query("SELECT * FROM species WHERE eye_colors LIKE :search")
    LiveData<List<Species>> findSpeciesByEyeColorLike(String search);

    @Query("SELECT * FROM species WHERE average_lifespan LIKE :search")
    LiveData<List<Species>> findSpeciesByAverageLifespanLike(String search);

    @Query("SELECT * FROM species WHERE homeworld LIKE :search")
    LiveData<List<Species>> findSpeciesByHomeworldLike(String search);

    @Query("SELECT * FROM species WHERE language LIKE :search")
    LiveData<List<Species>> findSpeciesByLanguageLike(String search);
}
