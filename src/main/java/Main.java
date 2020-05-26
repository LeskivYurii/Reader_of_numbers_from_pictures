import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends  Application{
    private Label label = new Label();
    private String directory;
    private  ImageView imageView  = new ImageView();
    private final double widthAndHeight = 400;
    private String result ;
    @FXML
    Button button2 = new Button();
    @FXML
    Button button1 = new Button();
    @FXML
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("Курсова робота Леськіва Юрій КН-301");
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        Class<?> clazz = this.getClass();
        final StackPane root = new StackPane();



        button1.setText("Choose directory");
        button1.setTranslateY(250);
        button1.setPrefSize(550,10);
        button2.setText("Start");
        button2.setPrefSize(550,10);
        button2.setTranslateY(220);

        Scene scene = new Scene(root);
        root.getChildren().add(button1);

        button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
                dialog.setMode(FileDialog.LOAD);
                dialog.setVisible(true);
                String file = dialog.getFile();
                System.out.println(file + " chosen.");
                directory = dialog.getDirectory()+dialog.getFile();
                Image image = new Image("file:"+directory,widthAndHeight,widthAndHeight,true,false);
                imageView.setImage(image);
                if(imageView!=null && root.getChildren().contains(imageView) == false ) {
                    root.getChildren().add(imageView);
                }
                imageView.setX(0);
                imageView.setY(0);

            }
        });

        button2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
               NumberReader numberReader = new NumberReader();
               result =  numberReader.reader(directory);
               Stage dialog = new Stage();
               dialog.initModality(Modality.APPLICATION_MODAL);
               dialog.setTitle("Result complying a  program");
               dialog.initOwner(primaryStage);
               VBox dialogVbox = new VBox(20);
               dialogVbox.getChildren().add(new Text(" "+result));
               dialogVbox.getChildren().get(0).setTranslateX(0);
               Scene dialogScene = new Scene(dialogVbox, 400, 600);
               dialog.setScene(dialogScene);
               dialog.show();

            }
        });

        root.getChildren().add(label);
        root.getChildren().add(button2);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args)  {

        launch();

    }

}
