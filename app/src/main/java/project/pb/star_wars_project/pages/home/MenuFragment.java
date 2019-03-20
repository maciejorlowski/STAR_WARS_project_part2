package project.pb.star_wars_project.pages.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.base.BaseFragment;
import project.pb.star_wars_project.pages.favorite.FavoriteFragment;
import project.pb.star_wars_project.pages.searching.SearchingFragment;

public class MenuFragment extends BaseFragment {

    private ImageButton imageButton1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActions().topBar().setTitle("Menu");

        ImageButton searchButton = view.findViewById(R.id.imageButton1);
        ImageButton testButton = view.findViewById(R.id.imageButton2);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActions().getNavManager().navigate(SearchingFragment.getsInstance(), true);            }
        });
        testButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getActions().getNavManager().navigate(FavoriteFragment.getsInstance(), true);
            }
        });

        //        imageButton1 = getView().findViewById(R.id.);
        //tutaj piszesz kod
    }
}
