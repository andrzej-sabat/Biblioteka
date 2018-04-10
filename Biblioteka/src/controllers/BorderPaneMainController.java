/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;




public class BorderPaneMainController  {
@FXML
   private BorderPane borderPane;
@FXML  
   private ToggleMenuButtonsController toggleMenuButtonsController;
   
    @FXML
    private void initialize(){
        toggleMenuButtonsController.setBorderPaneMainController(this);
    }
    
    public void setCenter(String fxmlPath){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = null;
        try{
            parent = loader.load();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        borderPane.setCenter(parent);
    }
}
