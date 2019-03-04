package project.pb.star_wars_project.pages.searching;

import android.util.Log;
import project.pb.star_wars_project.functional.rest.RestSingleton;
import project.pb.star_wars_project.models.interfaces.models.ResultsVehicles;
import project.pb.star_wars_project.models.interfaces.models.Vehicles;
import project.pb.star_wars_project.pages.result.ResultFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class SearchVehicle {

    ArrayList<Vehicles> v = new ArrayList<>();

    public void vSearch(final int number, final String the_name, final String the_model, final String the_class, final String the_length)
    {
        RestSingleton.getInstance().getApi().getAllVehicles(number).enqueue(new Callback<ResultsVehicles>() {
            @Override
            public void onResponse(Call<ResultsVehicles> call, Response<ResultsVehicles> response) {
                ResultsVehicles responseBody = response.body();
                int size = responseBody.results.size();
                int tmp;
                String nameSearch = the_name;
                String modelSearch = the_model;
                String classSearch = the_class;
                String lengthSearch = the_length;

                for (int i = 0; i < size; i ++)
                {
                    if (responseBody.results.get(i).name.toLowerCase().contains(nameSearch.toLowerCase())
                            &&(responseBody.results.get(i).model.toLowerCase().contains(modelSearch.toLowerCase()))
                            &&(responseBody.results.get(i).vehicle_class.toLowerCase().contains(classSearch.toLowerCase()))
                            &&(responseBody.results.get(i).length.contains(lengthSearch))
                            )
                    {
                        Log.i("VehicleName", responseBody.results.get(i).name);
                        v.add(responseBody.results.get(i));
                    }
                }
                tmp = number + 1;
                if(responseBody.next != null)
                {
                    vSearch(tmp, nameSearch, modelSearch, classSearch, lengthSearch);
                }
                else
                {
                    ResultFragment.getResultInstance().setVehiclesList(v);
                    ResultFragment.getResultInstance().setSelect(5);
                    SearchingFragment.getsInstance().executeResult();
                }
            }

            @Override
            public void onFailure(Call<ResultsVehicles> call, Throwable t) {

            }
        });
    }
}


