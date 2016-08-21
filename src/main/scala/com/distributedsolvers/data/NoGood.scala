package com.distributedsolvers.data

/**
  * Created by john on 8/20/16.
  */
case class NoGood(conflicts: Set[Variable], variable: Variable) {

  val conflictMap = conflicts.map(v => v.index -> v.assignment).toMap

  def consistent(cpa: CurrentPartialAssignment): Boolean = {

    cpa.assignments.forall(v => consistent(v))

  }

  def consistent(variable: Variable): Boolean =  {
    conflictMap.get(variable.index) match {
      case Some(d) => d == variable.assignment
      case None => true
    }
  }

}
