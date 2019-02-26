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

public class MainGrades extends Application {

    public Label label = new Label();
    public Label label1;
    public Label label2;
    public static int counter = 0;
    public static int counter1 = 0;
    public GradesFX1 f = new GradesFX1();

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        // BorderPane borderPane = new BorderPane();
        //Text txt = new Text("Welcome to");
        //txt.setFont(Font.font ("Times New Roman", 15));
        Text txt1 = new Text("Grade Calculator");
        txt1.setFont(Font.font ("Film Cryptic", 70));
        // txt1.setStyle("-fx-font-size: 32pt;");
        // txt1.setStyle("-fx-border-color: #336655;");
        Image image1 = new Image(new FileInputStream("GreyBack.png"));
        Text btn = new Text("Start");
        Text btn1 = new Text("End");
        btn.setFont(Font.font ("Film Cryptic", 25));
        btn1.setFont(Font.font ("Film Cryptic", 25));
        label.setText("");
        VBox v = new VBox();
        HBox h = new HBox();
        h.setSpacing(10);
        v.setSpacing(20);
        // txt.setAlignment(Pos.CENTER);
        // txt1.setAlignment(Pos.CENTER);
        h.getChildren().addAll(btn, btn1);
        h.setAlignment(Pos.CENTER);
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(txt1, h, label);
        // v.setStyle("-fx-background-color: rgba(0, 150, 0, 0.7);");
        BackgroundImage myBI = new BackgroundImage(image1,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        //then you set to your node
        v.setBackground(new Background(myBI));
        // borderPane.setCenter(v);

        btn.setOnMousePressed(e -> {
            try {
                f.start(primaryStage);
            }
            catch (FileNotFoundException g) {
                System.out.println("The file doesn't exist");
            }
        });

        btn.setOnMouseEntered(e -> {
            btn.setFill(Color.GREEN);
        });

        btn.setOnMouseExited(e -> {
            btn.setFill(Color.BLACK);
        });

        btn1.setOnMousePressed(e -> {
            System.exit(0);
        });

        btn1.setOnMouseEntered(e -> {
            btn1.setFill(Color.RED);
        });

        btn1.setOnMouseExited(e -> {
            btn1.setFill(Color.BLACK);
        });

        // txt1.setOnMousePressed(e -> {
        //     System.out.println();
        // });

        // txt1.setOnMouseEntered(e -> {
        //     txt1.setFill(Color.AQUA);
        // });

        // txt1.setOnMouseExited(e -> {
        //     txt1.setFill(Color.BLACK);
        // });

        Scene scene = new Scene(v, 1200, 900);
        primaryStage.setTitle("Grade Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }




}