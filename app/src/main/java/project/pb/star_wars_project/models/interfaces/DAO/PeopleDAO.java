package project.pb.star_wars_project.models.interfaces.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import project.pb.star_wars_project.models.interfaces.models.Films;
import project.pb.star_wars_project.models.interfaces.models.People;

import java.util.List;


@Dao
public interface PeopleDAO {

    @Update
    void update(People people);

    @Delete
    void delete(People people);

    @Insert
    void insert(People people);

    @Query("SELECT * from people")
    LiveData<List<People>> getAll();


    @Query("SELECT * FROM people WHERE name LIKE :search")
    LiveData<List<People>> findPeopleWithNameLike(String search);

    @Query("SELECT * FROM people WHERE mass LIKE :search")
    LiveData<List<People>> findPeopleWithMassLike(String search);

    @Query("SELECT * FROM people WHERE hair_color LIKE :search")
    LiveData<List<People>> findPeopleWithHairColorLike(String search);

    @Query("SELECT * FROM people WHERE skin_color LIKE :search")
    LiveData<List<People>> findPeopleWithSkinColorLike(String search);

    @Query("SELECT * FROM people WHERE eye_color LIKE :search")
    LiveData<List<People>> findPeopleWithEyeColorLike(String search);

    @Query("SELECT * FROM people WHERE birth_year LIKE :search")
    LiveData<List<People>> findPeopleWithBirthYearLike(String search);

    @Query("SELECT * FROM people WHERE gender LIKE :search")
    LiveData<List<People>> findPeopleWithGenderLike(String search);

}
