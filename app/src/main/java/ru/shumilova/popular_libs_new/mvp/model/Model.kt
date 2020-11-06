package ru.shumilova.popular_libs_new.mvp.model

class Model {
    private val counters: MutableList<Int> = mutableListOf(0, 0, 0)

    fun getCurrent(index: Int): Int {
        // TODO: входной контроль параметров
        return counters[index]
    }

    operator fun set(index: Int, value: Int) {
        counters[index] = value
    }

    /**
     * Инкремент счетчика
     * @param index - индекс счетчика
     * @return инкрементированное значение
     */
    fun next(index: Int): Int {
        val nextValue = counters[index] + 1
        counters[index] = nextValue
        return nextValue
    }
}