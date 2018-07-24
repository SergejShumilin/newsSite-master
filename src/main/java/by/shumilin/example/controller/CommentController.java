package by.shumilin.example.controller;

import by.shumilin.example.service.CommentDeleteFromDataBase;
import by.shumilin.example.service.CommentSaveToDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    CommentSaveToDataBase commentSaveToDataBase;

    @Autowired
    CommentDeleteFromDataBase commentDeleteFromDataBase;

    @PostMapping("/comment")
    public String setComment(@RequestParam String commentContent, @RequestParam Long newsId) {
        commentSaveToDataBase.save(commentContent, newsId);
        return "allnews";
    }

    @PostMapping("/delete{commentId}")
    public String deleteComment(@PathVariable Long commentId){
        commentDeleteFromDataBase.delete(commentId);
        return "news";
    }
}
