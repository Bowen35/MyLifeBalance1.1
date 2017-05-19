package com.inducesmile.androidmultiquiz.adapters;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inducesmile.androidmultiquiz.R;
import com.inducesmile.androidmultiquiz.entities.Client;

import java.util.List;

/**
 * Created by lalit on 10/10/2016.
 */

public class ClientRecyclerAdapter extends RecyclerView.Adapter<ClientRecyclerAdapter.ClientViewHolder> {

    private List<Client> listClients;

    public ClientRecyclerAdapter(List<Client> listClients) {
        this.listClients = listClients;
    }

    @Override
    public ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_client_recycler, parent, false);

        return new ClientViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ClientViewHolder holder, int position) {
        holder.textViewName.setText(listClients.get(position).getName());
        holder.textViewEmail.setText(listClients.get(position).getEmail());
//        holder.textViewPassword.setText(listClients.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        Log.v(ClientRecyclerAdapter.class.getSimpleName(),""+listClients.size());
        return listClients.size();
    }


    /**
     * ViewHolder class
     */
    public class ClientViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
//        public AppCompatTextView textViewPassword;

        public ClientViewHolder(View view) {
            super(view);
            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
//            textViewPassword = (AppCompatTextView) view.findViewById(R.id.textViewPassword);
        }
    }


}