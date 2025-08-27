package fr.diginamic.spring_security.controllers;

import fr.diginamic.spring_security.entities.Article;
import fr.diginamic.spring_security.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/new")
    public String createArticle(@ModelAttribute Article article) {
        articleRepository.save(new Article(article.getTitre(), article.getContenu()));
        return "article crée";
    }
}
