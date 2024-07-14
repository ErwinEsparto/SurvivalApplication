package com.bsit.survivalapplication.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsit.survivalapplication.AddItem;
import com.bsit.survivalapplication.ChecklistFragment;
import com.bsit.survivalapplication.Model.ChecklistModel;
import com.bsit.survivalapplication.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistAdapter.MyViewHolder> {

    private List<ChecklistModel> checklist;
    private Context context;
    private FirebaseFirestore firestore;

    public ChecklistAdapter(Context context, List<ChecklistModel> checklist){
        this.checklist = checklist;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.checklist_task, parent, false);
        firestore = FirebaseFirestore.getInstance();
        return new MyViewHolder(view);
    }

    public void deleteItem (int position){
        ChecklistModel checklistModel = checklist.get(position);
        firestore.collection("task").document(checklistModel.ItemId).delete();
        checklist.remove(position);
        notifyItemRemoved(position);
    }
//    public void editItem (int position){
//        ChecklistModel checklistModel = checklist.get(position);
//
//        Bundle bundle = new Bundle();
//        bundle.putString("task", checklistModel.getTask());
//        bundle.putString("due", checklistModel.getDue());
//        bundle.putString("id", checklistModel.ItemId);
//
//        AddItem addItem = new AddItem();
//        addItem.setArguments(bundle);
//        addItem.show(activity.getSupportFragmentManager(), addItem.getTag());
//    }
    public Context getContext(){
        return this.context;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChecklistModel checklistModel = checklist.get(position);
        holder.mCheckBox.setText(checklistModel.getTask());
        holder.mDueDate.setText("Due On " + checklistModel.getDue());
        holder.mCheckBox.setChecked(toBoolean(checklistModel.getStatus()));

        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    firestore.collection("task").document(checklistModel.ItemId).update("status", 1);
                }
                else{
                    firestore.collection("task").document(checklistModel.ItemId).update("status", 0);
                }
            }
        });
    }

    private boolean toBoolean(int status){
        return status != 0;
    }

    @Override
    public int getItemCount() {
        return checklist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mDueDate;
        CheckBox mCheckBox;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            mDueDate = itemView.findViewById(R.id.duedate);
            mCheckBox = itemView.findViewById(R.id.mcheckbox);
        }
    }
}
