package com.example.efarmoghgiaodontiatrous.view.AndroidUtil;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


/**
 * The type List view item view holder.
 */
public class ListViewItemViewHolder extends RecyclerView.ViewHolder {

    private CheckBox itemCheckbox;

    private TextView itemTextView;

    /**
     * Instantiates a new List view item view holder.
     *
     * @param itemView the item view
     */
    public ListViewItemViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Gets item checkbox.
     *
     * @return the item checkbox
     */
    public CheckBox getItemCheckbox() {
        return itemCheckbox;
    }

    /**
     * Sets item checkbox.
     *
     * @param itemCheckbox the item checkbox
     */
    public void setItemCheckbox(CheckBox itemCheckbox) {
        this.itemCheckbox = itemCheckbox;
    }

    /**
     * Gets item text view.
     *
     * @return the item text view
     */
    public TextView getItemTextView() {
        return itemTextView;
    }

    /**
     * Sets item text view.
     *
     * @param itemTextView the item text view
     */
    public void setItemTextView(TextView itemTextView) {
        this.itemTextView = itemTextView;
    }
}