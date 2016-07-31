package puruni

import org.scalatest.{Matchers, FunSuite}

/**
 * Created by jiyeon on 16. 7. 29..
 */
class ClassSpec extends FunSuite with Matchers{
  test("class with val") { // 불변의 값 val = value, es6 의 const 와 비슷비
    class ClassWithVal(val name:String)
    val classWithVal = new ClassWithVal("cheese")
    // classWithVal.name = "cake"  // val 이니까 SET 노노 GET 예예
    classWithVal.name shouldBe "cheese"
  }

  test("class with var") { // mutable
  class ClassWithVal(var name:String) // 이제 고칠수 잇
    val classWithVal = new ClassWithVal("cheese")
    classWithVal.name = "cake"
    classWithVal.name shouldBe "cake"
  }

}
