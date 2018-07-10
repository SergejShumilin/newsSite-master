package by.shumilin.example.controller;


import by.shumilin.example.entity.News;
import by.shumilin.example.repository.NewsRepository;
import by.shumilin.example.service.NewsGetFromDataBase;
import by.shumilin.example.service.NewsSaveToDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PublicationForm {
    @Autowired
    NewsSaveToDataBase newsSaveToDataBase;

    @Autowired
    NewsGetFromDataBase newsGetFromDataBase;

    @GetMapping("/publish")
    public String getFormPublication() {
        return "publication";
    }

    @PostMapping("/publication")
    public String setPublication(@RequestParam String title, @RequestParam String content, Model model) {
        newsSaveToDataBase.save(title, content);
        List<News> allNews = newsGetFromDataBase.getAllNews();
        model.addAttribute("allNews", allNews);
        return "allnews";
    }
}
