package spring.db.com.mysqlmongo.controller;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import spring.db.com.mysqlmongo.entity.Blog;
import spring.db.com.mysqlmongo.service.BlogService;

@RequestMapping("/blog")
@ResponseBody
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/tweets")
    public ResponseEntity<Object> getAllTweets() {
        return blogService.findAllBlog();
    }


}
