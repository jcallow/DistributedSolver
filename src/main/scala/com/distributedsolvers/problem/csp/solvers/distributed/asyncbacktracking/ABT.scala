package com.distributedsolvers.problem.csp.solvers.distributed.asyncbacktracking

import com.distributedsolvers.data.Problem
import akka.actor.Actor
import com.distributedsolvers.problem.csp.strategy.backtrack.Backtracker
import com.distributedsolvers.problem.csp.solvers.distributed.asyncbacktracking.Messages._
import com.distributedsolvers.data.Conflict
import com.distributedsolvers.data.NoConflict
import com.distributedsolvers.data.AgentRef
import scala.collection.mutable.{ Map => MutableMap }
import akka.actor.ActorRef
import com.distributedsolvers.data.CurrentPartialAssignment
import com.distributedsolvers.data.domain.Unknown

class ABT(solver: Backtracker, agentMap: Array[Int], index: Int) extends Actor {

  val myRef: AgentRef = AgentRef(index, solver.assignable.map(v => v.index), this.context.self)
  
  val lowerAgent: MutableMap[Int, AgentRef] = null
  
  val higherAgents: MutableMap[Int, AgentRef] = null
  
  
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
    solver.updateView(ok.cpa)
    checkAgentView
  }
  
  def checkAgentView() {
    if (!solver.consistent) {
      val conflict = solver.solve(null)
    
      conflict match {
        case Conflict(conflicts, variable) => {
          backTrack(Conflict(conflicts, variable))
        }
      
        case NoConflict => {
          val ok = Ok(solver.getCPA, myRef.ref)
          
          higherAgents.values.foreach(a => {
            a.ref ! ok
          })
        }
      }
    } 
  }
  
  def resolveConflict(noGood: NoGood) {
//    if (solver.coherant(noGood.noGood, solver.currentView)) {
//      checkAddLink(noGood)
//      solver.addNoGood(noGood.noGood)
//      checkAgentView
//    } else if (solver.coherant(noGood.noGood, solver.assignable.map(v => v.index).toSet)) {
//      noGood.sender ! Ok(solver.getCPA, myRef.ref)
//    }
  }
  
  def backTrack(noGood: Conflict) {
   
    if (noGood.conflicts.assignments.isEmpty) {
      stop
    } else {
      val sendTo = agentMap(noGood.variable.index)
      send(sendTo, NoGood(noGood, myRef.ref))
      solver.updateView(noGood.variable.index, Unknown)
      checkAgentView
    }
    
    
  }
  
  def setLink(request: RequestLink) = {
    val ref = request.agent
    higherAgents.put(ref.index, ref)
    ref.ref ! Ok(solver.getCPA, myRef.ref)
  }
  
  def checkAddLink(noGood: NoGood) = {
//    noGood.noGood.conflicts.assignments.foreach(v => {
//      if (lowerAgent.
//    }
  }

  def send(index: Int, message: Any) {
    // get ref at index, send it message
  }
  
  def stop() {
    // no solution, stop
  }
}
