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
