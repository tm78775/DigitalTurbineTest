package com.tm78775.digitalturbinetest.model

abstract class DataSource<T> {

    // region Variables

    protected val dataSource: MutableList<T> = mutableListOf()
    var count: Int = dataSource.count()
        get() { return dataSource.count() }
        private set

    // endregion

    // region Abstract Methods

    abstract fun contains(item: T): Boolean

    // endregion

    // region API

    /**
     * This method will set the data source for this adapter. By setting the data source,
     * it will clear any items that were previously in the data source.
     * @param items list of items which is our new data source.
     */
    fun setDataSource(items: List<T>) {
        dataSource.clear()
        dataSource.addAll(items)
    }

    /**
     * This method will get the item at the provided index.
     * @param index index into the data source.
     */
    fun getItem(index: Int): T {
        return dataSource[index]
    }

    /**
     * This method will add a single item to our data source to be appended at the end of
     * the list if no position was added. It will be entered in the position if the position
     * is provided.
     * @param item the item which will be appended to the list.
     * @param index the index into the data source into which the item will be entered.
     */
    fun addItem(item: T, index: Int = -1) {
        if(index < 0)
            dataSource.add(item)
        else
            dataSource.add(index, item)
    }

    /**
     * This method will append items to the end of the data source.
     * @param items list of items to be appended to the end of the list.
     * @param acceptDuplicates optional parameter. set to true if adding
     * duplicates is the preferred methodology.
     */
    fun addPageOfItems(items: List<T>, acceptDuplicates: Boolean = false) {
        if(acceptDuplicates)
            dataSource.addAll(items)
        else {
            items.forEach { it ->
                if(!contains(it)) {
                    dataSource.add(it)
                }
            }
        }
    }

    /**
     * This method will remove the item in the list by index.
     * @param index index of the item which should be removed.
     */
    fun removeItem(index: Int) {
        dataSource.removeAt(index)
    }

    // endregion

}