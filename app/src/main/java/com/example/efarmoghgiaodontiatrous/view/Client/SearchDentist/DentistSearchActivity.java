package com.example.efarmoghgiaodontiatrous.view.Client.SearchDentist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.view.AndroidUtil.DentistAdapter;
import com.example.efarmoghgiaodontiatrous.view.AndroidUtil.ItemSelectionListener;
import com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu.GuestMenuActivity;
import com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment.RequestAppointmentActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Dentist search activity.
 */
public class DentistSearchActivity extends AppCompatActivity implements ItemSelectionListener<Dentist>, DentistSearchView {
    /**
     * The Recycler view.
     */
    RecyclerView recyclerView;
    private DentistAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DentistSearchPresenter dentistSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_search);
        Set<Dentist> result = new HashSet<>();
        Intent intent = getIntent();
        dentistSearchPresenter = new DentistSearchPresenter(this);
        if (intent.hasExtra("lastname")) {
            String lastname = intent.getStringExtra("lastname");
            String firstname = intent.getStringExtra("firstname");
            result = dentistSearchPresenter.searchDentists(lastname, firstname);
        } else if (intent.hasExtra("region")) {
            String region = intent.getStringExtra("region");
            String specialization = intent.getStringExtra("specialization");
            String service = intent.getStringExtra("service");
            result = dentistSearchPresenter.searchDentistsWithFilters(region, specialization, service);
        }
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DentistAdapter(new ArrayList<>(result));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setDentistSelectionListener(this);
    }

    @Override
    public void onItemSelected(Dentist item) {
        dentistSearchPresenter.onDentistSelected(item);
    }

    @Override
    public void requestAppointment(Dentist item) {
        Intent intent = new Intent(this, RequestAppointmentActivity.class);
        intent.putExtra("DentistID", item.getID());
        startActivityForResult(intent, 1);
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(DentistSearchActivity.this, GuestMenuActivity.class);
        startActivity(intent);
    }
}