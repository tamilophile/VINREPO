package com.db.column;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/service")
public class JSONService
{
  @GET
  @Path("/get")
  @Produces("application/json")
  public Response getColumnInJSON()
  {
    List<Column> cols = new ArrayList<Column>();
    DBLookup db = new DBLookup();
    try
    {
      cols.addAll(db.getTableDesc("stock"));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return Response.status(200).entity(cols).build();
  }
  @GET
  @Path("/getScenario")
  @Produces("application/json")
  public Response getScenario()
  {
    List<Scenario> scrs = new ArrayList<Scenario>();
    DBLookup db = new DBLookup();
    try
    {
      scrs.addAll(db.getScenario("1"));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return Response.status(200).entity(scrs).build();
  }
  
  @GET
  @Path("/getQuery")
  @Produces("application/json")
  public Response getQurery()
  {
    List<Query> qry = new ArrayList<Query>();
    DBLookup db = new DBLookup();
    try
    {
      qry.addAll(db.getQuery("1"));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return Response.status(200).entity(qry).build();
  }
}