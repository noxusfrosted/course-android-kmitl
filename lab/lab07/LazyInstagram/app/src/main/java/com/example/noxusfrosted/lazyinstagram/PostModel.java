package com.example.noxusfrosted.lazyinstagram;

/**
 * Created by Noxusfrosted on 10/10/2017.
 */

public class PostModel {
    private int comment;
    private int like;
    private String url;

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}