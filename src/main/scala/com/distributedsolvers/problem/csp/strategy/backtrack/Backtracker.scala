package com.distributedsolvers.problem.csp.strategy.backtrack

import com.distributedsolvers.data.ConflictSet
import com.distributedsolvers.data.CurrentPartialAssignment
import com.distributedsolvers.data.Problem
import com.distributedsolvers.data.Variable
import com.distributedsolvers.data.Conflict
import com.distributedsolvers.data.domain.DomainValue

import scala.collection.mutable.{Map => MutableMap}

trait Generator {
  def noGoods:MutableMap[CurrentPartialAssignment, DomainValue]
  
  def addNoGood(noGood: Conflict) {
    noGoods.put(noGood.conflicts, noGood.variable.assignment)
  }
}

trait Backtracker {
  
  def view:Array[Variable]
  def assignable: Array[Variable]
  def generators: Map[Int, Generator]
  def currentView: Set[Int]
  
  
  def solve(): ConflictSet
  
  def consistent(): Boolean = {
    
  }
 
  def coherant(noGood: Conflict, variables: Set[Int]): Boolean = {
    noGood.conflicts.assignments.foreach( v => {
      if (variables.contains(v)) {
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
  }
}