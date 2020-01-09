package com.example.efarmoghgiaodontiatrous.view.AndroidUtil;


/**
 * The interface Item selection listener.
 *
 * @param <T> the type parameter
 */
//Interface that sets the selected Item as generic
public interface ItemSelectionListener<T> {
    /**
     * On item selected.
     *
     * @param item the item
     */
    void onItemSelected(T item);
}