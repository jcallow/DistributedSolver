package com.distributedsolvers.data.domain

trait DomainValue

abstract class NumericValue(value: Any) extends DomainValue

case class IntegerValue(value: Int) extends NumericValue {
  def canEqual(a: Any) = a.isInstanceOf[NumericValue]
  
  override def equals(that: Any): Boolean = that match {
    case that: IntegerValue => this.value == that.value
    case _ => false;
  }
  
  def +(that: NumericValue): NumericValue = that match {
    case that: IntegerValue => IntegerValue(this.value + that.value)
  }
  
  def *(that: NumericValue): NumericValue = that match {
    case that: IntegerValue => IntegerValue(this.value * that.value)
  }
}