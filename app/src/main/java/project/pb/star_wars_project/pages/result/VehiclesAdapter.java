package project.pb.star_wars_project.pages.result;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import project.pb.star_wars_project.R;
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
        View view = inflater.inflate(R.layout.vehicles_list_item,null);
        return new VehiclesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiclesViewHolder vehiclesViewHolder, int i) {
        Vehicles vehicle = vehiclesList.get(i);
        vehiclesViewHolder.name.setText(vehicle.getName());
        vehiclesViewHolder.model.setText(vehicle.getModel());
        vehiclesViewHolder.manufacturer.setText(vehicle.getManufacturer());
        vehiclesViewHolder.cost.setText(vehicle.getCost_in_credits());
        vehiclesViewHolder.lenght.setText(vehicle.getLength());
        vehiclesViewHolder.max_speed.setText(vehicle.getMax_atmosphering_speed());
        vehiclesViewHolder.crew.setText(vehicle.getCrew());
        vehiclesViewHolder.passengers.setText(vehicle.getPassengers());
        vehiclesViewHolder.cargo_capacity.setText(vehicle.getCargo_capacity());
        vehiclesViewHolder.consumables.setText(vehicle.getConsumables());
        vehiclesViewHolder.vehicle_class.setText(vehicle.getVehicle_class());

    }

    @Override
    public int getItemCount() {
        return vehiclesList.size();
    }

    public class VehiclesViewHolder extends RecyclerView.ViewHolder {

        TextView name,model,manufacturer,cost,lenght,max_speed,crew,passengers,cargo_capacity;
        TextView consumables,vehicle_class;
        public VehiclesViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.v_name);
            model=itemView.findViewById(R.id.v_model);
            manufacturer=itemView.findViewById(R.id.v_manufacturer);
            cost=itemView.findViewById(R.id.v_cost);
            lenght=itemView.findViewById(R.id.v_length);
            max_speed=itemView.findViewById(R.id.v_speed);
            crew=itemView.findViewById(R.id.v_crew);
            passengers=itemView.findViewById(R.id.v_passengers);
            cargo_capacity=itemView.findViewById(R.id.v_cargo_capacity);
            consumables=itemView.findViewById(R.id.v_comsumables);
            vehicle_class=itemView.findViewById(R.id.v_class);
        }
    }
}
