package com.db.column;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBLookup
{
  public Connection con = null;
  /**
   * 
   * @return
   */
  public Connection getCon()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return con;
  }
  /**
   * 
   * @param tableName
   * @return
   * @throws SQLException
   */
  public List<Column> getTableDesc(String tableName) throws SQLException
  {
    List<Column> cols = new ArrayList<Column>();
    Statement stmt = getCon().createStatement();
    ResultSet rs = stmt.executeQuery("select * from " + tableName);
    ResultSetMetaData meta = rs.getMetaData();
    int i = meta.getColumnCount();
    while (i != 0)
    {
      Column col = new Column();
      col.setName(meta.getColumnName(i));
      col.setType(meta.getColumnTypeName(i));
      i--;
      System.out.println(col.getName() + "...." + col.getType());
      cols.add(col);
    }
    rs.close();
    return cols;
  }
  /**
   * 
   * @param id
   * @return
   * @throws SQLException
   */
  public List<Scenario> getScenario() throws SQLException
  {
    List<Scenario> scenarios = new ArrayList<Scenario>();
    Statement stmt = getCon().createStatement();
    ResultSet rs = stmt.executeQuery("select * from scenario");
    while (rs.next())
    {
      Scenario sc = new Scenario();
      sc.setId("" + rs.getInt(1));
      sc.setTagIdCol(rs.getString(2));
      sc.setScenarioName(rs.getString(3));
      sc.setQueryId(rs.getString(4));
      sc.setCreatedBy(rs.getString(5));
      sc.setCreatedOn(rs.getDate(6));
      sc.setAlteredBy(rs.getString(7));
      sc.setAlteredOn(rs.getDate(8));
      // System.out.println(sc.getTagIdCol() + "...." + sc.getScenarioName());
      scenarios.add(sc);
    }
    rs.close();
    return scenarios;
  }
  /**
   * 
   * @param id
   * @return
   * @throws SQLException
   */
  public List<Query> getQuery(String id) throws SQLException
  {
    List<Query> queries = new ArrayList<Query>();
    Statement stmt = getCon().createStatement();
    ResultSet rs = stmt.executeQuery("select * from queries where query_id=" + id);
    while (rs.next())
    {
      Query q = new Query();
      q.setId("" + rs.getInt(1));
      Blob blob = rs.getBlob(2);
      byte[] bdata = blob.getBytes(1, (int) blob.length());
      String blb = new String(bdata);
      q.setQuery(blb);
      q.setColsHighlight(rs.getString(3));
      q.setCreatedBy(rs.getString(4));
      q.setCreatedOn(rs.getDate(5));
      q.setAlteredBy(rs.getString(6));
      q.setAlteredOn(rs.getDate(7));
      System.out.println(q.getColsHighlight() + "..." + q.getQuery());
      queries.add(q);
    }
    rs.close();
    return queries;
  }
  /**
   * 
   */
  public void closeConnection()
  {
    try
    {
      con.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  /**
   * 
   * @param args
   */
  public static void main(String args[])
  {
    DBLookup db = new DBLookup();
    try
    {
      db.getTableDesc("stock");
      db.getQuery("1");
      db.getScenario();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
