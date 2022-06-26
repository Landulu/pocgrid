package com.esgi.pocgrid

import android.os.Bundle
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.esgi.pocgrid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var _horizontalView : HorizontalScrollView;

    private lateinit var  _gardenGrid : GridView;

    private val grid = arrayOf(
        arrayOf(0,0,2,2,2,5,5,6),
        arrayOf(0,0,2,2,2,5,5,6),
        arrayOf(0,0,2,2,2,5,5,6),
        arrayOf(0,0,2,2,2,5,5,6),
        arrayOf(0,1,1,2,3,5,5,6),
        arrayOf(0,1,2,2,3,5,5,6),
        arrayOf(0,1,1,3,3,5,5,6),
        arrayOf(0,1,1,3,3,5,5,6),
        arrayOf(0,1,1,3,3,5,5,6),
        arrayOf(0,1,1,3,3,5,5,6),
        arrayOf(0,0,0,0,0,0,0,0),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        _gardenGrid = findViewById(R.id.garden_grid_view)

        _gardenGrid.numColumns = grid[0].size

        setupGridView()

    }

    private fun setupGridView() {

        var cellMatrix: MutableList<MutableList<CellDto>> = mutableListOf()


        for (l in grid.indices) {

            cellMatrix.add(mutableListOf())

            for (c in grid[0].indices) {

                val leftKin =  if (c == 0) false else grid[l][c-1] == grid[l][c]
                val rightKin =  if (c == grid[0].lastIndex) false else grid[l][c + 1] == grid[l][c]
                val topKin =  if (l == 0) false else grid[l-1][c] == grid[l][c]
                val bottomKin =  if (l == grid.lastIndex) false else grid[l+1][c] == grid[l][c]


                val cell = CellDto(grid[l][c], leftKin, rightKin, topKin, bottomKin)

                cellMatrix[l].add(cell);

            }
        }


        val adapter = GridCellAdapter(this, R.layout.cell_view, cellMatrix.flatten().toTypedArray())
        binding.gardenGridView.adapter = adapter

        binding.gardenGridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                Toast.makeText(
                    this@MainActivity, " Clicked : " + (grid.flatten()[position]),
                    Toast.LENGTH_SHORT
                ).show()
            }
    }



}