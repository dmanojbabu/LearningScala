package _050_implicit

/**
  * will gripe at compile time if there are two implicit bindings
  * of the same type.  It's worth noting that what Scala doing
  * are compile time tricks for implicit.
  *
  * One strategy is to wrap a value in a type to avoid conflict"
  *
  * Note:
  * the implicit group parameter list, can contain
  * more than one parameter, but needs to be in the same
  * implicit parameter group (and to be the last params group)
  */

case class Rate(value: Int)

case class Age(value: Int)

object _04_MultipleImplicitValuesIssue extends App {
  implicit val rate: Rate = Rate(20)
  implicit val age: Age = Age(50)
  implicit val currency: String = "$"

  def calculatePayment(hours: Int)(implicit currentRate: Rate, currency: String): String =
    currency + (hours * currentRate.value)

  println(s"calculatePayment(40): ${calculatePayment(40)}")
  print("calculatePayment(40)(Rate(50), \"JOD\"): ")
  println(calculatePayment(40)(Rate(50), "JOD"))
}