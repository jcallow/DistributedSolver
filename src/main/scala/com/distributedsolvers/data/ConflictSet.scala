package com.distributedsolvers.data


trait ConflictSet {
  val conflicts: Set[Variable]
  def index: Int

  def isEmpty: Boolean

  def +(v: Variable): ConflictSet

  def ++(c: ConflictSet): ConflictSet

  def ++(noGood: NoGood): ConflictSet

  def next: ConflictSet

}

case class Conflict(conflicts: Set[Variable], index: Int) extends ConflictSet {
  def isEmpty = conflicts.isEmpty

  def +(v: Variable): ConflictSet = {
    Conflict(conflicts + v, index)
  }

  def ++(c: ConflictSet): ConflictSet = {
    Conflict(conflicts ++ c.conflicts, index)
  }

  def ++(noGood: NoGood): ConflictSet = {
    Conflict(conflicts ++ noGood.conflicts, index)
  }

  def next: ConflictSet = {
    throw new Exception("Not implemented")
  }
}

case class NoConflict(index: Int) extends ConflictSet {
  val conflicts = Set[Variable]()
  def isEmpty = true

  def +(v: Variable): ConflictSet = {
    Conflict(Set[Variable](v), index)
  }

  def ++(c: ConflictSet): ConflictSet = {
    c
  }

  def ++(noGood: NoGood): ConflictSet = {
    Conflict(noGood.conflicts, index)
  }

  def next: ConflictSet = {
    throw new Exception("Not implemented")
  }
}

