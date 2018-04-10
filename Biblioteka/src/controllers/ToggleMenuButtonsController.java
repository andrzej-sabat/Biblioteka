/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Andrzej
 */
public class ToggleMenuButtonsController  {

    private BorderPaneMainController borderPaneMainController;
    
   @FXML
    private ToggleGroup toggleButtons;

    @FXML
    void openBookLIst() {
        borderPaneMainController.setCenter("/fxml/BookList.fxml");
    }

    @FXML
    void openAddBook( ) {
        borderPaneMainController.setCenter("/fxml/AddBook.fxml");
    }

    @FXML
    void openAddAuthor( ) {
        borderPaneMainController.setCenter("/fxml/AddAuthor.fxml");
    }

    @FXML
    void openAddCategory( ) {
        borderPaneMainController.setCenter("/fxml/AddCategory.fxml");
    }

    public void setBorderPaneMainController(BorderPaneMainController borderPaneMainController) {
        this.borderPaneMainController = borderPaneMainController;
    }
    
    
}
