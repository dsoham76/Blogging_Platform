package com.example.Blogging.Platform.API.service;

import com.example.Blogging.Platform.API.model.Post;
import com.example.Blogging.Platform.API.model.User;
import com.example.Blogging.Platform.API.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    public String createPost(Post post) {
        post.setPostCreatedTimeStamp(LocalDateTime.now());
        postRepo.save(post);
        return "Post uploaded!!!!";
    }



    public String removePost(Integer postId, User user) {

        Post post  = postRepo.findById(postId).orElse(null);
        if(post != null && post.getPostOwner().equals(user))
        {
            postRepo.deleteById(postId);
            return "Removed successfully";
        }
        else if (post == null)
        {
            return "Post to be deleted does not exist";
        }
        else{
            return "Un-Authorized delete detected....Not allowed";
        }
    }

    public boolean validatePost(Post blogPost) {
        return (blogPost!=null && postRepo.existsById(blogPost.getPostId()));
    }


    public Post getPostById(Integer id) {
        return postRepo.findById(id).orElse(null);
    }


    public List<Post> getAllPost() {
        return postRepo.findAll();
    }

    public String updatePost(Integer postId, User user, String postContent) {
        Post post  = postRepo.findById(postId).orElse(null);
        if(post != null && post.getPostOwner().equals(user))
        {
            post.setPostContent(postContent);
            postRepo.save(post);
            return "Post has been updated successfully";
        }
        else if (post == null)
        {
            return "Post to be updated does not exists";
        }
        else{
            return "Un-Authorized updation detected";
        }
    }


}

