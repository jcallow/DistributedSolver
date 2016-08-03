package com.distributedsolvers.problem.csp.strategy.backtrack

import org.scalatest._
import com.distributedsolvers.data._
import com.distributedsolvers.data.domain._
import com.distributedsolvers.constraints.NotEqual
import com.distributedsolvers.constraints.Constraint


class BasicBackTrackerTest extends FlatSpec {
  
  val problem = getSampleProblem()
  val backtracker = new BackTracker(problem)
  
  "Update View" should "Change the values of the different views" in {
    val variables = new Array[Variable](3)
    
    for (i <- 0 until 3) {
      val domain = Set[DomainValue](IntegerValue(0), IntegerValue(1))
      val variable = new Variable(i, domain, IntegerValue(1))
      variables(i) = variable
    }
    
    backtracker.updateView(CurrentPartialAssignment(variables))
    
    backtracker.view.foreach(v => {
      assert(v.assignment == IntegerValue(1))
    })
    
  }
  
  def getSampleProblem(): Problem = {
    
    val variables = new Array[Variable](3)
    
    for (i <- 0 until 3) {
      val domain = Set[DomainValue](IntegerValue(0), IntegerValue(1))
      val variable = new Variable(i, domain, Unknown)
      variables(i) = variable
    }
    
    
    val constraints = Set[Constraint](NotEqual(variables))
    
    val network = Network(variables, constraints)
    
    val problem = FullProblem(network)
    
    return problem
    
  }
}