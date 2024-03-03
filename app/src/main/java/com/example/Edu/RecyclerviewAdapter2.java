package com.example.Edu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Edu.fragments.FacultiesFragment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerviewAdapter2 extends RecyclerView.Adapter<RecyclerviewAdapter2.RecyclerviewHolder> {
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(UserData2 userData);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    Context context;
    List<UserData2> userDataList;
    List<UserData2> filteredUserDataList;

    public RecyclerviewAdapter2(Context context, List<UserData2> userDataList) {
        this.context = context;
        this.userDataList = userDataList;
        this.filteredUserDataList = userDataList;
    }

    public RecyclerviewAdapter2(FacultiesFragment context, List<android.service.autofill.UserData> userDataList) {
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row_item, parent, false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.userName.setText(filteredUserDataList.get(position).getUserName());
        holder.userDesc.setText(filteredUserDataList.get(position).getDescp());
        holder.userImage.setImageResource(filteredUserDataList.get(position).getImageUrl());

        ItemAnimation2.animateFadeIn(holder.itemView, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION && listener != null) {
                    listener.onItemClick(userDataList.get(adapterPosition));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return filteredUserDataList.size();
    }

    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {


        CircleImageView userImage;
        TextView userName, userDesc;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.userImage);
            userName = itemView.findViewById(R.id.userName);
            userDesc = itemView.findViewById(R.id.userDesc);


        }
    }

    public Filter getFilter(){

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String Key = charSequence.toString();
                if(Key.isEmpty()){
                    filteredUserDataList = userDataList;
                }
                else{

                    List<UserData2> lstFiltered = new ArrayList<>();
                    for(UserData2 row: userDataList){
                        if(row.getUserName().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);

                        }
                    }

                    filteredUserDataList = lstFiltered;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredUserDataList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                filteredUserDataList = (List<UserData2>)filterResults.values;
                notifyDataSetChanged();

            }
        };

    }


}