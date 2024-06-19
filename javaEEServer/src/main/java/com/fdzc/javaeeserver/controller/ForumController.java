package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.Forum;
import com.fdzc.javaeeserver.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumService forumService;

    // 查询所有校园论坛
    @GetMapping("/getAllPosts")
    public R getAllPosts() {
        List<Forum> list = forumService.getAllPosts();
        return new R(200, "查询成功", list);
    }

    // 发布论坛
    @PostMapping("/createPost")
    public R createPost(@RequestParam Integer studentId, @RequestParam String topic, @RequestParam String content) {
        boolean success = forumService.createPost(studentId, topic, content);
        return success ? new R(200, "发帖成功",true) : new R(500, "发帖失败",false);
    }

    // 回复论坛
    @PostMapping("/replyToPost")
    public R replyToPost(@RequestParam Integer studentId, @RequestParam Integer replyToPostId, @RequestParam String content) {
        boolean success = forumService.replyToPost(studentId, replyToPostId, content);
        return success ? new R(200, "回复成功",true) : new R(500, "回复失败",false);
    }
}
