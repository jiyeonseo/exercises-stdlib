package puruni

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by jiyeon on 2016. 9. 28..
  */
class ImplicitSpec extends FunSuite with Matchers{
  // implicit 단어 뜻 : 은연중의 <-> 대놓고, 명시적 (explicit)
  // http://dic.daum.net/search.do?q=implicits&nil_profile=redirect_pattern

  test("explicit") {
//    import Implicit._

    def foo(bar: String): String = bar + " " + bar

    val str = "hello" // implicit val str = "hello" // error. quiz1
    //    implicit val str2 = "world"

    println(foo(str)) // 이게 명시적인 것


    def foo1(implicit bar1: String): String = bar1 + " " + bar1

    println(foo1(str)) // 명시적처럼 쓸 수 있음
//    println(foo1) // 암묵적으로 쓰고 싶습니다.

    // 1. local scope 에서 찾는다
    // 2. companion object에서 찾는다
    // 3. import 된 것 중에 찾는다
    // _. 컴파일 에러
    // 찾는 기준은 값이 아니라 type!

    // Quiz1. 만약에 str도 앞에 implicit있으면 어떻게 될까요? (컴파일러는 어떻게 동작할까용?)
    // ambigous implicit values 라고 하며 컴파일 레벨에서 에러를 뱉어냄.

    // ex) import cats.implicits._

    //
    // 1. 함수의 파라미터에 implicit
    // 함수의 인자 : def foo(implicit bar:String)

    // 2. 변수에 implicit
    //    implicit var a

    // 3. 함수
//    implicit def foo(a:String): Int

    // 4. class
//    implicit class foo(a:String)  {
//      def bar:String= a + " " + a
//    }


    // 3...
//   implicit def foo2(bar:Int): String =  bar.toString + " converted."
    // 함수에서 implicit : 암묵적인 타입 캐스팅 할 수 있다

//    val a : String = 123
//    println(a)


    case class Status(status:Int)
    implicit def foo2(bar:Int) : Status = Status(bar)
    implicit def foo3(bar:Int) : String = bar.toString

    val a1 : Status = 200
    val a2 : Status = foo2(200)
    val a3 : String = 300

    println(a1)
    println(a2)
    println(a3)

    // 4....
    // 문법적인 요소, 확장
    implicit class Foo(b: String) {
      def barbarbar = b + b + b
    }

    println(a3.barbarbar)
    // 몽키 패칭과 비슷. -->  but 안티패턴
    println(new Foo(a3).barbarbar)

    // 자바의 단점
    // interface를 바꿀 수 없다
    // 오래된 List -> 의 인터페이스가 아직도 그대로다

    implicit class Fooo(a : Int) {
      override def toString: String  = a + a + a
    }
    val a : Int = 1
    println(a.toString) // 이런건 안먹네.

  }


}
