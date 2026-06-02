package com.hong.demo

/**
 * 在 Scala 中，伴生对象和伴生类可以互相访问对方的私有成员。伴生对象和伴生类是同名且在同一文件中的类和对象。
 */
class CompanionExample {
  private val privateField: String = "I am private in class"
}

object CompanionExample {
  def accessPrivateField(example: CompanionExample): String = {
    example.privateField  // 伴生对象可以访问类的 private 成员
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val example = new CompanionExample
    println(CompanionExample.accessPrivateField(example))
  }
}