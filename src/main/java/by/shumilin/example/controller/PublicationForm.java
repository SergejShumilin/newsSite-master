package by.shumilin.example.controller;


import by.shumilin.example.entity.News;
import by.shumilin.example.repository.NewsRepository;
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
    NewsRepository newsRepository;


    @GetMapping("/publish")
    public String getFormPublication() {
        return "publication";
    }

    @PostMapping("/publication")
    public String setPublication(@RequestParam String title, @RequestParam String content, Model model) {
        newsRepository.save(title, content);
        List<News> allNews = newsRepository.findAll();
        model.addAttribute("allNews", allNews);
        return "allnews";
    }
}
