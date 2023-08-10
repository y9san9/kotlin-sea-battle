package me.y9san9.seaBattle.render

import me.y9san9.seaBattle.field.GameCell
import me.y9san9.seaBattle.field.GameFieldView

object ConsoleRender {
    private val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

    fun render(field: GameFieldView) {
        val list = field.matrix.toList()

        val header = alphabet.take(field.matrix.width).joinToString(separator = "\t")
        println("  \t$header")

        for ((i, row) in list.withIndex()) {
            val rowNumber = "${i + 1} ".substring(0, 2)
            print("$rowNumber\t")

            for (element in row) {
                print("${element.stringify()}\t")
            }
            println()
        }
    }

    private fun GameCell.stringify() = when {
        !isOpen -> ' '
        else -> if (isShip) '■' else '~'
    }
}
