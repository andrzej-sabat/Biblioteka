/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka;

import dbutils.DbManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 *
 * @author Andrzej
 */
public class Biblioteka extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
       
        
        
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BorderPaneMain.fxml"));
        BorderPane borderPane = loader.load();
        Scene scene = new Scene (borderPane);
    
        stage.setTitle("Biblioteka");
        stage.setScene(scene);
        stage.show();
        
        DbManager.initDatabase();
    }

 
    public static void main(String[] args) {
        launch(args);
    }
    
}
