package project.pb.star_wars_project.pages.gallery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.base.BaseFragment;

import java.util.ArrayList;

public class GalleryFragment extends BaseFragment {

    private static GalleryFragment GalleryInstance=null;

    public static GalleryFragment getGalleryInstance() {
        if (GalleryInstance==null)
        {
            GalleryInstance = new GalleryFragment();
        }
        return GalleryInstance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.result_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));

        ArrayList<ImageData> imageGallery = new ArrayList<>();

        imageGallery.add(new ImageData( R.drawable.mem1));
        imageGallery.add(new ImageData(R.drawable.mem2));
        imageGallery.add(new ImageData( R.drawable.mem3));
        imageGallery.add(new ImageData(R.drawable.mem4));
        imageGallery.add(new ImageData(R.drawable.mem5));

        GalleryAdapter galleryAdapter = new GalleryAdapter(getContext(),imageGallery);
        recyclerView.setAdapter(galleryAdapter);
    }
}
