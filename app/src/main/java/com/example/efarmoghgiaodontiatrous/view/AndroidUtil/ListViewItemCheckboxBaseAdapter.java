package com.example.efarmoghgiaodontiatrous.view.AndroidUtil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.efarmoghgiaodontiatrous.R;

import java.util.List;

/**
 * The type List view item checkbox base adapter.
 */
//Extends Base Adapter so that it binds Strings with Checkboxes in order to be shown us a List
public class ListViewItemCheckboxBaseAdapter extends BaseAdapter {

    private List<ListViewItemDTO> listViewItemDtoList;

    private Context ctx;

    /**
     * Instantiates a new List view item checkbox base adapter.
     *
     * @param ctx                 the ctx
     * @param listViewItemDtoList the list view item dto list
     */
    public ListViewItemCheckboxBaseAdapter(Context ctx, List<ListViewItemDTO> listViewItemDtoList) {
        this.ctx = ctx;
        this.listViewItemDtoList = listViewItemDtoList;
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (listViewItemDtoList != null) {
            ret = listViewItemDtoList.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int itemIndex) {
        Object ret = null;
        if (listViewItemDtoList != null) {
            ret = listViewItemDtoList.get(itemIndex);
        }
        return ret;
    }

    @Override
    public long getItemId(int itemIndex) {
        return itemIndex;
    }

    @Override
    public View getView(int itemIndex, View convertView, ViewGroup viewGroup) {

        ListViewItemViewHolder viewHolder;

        if (convertView != null) {
            viewHolder = (ListViewItemViewHolder) convertView.getTag();
        } else {
            convertView = View.inflate(ctx, R.layout.activity_list_view_with_checkbox_item, null);

            CheckBox listItemCheckbox = convertView.findViewById(R.id.list_view_item_checkbox);

            TextView listItemText = convertView.findViewById(R.id.list_view_item_text);

            viewHolder = new ListViewItemViewHolder(convertView);

            viewHolder.setItemCheckbox(listItemCheckbox);

            viewHolder.setItemTextView(listItemText);

            convertView.setTag(viewHolder);
        }

        ListViewItemDTO listViewItemDto = listViewItemDtoList.get(itemIndex);
        viewHolder.getItemCheckbox().setChecked(listViewItemDto.isChecked());
        viewHolder.getItemTextView().setText(listViewItemDto.getItemText());

        return convertView;
    }
}