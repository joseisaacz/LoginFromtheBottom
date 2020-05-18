package com.example.loginfromthebottom.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.loginfromthebottom.Data.Database;
import com.example.loginfromthebottom.JobApplication;
import com.example.loginfromthebottom.Model.JobApplicationModel;
import com.example.loginfromthebottom.NavDrawerActivity;
import com.example.loginfromthebottom.R;
import com.example.loginfromthebottom.ViewJobApplication;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private List<JobApplicationModel> list;
    private ListView listView;
    private JobApplicationModel clickedObject=null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        listView = root.findViewById(R.id.listView);
        list=Database.getJobApplicationsByUserName(Database.currentUser);
        Object[] array = list.toArray();
        final ArrayAdapter<Object> listViewAdapter = new ArrayAdapter<Object>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                array
        );
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                clickedObject = (JobApplicationModel) adapter.getItemAtPosition(position);
                Intent intent = new Intent(getActivity().getBaseContext(), JobApplication.class);
                intent.putExtra("application",clickedObject);
                HomeFragment.this.startActivity(intent);

            }
        }
        );
        return root;
    }


}
