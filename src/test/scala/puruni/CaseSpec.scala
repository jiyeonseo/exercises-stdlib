package puruni

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by jiyeon on 2016. 8. 29..
  */
class CaseSpec extends FunSuite with Matchers{
  test("case") {
    // 클래스 종류 중 하나

    val aOption = Option(1)

    val aValue = aOption match {
      case Some(value) => value
      case None => "none"
      case _ => 0
    }

    println(aValue);
  }

  test("왜 어디에 쓰이나") {

    case class Foo(a: Int, b: Boolean)

    val foo = Foo(1, false)
    print(foo.a)
    // 1. @Data 와 비슷 . setter 자동생성
    // 2. new를 따로 안써줌
    // 3. 값 비교 가능

    val foo1 = Foo(1, false)
    val foo2 = Foo(2, false)

    assert(foo == foo1)
    assert(foo != foo2)
    //DTO , value

    // 상속
    // 상속이 된다 안된다? >> 안된다!
    // class extends case class (O)
    // case class extends case class (O)

//    case class Bar(c:Int) extends Foo(1,false)
//    val bar1 = Bar(1)
//    print(bar1)

    // case class는 불변

    val foo3: Foo = foo.copy(a = 10)
    println(foo)
    println(foo3)

    // val, var

    var f = foo
    f = foo1
//    f.a = 10 // nono해

    // case object
    // companion object

    case class Bar(a:Int, b:Int) {
      def sum() = a+b
    }

    val bar = Bar(10,20)
    println(bar.sum())


    class Bar1(val a:Int, b:Int){ // 기본 private , 밖에서도 보려면 val로(getter 생성)
      def sum() = a+b
    }

    // class와의 차이점
    // 1. new를 써준다
    // 2. 인자 기본이 private 이다
    val bar1 = new Bar1(10,20)
    println(bar1.a)
    println(bar1) // 주소값

    var bar2 = new Bar1(10,20)
    assert(bar1 != bar2) // 주소값이 다르기때문에 같지 않다

    val c = '\u0061' //unicode for a
    val d = '\141' //octal for a
    val e = '\"'
    val ff = '\\'


    println("%c".format(c))
    println("%c".format(d))
    println("%c".format(e))
    println("%c".format(ff))
  }

}
