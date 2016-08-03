package com.distributedsolvers.constraints

import com.distributedsolvers.data.Assignment
import com.distributedsolvers.data.Variable

abstract class Constraint(variables: Array[Variable], penalty: Double = 1) {
  def satisfied(): Boolean
}

case class NotEqual(val variables: Array[Variable], penalty: Double = 1) extends Constraint(variables, penalty) {
  
  def satisfied(): Boolean = {
    return (variables.map(v => v.assignment).size == variables.size)       
  }
  
}