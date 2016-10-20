package puruni

/**
  * Created by jiyeon on 2016. 10. 20..
  */
class GenericProgrammingSpec {
  case class Employee(name: String, number: Int, manager: Boolean)
  case class IceCream(name: String, numCherries : Int, inCone: Boolean)

  def employeeCSV(e : Employee) : List[String] = {
    List(e.name, e.number.toString, if(e.manager) "yes" else "no")
  }

  def iceCreamCSV(c : Employee) : List[String] = {
    List(c.name, c.number.toString, if(c.manager) "yes" else "no")
  }

  import shapeless._

  val genericEmployee = Generic[Employee].to(Employee("cheese", 123, false))
  // genericEmployee: shapeless.::[String,shapeless.::[Int,shapeless.::[
//  Boolean,shapeless.HNil]]] = Dave :: 123 :: false :: HNil
  val genericIceCream = Generic[IceCream].to(IceCream("sundae", 1, false))
  // genericIceCream: shapeless.::[String,shapeless.::[Int,shapeless.::[
//  Boolean,shapeless.HNil]]] = Sundae :: 1 :: false :: HNil

  // List[Int] 이렇게 하나의 타입만 넣을 수 잇엇는데 이건 다양한 걸 넣을 수 있다
  // heterogeneous
  // HList : 기존 List와 똑같이 쓰면 되는데 맨 마지막이 Nil이 아닌 HNil로 하면 됨
  def genericCsv(gen: String :: Int :: Boolean :: HNil): List[String]
    = List(gen(0), gen(1).toString, if(gen(2))"true" else "false")
  // genericCsv: (gen: shapeless.::[String,shapeless.::[Int,shapeless.::[Boolean,shapeless.HNil]]])List[String]
  // intellij 빨간 불은 무시해
  genericCsv(genericEmployee)

  // 상위 개념 : product
  // 하위 개녕 : coproduct

  type cheese1 = Either[Int, String] // either -- coproducts
  type cheese2 = (Int, String) // tuple -- products

  val c1 : cheese1 = Left(1) // 왼쪽
  val c2 : cheese1 = Right("abc") // 오른쪽





}





