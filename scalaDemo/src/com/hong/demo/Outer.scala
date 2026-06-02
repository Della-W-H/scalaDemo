package com.hong.demo

/**
 * 在 Scala 中，访问修饰符用于控制类、对象、特质（traits）及其成员（如字段和方法）的可见性和访问权限。
 *
 * Scala 访问修饰符基本和 Java 的一样，分别有：private，protected，public。
 *
 * 如果没有指定访问修饰符，默认情况下，Scala 对象的访问级别都是 public。
 *
 * Scala 中的 private 限定符，比 Java 更严格，在嵌套类情况下，外层类甚至不能访问被嵌套类的私有成员。
 */
class Outer{
  class Inner{
    private def f(): Unit = {
      println("f")
    }
    class InnerMost{
      f() // 正确
    }
  }
  //(new Inner).f() //错误
  /*
  (new Inner).f( ) 访问不合法是因为 f 在 Inner 中被声明为 private，而访问不在类 Inner 之内。
  但在 InnerMost 里访问 f 就没有问题的，因为这个访问包含在 Inner 类之内。
   */

  /*
  在 scala 中，对保护（Protected）成员的访问比 java 更严格一些。
  因为它只允许保护成员在定义了该成员的的类的子类中被访问。而在java中，用 protected关键字修饰的成员，除了定义了该成员的类的子类可以访问，同一个包里的其他类也可以进行访问。
   */
  class Super {
    protected def f(): Unit = {
      println("f")
    }
  }

  class Sub extends Super {
    f()
  }

  class Other {
    //(new Super).f() //错误
  }
  //Scala 中，如果没有指定任何的修饰符，则默认为 public。这样的成员在任何地方都可以被访问。
  class Outer {
    class Inner {
      def f(): Unit = {
        println("f")
      }

      class InnerMost {
        f() // 正确
      }
    }

    (new Inner).f() // 正确因为 f() 是 public
  }
}
