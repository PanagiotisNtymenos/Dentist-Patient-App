package com.example.efarmoghgiaodontiatrous.view.AndroidUtil;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.efarmoghgiaodontiatrous.R;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;

import java.util.List;

/**
 * A class that extends RecyclerView so that it shows Dentists with info to be selected for Activities to be done
 */
public class DentistAdapter extends RecyclerView.Adapter<DentistAdapter.ViewHolder> {
    private List<Dentist> itemList;

    private ItemSelectionListener<Dentist> dentSelectionListener;


    /**
     * Instantiates a new Dentist adapter.
     *
     * @param myDataset the my dataset
     */
    public DentistAdapter(List<Dentist> myDataset) {
        itemList = myDataset;
    }

    /**
     * Set a listener to be notified of dent selection (click on the TextView)
     *
     * @param dentSelectionListener the dent selection listener
     */
    public void setDentistSelectionListener(ItemSelectionListener<Dentist> dentSelectionListener) {
        this.dentSelectionListener = dentSelectionListener;
    }

    @Override
    public DentistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_dentist_result, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Dentist dentAtPosition = itemList.get(position);

        holder.txtDentist.setText("Name: " + dentAtPosition.getLastName() + " " + dentAtPosition.getFirstName() + "\nLocation: " + dentAtPosition.getInfirmaryLocation().print() + "\nEmail: " + dentAtPosition.getEmail() + " \nContact Number: " + dentAtPosition.getTelephoneNo() + "\nProviding Services: " + dentAtPosition.printServices() + "\nSpecializations: " + dentAtPosition.printSpecializations());
        holder.btnSelectDentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dentSelectionListener != null) {
                    dentSelectionListener.onItemSelected(dentAtPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /**
     * The type View holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * The List item.
         */
        public ViewGroup listItem;
        /**
         * The Txt dentist.
         */
        public TextView txtDentist;
        /**
         * The Btn select dentist.
         */
        public Button btnSelectDentist;

        /**
         * Instantiates a new View holder.
         *
         * @param v the v
         */
        public ViewHolder(ViewGroup v) {
            super(v);
            listItem = v;
            txtDentist = listItem.findViewById(R.id.txt_dentist_info);
            btnSelectDentist = listItem.findViewById(R.id.btn_select_dentist);
        }
    }
}