/**
 * 这里的 x 指代某个所属的包、类或单例对象。
 *
 * 如果写成 private[x]，读作 "这个成员除了对 […] 中的类或 […] 中的包中的类及它们的伴生对像可见外，对其它所有类都是 private"。
 *
 * 这种技巧在横跨了若干包的大型项目中非常有用，它允许你定义一些在你项目的若干子包中可见但对于项目外部的客户却始终不可见的东西。
 * 
 * 上述例子中，类 Navigator 被标记为 private[bobsrockets] 就是说这个类对包含在 bobsrockets 包里的所有的类和对象可见。
 *
 * 比如说，从 Vehicle 对象里对 Navigator 的访问是被允许的，因为对象 Vehicle 包含在包 launch 中，而 launch 包在 bobsrockets 中，相反，所有在包 bobsrockets 之外的代码都不能访问类 Navigator。
 */
package bobsrockets{
  package navigation{
    private[bobsrockets] class Navigator{
      protected def useStarChart(): Unit = {}
      class LegOfJourney{
        private[Navigator] val distance = 100
      }
      private[bobsrockets] var speed = 200
      private[navigation] var speed2 = 200
    }
  }
  package launch{
    import navigation._
    object Vehicle{
      private[launch] val guide = new Navigator
      guide.speed = 100;
    }
  }
}