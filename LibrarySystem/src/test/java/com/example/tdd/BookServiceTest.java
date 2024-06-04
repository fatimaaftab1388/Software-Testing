package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        IBookRepository bookRepository = new BookRepository();
//        IBookRepository bookRepository = new FakeRepositoryForTest();
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testGetBooksByAuthor() {
        FakeRepositoryForTest.booksList = null;
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthor_MultipleBooksFound() {
        FakeRepositoryForTest.booksList = FakeRepositoryForTest.defaultBooks();
        List<Book> books = bookService.getBooksByAuthor("Robert C. Martin");
        Assertions.assertEquals(2, books.size());
    }

    @Test
    public void testGetBooksByAuthor_EmptyRepository() {
        FakeRepositoryForTest.booksList = null;
        List<Book> books = bookService.getBooksByAuthor("Kentt Beck");
        Assertions.assertEquals(0, books.size());
    }
    @Test
    public void testGetBooksByAuthor_AuthorWithNoBooks() {
        FakeRepositoryForTest.booksList = FakeRepositoryForTest.defaultBooks();
        List<Book> books = bookService.getBooksByAuthor("J.K. Rowling");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle() {
        FakeRepositoryForTest.booksList = FakeRepositoryForTest.defaultBooks();
        List<Book> books = bookService.getBooksByTitle("Clean Code");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByTitle_NoBooksFound() {
        FakeRepositoryForTest.booksList = FakeRepositoryForTest.defaultBooks();
        List<Book> books = bookService.getBooksByTitle("Nonexistent Book");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_MultipleBooksFound() {
        FakeRepositoryForTest.booksList = FakeRepositoryForTest.defaultBooks();
        List<Book> books = bookService.getBooksByTitle("Refactoring");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Refactoring", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByTitle_EmptyRepository() {
        FakeRepositoryForTest.booksList = null;
        List<Book> books = bookService.getBooksByTitle("Cleaan Code");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_TitleWithNoBooks() {
        FakeRepositoryForTest.booksList = FakeRepositoryForTest.defaultBooks();
        List<Book> books = bookService.getBooksByTitle("Random Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle() {
        FakeRepositoryForTest.booksList = FakeRepositoryForTest.defaultBooks();
        List<Book> books = bookService.getBooksByAuthorAndTitle("Kent Beck", "Test Driven Development");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_NoBooksFound() {
        FakeRepositoryForTest.booksList = FakeRepositoryForTest.defaultBooks();
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_MultipleBooksFound() {
        FakeRepositoryForTest.booksList = FakeRepositoryForTest.defaultBooks();
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", "Clean Code");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_EmptyRepository() {
        FakeRepositoryForTest.booksList = null;
        List<Book> books = bookService.getBooksByAuthorAndTitle("Kennt Beck", "Test Driven Development");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_AuthorAndTitleWithNoBooks() {
        FakeRepositoryForTest.booksList = FakeRepositoryForTest.defaultBooks();
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Known Title");
        Assertions.assertEquals(0, books.size());
    }
}
