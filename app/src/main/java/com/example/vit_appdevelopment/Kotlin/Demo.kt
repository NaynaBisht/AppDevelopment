package com.example.vit_appdevelopment.Kotlin

fun main(){
    val numberOfFish = 30
    val numberOfPlants = 23
    if(numberOfFish >numberOfPlants ){
        println("good ratio")
    }else{
        println("unhealthy ratio")
    }

    val pets = arrayOf("dog", "cat", "canary")
    for (element in pets){
        print(element+" ")
    }
    println()

    for ((index, element) in pets.withIndex()){
        println("item at $index is $element\n")
    }

    for (i in 1..5) print(i)
    println()
    for (i in 5 downTo 1) print(i)
    println()
    for (i in 3..6 step 2) print(i)
    println()
    for (i in 'd'..'g') print(i)
    println()

    printHello("hello")
    drive()
    drive("slow")

    add(10,20)
    multiply(10,20, '*')


}
fun printHello(name: String?){
    println("hi there")
}

fun drive(speed:String = "fast") {
    println("driving $speed")
}
fun add(firstNo:Int, secondNo:Int):Int{
    return firstNo+secondNo
}
fun multiply(firstNo:Int, secondNo:Int, operation:Char):Int{
    return firstNo*secondNo
}
fun double(x:Int) = x*2