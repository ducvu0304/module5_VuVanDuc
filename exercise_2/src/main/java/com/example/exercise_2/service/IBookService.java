package com.example.exercise_2.service;

import com.example.exercise_2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import java.awt.print.Pageable;
import java.util.List;


public interface IBookService {
    List<Book>  getBookList(boolean isSort);
}
