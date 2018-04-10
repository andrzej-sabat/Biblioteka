/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import modelFx.BookFx;
import models.Book;

/**
 *
 * @author Andrzej
 */
public class ConverterBook {
    public static Book convertToBook(BookFx bookFx){
        Book book = new Book();
        book.setId(bookFx.getId());
        book.setTitle(bookFx.getTitle());
        book.setDescription(bookFx.getDescription());
        book.setRating(bookFx.getRating());
       
        
        
        return  book;
    }

    public static BookFx convertToBookFx(Book book){
        BookFx bookFx = new BookFx();
        bookFx.setId(book.getId());
        bookFx.setTitle(book.getTitle());
        bookFx.setDescription(book.getDescription());
        bookFx.setRating(book.getRating());
        
        
        bookFx.setAuthorFx(ConverterAuthor.convertToAuthorFx(book.getAuthor()));
        bookFx.setCategoryFx(ConverterCategory.convertToCategoryFx(book.getCategory()));
        return bookFx;
    }
}
