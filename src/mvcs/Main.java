/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvcs;

import java.sql.SQLException;
import java.util.List;
import mvcs.services.BookService;
import mvcs.models.Book;

/**
 *
 * @author omar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        BookService sv = new BookService();
//        List<Book> ls = sv.findAll();
//        ls.stream().forEach(System.out::println);
        Book book = sv.findByCode("b335");
        book.setTitle("Theory of Languages");
        sv.update(book);
        
    }

}
