package project.pb.star_wars_project.MemeGallery;

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

public class MemeFragment extends BaseFragment {
    private static MemeFragment MemeInstance =null;

    public static MemeFragment getMemeInstance() {
        if (MemeInstance ==null)
        {
            MemeInstance = new MemeFragment();
        }
        return MemeInstance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.meme_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));

        ArrayList<ImageData> imageGallery = new ArrayList<>();

        imageGallery.add(new ImageData( R.drawable.mem1));
        imageGallery.add(new ImageData(R.drawable.mem2));
        imageGallery.add(new ImageData( R.drawable.mem3));
        imageGallery.add(new ImageData(R.drawable.mem4));
        imageGallery.add(new ImageData(R.drawable.mem5));
        imageGallery.add(new ImageData(R.drawable.mem6));
        imageGallery.add(new ImageData(R.drawable.mem7));
        imageGallery.add(new ImageData(R.drawable.mem8));
        imageGallery.add(new ImageData(R.drawable.mem9));
        imageGallery.add(new ImageData(R.drawable.mem10));
        imageGallery.add(new ImageData(R.drawable.mem11));
        imageGallery.add(new ImageData(R.drawable.mem12));
        imageGallery.add(new ImageData(R.drawable.mem13));
        imageGallery.add(new ImageData(R.drawable.mem14));
        imageGallery.add(new ImageData(R.drawable.mem15));
        imageGallery.add(new ImageData(R.drawable.mem16));
        imageGallery.add(new ImageData(R.drawable.mem17));
        imageGallery.add(new ImageData(R.drawable.mem18));
        imageGallery.add(new ImageData(R.drawable.mem19));
        imageGallery.add(new ImageData(R.drawable.mem20));
        imageGallery.add(new ImageData(R.drawable.mem21));
        imageGallery.add(new ImageData(R.drawable.mem22));
        imageGallery.add(new ImageData(R.drawable.mem23));
        imageGallery.add(new ImageData(R.drawable.mem24));


        MemeAdapter memeAdapter = new MemeAdapter(getContext(),imageGallery);
        recyclerView.setAdapter(memeAdapter);
    }
}
