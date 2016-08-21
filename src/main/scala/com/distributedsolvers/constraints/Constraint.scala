package com.distributedsolvers.constraints

import com.distributedsolvers.data._

sealed trait ConstraintCheck

case object Satisfied extends ConstraintCheck

case class Unsatisfied(noGood: NoGood) extends ConstraintCheck

trait Constraint {
  def variables: Array[Int]
  def check(view: View): ConstraintCheck
}

/*
case class NotEqual(val variables: Array[Variable], penalty: Double = 1) extends Constraint(variables, penalty) {
  
  def check(): ConflictSet = {
    (variables.map(v => v.assignment).size == variables.size)
    return NoConflict(1)
  }
  
}*/
