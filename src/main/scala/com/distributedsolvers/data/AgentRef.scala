package com.distributedsolvers.data

import akka.actor.ActorRef

case class AgentRef(index: Int, variables: Array[Int], ref: ActorRef)