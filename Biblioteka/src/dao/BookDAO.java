/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import exceptions.ApplicationException;
import java.sql.SQLException;
import models.Book;

/**
 *
 * @author Andrzej
 */
public class BookDAO extends CommonDAO {
    public BookDAO() {
        super();
    }

    public void deleteByColumnName(String columName, int id) throws ApplicationException, SQLException {
        Dao<Book, Object> dao = getDao(Book.class);
        DeleteBuilder<Book, Object> deleteBuilder = dao.deleteBuilder();
        deleteBuilder.where().eq(columName, id);
        dao.delete(deleteBuilder.prepare());
    }
}
