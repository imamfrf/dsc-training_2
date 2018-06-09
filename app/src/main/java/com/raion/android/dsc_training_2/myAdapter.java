package com.raion.android.dsc_training_2;

        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {

    private List<List_Item> listItems;
    private Context context;

    public myAdapter(List<List_Item> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public myAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(myAdapter.ViewHolder holder, int position) {
        //binding value dari list item ke holder
        List_Item listItem = listItems.get(position);
        holder.tvLocation.setText(listItem.getLocation());
        holder.tvTemperature.setText(listItem.getTemperature());
        Picasso.get().load(listItem.getImgId()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvLocation, tvTemperature;
        public ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);

            tvLocation = itemView.findViewById(R.id.tv_location);
            tvTemperature = itemView.findViewById(R.id.tv_result_temperature);
            icon = itemView.findViewById(R.id.img_weather);

        }
    }
}

