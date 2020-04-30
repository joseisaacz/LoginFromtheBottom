package com.example.loginfromthebottom.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.loginfromthebottom.Data.Database;
import com.example.loginfromthebottom.Model.JobApplicationModel;
import com.example.loginfromthebottom.R;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        List<JobApplicationModel> list= Database.getListOfApplications();
        ListView listView= root.findViewById(R.id.listView);
        Object[] array=list.toArray();
        ArrayAdapter<Object> listViewAdapter= new ArrayAdapter<Object>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                array
        );
        listView.setAdapter(listViewAdapter);
        return root;
    }
}
