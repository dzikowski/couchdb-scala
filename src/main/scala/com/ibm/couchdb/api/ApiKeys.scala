package com.ibm.couchdb.api

import com.ibm.couchdb.Res
import com.ibm.couchdb.core.Client
import org.http4s.Status

import scalaz.concurrent.Task

class ApiKeys(client: Client) {

  def create: Task[Res.ApiKeyOk] = {
    client.post[String, Res.ApiKeyOk]("/_api/v2/api_keys", Status.Created, "")
  }
}