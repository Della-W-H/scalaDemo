package com.hong.demo

object Test {
  /**
   * 如果你希望一行声明多个变量，可以这样写：
   *
   * scala
   * var (a, b, c, d) = (10, 20, 25, 25)
   * 或者使用分号：
   *
   * scala
   * var a = 10; var b = 20; var c = 25; var d = 25
   *
   * &	按位与运算符	(a & b) 输出结果 12 ，二进制解释： 0000 1100
   * |	按位或运算符	(a | b) 输出结果 61 ，二进制解释： 0011 1101
   * ^	按位异或运算符	(a ^ b) 输出结果 49 ，二进制解释： 0011 0001
   * ~	按位取反运算符	(~a ) 输出结果 -61 ，二进制解释： 1100 0011， 在一个有符号二进制数的补码形式。
   * <<	左移动运算符	a << 2 输出结果 240 ，二进制解释： 1111 0000
   * >>	右移动运算符	a >> 2 输出结果 15 ，二进制解释： 0000 1111
   * >>>	无符号右移	A >>>2 输出结果 15, 二进制解释: 0000 1111
   *
   */
  def main(args: Array[String]): Unit = {
    var a: Int = 10
    var b = 20   // 类型推断为 Int
    var c = 25
    var d = 25

    println("a + b = " + (a + b))
    println("a - b = " + (a - b))
    println("a * b = " + (a * b))
    println("b / a = " + (b / a))
    println("b % a = " + (b % a))
    println("c % a = " + (c % a))

    a = 60 /* 60 = 0011 1100 */
    b = 13 /* 13 = 0000 1101 */
    c = 0

    c = a & b /* 12 = 0000 1100 */

    println("a & b = " + c)

    c = a | b /* 61 = 0011 1101 */

    println("a | b = " + c)

    c = a ^ b /* 49 = 0011 0001 */

    println("a ^ b = " + c)

    c = ~a /* -61 = 1100 0011 */

    println("~a = " + c)

    c = a << 2 /* 240 = 1111 0000 */

    println("a << 2 = " + c)

    c = a >> 2 /* 15 = 1111 */

    println("a >> 2  = " + c)

    c = a >>> 2 /* 15 = 0000 1111 */

    println("a >>> 2 = " + c)


    a = 10
    b = 20
    c = 0

    c = a + b
    println("c = a + b  = " + c)

    c += a
    println("c += a  = " + c)

    c -= a
    println("c -= a = " + c)

    c *= a
    println("c *= a = " + c)

    a = 10
    c = 15
    c /= a
    println("c /= a  = " + c)

    a = 10
    c = 15
    c %= a
    println("c %= a  = " + c)

    c <<= 2
    println("c <<= 2  = " + c)

    c >>= 2
    println("c >>= 2  = " + c)

    c >>= a
    println("c >>= a  = " + c)

    c &= a
    println("c &= 2  = " + c)

    c ^= a
    println("c ^= a  = " + c)

    c |= a
    println("c |= a  = " + c)
  }
}