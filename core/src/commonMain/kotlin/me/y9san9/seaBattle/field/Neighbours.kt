package me.y9san9.seaBattle.field

fun GameField.getNeighbours(ship: Ship) = ship.cells
    .flatMap { coordinate -> getNeighbours(coordinate) }
    .filter { coordinate -> coordinate !in ship.cells }
    .distinct()

fun GameField.getNeighbours(coordinates: Coordinates): List<Coordinates> {
    return coordinates
        .neighbours()
        .filter(::contains)
}
