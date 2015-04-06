package com.db.column;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/column")
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
}