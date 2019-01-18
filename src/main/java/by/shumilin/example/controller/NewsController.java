package by.shumilin.example.controller;

import by.shumilin.example.entity.Comment;
import by.shumilin.example.entity.News;
import by.shumilin.example.service.CommentService;
import by.shumilin.example.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NewsController {

    private final NewsService newsService;

    private final CommentService commentService;

    public NewsController(NewsService newsService, CommentService commentService) {
        this.newsService = newsService;
        this.commentService = commentService;
    }

//    @GetMapping(value = "/")
//    public String getAllNews(Model model) {
//        Iterable<News> allNews = newsService.findAll();
//        model.addAttribute("allNews", allNews);
//        return "main";
//    }

    @GetMapping(value = "/news/{newsId}")
    @Transactional
    public String getNews(@PathVariable long newsId, Model model) {
        News news = newsService.findById(newsId);
//        List<Comment> comments = news.getComments();
        List<Comment> comments = commentService.findAllByNewsId(newsId);
        model.addAttribute("news", news);
        model.addAttribute("comments", comments);
        return "news";
    }

    @GetMapping("/publish")
    public String getFormPublication() {
        return "publication";
    }

    @PostMapping("/publication")
    @Transactional
    public String setPublication(@RequestParam String title, @RequestParam String content, Model model) {
        String substring = content.substring(0, 200);
        News news = new News(title, content);
        news.setShortText(substring);
        newsService.save(news);

        Iterable<News> allNews = newsService.findAll();
        model.addAttribute("allNews", allNews);
        return "main";
    }

    @GetMapping("/edit/{newsId}")
    public String editNews(@PathVariable long newsId, Model model){
        News news = newsService.findById(newsId);
        model.addAttribute("news", news);
        return "edit";
    }

    @PostMapping("/update")
    @Transactional
    public String updateNews(@RequestParam String title, @RequestParam String content, @RequestParam long newsId, Model model){
        News news = newsService.findById(newsId);
        news.setTitle(title);
        news.setContent(content);
        String substring = content.substring(0, 200);
        news.setShortText(substring);
        newsService.save(news);
        List<Comment> comments = commentService.findAllByNewsId(newsId);
        model.addAttribute("news", news);
        model.addAttribute("comments", comments);
        return "redirect:/news/" + newsId;
    }

    @GetMapping("/")
    @Transactional
    public String nextPage(@RequestParam(defaultValue = "0") Integer number, Model model){
        PageRequest pageRequest = PageRequest.of(number, 5);
        Page<News> page = newsService.findAll(pageRequest);
        List<News> allNews = page.getContent();
        long count = newsService.count();
        model.addAttribute("allNews", allNews);
        return "main";
    }
}
