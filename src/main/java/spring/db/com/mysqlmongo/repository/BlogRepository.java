package spring.db.com.mysqlmongo.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import spring.db.com.mysqlmongo.config.MongoConfig;
import spring.db.com.mysqlmongo.entity.Blog;
import spring.db.com.mysqlmongo.response.Response;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository{
    private MongoDatabase mongoDatabase;

    @Autowired
    public void MyMongoClient(MongoConfig mongoConf) {
        this.mongoDatabase = mongoConf.newDatabase("blog");
    }


    public ResponseEntity<Object> findAll() {
        List<Blog> blogs = new ArrayList<>();
       MongoCollection<Document> collection = mongoDatabase.getCollection("blog-content");

       MongoCursor<Document> cursor = collection.find().iterator();

       try {
           while (cursor.hasNext()) {
               Document document = cursor.next();
               // 여기서 Document에서 Blog 객체로 변환하는 작업을 수행합니다.
               // 예를 들어, Blog 객체의 생성자 또는 빌더를 사용하여 변환합니다.
               Blog blog = convertDocumentToBlog(document);
               blogs.add(blog);
           }
       }finally {
           cursor.close();
       }

       return  Response.success("Success To Get Board", blogs);
    }

    private Blog convertDocumentToBlog(Document document) {
        Blog blog = new Blog();
        blog.setId(document.getLong("id"));
        blog.setTitle(document.getString("Title"));
        blog.setContent(document.getString("Content"));
        return blog;
    }




}
