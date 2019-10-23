package com.example.projectshop;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private ArrayList <Person> persons;

    private ItemClickListener itemClickListener;

    public MainAdapter(ArrayList<Person> persons, ItemClickListener itemClickListener) {
        super();
        this.persons = persons;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        //holder.id.setText(persons.get(position).getID());
        holder.textViewPersonName.setText(persons.get(position).getName());
        holder.description.setText(persons.get(position).getDescription());
        holder.dateOfBirth.setText(persons.get(position).getDateOfBirth());
        holder.image.setImageResource(persons.get(position).getImage());
        holder.setItemClick(persons.get(position));
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private CardView cardView;
        private TextView textViewPersonName;
        private TextView description;
        private ImageView image;
        private TextView dateOfBirth;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            //id=(TextView) itemView.findViewById(R.id.id);
            textViewPersonName = itemView.findViewById(R.id.textViewPersonName);
            description = (TextView)itemView.findViewById(R.id.textViewPersonDescription);
            image = (ImageView)itemView.findViewById(R.id.PersonPhoto);
            dateOfBirth = (TextView) itemView.findViewById(R.id.dateOfBirth);
        }

        public void setItemClick(final Person item) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(item, getAdapterPosition());
                    }
                }
            });
        }
    }

    interface ItemClickListener {

        void onItemClick(Person item, int position);
    }
}

