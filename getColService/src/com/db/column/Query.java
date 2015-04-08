package com.db.column;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "query")
public class Query implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @XmlAttribute(name = "id")
  String id;
  @XmlAttribute(name = "query")
  String query;
  @XmlAttribute(name = "colsHighlight")
  String colsHighlight;
  @XmlAttribute(name = "createdBy")
  String createdBy;
  @XmlAttribute(name = "cretaedOn")
  Date createdOn;
  @XmlAttribute(name = "alteredBy")
  String alteredBy;
  @XmlAttribute(name = "alteredOn")
  Date alteredOn;
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public String getQuery()
  {
    return query;
  }
  public void setQuery(String blob)
  {
    this.query = blob;
  }
  public String getColsHighlight()
  {
    return colsHighlight;
  }
  public void setColsHighlight(String colsHighlight)
  {
    this.colsHighlight = colsHighlight;
  }
  public String getCreatedBy()
  {
    return createdBy;
  }
  public void setCreatedBy(String createdBy)
  {
    this.createdBy = createdBy;
  }
  public Date getCreatedOn()
  {
    return createdOn;
  }
  public void setCreatedOn(Date createdOn)
  {
    this.createdOn = createdOn;
  }
  public String getAlteredBy()
  {
    return alteredBy;
  }
  public void setAlteredBy(String alteredBy)
  {
    this.alteredBy = alteredBy;
  }
  public Date getAlteredOn()
  {
    return alteredOn;
  }
  public void setAlteredOn(Date alteredOn)
  {
    this.alteredOn = alteredOn;
  }
}
