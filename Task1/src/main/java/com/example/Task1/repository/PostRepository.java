package com.example.Task1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Task1.model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Long>{

}
