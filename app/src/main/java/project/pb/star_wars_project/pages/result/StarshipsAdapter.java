package project.pb.star_wars_project.pages.result;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.models.interfaces.models.Starships;

import java.util.List;

public class StarshipsAdapter extends RecyclerView.Adapter<StarshipsAdapter.StarshipsViewHolder>{

    private Context mContext;
    private List<Starships> starshipsList;

    public StarshipsAdapter(Context mContext, List<Starships> starshipsList) {
        this.mContext = mContext;
        this.starshipsList = starshipsList;
    }

    @NonNull
    @Override
    public StarshipsAdapter.StarshipsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.starships_list_item,null);
        return new StarshipsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarshipsViewHolder starshipsViewHolder, int i) {
        Starships starship = starshipsList.get(i);
        starshipsViewHolder.name.setText(starship.getName());
        starshipsViewHolder.model.setText(starship.getModel());
        starshipsViewHolder.manufacturer.setText(starship.getManufacturer());
        starshipsViewHolder.cost.setText(starship.getCost_in_credits());
        starshipsViewHolder.lenght.setText(starship.getLength());
        starshipsViewHolder.max_speed.setText(starship.getMax_atmosphering_speed());
        starshipsViewHolder.crew.setText(starship.getCrew());
        starshipsViewHolder.passengers.setText(starship.getPassengers());
        starshipsViewHolder.cargo_capacity.setText(starship.getCargo_capacity());
        starshipsViewHolder.consumables.setText(starship.getConsumables());
        starshipsViewHolder.hyperdrive.setText(starship.getHyperdrive_rating());
        starshipsViewHolder.mglt.setText(starship.getMGLT());
        starshipsViewHolder.ship_class.setText(starship.getStarship_class());


    }

    @Override
    public int getItemCount() {
        return starshipsList.size();
    }

    public class StarshipsViewHolder extends RecyclerView.ViewHolder {

        TextView name,model,manufacturer,cost,lenght,max_speed,crew,passengers,cargo_capacity;
        TextView consumables,hyperdrive,mglt,ship_class;

        public StarshipsViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.st_name);
            model=itemView.findViewById(R.id.st_model);
            manufacturer=itemView.findViewById(R.id.st_manufacturer);
            cost=itemView.findViewById(R.id.st_cost);
            lenght=itemView.findViewById(R.id.st_length);
            max_speed=itemView.findViewById(R.id.st_speed);
            crew=itemView.findViewById(R.id.st_crew);
            passengers=itemView.findViewById(R.id.st_passengers);
            cargo_capacity=itemView.findViewById(R.id.st_cargo_capacity);
            consumables=itemView.findViewById(R.id.st_comsumables);
            hyperdrive=itemView.findViewById(R.id.st_hyperdrive);
            mglt=itemView.findViewById(R.id.st_mglt);
            ship_class=itemView.findViewById(R.id.st_class);
        }
    }
}
