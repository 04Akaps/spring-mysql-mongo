package spring.db.com.mysqlmongo.service.itf;

import spring.db.com.mysqlmongo.entity.Blog;

import java.util.List;

public interface BlogServiceInterface {
    List<Blog> listAll();

    Blog getById(String id);

    Blog saveOrUpdate(Blog product);

    void delete(String id);

}
