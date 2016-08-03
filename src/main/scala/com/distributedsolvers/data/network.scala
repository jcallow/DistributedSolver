package com.distributedsolvers.data

import com.distributedsolvers.constraints.Constraint

case class Network(variables: Array[Variable], constraints: Set[Constraint])