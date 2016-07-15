//package com.sample.lib.entities;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class StudentTest {
//    private static Student student;
//    private static Book book;
//
//    @BeforeClass
//    public static void setUp() throws Exception {
//        student = new Student();
//        book = new Book();
//        Librarian librarian = new Librarian("", "");
//        librarian.register(book);
//    }
//
//    @Test
//    public void shouldBeAbleToTakeABookFromLibrary() throws Exception {
//        assertTrue(student.take("Othello"));
//    }
//
//    @Test
//    public void shouldNotBeAbleToTakeABookWhichIsNotAvailableInLibrary() throws Exception {
//        assertFalse(student.take("Path"));
//    }
//}