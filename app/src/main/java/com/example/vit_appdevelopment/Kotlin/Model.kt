package com.example.vit_appdevelopment.Kotlin

class Model {
    class Employee(var name: String, var age: Int, var postalAddress: String) {
        init {
            println("Employee is getting created with name: $name")
        }
    }

    class Student(var name: String, var age: Int, var postalAddress: String)
}

fun main() {
    val employee = Model.Employee("ashi ved", 30, "123 Main St")
    println("Employee Details: Name - ${employee.name}, Age - ${employee.age}, Postal Address - ${employee.postalAddress}")

    val student = Model.Student("shiv", 21, "VIT")
    println("Student Details: Name - ${student.name}, Age - ${student.age}, Postal Address - ${student.postalAddress}")
}
