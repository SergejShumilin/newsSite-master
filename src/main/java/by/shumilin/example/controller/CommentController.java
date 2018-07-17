package by.shumilin.example.controller;

import by.shumilin.example.service.CommentSaveToDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    CommentSaveToDataBase commentSaveToDataBase;

    @PostMapping("/comment")
    public String setComment(@RequestParam String commentContent, @RequestParam Long newsId) {
        commentSaveToDataBase.save(commentContent, newsId);
        return "allnews";
    }
}
