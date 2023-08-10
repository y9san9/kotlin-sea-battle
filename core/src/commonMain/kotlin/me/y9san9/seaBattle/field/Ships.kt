package me.y9san9.seaBattle.field

fun GameField.getShipOrNull(coordinates: Coordinates): Ship? {
    return ships.firstOrNull { ship -> coordinates in ship.cells }
}

fun GameField.isShipDestroyed(ship: Ship): Boolean {
    return ship.cells.all { coordinates -> coordinates in opened }
}
