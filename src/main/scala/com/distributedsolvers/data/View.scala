package com.distributedsolvers.data

import com.distributedsolvers.data.domain.DomainValue
import com.distributedsolvers.data.domain.Unknown

/**
  * Created by john on 8/20/16.
  */
case class View(problemSize: Int) {
  val assignments = Array.fill[DomainValue](problemSize)(Unknown)

  def update(variable: Variable): Unit = {
    update(variable.index, variable.assignment)
  }

  def update(index: Int, domainValue: DomainValue): Unit = {
    assignments(index) = domainValue
  }

  def update(cpa: CurrentPartialAssignment): Unit = {
    cpa.assignments.foreach(f => update(f))
  }

  def apply(index: Int): Variable = {
    Variable(index, assignments(index))
  }
}
