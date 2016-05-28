package com.distributedsolvers.data

import com.distributedsolvers.constraints.Constraint

case class network(variables: Array[Variable], constraints: Set[Constraint])