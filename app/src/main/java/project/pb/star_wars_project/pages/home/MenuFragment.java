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

import project.pb.star_wars_project.pages.gallery.GalleryFragment;
import project.pb.star_wars_project.pages.searching.SearchingFragment;
import project.pb.star_wars_project.youtube.YouTubeFragment;

public class MenuFragment extends BaseFragment {

    private ImageButton imageButton1;
    private ImageButton imageButton2;

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
                getActions().getNavManager().navigate(SearchingFragment.getsInstance(), true);
            }
        });
        ImageButton gallery = view.findViewById(R.id.imageButton6);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryFragment galleryFragment = new GalleryFragment();
                getActions().getNavManager().navigate(galleryFragment, true);
            }
        });

        ImageButton youtubeButton = view.findViewById(R.id.imageButton2);
        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActions().getNavManager().navigate(YouTubeFragment.getyInstance(), true);

            }
        });

        //tutaj piszesz kod
    }
}

