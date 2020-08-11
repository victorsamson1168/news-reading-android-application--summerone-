package com.example.summerone;

public class Details {
    private String author;
    private String title;
    private String publishedAt;
    private String content;
    private String imageUrl,link;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    public Details(String author,String title,String publishedAt,String content,String imageUrl,String link){
        this.setTitle(title);
        this.setPublishedAt(publishedAt);
        this.setContent(content);
        this.setAuthor(author);
        this.setImageUrl(imageUrl);
        this.setLink(link);



    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
