package br.com.fiap.model;

import br.com.fiap.beans.Post;

import java.time.LocalDateTime;

public class PublicPost {

    private int id;
    private String author;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private String title;
    private String postContent;


    public PublicPost() {
        super();
    }

    public PublicPost(Post post) {
        super();

        this.id = post.getId();
        this.author = post.getAuthor();
        this.creationDate = post.getCreationDate();
        this.updateDate = post.getUpdateDate();
        this.title = post.getTitle();
        this.postContent = post.getPostContent();
    }

    public PublicPost(int id, String author, LocalDateTime creationDate, LocalDateTime updateDate, String title, String postContent) {
        super();

        this.id = id;
        this.author = author;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.title = title;
        this.postContent = postContent;
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

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", title='" + title + '\'' +
                ", postContent='" + postContent + '\'' +
                '}';
    }

}
