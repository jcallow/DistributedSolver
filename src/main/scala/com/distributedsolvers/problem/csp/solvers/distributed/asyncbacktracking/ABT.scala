package com.distributedsolvers.problem.csp.solvers.distributed.asyncbacktracking

import com.distributedsolvers.data.Problem
import akka.actor.Actor
import com.distributedsolvers.problem.csp.strategy.backtrack.Backtracker
import com.distributedsolvers.problem.csp.solvers.distributed.asyncbacktracking.Messages._

class ABT(solver: Backtracker) extends Actor {
  
  def receive = {
    case message: Ok => processInfo(message)
    
    case message: NoGood => resolveConflict(message)
    
    case message: RequestLink => setLink(message)
    
    case message: Stop => stop

    case _ => {
      throw new Exception("I don't know what happened")
    }
  }
  
  def processInfo(ok: Ok) {
    val conflict = solver.solve(ok.cpa)
  }
  
  def resolveConflict(noGood: NoGood) {
    
  }
  
  def setLink(request: RequestLink) {
    
  }
  
  def stop() {
    
  }

