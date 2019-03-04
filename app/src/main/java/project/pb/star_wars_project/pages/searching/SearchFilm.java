package project.pb.star_wars_project.pages.searching;

import android.util.Log;
import project.pb.star_wars_project.functional.rest.RestSingleton;
import project.pb.star_wars_project.models.interfaces.models.Films;
import project.pb.star_wars_project.models.interfaces.models.ResultsFilms;
import project.pb.star_wars_project.pages.result.ResultFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class SearchFilm {

    ArrayList<Films> f = new ArrayList<>();

    public void fSearch(final int number, final String the_title)
    {
        RestSingleton.getInstance().getApi().getAllFilms(number).enqueue(new Callback<ResultsFilms>() {
            @Override
            public void onResponse(Call<ResultsFilms> call, Response<ResultsFilms> response) {
                ResultsFilms resultBody = response.body();
                int size = resultBody.results.size();
                int tmp;
                String titleSearch = the_title;

                for (int i = 0; i < size; i++)
                {
                    if (resultBody.results.get(i).title.toLowerCase().contains(titleSearch.toLowerCase()))
                    {
                        Log.i("FilmName: ", resultBody.results.get(i).title);
                        f.add(resultBody.results.get(i));
                    }


                }
                tmp = number +1;
                if (resultBody.next != null)
                {
                    fSearch(tmp,titleSearch);
                }
                else
                {
                    ResultFragment.getResultInstance().setSelect(3);
                    ResultFragment.getResultInstance().setFilmsList(f);
                    SearchingFragment.getsInstance().executeResult();
                }
            }

            @Override
            public void onFailure(Call<ResultsFilms> call, Throwable t) {
                Log.e("status onresponse", String.valueOf(t.getCause()));

            }
        });
        return;
    }
}
