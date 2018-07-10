package by.shumilin.example.controller;

import by.shumilin.example.entity.News;
import by.shumilin.example.repository.NewsRepository;
import by.shumilin.example.service.NewsGetFromDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AllNews {
    @Autowired
    NewsGetFromDataBase newsGetFromDataBase;

    @GetMapping(value = "/")
    public String getAllNews(Model model) {
        List<News> allNews = newsGetFromDataBase.getAllNews();
        model.addAttribute("allNews", allNews);
        return "allnews";
    }

    @GetMapping(value = "/news/{id}")
    public String getNews(@PathVariable long id, Model model) {
        List<News> news = newsGetFromDataBase.getNews(id);
        model.addAttribute("news", news);
        return "news";
    }
}
