package com.example.exercise_2.service;

import com.example.exercise_2.entity.Book;
import com.example.exercise_2.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookService implements IBookService{
    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getBookList(boolean isSort) {

        if(isSort) {
            return bookRepo.findAll()
                    .stream()
                    .sorted(Comparator.comparing(Book::getName).reversed())
                    .collect(Collectors.toList());
        }

        return bookRepo.findAll();
    }
}
