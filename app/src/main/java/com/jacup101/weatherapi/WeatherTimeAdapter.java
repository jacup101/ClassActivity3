package com.jacup101.weatherapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class WeatherTimeAdapter extends RecyclerView.Adapter<WeatherTimeAdapter.ViewHolder> {
    private List<WeatherTime> weather;

    public WeatherTimeAdapter(List<WeatherTime> weather) {
        this.weather = weather;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View weatherView = inflater.inflate(R.layout.item_weathertime,parent,false);
        ViewHolder viewHolder = new ViewHolder(weatherView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherTime weatherTime = weather.get(position);
        holder.dateText.setText(weatherTime.getDate());
        holder.timeText.setText(weatherTime.getTime());
        holder.descText.setText(weatherTime.getDesc());
        holder.tempText.setText(weatherTime.getTemp());
    }

    @Override
    public int getItemCount() {
        return weather.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView dateText;
        TextView timeText;
        TextView descText;
        TextView tempText;
        public ViewHolder(View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.textView_date);
            timeText = itemView.findViewById(R.id.textView_time);
            descText = itemView.findViewById(R.id.textView_desc);
            tempText = itemView.findViewById(R.id.textView_temp);

        }
    }

}
