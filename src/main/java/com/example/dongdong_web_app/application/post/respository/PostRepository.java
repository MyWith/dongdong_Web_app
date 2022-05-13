package com.example.dongdong_web_app.application.post.respository;

import com.example.dongdong_web_app.application.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, String>, PostCustomRepository{
}
