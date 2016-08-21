package com.distributedsolvers.data

import com.distributedsolvers.data.domain.DomainValue

/**
  * Created by john on 8/20/16.
  */
class NoGoodStore(index: Int) {

  var store = List[NoGood]()

  def resolve(cpa: CurrentPartialAssignment): Set[DomainValue] = {
    store = store.filter(noGood => noGood.consistent(cpa))
    return store.foldLeft[Set[DomainValue]](Set[DomainValue]())((invalids, noGood) => invalids + noGood.variable.assignment)
  }

  def solve(): ConflictSet = {
    val conflicts = store.foldLeft[ConflictSet](NoConflict(index))((cset, noGood) => cset ++ noGood)
    conflicts
  }

  def ++(noGood: NoGood): NoGoodStore = {
    store = store :+ noGood
    this
  }
}
