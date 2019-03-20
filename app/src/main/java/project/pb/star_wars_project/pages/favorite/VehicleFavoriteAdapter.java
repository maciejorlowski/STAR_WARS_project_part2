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
import project.pb.star_wars_project.models.interfaces.models.Vehicles;

import java.util.List;

public class VehicleFavoriteAdapter extends RecyclerView.Adapter<VehicleFavoriteAdapter.VehicleFavoriteViewHolder> {

    Context myContext;
    List<Vehicles> vehiclesList;

    public VehicleFavoriteAdapter(Context myContext, List<Vehicles> vehiclesList)
    {
        this.myContext = myContext;
        this.vehiclesList = vehiclesList;
    }

    @NonNull
    @Override
    public VehicleFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View view = inflater.inflate(R.layout.favorite_vehicle_card,null);
        return new VehicleFavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleFavoriteViewHolder vehicleFavoriteViewHolder, int i) {
        Vehicles vehicles = vehiclesList.get(i);
        vehicleFavoriteViewHolder.name.setText(vehicles.getName());
        vehicleFavoriteViewHolder.imageView.setImageResource(R.drawable.logo);
    }

    @Override
    public int getItemCount() {
        return vehiclesList.size();
    }

    public class VehicleFavoriteViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;
        public VehicleFavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.fav_vehicle_name);
            imageView = itemView.findViewById(R.id.fav_vehicle_image);
        }
    }
}
