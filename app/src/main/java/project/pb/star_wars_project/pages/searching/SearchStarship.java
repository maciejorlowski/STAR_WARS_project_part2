package project.pb.star_wars_project.pages.searching;

import android.util.Log;
import project.pb.star_wars_project.functional.rest.RestSingleton;
import project.pb.star_wars_project.models.interfaces.models.ResultsStarships;
import project.pb.star_wars_project.models.interfaces.models.Starships;
import project.pb.star_wars_project.pages.result.ResultFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class SearchStarship {

    ArrayList<Starships> ss = new ArrayList<>();

    public void ssSearch(final int number, final String the_name, final String the_model, final String the_class, final String the_length)
    {
        RestSingleton.getInstance().getApi().getAllStarships(number).enqueue(new Callback<ResultsStarships>() {
            @Override
            public void onResponse(Call<ResultsStarships> call, Response<ResultsStarships> response) {
                ResultsStarships responseBody = response.body();
                int size = responseBody.results.size();
                int tmp;
                String nameSearch = the_name;
                String modelSearch = the_model;
                String classSearch = the_class;
                String lengthSearch = the_length;

                for (int i = 0; i < size; i++)
                {
                    if (responseBody.results.get(i).name.toLowerCase().contains(nameSearch.toLowerCase())
                            &&(responseBody.results.get(i).model.toLowerCase().contains(modelSearch.toLowerCase()))
                            &&(responseBody.results.get(i).starship_class.toLowerCase().contains(classSearch.toLowerCase()))
                            &&(responseBody.results.get(i).length.contains(lengthSearch))
                            )
                    {
                        Log.i("StarshipName", responseBody.results.get(i).name);
                        ss.add(responseBody.results.get(i));
                    }
                }
                tmp = number +1;
                if(responseBody.next != null)
                {
                    ssSearch(tmp, nameSearch,modelSearch, classSearch, lengthSearch );
                }
                else
                {
                    ResultFragment.getResultInstance().setStarshipsList(ss);
                    ResultFragment.getResultInstance().setSelect(4);
                    SearchingFragment.getsInstance().executeResult();
                }
            }

            @Override
            public void onFailure(Call<ResultsStarships> call, Throwable t) {

            }
        });
        return;
    }
}


