package spring.db.com.mysqlmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.db.com.mysqlmongo.entity.Blog;
import spring.db.com.mysqlmongo.repository.BlogRepository;
import spring.db.com.mysqlmongo.service.itf.BlogServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements BlogServiceInterface {

    private BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    @Override
    public List<Blog> listAll() {
        List<Blog> products = new ArrayList<>();
        blogRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

    @Override
    public Blog getById(String id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog saveOrUpdate(Blog product) {
        blogRepository.save(product);
        return product;
    }

    @Override
    public void delete(String id) {
        blogRepository.deleteById(id);
    }


}
