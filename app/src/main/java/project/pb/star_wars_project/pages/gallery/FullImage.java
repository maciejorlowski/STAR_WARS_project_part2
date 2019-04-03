package project.pb.star_wars_project.pages.gallery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.base.BaseFragment;

public class FullImage extends BaseFragment {
    private ImageAdapter imageAdapter;
    private int position;

    private static FullImage instance =null;

    public void setPosition(int position) {
        this.position = position;
    }
    public static FullImage getInstance(){
        if (instance==null) instance = new FullImage();
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       return inflater.inflate(R.layout.full_image,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageAdapter = new ImageAdapter(getContext());
        ImageView imageView = view.findViewById(R.id.full_image_view);
        imageView.setImageResource((Integer) imageAdapter.getItem(position));

    }
}
