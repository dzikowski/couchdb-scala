/*
 * Copyright 2015 IBM Corporation, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.couchdb

object Req {

  case class Docs[D](docs: Seq[CouchDoc[D]])

  case class DocKeys[K](keys: Seq[K])

  case class ViewWithKeys[K](keys: Seq[K], view: CouchView)

  case class Permissions(cloudant: Map[String, Seq[String]])

  object Permissions {
    def singleUserReadWrite(user: String): Permissions = {
      Permissions(cloudant = Map(user -> Seq("_reader", "_writer"), "nobody" -> Nil))
    }
  }

}
