/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelFx;

import converters.ConverterAuthor;
import converters.ConverterBook;
import converters.ConverterCategory;
import dao.AuthorDAO;
import dao.BookDAO;
import dao.CategoryDAO;
import exceptions.ApplicationException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Author;
import models.Book;
import models.Category;

/**
 *
 * @author Andrzej
 */
public class BookListModel {
    private ObservableList<BookFx> bookFxObservableList = FXCollections.observableArrayList();
    private ObservableList<AuthorFx> authorFxObservableList = FXCollections.observableArrayList();
    private ObservableList<CategoryFx> categoryFxObservableList = FXCollections.observableArrayList();

    private ObjectProperty<AuthorFx> authorFxObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<CategoryFx> categoryFxObjectProperty = new SimpleObjectProperty<>();

    private List<BookFx> bookFxList = new ArrayList<>();

    public void init() throws ApplicationException {
        BookDAO bookDao = new BookDAO();
        List<Book> books = bookDao.queryForAll(Book.class);
        bookFxList.clear();
        books.forEach(book -> {
            this.bookFxList.add(ConverterBook.convertToBookFx(book));
        });
        this.bookFxObservableList.setAll(bookFxList);

        initAuthors();
        initCategory();
    }

    public void filterBooksList() {
        if (getAuthorFxObjectProperty() != null && getCategoryFxObjectProperty() != null) {
            filterPredicate(predicateAuthor().and(predicateCatgory()));
        } else if (getCategoryFxObjectProperty() != null) {
            filterPredicate(predicateCatgory());
        } else if (getAuthorFxObjectProperty() != null) {
            filterPredicate(predicateAuthor());
        } else {
            this.bookFxObservableList.setAll(this.bookFxList);
        }
    }

    public void deleteBook(BookFx bookFx) throws ApplicationException {
        BookDAO bookDao = new BookDAO();
        bookDao.deleteById(Book.class, bookFx.getId());
        init();
    }

    private void initAuthors() throws ApplicationException {
        AuthorDAO authorDao = new AuthorDAO();
        List<Author> authorList = authorDao.queryForAll(Author.class);
        this.authorFxObservableList.clear();
        authorList.forEach(author -> {
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(author);
            this.authorFxObservableList.add(authorFx);
        });
    }

    private void initCategory() throws ApplicationException {
        CategoryDAO categoryDao = new CategoryDAO();
        List<Category> categories = categoryDao.queryForAll(Category.class);
        this.categoryFxObservableList.clear();
        categories.forEach(c -> {
            CategoryFx categoryFx = ConverterCategory.convertToCategoryFx(c);
            this.categoryFxObservableList.add(categoryFx);
        });
    }

    private Predicate<BookFx> predicateCatgory() {
        return bookFx -> bookFx.getCategoryFx().getId() == getCategoryFxObjectProperty().getId();
    }

    private Predicate<BookFx> predicateAuthor() {
        return bookFx -> bookFx.getAuthorFx().getId() == getAuthorFxObjectProperty().getId();
    }

    private void filterPredicate(Predicate<BookFx> predicate) {
        List<BookFx> newList = bookFxList.stream().filter(predicate).collect(Collectors.toList());
        this.bookFxObservableList.setAll(newList);
    }

    public ObservableList<BookFx> getBookFxObservableList() {
        return bookFxObservableList;
    }

    public void setBookFxObservableList(ObservableList<BookFx> bookFxObservableList) {
        this.bookFxObservableList = bookFxObservableList;
    }

    public ObservableList<AuthorFx> getAuthorFxObservableList() {
        return authorFxObservableList;
    }

    public void setAuthorFxObservableList(ObservableList<AuthorFx> authorFxObservableList) {
        this.authorFxObservableList = authorFxObservableList;
    }

    public ObservableList<CategoryFx> getCategoryFxObservableList() {
        return categoryFxObservableList;
    }

    public void setCategoryFxObservableList(ObservableList<CategoryFx> categoryFxObservableList) {
        this.categoryFxObservableList = categoryFxObservableList;
    }

    public AuthorFx getAuthorFxObjectProperty() {
        return authorFxObjectProperty.get();
    }

    public ObjectProperty<AuthorFx> authorFxObjectPropertyProperty() {
        return authorFxObjectProperty;
    }

    public void setAuthorFxObjectProperty(AuthorFx authorFxObjectProperty) {
        this.authorFxObjectProperty.set(authorFxObjectProperty);
    }

    public CategoryFx getCategoryFxObjectProperty() {
        return categoryFxObjectProperty.get();
    }

    public ObjectProperty<CategoryFx> categoryFxObjectPropertyProperty() {
        return categoryFxObjectProperty;
    }

    public void setCategoryFxObjectProperty(CategoryFx categoryFxObjectProperty) {
        this.categoryFxObjectProperty.set(categoryFxObjectProperty);
    }
}
