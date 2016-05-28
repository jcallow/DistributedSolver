package com.distributedsolvers.data

import com.distributedsolvers.data.domain.DomainValue

case class Variable(val index: Int, var domain: Set[DomainValue])