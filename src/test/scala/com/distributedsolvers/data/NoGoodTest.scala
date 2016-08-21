package com.distributedsolvers.data

import com.distributedsolvers.data.domain.IntegerValue
import org.scalatest.FlatSpec

/**
  * Created by john on 8/20/16.
  */
class NoGoodTest extends FlatSpec {


  "Consistent NoGood" should "return true" in {
    val var1 = Variable(0, IntegerValue(0))
    val var2 = Variable(1, IntegerValue(0))
    val var3 = Variable(2, IntegerValue(0))
    val var4 = Variable(3, IntegerValue(1))

    val conflict = Set[Variable](var1, var2)

    val noGood = NoGood(conflict, var3)

    val cpa = CurrentPartialAssignment(Array[Variable](var1, var2, var4))

    assert(noGood.consistent(cpa))

  }

  "Inconsistent NoGood" should "return false" in {
    val var1 = Variable(0, IntegerValue(0))
    val var2 = Variable(1, IntegerValue(0))
    val var3 = Variable(2, IntegerValue(0))

    val conflict = Set[Variable](var1, var2)

    val noGood = NoGood(conflict, var3)

    val var1_2 = Variable(0, IntegerValue(1))

    val cpa = CurrentPartialAssignment(Array[Variable](var1_2, var2))

    assert(!noGood.consistent(cpa))

  }


}
