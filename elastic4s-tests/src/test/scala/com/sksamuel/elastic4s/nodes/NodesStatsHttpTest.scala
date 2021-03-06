package com.sksamuel.elastic4s.nodes

import com.sksamuel.elastic4s.testkit.DockerTests
import org.scalatest.{Matchers, WordSpec}

class NodesStatsHttpTest extends WordSpec with Matchers with DockerTests {

  "node stats request" should {
    "return os information" in {
      val stats = http.execute {
        nodeStats()
      }.await

      stats.right.get.result.clusterName should be("docker-cluster")
      stats.right.get.result.nodes.nonEmpty shouldBe true
    }
  }
}
