package project.pb.star_wars_project.pages.searching;

import android.util.Log;
import project.pb.star_wars_project.functional.rest.RestSingleton;
import project.pb.star_wars_project.models.interfaces.models.Planets;
import project.pb.star_wars_project.models.interfaces.models.ResultsPlanets;
import project.pb.star_wars_project.pages.result.ResultFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class SearchPlanet {

    ArrayList<Planets> pl = new ArrayList<>();

    public void plSearch(final int number, final String the_name, final String the_diameter, final String the_gravity, final String the_population )
    {
        RestSingleton.getInstance().getApi().getAllPlanets(number).enqueue(new Callback<ResultsPlanets>() {
            @Override
            public void onResponse(Call<ResultsPlanets> call, Response<ResultsPlanets> response) {

                Log.e("planetsearch called","planet called");
                ResultsPlanets responseBody = response.body();
                int size = responseBody.results.size();
                int tmp;
                String nameSearch = the_name;
                String diameterSearch = the_diameter;
                String gravitySearch = the_gravity;
                String populationSearch = the_population;

                for (int i = 0; i < size; i++)
                {
                    if ((responseBody.results.get(i).name.toLowerCase().contains(nameSearch.toLowerCase()) || nameSearch == null)
                            &&(responseBody.results.get(i).diameter.contains(diameterSearch) || diameterSearch == null)
                            &&(responseBody.results.get(i).gravity.toLowerCase().contains(gravitySearch.toLowerCase()) || gravitySearch == null)
                            &&(responseBody.results.get(i).population.contains(populationSearch) || populationSearch == null)
                            )
                    {
                        Log.i("PlanetName", responseBody.results.get(i).name);
                        pl.add(responseBody.results.get(i));
                    }
                }
                tmp = number + 1;
                if (responseBody.next != null)
                {
                    plSearch(tmp, nameSearch, diameterSearch, gravitySearch, populationSearch);
                }
                else
                {
                    ResultFragment.getResultInstance().setSelect(2);
                   ResultFragment.getResultInstance().setPlanetList(pl);
                   SearchingFragment.getsInstance().executeResult();
                }

            }

            @Override
            public void onFailure(Call<ResultsPlanets> call, Throwable t) {

            }
        });
    }
}















