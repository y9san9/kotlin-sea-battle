package me.y9san9.seaBattle.field

fun GameField.shoot(x: Int, y: Int): GameField {
    return shoot(Coordinates(x, y))
}

fun GameField.shoot(coordinates: Coordinates): GameField {
    require(coordinates !in opened) { "This field is already opened" }

    val ship = getShipOrNull(coordinates)

    val newField = copy(opened = opened + coordinates)

    if (ship == null || !newField.isShipDestroyed(ship))
        return newField

    if (ships.all { newField.isShipDestroyed(it) })
        return openAll()

    val neighbours = getNeighbours(ship)
    val opened = opened + coordinates + neighbours
    return copy(opened = opened)
}


fun GameField.openAll(): GameField {
    val opened = buildSet {
        repeat(height) { y ->
            repeat(width) { x ->
                add(Coordinates(x, y))
            }
        }
    }
    return copy(opened = opened)
}
