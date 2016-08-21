package com.distributedsolvers.data

import com.distributedsolvers.data.domain.DomainValue

case class Variable(val index: Int, var assignment: DomainValue) {
  override def equals(that: Any): Boolean = that match {
    case that: Variable => (this.index == that.index) && this.assignment == that.assignment
    case _ => false;
  }
}