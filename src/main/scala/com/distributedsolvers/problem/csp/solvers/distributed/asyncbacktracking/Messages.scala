package com.distributedsolvers.problem.csp.solvers.distributed.asyncbacktracking

import com.distributedsolvers.data.CurrentPartialAssignment
import com.distributedsolvers.data.ConflictSet
import com.distributedsolvers.data.AgentRef
import com.distributedsolvers.data.Conflict
import akka.actor.ActorRef

object Messages {
  
  case class Ok(cpa: CurrentPartialAssignment, sender: ActorRef) 
  
  case class NoGood(noGood: ConflictSet, sender: ActorRef)
    
  case class Stop()
  
  case class RequestLink(agent: AgentRef, sender: ActorRef)  
}