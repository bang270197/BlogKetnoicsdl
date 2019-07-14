package com.codegym.repository;

import java.util.List;

public interface Repository<E> {
    List<E> showAll();

    E findById(Long id);

    void save(E e);

    void remove(Long id);
}
