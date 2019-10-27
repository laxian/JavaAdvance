package func

fun main() {
    println("hello world!")
    val b:B = B()
    b.a()
}

open class A {
    open fun a(){
        println("called from a")
    }
}

class B : A() {
    override fun a(){}
}