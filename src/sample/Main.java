package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
      //  Parent content = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group group = new Group();



        Scene scene=new Scene(group,1000,500);

        primaryStage.setScene(scene);
        primaryStage.show();



        TextField txt=new TextField();
        BorderPane mainPane=new BorderPane();
        VBox stolb =new VBox();
        stolb.setSpacing(5);
        mainPane.setMinHeight(300);
        mainPane.setMinWidth(300);
        stolb.setMinHeight(50);
        stolb.setMinWidth(50);
        stolb.setMaxHeight(100);
        stolb.setMaxWidth(100);
        mainPane.setCenter(stolb);



        Button btn=new Button("Нажми меня");
        Text hint=new Text("3 попытки");
        Text gameName=new Text("Игра-угадайка: задано число от 0 до 20. Даётся три попытки");
        stolb.getChildren().addAll(gameName,txt,btn,hint);
        stolb.setSpacing(5);

        group.getChildren().addAll(mainPane);



        Game game = new Game();//игра угадайка
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    int a = Integer.parseInt(txt.getText());//пытаемся угадать
                    if(game.getValue()>2) {
                        btn.setOnMouseClicked(null); //убираем слушателя
                        hint.setText("Человек, ты проиграл, смирись...");
                    }
                    else {

                        if (!game.tryGuess(a, hint)) {
                            System.out.println("try");
                        } else {
                            btn.setOnMouseClicked(null);
                        }
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    gameName.setText(gameName.getText()+"\n Буковки прошу");

                }
                ;
            }
        });




    }



    public static void main(String[] args) {
        launch(args);
    }
}
