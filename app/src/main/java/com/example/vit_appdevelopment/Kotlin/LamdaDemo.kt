package com.example.vit_appdevelopment.Kotlin

fun main(){
    var printImpl: PrintImpl = PrintImpl()
    printImpl.printSomething()

//    life after Lamdas
    val iPrint: () -> Unit = { println("printing something else from a lambda") }
    iPrint()

    var someLamda : (Int, Int) -> Int = {a:Int,b:Int -> a+b}
    println(someLamda(10,20))


    val func = operation()
    println(func(2))


}


var lamda : (Int) -> Int = {a-> a*a}
fun operation(): (Int)->Int{
    return lamda
}
fun square(x:Int) = x*x









