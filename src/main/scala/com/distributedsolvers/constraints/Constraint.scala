package com.distributedsolvers.constraints

import com.distributedsolvers.data.Assignment

abstract class Constraint(val variables: Array[Int], val penalty: Double) {
  def check(pa: Map[Int, Assignment]): Boolean
}