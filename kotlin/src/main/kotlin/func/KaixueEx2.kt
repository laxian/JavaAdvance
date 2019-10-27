package func

// https://kaixue.io/
// 实现一个 fill 函数，传入一个 Array 和一个对象，
// 将对象填充到 Array 中，
// 要求 Array 参数的泛型支持逆变（假设 Array size 为 1）。
fun fill(arr: Array<in Any>, obj: Any): List<Any?> {
    arr[0] = obj
    val list = arr.toList()
    return list
}

// 实现一个 copy 函数，传入两个 Array 参数，
// 将一个 Array 中的元素复制到另外个 Array 中，
// 要求 Array 参数的泛型分别支持协变和逆变。
// （提示：Kotlin 中的 for 循环如果要用索引，需要使用 Array.indices）
fun copy(f: Array<out Any>, t: Array<in Any>) {
    for (i in f.indices) {
        t[i] = f[i]
    }
}

