package me.y9san9.seaBattle.matrix

class MatrixBuilder<T> {
    private val list = mutableListOf<List<T>>()

    fun row(vararg elements: T) {
        val row = elements.toList()
        row.checkSize()
        list += row
    }

    fun row(builder: MutableList<T>.() -> Unit) {
        val row = buildList(builder)
        row.checkSize()
        list += row
    }

    private fun List<T>.checkSize() {
        if (list.isNotEmpty()) {
            require(list[0].size == size) {
                "You trying to create rows with variable size, while it should be constant"
            }
        }
    }

    fun toMatrix(): Matrix<T> = Matrix(list)
}

inline fun <T> buildMatrix(block: MatrixBuilder<T>.() -> Unit): Matrix<T> {
    return MatrixBuilder<T>().apply(block).toMatrix()
}
