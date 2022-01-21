fun main() {
    /*
    a = [1, 2, 5, 4, 6, 8, 7]
    x = 4
    indexOf(x)
    O(n) - поиск элемента в произвольном массиве.
    Бинарный поиск
    a = [1, 4, 5, 8, 9, 18, 32, 68, 99]
    x = 68
    O(log n) - бинарный поиск в упорядоченном массиве

    индексация
    */
    val array = arrayListOf(1, 1, 1, 5, 15, 17, 19, 22, 24, 31, 31, 31, 105, 150, 150)
    val x = 150
    val start = array.startIndex(x)
    val end = array.endIndex(x)
    println("Диапазон индексов элемента $x: $start..$end")
    /*
    Задача. Найти диапазон индексов, который заполняет данный элемент x
    в упорядоченном массиве, за логарифмическое время.
    */
}

fun <T: Comparable<T>>  ArrayList<T>.endIndex(value: T,
                                              range: IntRange = indices): Int? {
    if (range.first > range.last) {
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    if (value == this[middle]) {
        if (middle == range.last) {
            return range.last
        }
        if (this[middle + 1] != value) {
            return middle
        } else {
            endIndex(value, middle + 1..range.last)
        }
    }
    return if (value < this[middle]) {
        endIndex(value, range.first until middle)
    } else {
        endIndex(value, middle + 1..range.last)
    }
}



fun <T: Comparable<T>> ArrayList<T>.startIndex(value: T,
                                                range: IntRange = indices): Int? {
    if (range.first > range.last) {
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    if (value == this[middle]) {
        if (middle == range.first) {
            return middle
        }
        return if (value == this[middle - 1]) {
            startIndex(value, range.first until middle)
        } else {
            middle
        }
    }
    return if (value < this[middle]) {
        startIndex(value, range.first until middle)
    } else {
        startIndex(value, middle + 1..range.last)
    }
}

fun <T: Comparable<T>> ArrayList<T>.binarySearch1(value: T,
                                            range: IntRange = indices): Int? {
    if (range.first > range.last) {
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    if (value == this[middle]) {
        return middle
    }
    return if (value < this[middle]) {
        binarySearch1(value, range.first until middle)
    } else {
        binarySearch1(value, middle + 1..range.last)
    }
}