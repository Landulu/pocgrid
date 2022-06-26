package com.esgi.pocgrid

data class CellDto(
    val id: Int,
    val leftNeighborIsKin : Boolean,
    val rightNeighborIsKin : Boolean,
    val topNeighborIsKin : Boolean,
    val bottomNeighborIsKin : Boolean,
)
