package project.pb.star_wars_project.functional.rest;

import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestSingleton {

        private static final String Base_Url = "https://swapi.co/api/";
        private static RestSingleton mInstance;
        private Retrofit retrofit;

        private RestSingleton()
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        public static RestSingleton getInstance()
        {
            if(mInstance == null)
            {
                mInstance = new RestSingleton();
            }
            return mInstance;
        }

        public RestInterface getApi()
        {
            return retrofit.create(RestInterface.class);
        }
}
