package com.example.efarmoghgiaodontiatrous.view.AndroidUtil;


/**
 * The type List view item dto.
 */
//Class with function to set checkbox as Checked in ordewr to save the checked Items
public class ListViewItemDTO {

    private boolean checked = false;

    private String itemText = "";

    /**
     * Is checked boolean.
     *
     * @return the boolean
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * Sets checked.
     *
     * @param checked the checked
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     * Gets item text.
     *
     * @return the item text
     */
    public String getItemText() {
        return itemText;
    }

    /**
     * Sets item text.
     *
     * @param itemText the item text
     */
    public void setItemText(String itemText) {
        this.itemText = itemText;
    }
}