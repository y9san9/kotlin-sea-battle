package me.y9san9.seaBattle.field

data class Coordinates(val x: Int, val y: Int) {
    init {
        require(x >= 0 && y >= 0)
    }

    fun neighbours(): List<Coordinates> {
        return (-1..1).flatMap { deltaX ->
            (-1..1).mapNotNull { deltaY ->
                if (deltaX == 0 && deltaY == 0) return@mapNotNull null

                val x = x + deltaX
                val y = y + deltaY
                if (x < 0 || y < 0) return@mapNotNull null

                Coordinates(x, y)
            }
        }
    }
}
