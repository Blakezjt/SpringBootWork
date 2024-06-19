package com.fdzc.javaeeserver.service.impl;

import com.fdzc.javaeeserver.entity.Forum;
import com.fdzc.javaeeserver.mapper.ForumMapper;
import com.fdzc.javaeeserver.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    private ForumMapper forumMapper;

    @Override
    public List<Forum> getAllPosts() {
        return forumMapper.selectList(null);
    }

    @Override
    public boolean createPost(Integer studentId, String topic, String content) {
        Forum post = new Forum();
        post.setStudentId(studentId);
        post.setTopic(topic);
//        post.setContent(content);
        post.setPostDate(LocalDateTime.now());

        int result = forumMapper.insert(post);
        return result > 0;
    }

    @Override
    public boolean replyToPost(Integer studentId, Integer replyToPostId, String content) {
        Forum post = new Forum();
        post.setStudentId(studentId);
        post.setTopic(null); // 回复帖没有主题
//        post.setContent(content);
        post.setPostDate(LocalDateTime.now());

        int result = forumMapper.insert(post);
        return result > 0;
    }
}
