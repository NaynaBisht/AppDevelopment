package com.example.vit_appdevelopment.Kotlin

    fun main() {
        println("hello world");
        var myStudent: Student = Student("nayna",19,"nainital")
        println(myStudent.name)
        myStudent.name = "bisht"
        println(myStudent.name)

        var myEmployee: Employee = Employee("abhishek",22,"pune")
        println(myEmployee.getName())
        println(myEmployee.name)

    }

