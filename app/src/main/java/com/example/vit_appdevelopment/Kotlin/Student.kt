package com.example.vit_appdevelopment.Kotlin

// pojo - plain old java object / vo value object / model class - box with partitions
class Student(var name: String, var age: Int, var postalAddress: String){
    fun calculateEligibility(){
        println("you are eligible")
    }
}
