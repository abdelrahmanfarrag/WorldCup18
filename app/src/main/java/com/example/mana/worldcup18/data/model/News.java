package com.example.mana.worldcup18.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class News {

  @SerializedName("articles")
  private List<Article> articles;
  @SerializedName("status")
  private String status;

  public List<Article> getArticles() {
    return articles;
  }

  public String getStatus() {
    return status;
  }

  public class Article {

    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("source")
    @Expose
    private Sources sources;

    public void setAuthor(String author) {
      this.author = author;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public void setUrlToImage(String urlToImage) {
      this.urlToImage = urlToImage;
    }

    public void setSources(Sources sources) {
      this.sources = sources;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public void setPublishedAt(String publishedAt) {
      this.publishedAt = publishedAt;
    }

    public String getAuthor() {
      return author;
    }

    public String getTitle() {
      return title;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getUrl() {
      return url;
    }

    public Sources getSources() {
      return sources;
    }

    public String getUrlToImage() {
      return urlToImage;
    }

    public String getPublishedAt() {
      return publishedAt;
    }
  }

  public class Sources {
    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
      return name;
    }
  }
}

