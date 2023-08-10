package me.y9san9.seaBattle.field

data class GameCell(
    val isOpen: Boolean,
    val isShip: Boolean
) {
    val isEmpty: Boolean get() = !isShip
    val isHidden: Boolean get() = !isOpen

    companion object {
        fun Ship(isOpen: Boolean): GameCell = GameCell(
            isOpen = isOpen,
            isShip = true
        )
        fun Empty(isOpen: Boolean): GameCell = GameCell(
            isOpen = isOpen,
            isShip = false
        )
    }
}
