package by.shumilin.example.controller;


import by.shumilin.example.entity.Comment;
import by.shumilin.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    CommentRepository commentRepository;


    @PostMapping("/comment")
    public String setComment(Comment comment) {
        commentRepository.save(comment);
        return "allnews";
    }

    @PostMapping("/delete{commentId}")
    public String deleteComment(@PathVariable Long commentId){
        commentRepository.deleteByCommentId(commentId);
        return "news";
    }
}
