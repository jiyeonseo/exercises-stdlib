package puruni

import org.scalatest.{Matchers, FunSuite}

/**
 * Created by jiyeon on 16. 8. 1..
 */
class ObjectSpec  extends FunSuite with Matchers {

  // singletone 객체의 인스턴스가 하나다
  // java와 다른점 +object -statis
  object Person {
    def name = "cheese"
    def age = 20
  }

  test("object test") {
    val x = Person
    val y = x

    // 자바에서는 == (reference 비교)
    // 자바에서 equal 은 값을 비교

    // 스칼라에서 eq은 reference 비교
    x eq y shouldBe true
    x == y shouldBe true

    val z = Person
    y eq z shouldBe true // 싱글톤
    y == z shouldBe true

    class Foo

    val a = new Foo
    val b = new Foo

    a eq b shouldBe false
  }


  test("componion object") {
    class Movie(val name:String, val year:Short)

    // 접근 권한이 똑같다
    // factory 메소드 만들때 쓴다
    object Movie{ // class와 이름이 같아
      def apply(x:String, y:Short) = {
        new Movie(x, y)
      }
    }


    Movie("강시",1992) // ==  new Movie("강시", 1992)
  }


}
