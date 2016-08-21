package com.distributedsolvers.problem.csp.strategy.backtrack

import com.distributedsolvers.constraints.{Constraint, Satisfied}
import com.distributedsolvers.data.{Variable, View}
import com.distributedsolvers.data.domain.{DomainValue, IntegerValue}
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

/**
  * Created by john on 8/21/16.
  */
class GeneratorTest extends FlatSpec with MockFactory {

  "CheckConstraints" should "return true if constraints are satisfied" in {
    val view = new View(4)

    val var1 = Variable(0, IntegerValue(0))
    val var2 = Variable(0, IntegerValue(0))

    val variables = Array[Variable](var1, var2)

    val constraint1 = stub[Constraint]
    val constraint2 = stub[Constraint]

    (constraint1.check _) when view returns Satisfied
    (constraint2.check _) when view returns Satisfied

    val generator = new Generator(0, Set[DomainValue](IntegerValue(0), IntegerValue(1)), Set[Constraint](constraint1, constraint2))

    assert(generator.checkConstraints(view) == true)
  }

}
