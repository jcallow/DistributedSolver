package com.distributedsolvers.data

trait ConflictSet {
  
}

case class Conflict(conflicts: CurrentPartialAssignment, variable: Variable) extends ConflictSet

case object NoConflict extends ConflictSet