package puruni

import org.scalatest.{Matchers, FunSuite}

/**
 * Created by jiyeon on 16. 8. 1..
 */
class OptionSpec extends FunSuite with Matchers {
  // Option을 상속받은 타입 : Some, None
  // DB에서 Nullable인 경우 Option[] 을 사용함

  test("optional") {
    val cheeseOption: Option[String] = Some("cheese option")
    val cheeseOption2 = Some("cheese option")

    println(cheeseOption)
    println(cheeseOption2)
  }

  test("getOrElse") {
    val cheeseOption: Option[String] = Some("cheese option")
    val cheeseOption1: Option[String] = None
    cheeseOption getOrElse "No value" shouldBe ("cheese option")
    cheeseOption1 getOrElse "No value" shouldBe ("No value")
    None getOrElse(0) shouldBe (0)
  }

  test("isEmpty") {
    val cheeseOption: Option[String] = Some("cheese option")
    val cheeseOption1: Option[String] = None

    cheeseOption.isEmpty shouldBe false
  }

  test("pattern matching"){
    val cheeseAge : Option[Double] = Some(20.0) // Some[Double]

    val old = cheeseAge match {
      case Some(v) => "young"
      case None => "don't know"
    }

    old shouldBe "young"
  }



}
