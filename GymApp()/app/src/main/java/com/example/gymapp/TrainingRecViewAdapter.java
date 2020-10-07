package com.example.gymapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TrainingRecViewAdapter extends RecyclerView.Adapter<TrainingRecViewAdapter.Viewholder> {
        private static final String TAG = "TrainingRecViewAdapter";
    private Context mContext;
    private ArrayList<GymTraining> trainings = new ArrayList<>();


    public TrainingRecViewAdapter(Context mContext) {
        this.mContext = mContext;

    }

    public TrainingRecViewAdapter() {
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_list_item, parent, false);
        Viewholder holder = new Viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called");
        viewHolder.txtName.setText(trainings.get(i).getName());
        viewHolder.txtShortDesc.setText(trainings.get(i).getShortDesc());
        Glide.with(mContext).asBitmap().load(trainings.get(i).getImageUrl()).into(viewHolder.image);




        viewHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: navigate to the other activity

                Intent intent=new Intent(mContext,TrainingActivity.class);
                intent.putExtra("training",trainings.get(i));
                mContext.startActivity(intent);

            }
        });

    }





    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        private TextView txtName, txtShortDesc;
        private ImageView image;
        private CardView parent;


        public Viewholder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.trainingName);
            txtShortDesc = itemView.findViewById(R.id.trainingShortDescription);

            image = itemView.findViewById(R.id.trainingImage);
            parent = itemView.findViewById(R.id.parent);

        }
    }

    public void setTrainings(ArrayList<GymTraining> trainings) {
        this.trainings = trainings;
        notifyDataSetChanged();
    }
}
