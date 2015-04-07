package com.db.column;

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
  private Statement stmt = null;
  public ResultSet res = null;
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
    return cols;
  }
  /**
   * 
   * @param id
   * @return
   * @throws SQLException
   */
  public List<Scenario> getScenario(String id) throws SQLException
  {
    List<Scenario> scenarios = new ArrayList<Scenario>();
    Statement stmt = getCon().createStatement();
    ResultSet rs = stmt.executeQuery("select * from scenario where scenario_id=" + id);
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
      scenarios.add(sc);
    }
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
      q.setQuery(rs.getBlob(2));
      q.setColsHighlight(rs.getString(3));
      q.setCreatedBy(rs.getString(4));
      q.setCreatedOn(rs.getDate(5));
      q.setAlteredBy(rs.getString(6));
      q.setAlteredOn(rs.getDate(7));
      queries.add(q);
    }
    return queries;
  }
  /**
   * 
   */
  public void closeConnection()
  {
    try
    {
      if(res != null)
        res.close();
      stmt.close();
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
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
