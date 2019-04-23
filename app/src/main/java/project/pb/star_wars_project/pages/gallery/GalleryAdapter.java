package project.pb.star_wars_project.pages.gallery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import project.pb.star_wars_project.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter  extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

    List<ImageData> data ;
    Context context;

    public GalleryAdapter(Context context, ArrayList<ImageData> data) {
        this.context = context;
        this.data = data;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;

        public MyViewHolder(View v){
            super(v);
            imageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    @Override
    public GalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position){

        ImageData all = data.get(position);
        holder.imageView.setImageResource(all.imageId);

    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }
}
