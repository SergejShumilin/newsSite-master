package by.shumilin.example.controller;


import by.shumilin.example.entity.Comment;
import by.shumilin.example.entity.News;
import by.shumilin.example.repository.CommentRepository;
import by.shumilin.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {


    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public String setComment(@RequestParam String commentContent, @RequestParam long newsId) {

        Comment comment = new Comment(commentContent, new News(newsId));
        commentService.save(comment);

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteComment(@RequestParam Long commentId){
        commentService.deleteById(commentId);
        return "redirect:/";
    }
}
