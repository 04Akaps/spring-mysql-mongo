package spring.db.com.mysqlmongo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.db.com.mysqlmongo.entity.Blog;
import spring.db.com.mysqlmongo.service.BlogService;

@RequestMapping("/blog")
@ResponseBody
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;


    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/product/list";
    }

    @RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("products", blogService.listAll());
        return "product/list";
    }
    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", blogService.getById(id));
        return "product/show";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new Blog());
        return "product/productform";
    }
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid Blog blog, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        Blog savedProduct = blogService.saveOrUpdate(blog);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        blogService.delete(id);
        return "redirect:/product/list";
    }


}
