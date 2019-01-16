package com.tm78775.digitalturbinetest.adapter

import androidx.recyclerview.widget.RecyclerView
import com.tm78775.digitalturbinetest.datasource.DataSource
import java.lang.IllegalStateException

abstract class BaseAdapter<T>: RecyclerView.Adapter<RecyclerView.ViewHolder>(), OnClickedItemIndexListener {

    var dataSource: DataSource<T> = DataSource()

    override fun getItemCount(): Int {
        return dataSource.getItemCount()
    }

    fun appendToDataSource(items: List<T>) {
        dataSource.addPageOfItems(items)
    }

    /**
     * Helper method that will allow the ViewHolder to return the index of an item
     * that was clicked on by the end user. Override this to receive a notification
     * that an item was clicked.
     */
    override fun onItemClicked(index: Int) {
        // this can be overridden if needed or left empty if not needed.
    }

}