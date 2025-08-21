package br.com.fiap.beans;

import java.time.LocalDateTime;

public class Post {

    private int id;
    private String author;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private String title;
    private String postContent;
    private String keyWord;

    public Post() {
        super();
    }

    public Post(int id, String author, LocalDateTime creationDate, LocalDateTime updateDate, String title, String postContent, String keyWord) {
        super();

        this.id = id;
        this.author = author;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.title = title;
        this.postContent = postContent;
        this.keyWord = keyWord;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", title='" + title + '\'' +
                ", postContent='" + postContent + '\'' +
                ", keyWord='" + keyWord + '\'' +
                '}';
    }

}
