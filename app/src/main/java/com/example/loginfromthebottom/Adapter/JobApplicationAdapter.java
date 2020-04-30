package com.example.loginfromthebottom.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.loginfromthebottom.Model.JobApplicationModel;
import com.example.loginfromthebottom.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JobApplicationAdapter extends RecyclerView.Adapter<JobApplicationAdapter.MyViewHolder> implements Filterable {
    private List<JobApplicationModel> list;
    private List<JobApplicationModel> listFiltered;
    private JobAppAdapterListener listener;
    private JobApplicationModel deletedItem;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title1, title2, description;
        //two layers
        public RelativeLayout viewForeground, viewBackgroundDelete, viewBackgroundEdit;

        public MyViewHolder(View view) {
            super(view);
            title1 = view.findViewById(R.id.titleFirstLbl);
            title2 = view.findViewById(R.id.titleSecLbl);
            description = view.findViewById(R.id.descriptionLbl);
            viewBackgroundDelete = view.findViewById(R.id.view_background_delete);
            viewBackgroundEdit = view.findViewById(R.id.view_background_edit);
            viewForeground = view.findViewById(R.id.view_foreground);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onContactSelected(listFiltered.get(getAdapterPosition()));
                }
            });
        }
    }

    public JobApplicationAdapter(List<JobApplicationModel> carreraList, JobAppAdapterListener listener) {
        this.list = carreraList;
        this.listener = listener;
        //init filter
        this.listFiltered = carreraList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jobapp_viewholder, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // basically a render
        final JobApplicationModel jobApplication = listFiltered.get(position);
        holder.title1.setText(jobApplication.getFirstName()+" "+jobApplication.getLastName());
        holder.title2.setText(jobApplication.getApplyingJob());
        //holder.description.setText(jobApplication.getPosition());
    }

    @Override
    public int getItemCount() {
        return listFiltered.size();
    }

    public void removeItem(int position) {
        deletedItem = listFiltered.remove(position);
        Iterator<JobApplicationModel> iter = list.iterator();
        while (iter.hasNext()) {
            JobApplicationModel aux = iter.next();
            if (deletedItem.equals(aux))
                iter.remove();
        }
        // notify item removed
        notifyItemRemoved(position);
    }

    public void restoreItem(int position) {

        if (listFiltered.size() == list.size()) {
            listFiltered.add(position, deletedItem);
        } else {
            listFiltered.add(position, deletedItem);
            list.add(deletedItem);
        }
        notifyDataSetChanged();
        // notify item added by position
        notifyItemInserted(position);
    }

    public JobApplicationModel getSwipedItem(int index) {
        if (this.list.size() == this.listFiltered.size()) { //not filtered yet
            return list.get(index);
        } else {
            return listFiltered.get(index);
        }
    }

    public void onItemMove(int fromPosition, int toPosition) {
        if (list.size() == listFiltered.size()) { // without filter
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(list, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(list, i, i - 1);
                }
            }
        } else {
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(listFiltered, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(listFiltered, i, i - 1);
                }
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    listFiltered = list;
                } else {
                    List<JobApplicationModel> filteredList = new ArrayList<>();
                    for (JobApplicationModel row : list) {
                        String code=""+row.getId();
                        // filter use two parameters
                        if (code.equals(charString.toLowerCase()) || row.getFirstName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    listFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = listFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listFiltered = (ArrayList<JobApplicationModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface JobAppAdapterListener {
        void onContactSelected(JobApplicationModel model);
    }
}