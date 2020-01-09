package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu.DentistMenuActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistUpdateAccount.DentistUpdateAccountActivity;

/**
 * The type Dentist view profile activity.
 */
public class DentistViewProfileActivity extends AppCompatActivity implements DentistViewProfileView {
    /**
     * The Presenter.
     */
    protected DentistViewProfilePresenter presenter;
    /**
     * The Id.
     */
    protected String ID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_view_profile);

        presenter = new DentistViewProfilePresenter(this);

        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");
        TextView profile = findViewById(R.id.dentist_info);

        profile.setText(presenter.onShowProfile(ID));

        findViewById(R.id.btn_update_account).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onUpdateAccount();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(DentistViewProfileActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }

    public void updateAccount() {
        finish();
        Intent intent = new Intent(DentistViewProfileActivity.this, DentistUpdateAccountActivity.class);
        intent.putExtra("ID", ID);
        startActivity(intent);
    }
}