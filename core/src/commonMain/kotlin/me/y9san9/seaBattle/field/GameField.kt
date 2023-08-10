package me.y9san9.seaBattle.field

import me.y9san9.seaBattle.matrix.buildMatrix

data class GameField(
    val height: Int,
    val width: Int,
    val ships: List<Ship>,
    val opened: Set<Coordinates>
) {
    val isAllOpen: Boolean get() = height * width == opened.size

    init {
        val shipsCells = ships.flatMap { ship -> ship.cells }
        require(
            shipsCells.distinct().size == shipsCells.size
        ) { "Ships overlap each other" }

        val allCells = opened + shipsCells
        require(allCells.all(::contains)) {
            "Coordinates are out of bounds"
        }

        for (ship in ships) {
            require(getNeighbours(ship).map(::get).all { cell -> cell.isEmpty }) {
                "Ships overlap each other"
            }
        }
    }

    operator fun get(coordinates: Coordinates): GameCell {
        return get(coordinates.x, coordinates.y)
    }

    operator fun get(x: Int, y: Int): GameCell {
        require(x < width && y < height) { "Index out of bound" }
        val coordinates = Coordinates(x, y)
        val isOpen = coordinates in opened
        val isShip = ships.any { ship -> coordinates in ship.cells }
        return GameCell(isOpen, isShip)
    }

    operator fun contains(coordinates: Coordinates): Boolean {
        return coordinates.x < width && coordinates.y < height
    }

    fun toView(): GameFieldView {
        val matrix = buildMatrix {
            repeat(height) { y ->
                row {
                    repeat(width) { x ->
                        add(get(x, y))
                    }
                }
            }
        }

        return GameFieldView(matrix)
    }
}
