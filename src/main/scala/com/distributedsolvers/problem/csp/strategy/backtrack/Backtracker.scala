package com.distributedsolvers.problem.csp.strategy.backtrack

import com.distributedsolvers.constraints.Constraint
import com.distributedsolvers.data.ConflictSet
import com.distributedsolvers.data.CurrentPartialAssignment
import com.distributedsolvers.data.Problem
import com.distributedsolvers.data.Variable
import com.distributedsolvers.data.Conflict
import com.distributedsolvers.data.domain.DomainValue

import scala.collection.mutable.{Map => MutableMap}

class Backtracker(problem: Problem) {
  
 /* def view:Array[Variable] = problem.network.variables
  def assignable: Array[Variable] = problem.network.variables.filter(p => problem.assignList.contains(p.index))
  def generators: Map[Int, Generator] = null
  def currentView: Set[Variable] = assignable.toSet
  
  
  def solve(cpa: CurrentPartialAssignment): ConflictSet = {

  }
  
  def consistent(): Boolean = {
    false
  }
 
  def coherant(noGood: Conflict, variables: Set[Int]): Boolean = {
    noGood.conflicts.assignments.foreach( v => {
      if (variables.contains(v.index)) {
        if (v.assignment != view(v.index).assignment) return false
      }
    })
    return true
  }
  
  def addNoGood(noGood: Conflict) {
    generators.get(noGood.variable.index).get.addNoGood(noGood)
  }
  
  def getCPA(): CurrentPartialAssignment = {
    CurrentPartialAssignment(assignable)
  }
  
  def updateView(cpa: CurrentPartialAssignment) {
    cpa.assignments.foreach(v => {
      updateView(v.index, v.assignment)
    })
  }
  
  def updateView(index: Int, value: DomainValue) {
    view(index).assignment = value
  }*/
}