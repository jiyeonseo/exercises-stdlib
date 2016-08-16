package puruni

import org.scalatest.{FunSuite, Matchers}

class LambdaSpec extends FunSuite with Matchers {

  test("lambda") {
    // method , function

    // function : 이름 없어도 됨, top에서 독자적으로 쓰일수 있음
    // method : class, object 안에 잇어야 함

  }
  val f:(Int) => String = (x:Int) => x.toString
  def f4(a:Int):String = a.toString

  val f2 = new Function1[Int, String] {
    override def apply(v1: Int): String = {
      v1.toString
    }
  }

  f4(1000) shouldBe "1000"

  def x = 10+1 // x를 부를 때 마다 연산
  val y = 10+1 // 값을 y에 할당
  // 참고 lazy val
}

