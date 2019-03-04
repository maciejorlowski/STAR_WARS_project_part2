package project.pb.star_wars_project.models.interfaces.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import project.pb.star_wars_project.models.interfaces.models.Films;

import java.util.List;

@Dao
public interface FilmsDAO {

    @Update
    void update(Films films);

    @Delete
    void delete(Films films);

    @Insert
    void insert(Films films);


    @Query("SELECT * from films")
    LiveData<List<Films>> getAll();


    @Query("SELECT * FROM films WHERE release_date LIKE :searchRelease_date")
    LiveData<List<Films>> findFilmWithReleaseDate(String searchRelease_date);

    @Query("SELECT * FROM films WHERE producer LIKE :search")
    LiveData<List<Films>> findFilmWithProducerLike(String search);

    @Query("SELECT * FROM films WHERE title LIKE :search")
    LiveData<List<Films>> findFilmWithTitleLike(String search);

    @Query("SELECT * FROM films WHERE episode_id LIKE :search")
    LiveData<List<Films>> findFilmWithEpisodeIDLike(String search);

    @Query("SELECT * FROM films WHERE director LIKE :search")
    LiveData<List<Films>> findFilmWithDirectorLike(String search);
}
