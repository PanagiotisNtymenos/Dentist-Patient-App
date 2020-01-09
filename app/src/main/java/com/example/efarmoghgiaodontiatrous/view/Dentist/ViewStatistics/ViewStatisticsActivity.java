package com.example.efarmoghgiaodontiatrous.view.Dentist.ViewStatistics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu.DentistMenuActivity;

/**
 * The type View statistics activity.
 */
public class ViewStatisticsActivity extends AppCompatActivity implements ViewStatisticsView {

    /**
     * The Presenter.
     */
    protected ViewStatisticsPresenter presenter;
    private String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_statistics);
        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");

        presenter = new ViewStatisticsPresenter(this);

        TextView welcome = findViewById(R.id.welcome);
        welcome.setText(presenter.onWelcome(ID));

        TextView result = findViewById(R.id.result);
        result.setText(presenter.onStats(ID));
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(ViewStatisticsActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }
}