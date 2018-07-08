package com.example.mana.worldcup18.data.database.offline_news;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Offline {
  @PrimaryKey(autoGenerate = true)
  private int id;
  private String author, description, urlToNews, urlToImage, publishedAt, url;

  public Offline(String author, String description, String urlToNews, String urlToImage,
      String publishedAt, String url) {
    this.author = author;
    this.description = description;
    this.urlToNews = urlToNews;
    this.urlToImage = urlToImage;
    this.publishedAt = publishedAt;
    this.url = url;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUrlToNews() {
    return urlToNews;
  }

  public void setUrlToNews(String urlToNews) {
    this.urlToNews = urlToNews;
  }

  public String getUrlToImage() {
    return urlToImage;
  }

  public void setUrlToImage(String urlToImage) {
    this.urlToImage = urlToImage;
  }

  public String getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(String publishedAt) {
    this.publishedAt = publishedAt;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
