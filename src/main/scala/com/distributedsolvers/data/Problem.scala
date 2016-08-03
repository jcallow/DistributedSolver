package com.distributedsolvers.data

abstract class Problem() {
  def network:Network
  def assignList: Array[Int]
}

case class FullProblem(network: Network) extends Problem {
  val assignList = network.variables.map(v => v.index)
}

case class PartialProblem(network: Network, assignList: Array[Int]) extends Problem