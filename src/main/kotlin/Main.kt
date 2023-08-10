import me.y9san9.seaBattle.field.Coordinates
import me.y9san9.seaBattle.field.GameField
import me.y9san9.seaBattle.field.Ship
import me.y9san9.seaBattle.field.shoot
import me.y9san9.seaBattle.render.ConsoleRender

fun main() {
    var field = GameField(
        height = 10,
        width = 10,
        ships = listOf(
            Ship(
                leftTopCell = Coordinates(0, 0),
                size = 2,
                orientation = Ship.Orientation.Horizontal
            ),
            Ship(
                leftTopCell = Coordinates(3, 0),
                size = 3,
                orientation = Ship.Orientation.Vertical
            ),
            Ship(
                leftTopCell = Coordinates(0, 2),
                size = 4,
                orientation = Ship.Orientation.Vertical
            )
        ),
        opened = emptySet()
    )

    while (true) {
        ConsoleRender.render(field.toView())
        if (field.isAllOpen) break

        print("Введите координаты для стрельбы x, y: ")

        val (x, y) = readln()
            .split(Regex("([, ])"), limit = 2)
            .map(String::toInt)

        field = field.shoot(x, y)
    }

    println("Игра окончена!")
}
