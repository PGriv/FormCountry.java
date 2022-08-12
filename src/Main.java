import javafx.application.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.control.Menu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Main extends Application {
    Button btn;

    @Override
    public void start(Stage stage) {
        //menu manage
        Menu menuManage = new Menu("_Manage");
        MenuItem menuCountries = new MenuItem("_Countries");
        MenuItem menuCities = new MenuItem("_Cities");
        MenuItem menuLanguages = new MenuItem("_Languages");

        menuCountries.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        menuCountries.setOnAction(e->click());

        menuCities.setAccelerator(new KeyCodeCombination(KeyCode.C,KeyCombination.CONTROL_DOWN,KeyCombination.SHIFT_DOWN));
        menuLanguages.setAccelerator(new KeyCodeCombination(KeyCode.L,KeyCombination.CONTROL_DOWN));
        menuCities.setOnAction(e->click2());
        menuManage.getItems().addAll(menuCountries,menuCities,menuLanguages);

        //menu Diagrams
        Menu menuDiagram = new Menu("_Diagrams");
        MenuItem menuCountriesPerContinent = new MenuItem("Countries per Continent");
        MenuItem menuCitiesPerCountry = new MenuItem("Cities per Country");
        MenuItem menuPopulationDistribution = new MenuItem("Population Distribution");
        MenuItem menuReligionDistribution = new MenuItem("Religion Distribution");

        menuDiagram.getItems().addAll(menuCountriesPerContinent,menuCitiesPerCountry,new SeparatorMenuItem(),menuPopulationDistribution,menuReligionDistribution);

        //menu Help
        Menu menuHelp = new Menu("_Help");
        MenuItem menuContents = new MenuItem("Contents");
        MenuItem menuAbout = new MenuItem("About");
        menuHelp.getItems().addAll(menuContents,menuAbout);
        menuHelp.setAccelerator(new KeyCodeCombination(KeyCode.H,KeyCombination.CONTROL_DOWN));

        MenuBar menuBar = new MenuBar(menuManage,menuDiagram,menuHelp);

        HBox boxMenu = new HBox();
        boxMenu.getChildren().addAll(menuBar);

        HBox imgContainer= new HBox();
        imgContainer.setAlignment(Pos.CENTER);
        ImageView img = new ImageView(new Image("world.png"));
        img.setFitHeight(imgContainer.getWidth());
        img.setPreserveRatio(true);
        imgContainer.getChildren().add(img);

        VBox container = new VBox();
        container.getChildren().addAll(boxMenu, imgContainer);

        Scene scene = new Scene(container,200,200);
        container.setPrefWidth(scene.getWidth());
        menuBar.setPrefWidth(scene.getWidth());
        scene.widthProperty().addListener(((observable, oldValue, newValue) ->{
            boxMenu.setPrefWidth(scene.getWidth());
            menuBar.setPrefWidth(scene.getWidth());
        }));

        stage.setScene(scene);
        stage.setTitle("The World!");
        stage.setX((Screen.getPrimary().getVisualBounds().getWidth()-500)/2);
        stage.setY((Screen.getPrimary().getVisualBounds().getHeight()-600)/2);
        stage.setWidth(500);
        stage.setHeight(600);
        stage.setMaximized(true);

        stage.show();
    }

    public void click() {
        FormCountry fc = new FormCountry();
    }

    public void click2() {
        FormCity formCity = new FormCity();
    }

    public static void main(String[] args) {
        launch(args);
    }
}