package com.ibm.couchdb.api

import com.ibm.couchdb.{Req, Res}
import com.ibm.couchdb.Res.ApiKeyOk
import com.ibm.couchdb.core.Client
import org.http4s.Status

import scalaz.concurrent.Task

class ApiKeys(client: Client) {

  private val api = "/_api/v2"

  def create: Task[Res.ApiKeyOk] = {
    client.post[String, Res.ApiKeyOk](s"${api}/api_keys", Status.Created, "")
  }

  def assign(db: String, permissions: Req.Permissions): Task[Res.Ok] = {
    client.put[Req.Permissions, Res.Ok](s"${api}/db/${db}/_security", Status.Ok, permissions)
  }
}