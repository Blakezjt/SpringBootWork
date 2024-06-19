package com.fdzc.javaeeserver.service.impl;

import com.fdzc.javaeeserver.entity.Forum;

import java.util.List;

public interface ForumService {
    List<Forum> getAllPosts();

    boolean createPost(Integer studentId, String topic, String content);

    boolean replyToPost(Integer studentId, Integer replyToPostId, String content);
}
