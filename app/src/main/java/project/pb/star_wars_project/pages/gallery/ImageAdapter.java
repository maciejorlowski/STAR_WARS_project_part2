package project.pb.star_wars_project.pages.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import project.pb.star_wars_project.R;

public class ImageAdapter extends BaseAdapter {

    Context context;
    public ImageAdapter(Context context){
        this.context = context;
    }
    public Integer images[] = {
            R.drawable.pic1,
            R.drawable.pic2,R.drawable.pic3,
            R.drawable.pic4,R.drawable.pic5,
            R.drawable.pic6,R.drawable.pic7,
            R.drawable.pic8,R.drawable.pic9,
            R.drawable.pic10
    };
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240));
        return imageView;
    }
}
