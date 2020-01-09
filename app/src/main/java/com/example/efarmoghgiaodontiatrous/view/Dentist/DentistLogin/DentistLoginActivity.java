package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu.DentistMenuActivity;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistSignup.DentistSignupActivity;
import com.example.efarmoghgiaodontiatrous.view.HomePage.MainActivity;

/**
 * The type Dentist login activity.
 */
public class DentistLoginActivity extends AppCompatActivity implements DentistLoginView {

    private DentistLoginPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_login);

        findViewById(R.id.Signup).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                signUp();
            }
        });

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);

        presenter = new DentistLoginPresenter(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (usernameEditText).getText().toString();
                String password = (passwordEditText).getText().toString();
                Dentist dentist = presenter.onValid(email, password);

                if (dentist != null) {
                    updateUiWithUser(dentist);
                } else {
                    showLoginFailed(presenter.onResult(email));
                }
            }
        });
    }

    private void updateUiWithUser(Dentist dentist) {
        String welcome = "Welcome Dr. " + dentist.getLastName();
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_SHORT).show();
        dentistMenu(dentist.getID());
    }

    private void showLoginFailed(String result) {
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
    }

    /**
     * Sign up.
     */
    public void signUp() {
        finish();
        Intent intent = new Intent(DentistLoginActivity.this, DentistSignupActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(DentistLoginActivity.this, MainActivity.class);
        intent.putExtra("notFirstTime", 1);
        startActivity(intent);
    }

    /**
     * Dentist menu.
     *
     * @param ID the id
     */
    public void dentistMenu(String ID) {
        finish();
        Intent intent = new Intent(DentistLoginActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }
}