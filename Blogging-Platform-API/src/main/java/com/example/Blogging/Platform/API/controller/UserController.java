package com.example.Blogging.Platform.API.controller;

import com.example.Blogging.Platform.API.model.Comment;
import com.example.Blogging.Platform.API.model.Post;
import com.example.Blogging.Platform.API.model.User;
import com.example.Blogging.Platform.API.model.dto.SignInInput;
import com.example.Blogging.Platform.API.model.dto.SignUpOutput;
import com.example.Blogging.Platform.API.service.AuthenticationService;
import com.example.Blogging.Platform.API.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;


    // Sign In, Sing Out, Sign Up
    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String signOutUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.signOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
    }

    }

    //Blog Content

    @PostMapping("post")
    public String createPost(@RequestBody Post post, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.createPost(post,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @PutMapping("post")
    public String updatePost(@RequestParam Integer postId, @RequestParam String email, @RequestParam String token,@RequestParam String postContent)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.updatePost(postId,email,postContent);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @DeleteMapping("post")
    public String removePost(@RequestParam Integer postId, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.removePost(postId,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }



    @PostMapping("comment")
    public String addComment(@RequestBody Comment comment, @RequestParam String commenterEmail, @RequestParam String commenterToken)
    {
        if(authenticationService.authenticate(commenterEmail,commenterToken)) {
            return userService.addComment(comment,commenterEmail);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }


    @DeleteMapping("comment")
    public String removeComment(@RequestParam Integer commentId, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.removeComment(commentId,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @GetMapping("posts")
    public List<Post> getAllPost(){
        return userService.getAllPost();
    }









}

