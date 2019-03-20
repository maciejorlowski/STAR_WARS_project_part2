package project.pb.star_wars_project.pages.favorite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.base.BaseFragment;

public class FavoriteFragment extends BaseFragment {


    private static FavoriteFragment fInstance;

    public static FavoriteFragment getsInstance(){
        if(fInstance==null){
            fInstance=new FavoriteFragment();
        }
        return fInstance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorite_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //TODO Pobranie odpowiednich itemow z bazy, obczaic jak wyswietlic wszystkie obiekty (filmy, planety itp...) w jednej liscie, funkconalnosc przyciskow
}
