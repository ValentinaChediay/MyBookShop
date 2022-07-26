package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public BookService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Book> getBooksData() {
    List<Book> books = jdbcTemplate.query("SELECT BOOKS.id, firstAndLastName AS author, title, priceOld, price FROM BOOKS INNER JOIN AUTHORS ON BOOKS.author = AUTHORS.id", (ResultSet rs, int rowNum) -> {
      Book book = new Book();
      book.setId(rs.getInt("id"));
      book.setAuthor(rs.getString("author"));
      book.setTitle(rs.getString("title"));
      book.setPriceOld(rs.getString("priceOld"));
      book.setPrice(rs.getString("price"));
      return book;
    });
    return new ArrayList<>(books);
  }

  public List<Author> getAuthorsData() {
    List<Author> authors = jdbcTemplate.query("SELECT * FROM authors ORDER BY firstAndLastName", (ResultSet rs, int rowNum) -> {
      Author author = new Author();
      author.setId(rs.getInt("id"));
      author.setFirstAndLastName(rs.getString("firstAndLastName"));
      return author;
    });
    return new ArrayList<>(authors);
  }
}
