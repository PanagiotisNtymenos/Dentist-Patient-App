package com.example.efarmoghgiaodontiatrous.view.HomePage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu.GuestMenuActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistLogin.DentistLoginActivity;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity implements MainActivityView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (!intent.hasExtra("notFirstTime")) {
            Initializer initializer = new MemoryInitializer();
            initializer.prepareData();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainActivityPresenter presenter = new MainActivityPresenter(this);

        findViewById(R.id.Guest_Button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onGuestMenu();
            }
        });

        findViewById(R.id.Dentist_Button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onDentistMenu();
            }
        });
    }

    @Override
    public void dentistMenu() {
        Intent intent = new Intent(MainActivity.this, DentistLoginActivity.class);
        startActivityForResult(intent, 1);
        finish();
    }

    @Override
    public void guestMenu() {
        Intent intent = new Intent(MainActivity.this, GuestMenuActivity.class);
        startActivityForResult(intent, 1);
        finish();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("We will miss you!")
                .setMessage("Are you sure you want to exit e-Dentist?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}