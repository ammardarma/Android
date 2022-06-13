package com.ammar.buxapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {
    private Context context;
    private List<TicketModel> items;

    private TicketOnClickListener listener;

    public interface TicketOnClickListener{
        public void onClick(View view, int position);
    }

    public void setListener(TicketOnClickListener listener){
        this.listener = listener;
    }

    public TicketAdapter(Context context, List<TicketModel> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_ticket_item, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.ViewHolder holder, int position) {
//SET ITEM
        TicketModel item = items.get(position);


        holder.date.setText(item.getStartDate() + ", " + item.getStartAt());
        holder.bookNumber.setText(item.getBookNumber());
        holder.poName.setText(item.getPoName());
        holder.poNumber.setText(item.getPoNumber());
        holder.startAt.setText(item.getStartAt());
        holder.startTerminal.setText(item.getStartTerminal());
        holder.endTerminal.setText(item.getEndTerminal());

        String stats = "Issued";
        holder.statusPembayaran.setText(stats);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TicketDetail.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("numberPhone", item.getNumberPhone());
            intent.putExtra("seats", String.valueOf(item.getSeats()));
            intent.putExtra("seatsNo", item.getSeatsNo());
            intent.putExtra("poName", item.getPoName());
            intent.putExtra("bookNumber", item.getBookNumber());
            intent.putExtra("poNumber", item.getPoNumber());
            intent.putExtra("startAt", item.getStartAt());
            intent.putExtra("endAt", item.getEndAt());
            intent.putExtra("startCity", item.getStartCity());
            intent.putExtra("endCity", item.getEndCity());
            intent.putExtra("startDate", item.getStartDate());
            intent.putExtra("endDate", item.getEndDate());
            intent.putExtra("startTerminal", item.getStartTerminal());
            intent.putExtra("endTerminal", item.getEndTerminal());
            intent.putExtra("total", String.valueOf(item.getTotal()));
            intent.putExtra("statusPembayaran", stats);
            context.startActivity(intent);


        });
    }

    @Override
    public int getItemCount() { return (items != null) ? items.size() : 0;}

    public class ViewHolder extends RecyclerView.ViewHolder {
//GET ID

        TextView date, bookNumber, poName, poNumber, startAt, startTerminal, endTerminal, statusPembayaran;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            bookNumber = itemView.findViewById(R.id.bookNumber);
            poName = itemView.findViewById(R.id.poName);
            poNumber = itemView.findViewById(R.id.poNumber);
            startAt = itemView.findViewById(R.id.startAt);
            startTerminal = itemView.findViewById(R.id.startTerminal);
            endTerminal = itemView.findViewById(R.id.endTerminal);
            statusPembayaran = itemView.findViewById(R.id.statusPembayaran);

            itemView.setOnClickListener(v -> {
                listener.onClick(v, getAdapterPosition());
            });
        }

    }
}
