package me.y9san9.seaBattle.field

import me.y9san9.seaBattle.field.Ship.Orientation.Horizontal
import me.y9san9.seaBattle.field.Ship.Orientation.Vertical

data class Ship(
    val leftTopCell: Coordinates,
    val size: Int,
    val orientation: Orientation
) {
    val cells: List<Coordinates> = buildList {
        val (x, y) = leftTopCell

        repeat(this@Ship.size) { index ->

            add(
                Coordinates(
                    x = if (orientation == Horizontal) x + index else x,
                    y = if (orientation == Vertical) y + index else y
                )
            )
        }
    }

    enum class Orientation {
        Vertical, Horizontal
    }

    companion object {
        fun horizontal(
            leftTopCell: Coordinates,
            size: Int
        ): Ship = Ship(leftTopCell, size, Horizontal)

        fun vertical(
            leftTopCell: Coordinates,
            size: Int
        ): Ship = Ship(leftTopCell, size, Vertical)
    }
}
