package com.example.akshay.parth;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akshay on 10/9/17.
 */

public class AdapterJobs extends RecyclerView.Adapter<AdapterJobs.JobViewHolder> {

    private ArrayList<JobSeekerInfo> currentJobs;
    private ListItemClickListener mOnClickListener;
    public AdapterJobs(ArrayList<JobSeekerInfo> inputlist,ListItemClickListener listener){
        currentJobs=new ArrayList<JobSeekerInfo>();
        currentJobs=inputlist;
        mOnClickListener = listener;


    }

    public interface ListItemClickListener{
        void OnListItemClick(String ButtonInfo,int i);
    }
    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflator=LayoutInflater.from(context);
        View view= inflator.inflate(R.layout.jobs_view_holder,parent,false);
        JobViewHolder viewHolder=new JobViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(JobViewHolder holder, int position) {
        holder.Bind(currentJobs.get(position).getTitleUser(),currentJobs.get(position).getNameUser());
        Log.i("message121212",currentJobs.get(position).getAddressUser());
        for(JobSeekerInfo i:currentJobs ){
            Log.i("message",i.getNameUser());
            Log.i("message",String.valueOf(currentJobs.size()));
        }

    }


    @Override
    public int getItemCount() {
        Log.i("121212121",String.valueOf(currentJobs.size()));
        return currentJobs.size();
    }
    class JobViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView TitleTextView;
        TextView NameTextView;
        ImageButton CallImageButton;
        ImageButton MessageImageButton;

        public JobViewHolder(View itemView){
            super(itemView);
            TitleTextView=itemView.findViewById(R.id.titleTextView);
            NameTextView=itemView.findViewById(R.id.addressTextView);
            CallImageButton=itemView.findViewById(R.id.callingimageButton);

            MessageImageButton=itemView.findViewById(R.id.messageImageButton);
            CallImageButton.setOnClickListener(this);
            MessageImageButton.setOnClickListener(this);
            TitleTextView.setOnClickListener(this);


        }
        void Bind(String Title,String Name){
            TitleTextView.setText(Title);
            NameTextView.setText(Name);

        }

        @Override
        public void onClick(View view) {

            int clickedItemIndex=getAdapterPosition();
            int i=0;
            switch (view.getId()){
                case R.id.callingimageButton:
                    i=0;
                    break;
                case R.id.messageImageButton:
                    i=1;
                    break;
                case R.id.titleTextView:
                    i=2;
                    break;

            }

            mOnClickListener.OnListItemClick(currentJobs.get(clickedItemIndex).getPhnNoUser(),i);

        }

    }
}
