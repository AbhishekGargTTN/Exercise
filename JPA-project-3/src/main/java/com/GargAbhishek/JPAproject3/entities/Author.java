package com.GargAbhishek.JPAproject3.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //    @Embedded
//    private Address address;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Subjects> subjectsList;

//    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL)
//    private Book book;

//    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
//    private Set<Book> books;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.MERGE)
    private Set<Book> books;

//    public List<Subjects> getSubjectsList() {
//        return subjectsList;
//    }
//
//    public void setSubjectsList(List<Subjects> subjectsList) {
//        this.subjectsList = subjectsList;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subjects> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(List<Subjects> subjectsList) {
        this.subjectsList = subjectsList;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
}
