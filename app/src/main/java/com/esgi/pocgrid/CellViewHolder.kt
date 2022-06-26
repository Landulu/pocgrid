package com.esgi.pocgrid

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.esgi.pocgrid.databinding.CellViewBinding


class CellViewHolder(private val inflater: LayoutInflater) {

    var cellBtn: TextView? = null

    val view: View;


    private lateinit var itemBinding: CellViewBinding


    init {
        itemBinding = CellViewBinding.inflate(inflater)

        view = itemBinding.root
    }

    fun bind(cell: CellDto, position: Int) {

        var drawable = GradientDrawable()

        itemBinding.cellTv.text = cell.id.toString()
        val left = if (cell.leftNeighborIsKin) 0 else 10
        val right = if (cell.rightNeighborIsKin) 0 else 10
        val top = if (cell.topNeighborIsKin) 0 else 10
        val bottom = if (cell.bottomNeighborIsKin) 0 else 10

        drawable.setColor(itemBinding.root.resources.getColor(R.color.teal_200))


        val layers = arrayOf<Drawable>(drawable)

        val layerDrawable = LayerDrawable(layers)

        layerDrawable.setLayerInset(0, left, top, right, bottom)

        itemBinding.cellCard.setBackground(layerDrawable)

        //itemBinding.cellTv.setPadding(left, top, right, bottom)


    }
}