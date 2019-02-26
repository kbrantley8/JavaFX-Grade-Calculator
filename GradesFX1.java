import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
import java.io.*;
import javafx.*;
import java.util.Scanner;
import java.util.ArrayList;

public class GradesFX1 extends Application {

    private BorderPane bp = new BorderPane();
    public ArrayList<Text> al = new ArrayList<Text>(20);

    public void start(Stage primaryStage) throws FileNotFoundException {
        Image image1 = new Image(new FileInputStream("GreyBack.png"));
        BackgroundImage myBI = new BackgroundImage(image1,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        File courseFile = new File("AllTheGrades.txt");
        Scanner scan = new Scanner(courseFile);
        VBox vb = new VBox();
        HBox hb1 = new HBox();
        bp.setBackground(new Background(myBI));
        while (scan.hasNext()) {
            String line = scan.nextLine();
            line = line.substring(0, line.length() - 4);
            Text txt = new Text(line);
            txt.setFont(Font.font ("Film Cryptic", 50));
            al.add(txt);
            vb.getChildren().addAll(txt);
        }
        Text back = new Text("Grade Calculator");
        back.setFont(Font.font ("Film Cryptic", 30));
        back.setUnderline(true);
        hb1.getChildren().addAll(back);
        bp.setTop(hb1);
        vb.setAlignment(Pos.CENTER);
        hb1.setAlignment(Pos.BOTTOM_CENTER);
        bp.setCenter(vb);
        primaryStage.setScene(new Scene(bp, 1200, 900));
        int count = 0;
        for (int i = 0; i < al.size(); i++) {
            Text txt = al.get(i);
            String name = txt.getText();
            txt.setOnMousePressed(e -> {
                try {
                    showGrades(name + ".txt", primaryStage);
                } catch (FileNotFoundException f) {
                    System.out.println();
                }
            });

            txt.setOnMouseEntered(e -> {
                txt.setFill(Color.GREEN);
            });

            txt.setOnMouseExited(e -> {
                txt.setFill(Color.BLACK);
            });
        }

        back.setOnMousePressed(e -> {
            MainGrades g = new MainGrades();
            try {
                g.start(primaryStage);
            }
            catch (FileNotFoundException f) {
                System.out.println();
            }
        });

        back.setOnMouseEntered(e -> {
            back.setFill(Color.GREEN);
        });

        back.setOnMouseExited(e -> {
            back.setFill(Color.BLACK);
        });

    }

    public void showGrades(String name, Stage primaryStage) throws FileNotFoundException {
        File file = new File(name);
        Image image1 = new Image(new FileInputStream("GreyBack.png"));
        BackgroundImage myBI = new BackgroundImage(image1,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        BorderPane bp = new BorderPane();
        BorderPane bp2 = new BorderPane();
        bp.setBackground(new Background(myBI));
        VBox hb = new VBox();
        VBox vb = new VBox();
        VBox vb1 = new VBox();
        HBox vb2 = new HBox();
        VBox hb1 = new VBox();
        VBox vb3 = new VBox();
        Text txt4 = new Text("Section:");
        txt4.setFont(Font.font ("Film Cryptic", 30));
        txt4.setUnderline(true);
        vb1.getChildren().addAll(txt4);
        Text txt5 = new Text("Grades:");
        txt5.setFont(Font.font ("Film Cryptic", 30));
        txt5.setUnderline(true);
        vb.getChildren().addAll(txt5);
        Text txt6 = new Text("Percentage(%):");
        txt6.setFont(Font.font ("Film Cryptic", 30));
        txt6.setUnderline(true);
        hb1.getChildren().addAll(txt6);
        Text txt7 = new Text("Averages:");
        txt7.setFont(Font.font ("Film Cryptic", 30));
        txt7.setUnderline(true);
        vb3.getChildren().addAll(txt7);
        vb2.setSpacing(10);
        Scanner scan = new Scanner(file);
        int ans2 = 0;
        ArrayList<Integer> al1 = new ArrayList<Integer>(10);
        ArrayList<Double> al2 = new ArrayList<Double>(10);
        int counter1 = 0;
        while (scan.hasNext()) {
            int counter2 = counter1 + 1;
            counter1++;
            ArrayList<String> al = new ArrayList<String>(10);
            String line = scan.nextLine();
            Scanner scan1 = new Scanner(line);
            hb1.setAlignment(Pos.CENTER);
            while (scan1.hasNext()) {
                String word = scan1.next();
                al.add(word);
            }
            String withoutPerc = "";
            String first = al.get(0);
            Text txt1 = new Text(first);
            txt1.setFont(Font.font ("Film Cryptic", 30));
            vb1.getChildren().addAll(txt1);
            HBox ae = new HBox();
            ae.setSpacing(10);
            int count = 0;
            for (int i = 1; i < al.size() - 1; i++) {
                Text t = new Text(al.get(i));
                t.setFont(Font.font ("Film Cryptic", 30));
                ae.getChildren().addAll(t);
                withoutPerc = withoutPerc + " " + al.get(i);
                int count1 = count + 1;
                count++;
                t.setOnMousePressed(e -> {
                    TextField tf = new TextField();
                    ae.getChildren().addAll(tf);
                    tf.setOnAction(f -> {
                        String s = "" + tf.getCharacters();
                        int g = Integer.parseInt(s);
                        try {
                            // System.out.println(g + " " + count1 + " " + counter2);
                            changeGrade1(g, count1, counter2, name);
                            showGrades(name, primaryStage);
                        } catch (FileNotFoundException h) {
                            System.out.println();
                        }
                    });
                });
                t.setOnMouseEntered(e -> {
                    t.setFill(Color.GREEN);
                });

                t.setOnMouseExited(e -> {
                    t.setFill(Color.BLACK);
                });
            }
            ae.setAlignment(Pos.CENTER);
            Text txt2 = new Text(al.get(al.size() - 1) + "%");
            int ans = getAverage(withoutPerc);
            al1.add(ans);
            al1.add(Integer.parseInt(al.get(al.size() - 1)) / 100);
            al2.add((double) ans * Integer.parseInt(al.get(al.size() - 1)) / 100);
            String st = "" + ans;
            Text st1 = new Text(st);
            hb1.getChildren().addAll(txt2);
            vb3.getChildren().addAll(st1);
            vb3.setAlignment(Pos.CENTER);
            st1.setFont(Font.font ("Film Cryptic", 30));
            hb1.setAlignment(Pos.CENTER_RIGHT);
            txt2.setFont(Font.font ("Film Cryptic", 30));
            // vb2.getChildren().addAll(hb1, vb3);
            Text txt = new Text(withoutPerc);
            txt.setFont(Font.font ("Film Cryptic", 30));
            vb.getChildren().addAll(ae);
        }
        double b = 0;
        for (int i = 0; i < al2.size(); i++) {
            double a = al2.get(i);
            b = b + a;
        }
        int c = (int) Math.round(b);
        String ba = "" + c;
        vb2.getChildren().addAll(hb1, vb3);
        vb.setAlignment(Pos.CENTER);
        Text back = new Text("Grade Calculator");
        back.setFont(Font.font ("Film Cryptic", 30));
        Text back1 = new Text("");
        Text back3 = new Text("");
        Text back4 = new Text("");
        Text back5 = new Text("");
        Text back6 = new Text("");
        Text back7 = new Text("");
        Text back8 = new Text("");
        Text back9 = new Text("");
        Text back10 = new Text("");
        Text back2 = new Text(name.substring(0,name.length() - 4) + ": " + ba);
        HBox asdf = new HBox();
        asdf.getChildren().addAll(back2);
        back2.setFont(Font.font ("Film Cryptic", 60));
        back.setUnderline(true);
        vb1.setAlignment(Pos.CENTER);
        vb2.setAlignment(Pos.CENTER);
        hb1.setAlignment(Pos.CENTER);
        vb2.setSpacing(20);
        bp2.setLeft(vb1);
        bp2.setRight(vb2);
        bp2.setCenter(vb);
        hb.getChildren().addAll(back);
        hb.setAlignment(Pos.CENTER);
        bp.setTop(hb);
        asdf.setAlignment(Pos.CENTER);
        bp2.setTop(asdf);
        bp.setCenter(bp2);
        primaryStage.setScene(new Scene(bp, 1200, 900));
        back.setOnMousePressed(e -> {
            GradesFX1 g = new GradesFX1();
            try {
                g.start(primaryStage);
            }
            catch (FileNotFoundException f) {
                System.out.println();
            }
        });

        back.setOnMouseEntered(e -> {
            back.setFill(Color.GREEN);
        });

        back.setOnMouseExited(e -> {
            back.setFill(Color.BLACK);
        });
    }

    public int getAverage(String s) throws FileNotFoundException {
        Scanner scan = new Scanner(s);
        int b = 0;
        int count = 0;
        while (scan.hasNext()) {
            int a = Integer.parseInt(scan.next());
            b = b + a;
            count++;
        }
        return (int) Math.round((double) b / (double) count);

    }

    public static void changeGrade1(int g, int count, int a, String name) throws FileNotFoundException {
        File file = new File(name);
        Scanner scan = new Scanner(file);
        String all = "";
        // BEFORE
        for (int i = 1; i < a; i++) {
            String before = scan.nextLine();
            if (i == a - 1) {
                all = all + " " + before;
            } else {
                all = all + " " + before + " INDEX";
            }
        }
        String all1 = "";
        Scanner scan1 = new Scanner(file);
        int countly = 0;
        while (scan1.hasNext()) {
            String hw = scan1.nextLine();
            countly++;
        }
        Scanner scan2 = new Scanner(file);
        // AFTER
        for (int i = 0; i < countly; i++) {
            String after = scan2.nextLine();
            if (i < a) {
                int ba = 0;
            } else if (i == countly - 1) {
                all1 = all1 + " " + after;
            } else {
                all1 = all1 + " " + after + " INDEX";
            }
        }

        String wanted = scan.nextLine();
        //System.out.println(all);
        //System.out.println(all1);
        //System.out.println(wanted);
        Scanner scan4 = new Scanner(wanted);
        String pos = scan4.next();
        // System.out.print("****************************");
        // System.out.print("(" + s.substring(0, s.length() - 4) + ")");
        // System.out.println("****************************");
        Scanner scan5 = new Scanner(wanted);
        String newWanted1 = "";
        int count2 = 0;
        while (scan5.hasNext()) {
            String an = scan5.next();
            if (scan5.hasNext()) {
                count2++;
                // System.out.print(an + " ");
                newWanted1 = newWanted1 + " " + an;
            }
        }
        // System.out.println(count2);
        newWanted1 = newWanted1.substring(1, newWanted1.length());
        // System.out.println();
        String am1 = pos.substring(0, pos.length() - 1);
        int ans = count;
        int ans1 = g;
        String newBefore = "";
        String newAfter = "";
        Scanner scan6 = new Scanner(wanted);
        for (int i = 0; i < ans; i++) {
            if (i == 0) {
                newBefore = newBefore + scan6.next();
            } else {
                newBefore = newBefore + " " + scan6.next();
            }
        }
        Scanner scan7 = new Scanner(wanted);
        int counter = 0;
        while (scan7.hasNext()) {
            String hw = scan7.next();
            counter++;
        }
        scan6 = new Scanner(wanted);
        for (int i = 0; i < counter; i++) {
            String want = scan6.next();
            if (i <= ans) {
                int boo = 0;
            } else {
                newAfter = newAfter + " " + want;
            }
        }
        //System.out.println(newBefore);
        //System.out.println(newAfter);

        PrintWriter outWriter = new PrintWriter(file);
        Scanner scan11 = new Scanner(all);
        int count1 = 0;
        if (all.isEmpty()) {
            int anna = 0;
        } else {
            while (scan11.hasNext()) {
                //System.out.println(++count1);
                String hw = scan11.next();
                if (hw.equals("INDEX")) {
                    outWriter.println();
                } else {
                    outWriter.print(hw + " ");
                }
            }
            outWriter.println();
        }
        outWriter.print(newBefore);
        outWriter.print(" " + ans1);
        outWriter.print(newAfter);
        outWriter.println();
        Scanner scan13 = new Scanner(all1);
        while (scan13.hasNext()) {
            String hw = scan13.next();
            if (hw.equals("INDEX")) {
                outWriter.println();
            } else {
                outWriter.print(hw + " ");
            }
        }
        outWriter.close();
        // System.out.println(am1 + " #" + ans + " is now a " + ans1);



    }

}