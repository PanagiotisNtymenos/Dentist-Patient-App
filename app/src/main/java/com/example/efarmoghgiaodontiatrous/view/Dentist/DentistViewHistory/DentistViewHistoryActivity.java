package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewHistory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu.DentistMenuActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.RecordService.RecordServiceActivity;

/**
 * The type Dentist view history activity.
 */
public class DentistViewHistoryActivity extends AppCompatActivity implements DentistViewHistoryView {
    /**
     * The Presenter.
     */
    protected DentistViewHistoryPresenter presenter;
    /**
     * The Id.
     */
    protected String ID;
    private String AMKA;

    /**
     * Uses the AMKA to call other functions and show the info to the Dentist
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        presenter = new DentistViewHistoryPresenter(this);
        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");
        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView history = findViewById(R.id.history_info);
                AMKA = ((EditText) findViewById(R.id.input_amka)).getText().toString();
                history.setText(presenter.onHistoryBack(AMKA));
                findViewById(R.id.plusBtn).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.plusBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AMKA = ((EditText) findViewById(R.id.input_amka)).getText().toString();
                onCheckAMKA(AMKA);
            }
        });
    }

    /**
     * On check amka.
     *
     * @param AMKA the amka
     */
    public void onCheckAMKA(String AMKA) {
        if (!AMKA.equals("")) {
            onRecordService();
        } else {
            Toast.makeText(getBaseContext(), "The Client's AMKA field is required!", Toast.LENGTH_SHORT).show();
            findViewById(R.id.plusBtn).setEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(DentistViewHistoryActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }

    /**
     * On record service.
     */
    public void onRecordService() {
        Intent intent = new Intent(DentistViewHistoryActivity.this, RecordServiceActivity.class);
        intent.putExtra("ID", ID);
        intent.putExtra("AMKA", AMKA);
        intent.putExtra("cameFromWhere?", "History");
        startActivity(intent);
        finish();
    }
}