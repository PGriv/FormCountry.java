import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class MessageBoxOKCancel {

        Stage stage;
        Label lbl;
        Button btnOK;
        Button btnCancel;
        boolean returnValue;
        String message;
        String title;

        public MessageBoxOKCancel(String message, String title) {
            this.message = message;
            this.title = title;
            show();
        }

        public void show()
        {
            lbl = new Label();
            lbl.setText(message);

            btnOK = new Button();
            btnOK.setText("OK");
            btnOK.setDefaultButton(true);
            btnOK.setOnAction(e -> ok());

            btnCancel = new Button();
            btnCancel.setText("Cancel");
            btnCancel.setDefaultButton(true);
            btnCancel.setOnAction(e -> cancel());


            VBox pane = new VBox();
            HBox pane2 = new HBox();

            pane.getChildren().addAll(lbl, pane2);
            pane.setAlignment(Pos.CENTER);

            pane2.getChildren().addAll(btnOK, btnCancel);
            pane2.setAlignment(Pos.CENTER);


            Scene scene = new Scene(pane);

            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setWidth(200);
            stage.setHeight(200);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.showAndWait();
        }

        public void ok() {
            returnValue = true;
            stage.close();
        }

        public void cancel() {
            returnValue = false;
            stage.close();
        }

        public boolean getResponse() {
            return returnValue;
        }
    }

