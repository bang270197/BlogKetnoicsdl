package com.codegym.service;

import java.util.List;

public interface BlogService<E> {
    List<E> showAll();

    E findById(Long id);

    void save(E e);

    void remove(Long id);
}
