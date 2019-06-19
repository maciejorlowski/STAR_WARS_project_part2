package project.pb.star_wars_project.MemeGallery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.base.BaseFragment;
import project.pb.star_wars_project.pages.gallery.YouTubeGalleryFragment;
import project.pb.star_wars_project.youtube.YouTubeFragment;

public class YoutubeGalleryFragment extends BaseFragment {
    private static YouTubeGalleryFragment YouTubeGalleryInstance=null;

    public static YouTubeGalleryFragment getYouTubeGalleryInstance() {
        if (YouTubeGalleryInstance==null)
        {
            YouTubeGalleryInstance = new YouTubeGalleryFragment();
        }
        return YouTubeGalleryInstance;
    }

    Button youTubeButton;
    Button galleryButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.youtube_gallery_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        youTubeButton = view.findViewById(R.id.youTubeButton);
        youTubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActions().getNavManager().navigate(YouTubeFragment.getYouTubeInstance(),true);
            }
        });

        galleryButton = view.findViewById(R.id.galleryButton);
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActions().getNavManager().navigate(MemeFragment.getMemeInstance(),true);
            }
        });
    }

}
