package com.hong.demo

object VariableExample {
  def main(args: Array[String]): Unit = {
    // 声明不可变变量
    val immutableVariable: Int = 10
    println(s"Immutable Variable: $immutableVariable")

    // 声明可变变量
    var mutableVariable: Int = 20
    println(s"Mutable Variable: $mutableVariable")

    // 修改可变变量的值
    mutableVariable = 30
    println(s"Updated Mutable Variable: $mutableVariable")

    // 不可变变量不能被重新赋值，会导致编译错误
    // immutableVariable = 15 // Uncommenting this line will cause a compilation error

    val inferredInt = 42 // 编译器推断为 Int
    val inferredDouble = 3.14 // 编译器推断为 Double
    val inferredString = "Hello, Scala!" // 编译器推断为 String
    val inferredBoolean = true // 编译器推断为 Boolean

    //显式类型声明时，在变量名后跟上冒号和数据类型
    val explicitInt: Int = 42
    val explicitDouble: Double = 3.14
    val explicitString: String = "Hello, Scala!"
    val explicitBoolean: Boolean = true

  }
}