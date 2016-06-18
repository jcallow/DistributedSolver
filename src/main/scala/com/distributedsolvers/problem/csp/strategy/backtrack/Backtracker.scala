package com.distributedsolvers.problem.csp.strategy.backtrack

import com.distributedsolvers.data.ConflictSet
import com.distributedsolvers.data.CurrentPartialAssignment
import com.distributedsolvers.data.Problem

trait Backtracker {
  
  def solve(cpa: CurrentPartialAssignment): ConflictSet
 
  def coherant(cpa: CurrentPartialAssignment): Boolean
  
  def addNoGood()
}