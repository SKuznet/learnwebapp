package com.learn.controller;

import com.learn.config.AppConfig;
import com.learn.model.Cat;
import com.learn.model.CatService;
import com.learn.model.Dog;
import com.learn.model.Rabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@ImportResource(value = "classpath:ioc.xml")
@PropertySource(value = "classpath:example.properties")
public class AppController {
    private Environment environment;

    private CatService barsikService;
    private Rabbit defRabbit;
    private Dog dog;
    // non recommend
    @Autowired
    private Cat cat;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(AppConfig.class);
        ctx.refresh();
    }

    // recommend
//    public AppController(Cat cat) {
//        this.cat = cat;
//    }

    // localhost:8080/
    @RequestMapping("/")
    public String getHelloPage(Model model) {
        model.addAttribute("name", environment.getRequiredProperty("name"));
        return "hello";
    }

    @Autowired
    @Value("Sharik")
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Autowired
    public void setRabbit(Rabbit rabbit) {
        this.defRabbit = rabbit;
    }

    @Autowired
    @Qualifier(value = "barsikService")
    public void setCatService(CatService barsikService) {
        this.barsikService = barsikService;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

//    @Autowired
//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }
}
