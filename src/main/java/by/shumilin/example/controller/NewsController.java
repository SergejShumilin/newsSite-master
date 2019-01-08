package by.shumilin.example.controller;

import by.shumilin.example.entity.Comment;
import by.shumilin.example.entity.News;
import by.shumilin.example.repository.CommentRepository;
import by.shumilin.example.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class NewsController {
    @Autowired
    NewsRepository newsGetFromDataBase;

    @Autowired
    CommentRepository commentsGetFromDataBase;

    @GetMapping(value = "/")
    public String getAllNews(Model model) {
        List<News> allNews = newsGetFromDataBase.findAll();
        model.addAttribute("allNews", allNews);
        return "allnews";
    }

    @GetMapping(value = "/news/{newsId}")
    public String getNews(@PathVariable long newsId, Model model) {
        News news = newsGetFromDataBase.findById(newsId);
        List<Comment> comments = commentsGetFromDataBase.findAllByNewsId(newsId);
        model.addAttribute("news", news);
        model.addAttribute("comments", comments);
        return "news";
    }
}
