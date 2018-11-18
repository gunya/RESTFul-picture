package com.hepexta.comments.cfg;

import com.hepexta.comments.mapper.CommentMapper;
import com.hepexta.comments.mapper.MockCommentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentConfig {

    @Bean
    CommentMapper commentMapper(){
        return new MockCommentMapper();
    }
}
