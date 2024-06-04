package com.example.tdd;

import java.util.Arrays;
import java.util.List;

public class FakeRepositoryForTest implements IBookRepository{
    public static List<Book> booksList;

    @Override
    public List<Book> findAllBooks() {
        return booksList;
    }

    public static  List<Book> defaultBooks(){
        return Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Robert C. Martin")
        );
    }
}
