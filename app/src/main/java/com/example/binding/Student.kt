package com.example.binding

//something like a constructor
//Student s = new Student(x,y)
//if nothing in the ( ), then its a default constructor in the main class
data class Student(
    var id:String = "",
    var name:String = ""
)

// if we set default value for the constructor, then it is like a default constructor ex. ""