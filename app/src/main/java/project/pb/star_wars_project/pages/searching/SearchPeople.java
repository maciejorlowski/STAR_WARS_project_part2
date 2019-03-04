package project.pb.star_wars_project.pages.searching;

import android.util.Log;
import project.pb.star_wars_project.functional.rest.RestSingleton;
import project.pb.star_wars_project.models.interfaces.models.People;
import project.pb.star_wars_project.models.interfaces.models.ResultsPeople;
import project.pb.star_wars_project.pages.result.ResultFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class SearchPeople {

    ArrayList<People> p = new ArrayList<>();
    private boolean ended=false;

    public boolean isEnded() {
        return ended;
    }

    public ArrayList<People> getP() {
        Log.e("People in class1: ", String.valueOf(p.size()));
        return p;
    }

    public void pSearch(final int number,
                        final String the_name,
                        final String the_birth_year,
                        final String the_gender)
    {

        RestSingleton.getInstance().getApi().getAllPeople(number).enqueue(new Callback<ResultsPeople>() {
            @Override
            public void onResponse(Call<ResultsPeople> call, Response<ResultsPeople> response) {

                Log.e("peoplesearch called","people called");

                ResultsPeople responseBody = response.body();
                int size = responseBody.results.size();
                int tmp;
                String nameSearch = the_name.toLowerCase();
                String yearSearch = the_birth_year;
                String genderSearch = the_gender;
                //ArrayList<People> people = p;

                for (int i = 0; i < size; i++) {
                    if ((responseBody.results.get(i).name.toLowerCase().contains(nameSearch.toLowerCase()) || nameSearch == null)
                            && (responseBody.results.get(i).birth_year.contains(yearSearch.toLowerCase()) || yearSearch == null)
                            && (responseBody.results.get(i).gender.equals(genderSearch.toLowerCase()))
                            ) {

                        Log.e("Name", responseBody.results.get(i).name);
                        /*
                        Log.e("Birth Year", resultBody.results.get(i).birth_year);
                        Log.e("Height", resultBody.results.get(i).height);
                        Log.e("Eye collor", resultBody.results.get(i).eye_color);
                        Log.e("Gender", resultBody.results.get(i).gender);
                        Log.e("Species", resultBody.results.get(i).species.toString());
                        */
                        p.add(responseBody.results.get(i));
                        //Log.e("People", people.get(0).name);

                    }
                }
                tmp = number + 1;
                if(responseBody.next != null)
                {
                    pSearch(tmp,nameSearch,yearSearch,genderSearch);
                    Log.i("Bollean ",String.valueOf(ended));
                }


                //Jak to wykonac ??
                else
                {
                    ResultFragment.getResultInstance().setPeopleList(p);
                    ResultFragment.getResultInstance().setSelect(1);
                    SearchingFragment.getsInstance().executeResult();
                }

                Log.e("People in class1: ", String.valueOf(p.size()));
            }

            @Override
            public void onFailure(Call<ResultsPeople> call, Throwable t) {
                Log.e("status onresponse", String.valueOf(t.getCause()));

            }
        });
        Log.e("People in class: ", String.valueOf(p.size()));
        Log.i("TEsting Testing: ", p.toString());

    }

}
