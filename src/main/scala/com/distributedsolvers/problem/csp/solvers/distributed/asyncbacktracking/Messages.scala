package com.distributedsolvers.problem.csp.solvers.distributed.asyncbacktracking

import com.distributedsolvers.data.CurrentPartialAssignment

object Messages {
  
  case class Ok(cpa: CurrentPartialAssignment) 
  
  case class NoGood(noGood: NoGood)
    
  case class Stop()
  
  case class RequestLink(index: Int)  
}