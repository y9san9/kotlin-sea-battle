package me.y9san9.seaBattle.matrix

/**
 * [
 *     [1, 2, 3, 4],
 *     [1, 2, 3, 4],
 *     [1, 2, 3, 4]
 * ]
 */
@JvmInline
value class Matrix<out T>(private val list: List<List<T>>) {
    init {
        require(list.maxOfOrNull { it.size } == list.minOfOrNull { it.size }) {
            "Size of matrix rows should be constant"
        }
    }

    val height: Int get() = list.size
    val width: Int get() = list.getOrNull(index = 0)?.size ?: 0

    operator fun get(x: Int, y: Int): T {
        return list[y][x]
    }

    fun toList(): List<List<T>> = list
}
