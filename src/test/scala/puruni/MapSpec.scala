package puruni

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by jiyeon on 2016. 8. 17..
  */
class MapSpec extends FunSuite with Matchers {
  test("maps") {

    //mutable , immutable
    // 1. Map(A,B)
    val map = Map[Int, String]((10,"십"), (1,"일"))
    val map2 = Map((10,"십"), (1,"일"))

    // 2. A -> B
    val map3 = Map(10->"십",1->"일")

    map shouldBe map2
    map2 shouldBe map3

    val map4 = map + ( 2 -> "이")


    map4.get(10) shouldBe Some("십")
    map4.getOrElse(4,"사") shouldBe "사" //


  }
}
