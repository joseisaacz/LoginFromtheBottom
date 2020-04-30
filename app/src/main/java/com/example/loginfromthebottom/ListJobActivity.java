package com.example.loginfromthebottom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.loginfromthebottom.Adapter.JobApplicationAdapter;
import com.example.loginfromthebottom.Adapter.RecyclerItemTouchHelper;
import com.example.loginfromthebottom.Data.Database;
import com.example.loginfromthebottom.Model.JobApplicationModel;

public class ListJobActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener, JobApplicationAdapter.JobAppAdapterListener{
    private RecyclerView recyclerView;
    private JobApplicationAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_job);
        recyclerView=findViewById(R.id.recyclerJobs);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter= new JobApplicationAdapter(Database.getListOfApplications(),this);
        recyclerView.setAdapter(adapter);
        //delete swiping left and right
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
        //checkIntentInformation();
        adapter.notifyDataSetChanged();
    }



    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (direction == ItemTouchHelper.START) {
            if (viewHolder instanceof JobApplicationAdapter.MyViewHolder) {
                // get the removed item name to display it in snack bar
                String name = Database.getListOfApplications().get(viewHolder.getAdapterPosition()).getFirstName();

                // save the index deleted
                final int deletedIndex = viewHolder.getAdapterPosition();
                // remove the item from recyclerView
                adapter.removeItem(viewHolder.getAdapterPosition());



            }
        } else {
            //If is editing a row object
            JobApplicationModel aux = adapter.getSwipedItem(viewHolder.getAdapterPosition());
            //send data to Edit Activity
//            Intent intent = new Intent(this, AddUpdCarreraActivity.class);
//            intent.putExtra("editable", true);
//            intent.putExtra("carrera", aux);
            adapter.notifyDataSetChanged(); //restart left swipe view
            //startActivity(intent);
        }
    }

    @Override
    public void onItemMove(int source, int target) {
        adapter.onItemMove(source, target);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() { //TODO it's not working yet


        super.onBackPressed();
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @Override
    public void onContactSelected(JobApplicationModel jobApplication) { //TODO get the select item of recycleView
        Toast.makeText(getApplicationContext(), "Selected: " + jobApplication.getId() + ", " + jobApplication.getFirstName(), Toast.LENGTH_LONG).show();
    }
}