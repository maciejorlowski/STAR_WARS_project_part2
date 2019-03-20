package project.pb.star_wars_project.pages.result;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import project.pb.star_wars_project.R;
import project.pb.star_wars_project.functional.navigation.NavManager;
import project.pb.star_wars_project.models.interfaces.models.Vehicles;

import java.util.List;

public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.VehiclesViewHolder>{

    private Context mContext;
    private List<Vehicles> vehiclesList;

    public VehiclesAdapter(Context mContext, List<Vehicles> vehiclesList) {
        this.mContext = mContext;
        this.vehiclesList = vehiclesList;
    }

    @NonNull
    @Override
    public VehiclesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.vehicle_single_item,null);
        return new VehiclesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiclesViewHolder vehiclesViewHolder, int i) {
        final Vehicles vehicle = vehiclesList.get(i);
        vehiclesViewHolder.name.setText(vehicle.getName());
        vehiclesViewHolder.model.setText(vehicle.getModel());
        vehiclesViewHolder.imageView.setImageResource(R.drawable.logo);
        /*vehiclesViewHolder.manufacturer.setText(vehicle.getManufacturer());
        vehiclesViewHolder.cost.setText(vehicle.getCost_in_credits());
        vehiclesViewHolder.lenght.setText(vehicle.getLength());
        vehiclesViewHolder.max_speed.setText(vehicle.getMax_atmosphering_speed());
        vehiclesViewHolder.crew.setText(vehicle.getCrew());
        vehiclesViewHolder.passengers.setText(vehicle.getPassengers());
        vehiclesViewHolder.cargo_capacity.setText(vehicle.getCargo_capacity());
        vehiclesViewHolder.consumables.setText(vehicle.getConsumables());
        vehiclesViewHolder.vehicle_class.setText(vehicle.getVehicle_class());*/
        vehiclesViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Recycle Click", Toast.LENGTH_SHORT).show();
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setVehicle(vehicle);
                detailFragment.setSelect(4);
                NavManager navManager = new NavManager((FragmentActivity) mContext);
                navManager.navigate(detailFragment, true);
            }
        });

    }

    @Override
    public int getItemCount() {
        return vehiclesList.size();
    }

    public class VehiclesViewHolder extends RecyclerView.ViewHolder {

        TextView name,model;
        ImageView imageView;
        public VehiclesViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.vehicle_name);
            model=itemView.findViewById(R.id.vehicle_model_label);
            imageView=itemView.findViewById(R.id.vehicle_image_view);
           /* manufacturer=itemView.findViewById(R.id.v_manufacturer);
            cost=itemView.findViewById(R.id.v_cost);
            lenght=itemView.findViewById(R.id.v_length);
            max_speed=itemView.findViewById(R.id.v_speed);
            crew=itemView.findViewById(R.id.v_crew);
            passengers=itemView.findViewById(R.id.v_passengers);
            cargo_capacity=itemView.findViewById(R.id.v_cargo_capacity);
            consumables=itemView.findViewById(R.id.v_comsumables);
            vehicle_class=itemView.findViewById(R.id.v_class);*/
        }
    }
}
