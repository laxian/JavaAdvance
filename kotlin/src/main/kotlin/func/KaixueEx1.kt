package func

// https://kaixue.io/kotlin-basic-2/
//创建一个 Kotlin 类，这个类需要禁止外部通过构造器创建实例，并提供至少一种实例化方式。
class Cls {
    private constructor()

    // one
    fun getInstance(): Cls {
        return Cls()
    }
}


//分别用 Array、IntArray、List 实现 「保存 1-100_000 的数字，并求出这些数字的平均值」，打印出这三种数据结构的执行时间。
fun ans() {
    sumArray()
    sumIntArray()
    sumList()
}

fun sumList() {
    val tik = System.currentTimeMillis()

    var arr = List(100_000) { i -> i + 1 }
    println(arr.size)
    var sum = 0
    for (i in arr) {
        sum+=i
    }
    val tok = System.currentTimeMillis();
    println("sum is $sum: time: ${tok - tik}")
}

private fun sumIntArray() {
    val tik = System.currentTimeMillis()

    var arr = IntArray(100_000) { i -> i + 1 }
    println(arr.size)
    var sum = 0
    for (i in arr) {
        sum += i
    }
    val tok = System.currentTimeMillis();
    println("sum is $sum: time: ${tok - tik}")
}

private fun sumArray() {
    val tik = System.currentTimeMillis()
    var arr: Array<Int> = Array(100_000) { i -> i + 1 }

    println(arr.size)
    var sum = 0
    for ((_, i) in arr.withIndex()) {
        sum += i
    }
    val tok = System.currentTimeMillis();
    println("sum is $sum: time: ${tok - tik}")
}

fun main() {
    ans()
}
