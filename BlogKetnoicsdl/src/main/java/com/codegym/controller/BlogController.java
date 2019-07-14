package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;
import java.lang.ref.PhantomReference;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/show-blog")
    public String showBlog(Model model){
        List<Blog> blogs=blogService.showAll();
        model.addAttribute("blog",blogs);
        return "/blog/list";
    }

    @GetMapping("/show-create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "/blog/create";
    }
    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute Blog blog)
    {
        blogService.save(blog);
        ModelAndView modelAndView=new ModelAndView("/blog/create");
        modelAndView.addObject("blogs",new Blog());
        modelAndView.addObject("message","Add blog successfully");
        return modelAndView;
    }
    @GetMapping("/show-view/{id}")
    public ModelAndView showView(@PathVariable Long id){
        Blog blog= (Blog) blogService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/blog/view");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
    @GetMapping("/show-delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id){
        Blog blog= (Blog) blogService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/blog/delete");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
    @PostMapping("/delete-blog")
    public ModelAndView deleteBlog(@ModelAttribute Blog blog){
        Long id=blog.getId();
        if (id!=null){
            blogService.remove(id);
            ModelAndView modelAndView=new ModelAndView("/blog/delete");
            modelAndView.addObject("message","Delete blog successfully");
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("/blog/delete");
            modelAndView.addObject("message1","Delete faild");
            return modelAndView;
        }
    }

    @GetMapping("/show-edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        Blog blog= (Blog) blogService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/blog/edit");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
    @PostMapping("/edit-blog")
    public ModelAndView editBlog(@ModelAttribute Blog blog)
    {
        if (blog!=null){
            blogService.save(blog);
            ModelAndView modelAndView=new ModelAndView("/blog/edit");
            modelAndView.addObject("blog",blog);
            modelAndView.addObject("message","Edit successfully");
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("/blog/edit");
            modelAndView.addObject("message1","edit faild");
            return modelAndView;
        }
    }
}
