package com.example.MyBookShopApp.data;

public class Author {

  private Integer id;
  private String firstAndLastName;

  @Override
  public String toString() {
    return "Author{" +
        "id=" + id +
        ", firstAndLastName='" + firstAndLastName + '\'' +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstAndLastName() {
    return firstAndLastName;
  }

  public void setFirstAndLastName(String firstAndLastName) {
    this.firstAndLastName = firstAndLastName;
  }
}
