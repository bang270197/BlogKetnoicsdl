package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService<Blog> {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> showAll() {
        return blogRepository.showAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
      blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
     blogRepository.remove(id);
    }
}
