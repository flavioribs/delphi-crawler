// Copyright (C) 2018 The Delphi Team.
// See the LICENCE file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package de.upb.cs.swt.delphi.crawler

import java.net.URI

import akka.stream.ThrottleMode
import com.sksamuel.elastic4s.ElasticsearchClientUri

import scala.concurrent.duration._

class Configuration  {
  val elasticsearchClientUri: ElasticsearchClientUri = ElasticsearchClientUri(sys.env.getOrElse("DELPHI_ELASTIC_URI","elasticsearch://localhost:9200"))
  val mavenRepoBase: URI = new URI("http://repo1.maven.org/maven2/") // TODO: Create a local demo server "http://localhost:8881/maven2/"
  val controlServerPort : Int = 8882
  val limit : Int = 50
  val throttle : Throttle = Throttle(5, 30 second, 5, ThrottleMode.shaping)

  case class Throttle(element : Int, per : FiniteDuration, maxBurst : Int, mode : ThrottleMode)
}

