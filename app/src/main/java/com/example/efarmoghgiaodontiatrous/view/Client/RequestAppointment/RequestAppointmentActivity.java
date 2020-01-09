package com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;
import com.example.efarmoghgiaodontiatrous.util.SystemDate;
import com.example.efarmoghgiaodontiatrous.view.HomePage.MainActivity;

import java.util.List;

/**
 * The type Request appointment activity.
 */
public class RequestAppointmentActivity extends AppCompatActivity implements RequestAppointmentView {
    /**
     * The Date of appointment.
     */
    SimpleCalendar dateOfAppointment = SystemDate.now();
    /**
     * The Presenter.
     */
    RequestAppointmentPresenter Presenter;
    /**
     * The S.
     */
    Spinner s;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Presenter = new RequestAppointmentPresenter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_appointment);
        Intent intent = getIntent();
        CalendarView calendar = findViewById(R.id.DateOfAppointment);
        final String DentistID = intent.getStringExtra("DentistID");
        final Dentist dentist = Presenter.findDentistByID(DentistID);

        change(DentistID, dateOfAppointment);
        TextView dentistInfo = findViewById(R.id.dentistInfo);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                month++;
                dateOfAppointment = new SimpleCalendar(year, month, dayOfMonth);
                change(DentistID, dateOfAppointment);
            }

        });

        dentistInfo.setText(dentist.getLastName() + " " + dentist.getFirstName() + "\n" + dentist.getInfirmaryLocation().getStreet() + " " + dentist.getInfirmaryLocation().getNumber() +
                ", " + dentist.getInfirmaryLocation().getZipCode() + ", " + dentist.getInfirmaryLocation().getCity() + "\n" + dentist.getEmail());
        findViewById(R.id.submitAppointmentRequest).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SimpleCalendar bookDate = dateOfAppointment;
                String time = s.getSelectedItem().toString();
                String lastName = ((EditText) findViewById(R.id.lastname)).getText().toString();
                String firstName = ((EditText) findViewById(R.id.firstname)).getText().toString();
                String telNo = ((EditText) findViewById(R.id.ContactNum)).getText().toString();
                Presenter.requestAppointment(dentist, bookDate, time, telNo, lastName, firstName);
            }
        });
    }

    public void change(String DentistID, SimpleCalendar dateOfAppointment) {
        List<String> times = Presenter.getAppTimes(DentistID, dateOfAppointment);
        s = findViewById(R.id.AppointmentTime);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, times);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}