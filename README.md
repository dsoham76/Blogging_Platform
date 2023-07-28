# Blogging Platform API

## Framework and Language

> Framework: SpringBoot Language: Java 17

## Data flow

1.  Controller

        1.1  User Controller
                - @PostMapping("user/signup"): To sign up a user
                - @PostMapping("user/signIn"): To sign in a user
                - @DeleteMapping("user/signOut"): To sign out a user
                - @PostMapping("post"): To upload a post
                - @PutMapping("post"): To update a post
                - @DeleteMapping("post"):To delete a post
                - @PostMapping("comment"): To add a comment
                - @DeleteMapping("comment"): To delete a comment
                - @GetMapping("posts"): To get all the post

2.  Services

        2.1 UserService
                - signUpUser(User user)
                - signInUser(SignInInput signInInput)
                - sigOutUser(String email)
                - createPost(Post post, String email): To upload a post
                - removePost(Integer postId,String email): To delete a post
                - addComment(Comment comment,String commenterEmail): To add a comment
                - removeComment(Integer commentId, String email): To delete a comment
                - updatePost(Integer postId, String email, String postContent):To update an existing post
                - getAllPost(): To get all the post

        2.2 Post Service
                - createPost(Post post): To upload a post
                - updatePost(Integer postId, User user, String postContent): To update a post
                - getAllPost(): To get all post
                - getPostById(Integer id): To get a post by PostId
                - removePost(Integer postId, User user): To delete a post


        2.3 Authentication Service
                - authenticate(String email, String authTokenValue): To authenticate user email and AuthToken Value
                - saveAuthToken(AuthenticationToken authToken): To save a authToken
                - findFirstByUser(User user): To find a user
                - removeToken(AuthenticationToken token): To delete a authToken

        2.4 Comment Service
                - addComment(Comment comment): To add a commnet
                - findComment(Integer commentId): To find a commnent by Id
                - removeComment(Comment comment): To delete a commnet

3.  Repository

        3.1 IUserRepo
                - User findFirstByUserEmail(String newEmail): To find a user by userEmail
        3.2 IAutenticationRepo
                - findFirstByTokenValue(String authTokenValue): To find a user by AuthToken
                - findFirstByUser(User user): To find a user
        3.3 IPostRepo
        3.4 ICommentRepo

4.  Database Design

        4.1 User Model:
                - Integer userId
                - String userName
                - String userEmail
                - String userPassword
        4.2 Post Model:
                - Integer PostId
                - String postContent
                - LocalDateTime postCreatedTimeStamp
                - private User postOwner
                - User postOwner(ManyToOne Mapping)
        4.3 Authentication Model:
                - Long tokenId
                - String tokenValue
                - LocalDateTime tokenCreationDateTime
                - User user
        4.4 Comment Model
                - Integer commentId
                - String commentBody
                - LocalDateTime commentCreationTimeStamp
                - Post blogPost(ManyToOne Mapping)
                - User commenter(ManyToOne Mapping)

## Data Structure Used in Project

     JPARepository has been used as primay datastructure

## Project Summary

The Blogging Platform API is a powerful and versatile tool that enables developers to integrate comprehensive blogging functionality into their applications. It offers a range of features to manage blog posts effectively, including creation, updating, and deletion. The API also includes secure user authentication and a feature-rich commenting system to engage readers and foster community interaction.
