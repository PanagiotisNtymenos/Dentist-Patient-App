package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistUpdateAccount;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.view.AndroidUtil.ListViewItemCheckboxBaseAdapter;
import com.example.efarmoghgiaodontiatrous.view.AndroidUtil.ListViewItemDTO;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu.DentistMenuActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The type Dentist update account activity.
 */
public class DentistUpdateAccountActivity extends AppCompatActivity implements DentistUpdateAccountView {
    /**
     * The Temp specialization.
     */
    List<String> tempSpecialization;
    /**
     * The Temp services.
     */
    List<String> tempServices;
    private DentistUpdateAccountPresenter presenter;
    private Dentist dentist;
    private String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tempSpecialization = new ArrayList<>();
        tempServices = new ArrayList<>();
        setContentView(R.layout.activity_dentist_update_account);
        presenter = new DentistUpdateAccountPresenter(this);

        Intent intent = getIntent();
        ID = intent.getStringExtra("ID");
        dentist = presenter.onLoggedInDentist(ID);

        final ListView listViewWithCheckbox = findViewById(R.id.list_view_with_checkbox);
        final ListView listViewWithCheckbox2 = findViewById(R.id.list_view_with_checkbox2);

        final List<ListViewItemDTO> initItemListSpec = this.getInitViewItemDtoList();
        final List<ListViewItemDTO> initItemListServ = this.getInitViewItemDtoListServ();

        final ListViewItemCheckboxBaseAdapter listViewDataAdapter = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemListSpec);
        final ListViewItemCheckboxBaseAdapter listViewDataAdapter2 = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), initItemListServ);

        listViewDataAdapter.notifyDataSetChanged();
        listViewDataAdapter2.notifyDataSetChanged();

        listViewWithCheckbox.setAdapter(listViewDataAdapter);
        listViewWithCheckbox2.setAdapter(listViewDataAdapter2);

        Iterator stopSp = dentist.getSpecializations().iterator();
        for (Specialization key : dentist.getSpecializations()) {
            int c = 0;
            for (ListViewItemDTO check : initItemListSpec) {
                if (key.getSpecializationName().equals(check.getItemText())) {
                    listViewWithCheckbox.setItemChecked(c, true);
                    check.setChecked(true);
                    if (!tempSpecialization.contains(check.getItemText())) {
                        tempSpecialization.add(check.getItemText());
                    }
                }
                c++;
            }
            if (!stopSp.hasNext()) {
                break;
            }
        }

        Iterator stopSe = dentist.getServices().iterator();
        for (Service key : dentist.getServices()) {
            int c = 0;
            for (ListViewItemDTO check : initItemListServ) {
                if (key.getServiceName().equals(check.getItemText())) {
                    listViewWithCheckbox2.setItemChecked(c, true);
                    check.setChecked(true);
                    if (!tempServices.contains(check.getItemText())) {
                        tempServices.add(check.getItemText());
                    }
                }
                c++;
            }
            if (!stopSe.hasNext()) {
                break;
            }
        }

        listViewWithCheckbox2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long l) {
                Object itemObject = adapterView.getAdapter().getItem(itemIndex);

                ListViewItemDTO itemDto = (ListViewItemDTO) itemObject;

                CheckBox itemCheckbox = view.findViewById(R.id.list_view_item_checkbox);

                if (itemDto.isChecked()) {
                    itemCheckbox.setChecked(false);
                    itemDto.setChecked(false);
                    tempServices.remove(itemDto.getItemText());
                } else {
                    itemCheckbox.setChecked(true);
                    itemDto.setChecked(true);
                    if (!tempServices.contains(itemDto.getItemText())) {
                        tempServices.add(itemDto.getItemText());
                    }
                }
            }
        });

        listViewWithCheckbox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long l) {
                Object itemObject = adapterView.getAdapter().getItem(itemIndex);

                ListViewItemDTO itemDto = (ListViewItemDTO) itemObject;

                CheckBox itemCheckbox = view.findViewById(R.id.list_view_item_checkbox);

                if (itemDto.isChecked()) {
                    itemCheckbox.setChecked(false);
                    itemDto.setChecked(false);
                    tempSpecialization.remove(itemDto.getItemText());
                } else {
                    itemCheckbox.setChecked(true);
                    itemDto.setChecked(true);
                    if (!tempSpecialization.contains(itemDto.getItemText())) {
                        tempSpecialization.add(itemDto.getItemText());
                    }
                }
            }
        });

        TextView fname = findViewById(R.id.input_fname);
        fname.setText(dentist.getFirstName());

        TextView lname = findViewById(R.id.input_lname);
        lname.setText(dentist.getLastName());

        TextView mail = findViewById(R.id.input_email);
        mail.setText(dentist.getEmail());

        TextView pass = findViewById(R.id.input_password);
        pass.setText(dentist.getPassword());

        TextView phone = findViewById(R.id.input_phone);
        phone.setText(dentist.getTelephoneNo());

        TextView uni = findViewById(R.id.input_uni);
        uni.setText(dentist.getUniversityAttended());

        TextView street = findViewById(R.id.input_street);
        street.setText(dentist.getInfirmaryLocation().getStreet());

        TextView strno = findViewById(R.id.input_num);
        strno.setText(dentist.getInfirmaryLocation().getNumber());

        TextView zip = findViewById(R.id.input_zip);
        zip.setText(dentist.getInfirmaryLocation().getZipCode() + "");

        TextView city = findViewById(R.id.input_city);
        city.setText(dentist.getInfirmaryLocation().getCity());

        TextView country = findViewById(R.id.input_country);
        country.setText(dentist.getInfirmaryLocation().getCountry());

        TextView years = findViewById(R.id.input_years);
        years.setText(dentist.getTimeOfExperience() + "");

        TextView license = findViewById(R.id.input_license);
        license.setText(dentist.getExerciseLicense());

        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tempServices.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Select at least on Service!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (tempSpecialization.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Select at least on Specialization!", Toast.LENGTH_LONG).show();
                    return;
                }
                update();
                presenter.onDentistMenu();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent1 = new Intent(DentistUpdateAccountActivity.this, DentistMenuActivity.class);
        intent1.putExtra("Logged-In User", ID);
        startActivity(intent1);
    }

    /**
     * Validate boolean.
     *
     * @return the boolean
     */
    public boolean validate() {
        boolean valid = true;

        String name = ((EditText) findViewById(R.id.input_fname)).getText().toString();
        String email = ((EditText) findViewById(R.id.input_email)).getText().toString();
        String password = ((EditText) findViewById(R.id.input_password)).getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            ((EditText) findViewById(R.id.input_fname)).setError("at least 3 characters");
            valid = false;
        } else {
            ((EditText) findViewById(R.id.input_fname)).setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ((EditText) findViewById(R.id.input_email)).setError("enter a valid email address");
            valid = false;
        } else {
            ((EditText) findViewById(R.id.input_email)).setError(null);
        }

        if (password.isEmpty() || password.length() < 8) {
            ((EditText) findViewById(R.id.input_password)).setError("At least 8 characters");
            valid = false;
        } else {
            ((EditText) findViewById(R.id.input_password)).setError(null);
        }
        return valid;
    }

    /**
     * Update.
     */
    public void update() {
        if (!validate()) {
            onUpdateFailed();
            return;
        }

        findViewById(R.id.btn_update).setEnabled(false);

        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        onUpdateSuccess();
                    }
                }, 1000);
    }

    /**
     * On update success.
     */
//
    public void onUpdateSuccess() {
        dentist.setFirstName(((EditText) findViewById(R.id.input_fname)).getText().toString());
        dentist.setLastName(((EditText) findViewById(R.id.input_lname)).getText().toString());
        dentist.setEmail(((EditText) findViewById(R.id.input_email)).getText().toString());
        dentist.setPassword(((EditText) findViewById(R.id.input_password)).getText().toString());
        dentist.setTelephoneNo(((EditText) findViewById(R.id.input_phone)).getText().toString());
        dentist.setUniversityAttended(((EditText) findViewById(R.id.input_uni)).getText().toString());
        dentist.getInfirmaryLocation().setStreet(((EditText) findViewById(R.id.input_street)).getText().toString());
        dentist.getInfirmaryLocation().setNumber(((EditText) findViewById(R.id.input_num)).getText().toString());
        dentist.getInfirmaryLocation().setZipCode(Integer.parseInt(((EditText) findViewById(R.id.input_zip)).getText().toString()));
        dentist.getInfirmaryLocation().setCity(((EditText) findViewById(R.id.input_city)).getText().toString());
        dentist.getInfirmaryLocation().setCountry(((EditText) findViewById(R.id.input_country)).getText().toString());
        dentist.setTimeOfExperience(Integer.parseInt(((EditText) findViewById(R.id.input_years)).getText().toString()));
        dentist.setExerciseLicense(((EditText) findViewById(R.id.input_license)).getText().toString());
        for (Specialization key : dentist.getSpecializations()) {
            dentist.removeSpecialization(new Specialization(key.getSpecializationName(), key.getSpecializationID()));
        }
        for (Service key : dentist.getServices()) {
            dentist.removeService(new Service(key.getServiceName(), key.getServiceID()));
        }
        presenter.addServices(tempServices, dentist);
        presenter.addSpecializations(tempSpecialization, dentist);

        presenter.onUpdate(dentist);
        Toast.makeText(getApplicationContext(), "Update Successful!", Toast.LENGTH_LONG).show();
    }

    public void dentistMenu() {
        finish();
        Intent intent = new Intent(DentistUpdateAccountActivity.this, DentistMenuActivity.class);
        intent.putExtra("Logged-In User", ID);
        startActivity(intent);
    }

    /**
     * On update failed.
     */
    public void onUpdateFailed() {
        Toast.makeText(getBaseContext(), "Update Failed, try again!", Toast.LENGTH_LONG).show();
        findViewById(R.id.btn_update).setEnabled(true);
    }

    private List<ListViewItemDTO> getInitViewItemDtoList() {
        String[] itemTextArr = presenter.getSpecializationList();
        List<ListViewItemDTO> ret = new ArrayList<>();
        int length = itemTextArr.length;

        for (int i = 0; i < length; i++) {
            String itemText = itemTextArr[i];

            ListViewItemDTO dto = new ListViewItemDTO();
            dto.setChecked(false);
            dto.setItemText(itemText);

            ret.add(dto);
        }
        return ret;
    }

    private List<ListViewItemDTO> getInitViewItemDtoListServ() {
        String[] itemTextArr = presenter.getService();
        List<ListViewItemDTO> ret = new ArrayList<>();
        int length = itemTextArr.length;

        for (int i = 0; i < length; i++) {
            String itemText = itemTextArr[i];

            ListViewItemDTO dto = new ListViewItemDTO();
            dto.setChecked(false);
            dto.setItemText(itemText);

            ret.add(dto);
        }
        return ret;
    }
}