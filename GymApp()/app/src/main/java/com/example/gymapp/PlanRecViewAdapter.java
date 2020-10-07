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
import java.util.zip.Inflater;

public class PlanRecViewAdapter extends RecyclerView.Adapter<PlanRecViewAdapter.ViewHolder> {

    private static final String TAG = "PlanRecViewAdapter";
    private Context mContext;
    private ArrayList<Plan> plans = new ArrayList<>();


    public PlanRecViewAdapter() {
    }

    public PlanRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: started");
        holder.activityName.setText(plans.get(position).getTraining().getName());
        Glide.with(mContext).asBitmap().load(plans.get(position).getTraining().getImageUrl()).into(holder.activityImage);
        holder.activityTime.setText(String.valueOf(plans.get(position).getMinutes()));
        holder.activityShortDescription.setText(plans.get(position).getTraining().getShortDesc());
        if (plans.get(position).isAccomplished()) {
            holder.emptyCheckBox.setVisibility(View.GONE);
            holder.filledCheckBox.setVisibility(View.VISIBLE);
        } else {
            holder.emptyCheckBox.setVisibility(View.VISIBLE);
            holder.filledCheckBox.setVisibility(View.GONE);
        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TrainingActivity.class);
                intent.putExtra("training", plans.get(position).getTraining());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView activityName, activityTime, activityShortDescription;
        private ImageView activityImage, emptyCheckBox, filledCheckBox;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            activityName = itemView.findViewById(R.id.activityName);
            activityShortDescription = itemView.findViewById(R.id.txtShortDescription);
            activityTime = itemView.findViewById(R.id.txtTimeAmount);
            parent = itemView.findViewById(R.id.parent);
            activityImage = itemView.findViewById(R.id.activityImage);
            emptyCheckBox = itemView.findViewById(R.id.emptyCheckBox);
            filledCheckBox = itemView.findViewById(R.id.filledCheckBox);

        }
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }
}
