package com.hong.demo

import java.util.Date
import scala.math.Fractional.Implicits.infixFractionalOps

object Function {

  def main(args: Array[String]): Unit = {
    /**
     * 函数传名调用(call-by-name):将未计算的参数表达式直接应用到函数内部
     * 关键点：delayed 的参数是 t: => Long，这是按名传递（call-by-name）参数。每次使用 t 时，表达式 time() 都会被重新求值。
     */
    delayed(time());

    /**
     * 函数传值调用(call-by-value):将参数表达式的值传递给函数
     *
     * 按值传参 是默认、直觉的传递方式，适合大多数情况。
     *
     * 按名传参 允许你延迟求值甚至不求值（例如实现 while 循环、&& 短路逻辑）。
     *
     * 选择哪种取决于是否需要重复求值或避免提前求值
     */
    printInt(b = 5, a = 7)
    callByValue(time())

    /**
     * 通过在参数的类型之后放一个星号来设置可变参数(可重复的参数)。例如：
     */
    printStrings("Runoob", "Scala", "Python");

    /**
     * 递归函数来计算阶乘
     */
    for (i <- 1 to 10)
      println(i + " 的阶乘为: = " + factorial(i))

    /**
     * Scala 可以为函数参数指定默认参数值，使用了默认参数，你在调用函数的过程中可以不需要传递参数，这时函数就会调用它的默认参数值，如果传递了参数，则传递值会取代默认值
     */
    println("返回值 : " + addInt(2,4));
    /**
     * 高阶函数（Higher-Order Function）就是操作其他函数的函数。
     *
     * Scala 中允许使用高阶函数, 高阶函数可以使用其他函数作为参数，或者使用函数作为输出结果。
     *
     * 以下实例中，apply() 函数使用了另外一个函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v：
     * 解释要点：
     *
     * 定义了一个高阶函数 apply，它接受一个函数 f: Int => String 和一个整数 v，返回 f(v)。
     *
     * 定义了一个泛型函数 layout[A](x: A): String，返回 [x.toString]。
     *
     * println(apply(layout, 10)) 调用：将 layout 作为函数参数传递，由于 layout 接受任意类型 A，但 apply 要求 Int => String，
     * 而 layout 可以适配为 Int => String（因为当传入 Int 时，A 被推断为 Int），所以可以工作。输出应该是 [10]。
     * 解释 layout 是泛型，但在这里被具体化为 Int。
     *
     * 第一个参数 layout 是一个方法，它的类型是 [A](x: A): String。
     *
     * 在 Scala 中，方法可以自动提升为函数（称为 eta-expansion）。layout 被当作函数值 Int => String 传递，因为 apply 要求参数 f 的类型是 Int => String，所以编译器推断 A 为 Int。
     *
     * apply 内部调用 f(v)，即调用 layout(10)。
     *
     * layout 执行：x.toString 得到 "10"，然后拼接成 "[10]" 返回。
     *
     * println 打印这个字符串。
     */
    println(apply(layout, 10))

    /**
     * 在 Scala 函数内定义函数，定义在函数内的函数称之为局部函数。
     * 计算阶乘的尾递归版本。
     * 尾递归：递归调用是函数的最后一个操作。Scala 编译器会将其优化为循环（类似 while），避免栈溢出。
     *
     * 累加器：accumulator 保存中间结果，把计算传递给下一次调用，而不是在返回后继续运算。
     *
     * 这种写法比普通递归（n * fact(n-1)）更安全，适合处理较大的输入。
     */
    println(factorial2(0))
    println(factorial2(1))
    println(factorial2(2))
    println(factorial2(3))
    /**
     * 内部函数可以捕获外部函数的变量（包括参数），形成一个闭包。即使外部函数返回后，如果内部函数被传递出去，它仍然保留对外部变量的引用。
     */
    val add5 = makeAdder(5)
    println(add5(3)) // 8

    val hello = greeting("Hello")
    val hi = greeting("Hi")
    println(hello("Alice")) // Hello, Alice!
    println(hi("Bob")) // Hi, Bob!

    /**
     * Scala 中定义匿名函数的语法很简单，箭头左边是参数列表，右边是函数体
     */
    var inc = (x:Int) => x+1

    /**
     * 这是一个方法定义，返回类型是Int => Int（一个函数类型），方法体是一个匿名函数（字面量）(x: Int) => x + 1。注意与val add2 = (x: Int) => x + 1的区别。
     * 可以提一下方法每次调用会创建新的函数对象吗？实际上，这里方法体中的匿名函数在每次调用add2时会被求值，因此每次调用都会创建一个新的函数实例（不同于val定义的函数值）
     * val inc = (x: Int) => x + 1
     * inc 是一个函数值（实例），定义时创建一次函数对象，之后反复使用同一个对象。
     */


    val f = add2 // 调用 add2 方法，获得一个函数对象
    println(f(5)) // 6

    // 或者直接链式调用（不常见，但语法允许）
    println(add2(5)) // 错误
    println(add2.apply(5)) // 正确，但很别扭
    // Scala中，匿名函数（lambda）实际上是语法糖，会生成一个继承自某个FunctionN trait的对象，其中N是参数的数量。
    // 对于有多个参数的函数，会使用Function2、Function3等。对于0个参数的函数，会使用Function0。所以并非所有匿名函数的父类都是Function1，只有单参数匿名函数才是
    val f1 = add2 // 方法调用，获得一个新的函数实例
    val f2 = add2 // 再次调用，会创建另一个新的函数实例
    println(f1 eq f2) // false，在 Scala 2.12+ 版本之前, 因为每次调用方法都会重新求值方法体，重新创建匿名函数对象
    //在 Scala 2.12+ 版本中，f1 eq f2 确实输出 true
    //对于无捕获的匿名函数（纯函数），编译器会优化为单例对象，因此 eq 返回 true。
    //同时，需要注意：如果匿名函数捕获了外部变量（即闭包），则每次调用会创建新实例，eq 返回 false。
    //捕获 val（纯函数） 捕获 var（有状态） 无捕获（纯函数）
    // true             false            true
    val c1 = addWithCapture()
    val c2 = addWithCapture()

    println(c1 eq c2)
    println(c1(5))
    println(c2(5))


    //偏应用函数优化，绑定第一个 date 参数，第二个参数使用下划线(_)替换缺失的参数列表，并把这个新的函数值的索引的赋给变量。以上实例修改如下：
    val date = new Date
    val logWithDateBound = log(date, _: String)
    logWithDateBound("message1")
    Thread.sleep(1000)
    logWithDateBound("message2")
    Thread.sleep(1000)
    logWithDateBound("message3")

    //柯里化(Currying)指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程。新的函数返回一个以原有第二个参数为参数的函数。
    //首先我们定义一个函数: def add(x:Int,y:Int)=x+y
    //那么我们应用的时候，应该是这样用：add(1,2) 现在我们把这个函数变一下形： def add(x:Int)(y:Int) = x + y
    //那么我们应用的时候，应该是这样用：add(1)(2),最后结果都一样是3，这种方式（过程）就叫柯里化。
    //实现过程
    //add(1)(2) 实际上是依次调用两个普通函数（非柯里化函数），第一次调用使用一个参数 x，返回一个函数类型的值，第二次使用参数y调用这个函数类型的值。
    //实质上最先演变成这样一个方法：
    //def add(x:Int)=(y:Int)=>x+y
    //那么这个函数是什么意思呢？ 接收一个x为参数，返回一个匿名函数，该匿名函数的定义是：接收一个Int型参数y，函数体为x+y。现在我们来对这个方法进行调用。
    //val result = add(1) 返回一个result，那result的值应该是一个匿名函数：(y:Int)=>1+y 所以为了得到结果，我们继续调用result。
    //val sum = result(2)
    //最后打印出来的结果就是3。
    val str1: String = "Hello, "
    val str2: String = "Scala!"
    println("str1 + str2 = " + strcat(str1)(str2))

    //闭包
    //在 Scala 中，:+ 是 List（以及一般 Seq）的一个方法，用于在序列末尾追加一个元素
    //这种写法的特点：
    //: 通常在 Scala 中表示右关联操作符，但 :+ 和 +: 中，冒号靠近集合的一端表示这一端是集合。
    //:+ 的冒号在右边，表示追加到末尾；而 +: 冒号在左边，表示追加到开头（例如 msg +: messages）。
    //由于不可变，每次 :+ 都会创建新列表，时间复杂度 O(n)（n 为原列表长度）
    var messages = List("Hello", "World")
    val addMessage = (msg: String) => messages = messages :+ msg
    addMessage("Scala")
    println(messages) // 输出 List(Hello, World, Scala)
  }

  def strcat(s1: String)(s2: String) = {
    s1 + s2
  }

  def log(date: Date, message: String) = {
    println(s"$date, $message!")
  }

  var y = 10
  private def addWithCapture(): Int => Int = (x: Int) => {
      y += 1
      x + y
  }
  private def add2: Int => Int = (x: Int) => x + 1

  def greeting(prefix: String): String => String = {
    (name: String) => s"$prefix, $name!" // 匿名函数捕获了 prefix
  }

  private def makeAdder(x: Int): Int => Int = {
    def add(y: Int): Int = x + y // 闭包，捕获 x
    add
  }
  private def factorial2(i: Int): Int = {
    def fact(i: Int, accumulator: Int): Int = {
      if (i <= 1)
        accumulator
      else
        fact(i - 1, i * accumulator)
    }

    fact(i, 1)
  }

  def apply(f: Int => String, v: Int): String = f(v)

  private def layout[A](x: A) = "[" + x.toString + "]"

  private def addInt(a: Int = 5, b: Int = 7): Int = {
    var sum: Int = 0
    sum = a + b
    return sum
  }

  private def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorial(n - 1)
  }

  private def printStrings(args: String*) = {
    var i: Int = 0;
    for (arg <- args) {
      println("Arg value[" + i + "] = " + arg);
      i = i + 1;
    }
  }

  private def time() = {
    println("获取时间，单位为纳秒")
    System.nanoTime
  }

  private def delayed(t: => Long) = {
    println("在 delayed 方法内")
    println("参数： " + t)
    println("参数： " + t) // t 被求值两次
  }
  private def callByValue(t: Long) = { // 按值传参
    println("进入函数")
    println(t) // 直接使用传入的值
    println(t) // 再次使用同一个值
  }
  private def printInt(a: Int, b: Int) = {
    println("Value of a : " + a);
    println("Value of b : " + b);
  }
}