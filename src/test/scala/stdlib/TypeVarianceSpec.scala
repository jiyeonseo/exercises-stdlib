package stdlib

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class TypeVarianceSpec extends Spec with Checkers {
  def `type variance` = {
    check(
      Test.testSuccess(
        TypeVariance.syntacticOverheadTypeVariance _,
        "Orange" :: HNil
      )
    )
  }

  def `explicit type declarations` = {
    check(
      Test.testSuccess(
        TypeVariance.typeVariableTypeVariance _,
        "Fruit" :: HNil
      )
    )
  }

  def `coercions` = {
    check(
      Test.testSuccess(
        TypeVariance.coerceObjectTypeVariance _,
        "Fruit" :: HNil
      )
    )
  }

  def `variance` = {
    check(
      Test.testSuccess(
        TypeVariance.polymorphismTypeVariance _,
        "Fruit" :: HNil
      )
    )
  }

  def `variance restrictions` = {
    check(
      Test.testSuccess(
        TypeVariance.covarianceInmutableTypeVariance _,
        "Orange" :: HNil
      )
    )
  }

  def `invariance` = {
    check(
      Test.testSuccess(
        TypeVariance.invarianceVarianceTypeVariance _,
        "Citrus" :: HNil
      )
    )
  }

}
