package fr.diginamic.spring_security.controllers;

import fr.diginamic.spring_security.entities.Article;
import fr.diginamic.spring_security.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/new")
    public String createArticle(@ModelAttribute Article article, Authentication auth) {
        String username = ((UserDetails) auth.getPrincipal()).getUsername();
        articleRepository.save(new Article(article.getTitre(), article.getContenu(), username));
        return "article crée";
    }
}
