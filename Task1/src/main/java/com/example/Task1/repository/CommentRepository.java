package com.example.Task1.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Task1.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{

}
