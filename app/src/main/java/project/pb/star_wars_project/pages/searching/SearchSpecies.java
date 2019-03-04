package project.pb.star_wars_project.pages.searching;

import android.util.Log;
import project.pb.star_wars_project.functional.rest.RestSingleton;
import project.pb.star_wars_project.models.interfaces.models.ResultsSpecies;
import project.pb.star_wars_project.models.interfaces.models.Species;
import project.pb.star_wars_project.pages.result.ResultFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class SearchSpecies {
    ArrayList<Species> sp = new ArrayList<>();

    public void spSearch(final int number, final String the_name, final String the_class, final String the_homeworld)
    {
        RestSingleton.getInstance().getApi().getAllSpecies(number).enqueue(new Callback<ResultsSpecies>() {
            @Override
            public void onResponse(Call<ResultsSpecies> call, Response<ResultsSpecies> response) {
                ResultsSpecies responseBody = response.body();
                int size = responseBody.results.size();
                int tmp;
                String nameSearch = the_name;
                String classSearch = the_class;
                String homeworldSearch = the_homeworld;

                for (int i = 0; i < size; i++)
                {
                    if (responseBody.results.get(i).name.toLowerCase().contains(nameSearch.toLowerCase())
                            &&(responseBody.results.get(i).classification.toLowerCase().contains(classSearch.toLowerCase()))
                            //&&(responseBody.results.get(i).homeworld.contains(homeworldSearch)) jedno pole jest null i wywala error
                            //TODO naprawic szukanie po homeworld
                            )
                    {
                        Log.i("SpeciesName", responseBody.results.get(i).name);
                        sp.add(responseBody.results.get(i));
                    }
                }
                tmp = number +1;
                if(responseBody.next != null)
                {
                    spSearch(tmp,nameSearch,classSearch,homeworldSearch);
                }
                else
                {
                    ResultFragment.getResultInstance().setSpeciesList(sp);
                    ResultFragment.getResultInstance().setSelect(6);
                    SearchingFragment.getsInstance().executeResult();
                }
            }

            @Override
            public void onFailure(Call<ResultsSpecies> call, Throwable t) {

            }
        });
    }
}



