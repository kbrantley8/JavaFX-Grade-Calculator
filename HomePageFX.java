import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.*;
import java.io.*;
import javafx.*;

public class HomePageFX extends Application {

    ClassListPageFX f = new ClassListPageFX();

    public void start(Stage primaryStage) throws FileNotFoundException {

        //**************************************************
        //CREATE TEXTS
        //**************************************************

        Text gradeCalc = new Text("Grade Calculator");
        gradeCalc.setFont(Font.font ("Film Cryptic", 70));
        Image image1 = new Image(new FileInputStream("GreyBack.png"));
        Text startBtn = new Text("Start");
        Text endBtn = new Text("End");
        startBtn.setFont(Font.font ("Film Cryptic", 25));
        endBtn.setFont(Font.font ("Film Cryptic", 25));





        //**************************************************
        //CREATE H-BOX
        //**************************************************
        HBox h = new HBox();
        h.setSpacing(10);
        h.setAlignment(Pos.CENTER);
        h.getChildren().addAll(startBtn, endBtn);




        //**************************************************
        //CREATE V-BOX AND BACKGROUND
        //**************************************************

        VBox v = new VBox();
        v.setSpacing(20);
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(gradeCalc, h);
        BackgroundImage myBI = new BackgroundImage(image1,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        v.setBackground(new Background(myBI));





        //**************************************************
        //CREATE BUTTON FX
        //**************************************************

        startBtn.setOnMousePressed(e -> {
            try {
                f.start(primaryStage);
            }
            catch (FileNotFoundException g) {
                System.out.println("The file doesn't exist");
            }
        });

        startBtn.setOnMouseEntered(e -> {
            startBtn.setFill(Color.GREEN);
        });

        startBtn.setOnMouseExited(e -> {
            startBtn.setFill(Color.BLACK);
        });

        endBtn.setOnMousePressed(e -> {
            System.exit(0);
        });

        endBtn.setOnMouseEntered(e -> {
            endBtn.setFill(Color.RED);
        });

        endBtn.setOnMouseExited(e -> {
            endBtn.setFill(Color.BLACK);
        });




        //**************************************************
        //CREATE SCENE
        //**************************************************

        Scene scene = new Scene(v, 1200, 900);
        primaryStage.setTitle("Grade Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}