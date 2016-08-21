package com.distributedsolvers.data

import com.distributedsolvers.data.domain.IntegerValue
import org.scalatest.FlatSpec

/**
  * Created by john on 8/20/16.
  */
class NoGoodStoreTest extends FlatSpec {

  "++" should "Add a nogood to the store" in {

    val noGoodStore = new NoGoodStore(0)

    val noGood = NoGood(Set[Variable](), Variable(1, IntegerValue(1)))

    noGoodStore ++ noGood

    assert(noGoodStore.store.contains(noGood))

  }

  "solve" should "return a ConflictSet" in {
    val var1 = Variable(0, IntegerValue(0))
    val var2 = Variable(1, IntegerValue(1))
    val var3 = Variable(2, IntegerValue(2))
    val var4 = Variable(3, IntegerValue(3))


    val noGoodStore = new NoGoodStore(0)
    val noGood = NoGood(Set[Variable](var3, var4), var1)
    val noGood2 = NoGood(Set[Variable](var2), var1)

    noGoodStore ++ noGood ++ noGood2

    val conflictSet = noGoodStore.solve()

    assert(conflictSet.conflicts.contains(var2))
    assert(conflictSet.conflicts.contains(var3))
    assert(conflictSet.conflicts.contains(var4))
    assert(!conflictSet.conflicts.contains(var1))


  }

  "resolve" should "remove inconsitent noGoods and return an invalid Domain Set" in {
    val var2 = Variable(1, IntegerValue(1))
    var var3 = Variable(2, IntegerValue(2))
    val var4 = Variable(3, IntegerValue(3))


    val noGoodStore = new NoGoodStore(0)
    val noGood = NoGood(Set[Variable](var3, var4), Variable(0, IntegerValue(1)))
    val noGood2 = NoGood(Set[Variable](var2), Variable(0, IntegerValue(2)))

    noGoodStore ++ noGood ++ noGood2

    var3 = Variable(2, IntegerValue(-1))

    val invalidDomain = noGoodStore.resolve(CurrentPartialAssignment(Array[Variable](var3)))

    assert(invalidDomain.contains(IntegerValue(2)))
    assert(!invalidDomain.contains(IntegerValue(1)))

    assert(noGoodStore.store.contains(noGood2))
    assert(!noGoodStore.store.contains(noGood))
  }

}
