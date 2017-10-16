package com.example.noxusfrosted.lazyinstagram.model;

import com.example.noxusfrosted.lazyinstagram.model.PostModel;

import java.util.List;

/**
 * Created by Noxusfrosted on 10/10/2017.
 */


public class UserProfile {
    private int following;
    private boolean isFollow;
    private int post;
    private String urlProfile;
    private String user;
    private String bio;
    private int follower;
    private List<PostModel> posts;

    //Setter & Getter

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getUrlProfile() {
        return urlProfile;
    }

    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public List<PostModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostModel> posts) {
        this.posts = posts;
    }
}



