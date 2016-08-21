package com.distributedsolvers.problem.csp.strategy.backtrack

import com.distributedsolvers.constraints.{Constraint, Satisfied, Unsatisfied}
import com.distributedsolvers.data._
import com.distributedsolvers.data.domain.DomainValue

/**
  * Created by john on 8/6/16.
  */
/*trait Generator {

  def domain: Set[DomainValue]
  def currentDomain: Array[DomainValue]

  def constraints: Set[Constraint]

  def assignVariable: ConflictSet

  val noGoodStore: NoGoodStore

  def addNoGood(noGood: ConflictSet) {

  }
}*/

class Generator(index: Int, domain: Set[DomainValue], constraints: Set[Constraint]) {

  var currentDomainIndex = 0

  val noGoodStore: NoGoodStore = new NoGoodStore(index)

  var currentDomain = Array[DomainValue]()

  def assignVariable(view: View): ConflictSet = {

    if (currentDomain.isEmpty) {
      return noGoodStore.solve()
    }

    view.update(index, currentDomain(currentDomainIndex))

    while (!checkConstraints(view)) {
      currentDomainIndex += 1

      if (currentDomainIndex < currentDomain.size) {
        view.update(index, currentDomain(currentDomainIndex))
      } else {
        return noGoodStore.solve()
      }
    }

    NoConflict(index)
  }

  def checkConstraints(view: View): Boolean = {

    var satisfies = true

    for (constraint <- constraints) {
      constraint.check(view) match {
        case Satisfied => {}
        case Unsatisfied(noGood) => {
          noGoodStore ++ noGood
          satisfies = false
        }
      }
    }

    return satisfies
  }

  def resolve(cpa: CurrentPartialAssignment): Unit = {
    currentDomain = noGoodStore.resolve(cpa).toArray
    currentDomainIndex = 0
  }
}
