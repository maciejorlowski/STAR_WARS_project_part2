package project.pb.star_wars_project.pages.favorite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.models.interfaces.models.People;

import java.util.List;

public class PeopleFavoriteAdapter extends RecyclerView.Adapter<PeopleFavoriteAdapter.PeopleFavoriteViewHoldeer> {


    private Context  myContext;
    private List<People> peopleList;

    public PeopleFavoriteAdapter(Context myContext, List<People> peopleList)
    {
        this.myContext = myContext;
        this.peopleList = peopleList;
    }

    @NonNull
    @Override
    public PeopleFavoriteViewHoldeer onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View view = inflater.inflate(R.layout.favorite_people_card, null);
        return new PeopleFavoriteViewHoldeer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleFavoriteViewHoldeer peopleFavoriteViewHoldeer, int i) {
        People people = peopleList.get(i);
        peopleFavoriteViewHoldeer.name.setText(people.getName());
        peopleFavoriteViewHoldeer.imageView.setImageResource(R.drawable.logo);
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public class PeopleFavoriteViewHoldeer extends RecyclerView.ViewHolder{

        TextView name;
        ImageView imageView;
        public PeopleFavoriteViewHoldeer(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.people_fav_name);
            imageView = itemView.findViewById(R.id.fav_people_image);
        }
    }
}
