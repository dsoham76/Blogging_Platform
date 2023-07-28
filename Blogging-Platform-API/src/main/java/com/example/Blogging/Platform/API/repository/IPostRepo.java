package com.example.Blogging.Platform.API.repository;

import com.example.Blogging.Platform.API.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepo extends JpaRepository<Post,Integer> {
}
