package by.shumilin.example.controller;


import by.shumilin.example.entity.Comment;
import by.shumilin.example.entity.News;
import by.shumilin.example.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public String setComment(@RequestParam String commentContent, @RequestParam long newsId) {
        Comment comment = new Comment(commentContent, new News(newsId), new Date());
        commentService.save(comment);
        return "redirect:/news/" + newsId;
    }

    @PostMapping("/delete")
    public String deleteComment(@RequestParam Long commentId, @RequestParam long newsId){
        commentService.deleteById(commentId);
        return "redirect:/news/" + newsId;
    }
}
