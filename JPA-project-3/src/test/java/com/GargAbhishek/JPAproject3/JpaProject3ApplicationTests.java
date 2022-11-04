package com.GargAbhishek.JPAproject3;

import com.GargAbhishek.JPAproject3.entities.Author;
import com.GargAbhishek.JPAproject3.entities.Book;
import com.GargAbhishek.JPAproject3.entities.Subjects;
import com.GargAbhishek.JPAproject3.repositories.AuthorRepository;
import com.GargAbhishek.JPAproject3.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class JpaProject3ApplicationTests {

	@Autowired
	BookRepository repository;

	@Autowired
	AuthorRepository authorRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testPersistSubjects(){
		Author author= new Author();
		author.setName("Ayush Sharma");

		List<Subjects> subjects= new ArrayList<>();
		Subjects subject1= new Subjects();
		subject1.setSubjectName("Java Core");
		subject1.setAuthor(author);
		subjects.add(subject1);
		Subjects subject2= new Subjects();
		subject2.setSubjectName("Spring Data JPA");
		subject2.setAuthor(author);
		subjects.add(subject2);
		Subjects subject3= new Subjects();
		subject3.setSubjectName("Spring Security");
		subject3.setAuthor(author);
		subjects.add(subject3);

		author.setSubjectsList(subjects);
		authorRepository.save(author);
	}

//	@Test
//	public void testOneToOneAddBook(){
//		Book book= new Book();
//		book.setBookName("JPA 1");
//		Author author= new Author();
//		author.setName("Abhishek Garg");
//		book.setAuthor(author);
//		repository.save(book);
//	}

//	@Test
//	public void testOneToManyAuthor(){
//		Author author= new Author();
//		author.setName("Tarun Singh");
//		Set<Book> books= new HashSet();
//
//		Book book1= new Book();
//		book1.setBookName("Spring JPA 1");
//		book1.setAuthor(author);
//		books.add(book1);
//
//		Book book2= new Book();
//		book2.setBookName("Spring JPA 2");
//		book2.setAuthor(author);
//		books.add(book2);
//
//		author.setBooks(books);
//
//		authorRepository.save(author);
//	}

	@Test
	public void testManyToManyAuthor(){
		Set<Author> authors= new HashSet();
		Author author= new Author();
		author.setName("Joice Joseph");
		authors.add(author);

		Set<Book> books= new HashSet();

		Book book= new Book();
		book.setBookName("Spring JPA ");
		book.setAuthors(authors);
		books.add(book);

		authorRepository.save(author);
		repository.save(book);

	}
}
