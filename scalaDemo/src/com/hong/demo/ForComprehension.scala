package com.hong.demo

object ForComprehension {
  def main(args: Array[String]): Unit = {
    // 同时声明多个变量用于迭代
    val numbers = List((1, "one"), (2, "two"), (3, "three"))
    for ((number, word) <- numbers) {
      println(s"Number: $number, Word: $word")
    }

    // 使用 for 推导式生成新集合
    val newNumbers = for {
      (number, word) <- numbers
    } yield (number * 2, word.toUpperCase)

    println(s"New Numbers: $newNumbers")

    var a = 0;
    // for 循环
    for (a <- 1 to 10) {
      println("Value of a: " + a);
    }
    a = 0;
    // for 循环
    for (a <- 1 until 10) {
      println("Value of a: " + a);
    }

    a = 0;
    var b = 0;
    // for 循环
    for (a <- 1 to 3; b <- 1 to 6) {
      println("Value of a: " + a);
      println("Value of b: " + b);
    }

    a = 0;
    var numList = List(1, 2, 3, 4, 5, 6);

    // for 循环
    for (a <- numList) {
      println("Value of a: " + a);
    }

    a = 0;
    numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // for 循环
    for (a <- numList
         if a != 3; if a < 8) {
      println("Value of a: " + a);
    }


    a = 0;
    numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // for 循环
    var retVal = for {a <- numList
                      if a != 3; if a < 8
                      } yield a

    // 输出返回值
    for (a <- retVal) {
      println("Value of a: " + a);
    }
  }
}