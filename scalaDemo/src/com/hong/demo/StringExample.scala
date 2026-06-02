package com.hong.demo

object StringExample {

  def main(args: Array[String]): Unit = {
    val buf = new StringBuilder;
    buf += 'a'
    buf ++= "bcdef"
    println( "buf is : " + buf.toString );

    var floatVar = 12.456
    var intVar = 2000
    var stringVar = "菜鸟教程!"
    var fs = printf("浮点型变量为 " +
      "%f, 整型变量为 %d, 字符串为 " +
      " %s", floatVar, intVar, stringVar)
    println(fs)
    //printf 方法的作用是按照格式字符串输出到标准输出，并返回 Unit（在 Scala 中写作 ()）。
    //
    //所以 fs 的类型是 Unit，值为 ()。
    //
    //然后 println(fs) 会打印 ()。
    //
    //同时，printf 本身已经输出了格式化后的字符串，所以控制台先看到格式化输出，紧接着 println 又打印了一个 ()。
    //
    //因此最终输出是两部分的拼接：先有 printf 输出的 "浮点型变量为 12.456000, 整型变量为 2000, 字符串为 菜鸟教程!"，然后换行？实际上 printf 不自动换行，接着 println 打印 () 并换行。所以看起来末尾有个 ()。
    //
    //用户可能期望只输出格式化字符串，不想要 ()。解决方案是直接调用 printf 而不捕获返回值，或者使用 print/println 配合字符串插值。
  }

}
