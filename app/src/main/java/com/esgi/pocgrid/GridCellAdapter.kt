package com.esgi.pocgrid


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.esgi.pocgrid.databinding.CellViewBinding

internal class GridCellAdapter internal constructor(
    context: Context,
    private val resource: Int,
    private val itemList: Array<CellDto>?
) : ArrayAdapter<CellViewHolder>(context, resource){


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var itemBinding: CellViewBinding

    override fun getCount(): Int {
        return if (this.itemList != null) this.itemList.size else 0
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var convertView = view
        val holder = CellViewHolder(inflater)
        holder.bind(itemList!![position], position)
        return holder.view
    }


}