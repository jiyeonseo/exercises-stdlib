package puruni

import org.scalatest.{FunSuite, Matchers}

import scala.concurrent.{ExecutionContextExecutor, Future}

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

  /*
    implicit 위치 4가지 :
    - 함수의 파라미터
    - 변수의 앞에
    - class 앞에
    - 함수 앞에
   */

//  case class Bar(a: String)
//  case class Cheese(c: Int, b: Bar)
//
//  class Fooo(c: Cheese)(implicit bar:Bar) {
//    def barbar(): String = {
//      c.copy(b = bar).b.a
//    }
//  }
//
//  implicit class Fooo2(c: Cheese)(implicit bar:Bar) {
//    def barbar(): String = {
//      c.copy(b = bar).b.a
//    }
//  }
//
//  val cheese = Cheese(10, Bar("cheese"))


  test("실전") {
    // 1. 암묵적인 type casting
    // edina
    case class Suldina(edina:String)

    case class Edina(sul: String)

    implicit def eee(e:Edina) : Suldina = Suldina(e.sul)

    val suldina : Suldina = Edina("isool")


    // 2. 기존에 있는 class에 문법 추가하기

    implicit class dd(a:Edina)  { // 클래스의 생성자의 타입이 중요!! 이걸 보고 implicit 을 결정
       def name():String = a.sul
    }
      //      def bar:String= a + " " + a
      //    }
    val e1 = Edina("막걸리")
    e1.name == "에디나"


    // 3. 암묵적인 변수를 특정 클래스에 주입을 한다.
    import scala.concurrent.ExecutionContext.Implicits.global
//    implicit val ec = scala.concurrent.ExecutionContext.Implicits.global
//    val re: Future[ExecutionContextExecutor] = Future[Int](
//      println(10);
//      Thread.sleep(1000);
//      val ee = 1+1;
//    )(ec)
//    val a = Future[Int](2)(ec)
    val list = List[Int](2)
    val future = Future[Int](2) // same with a.. apply에 들어가보면 두번쨰 인자에 implicit으로 ExecutionContext가 들어가 있음
    // 만약 위에 implicit val ec 저걸 선언 안해주게 되면 import를 해줄수도 있다
    val set = Set[Int](2)

//    val fff = ???
//    val rr = Future(fff)


  }




}
