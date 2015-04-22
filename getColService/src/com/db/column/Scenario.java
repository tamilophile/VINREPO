package com.db.column;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "scenario")
public class Scenario implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @XmlAttribute(name = "id")
  String id;
  @XmlAttribute(name = "tagIdCol")
  String tagIdCol;
  @XmlAttribute(name = "scenarioName")
  String scenarioName;
  @XmlAttribute(name = "queryId")
  String queryId;
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
  public String getTagIdCol()
  {
    return tagIdCol;
  }
  public void setTagIdCol(String tagIdCol)
  {
    this.tagIdCol = tagIdCol;
  }
  public String getScenarioName()
  {
    return scenarioName;
  }
  public void setScenarioName(String scenarioName)
  {
    this.scenarioName = scenarioName;
  }
  public String getQueryId()
  {
    return queryId;
  }
  public void setQueryId(String queryId)
  {
    this.queryId = queryId;
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
