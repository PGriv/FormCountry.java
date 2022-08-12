import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;


public class FormCity {
    Stage stage;
    Label lblName, lblCountry, lblDistrict, lblPopulation;
    TextField txtName, txtDistrict, txtPopulation;
    ComboBox<String> comCountry;
    ListView<City> lvCities;
    Button btnNew, btnEdit, btnDelete;
    Button btnSave, btnCancel;
    HBox hBoxAddEditDel, hBoxSaveCancel;
    EnumFormState enumFormState;

    private City kabul, qandahar, herat, mazarelsharif;


    public FormCity() {

        kabul = new City("Kabul", "Afghanistan", "Kabol", 1780000L);
        qandahar = new City("Qandahar", "Afghanistan", "Qandahar", 237500L);
        herat = new City("Herat", "Afghanistan", "Herat", 186800L);
        mazarelsharif = new City("Mazar-e-Sharif", "Afghanistan", "Balkh", 731200L);


        // the grid
        GridPane grid = new GridPane();
        grid.setHgap(3);
        grid.setVgap(5);



        // name
        lblName = new Label("Name: ");
        txtName = new TextField();

        grid.add(lblName,1,0);
        GridPane.setHalignment(lblName, HPos.RIGHT);
        GridPane.setValignment(lblName, VPos.CENTER);

        grid.add(txtName,2,0);
        GridPane.setHalignment(txtName, HPos.LEFT);
        GridPane.setValignment(txtName, VPos.CENTER);


        // country

        lblCountry = new Label("Country: ");

        comCountry = new ComboBox<String>();
        comCountry.setEditable(true);
        comCountry.getItems().addAll("Aruba", "Afghanistan", "Angola", "Anguilla");
        new AutoCompleteComboBoxListener<>(comCountry);

        grid.add(lblCountry,1,1);
        GridPane.setHalignment(lblCountry, HPos.RIGHT);
        GridPane.setValignment(lblCountry, VPos.CENTER);

        grid.add(comCountry,2,1);
        GridPane.setHalignment(comCountry, HPos.LEFT);
        GridPane.setValignment(comCountry, VPos.CENTER);


        // District
        lblDistrict = new Label("District: ");
        txtDistrict = new TextField();

        grid.add(lblDistrict,1,2);
        GridPane.setHalignment(lblDistrict, HPos.RIGHT);
        GridPane.setValignment(lblDistrict, VPos.CENTER);

        grid.add(txtDistrict,2,2);
        GridPane.setHalignment(txtDistrict, HPos.LEFT);
        GridPane.setValignment(txtDistrict, VPos.CENTER);

        // Population
        lblPopulation = new Label("Population: ");
        txtPopulation = new TextField();

        grid.add(lblPopulation,1,3);
        GridPane.setHalignment(lblPopulation, HPos.RIGHT);
        GridPane.setValignment(lblPopulation, VPos.CENTER);

        grid.add(txtPopulation,2,3);
        GridPane.setHalignment(txtPopulation, HPos.LEFT);
        GridPane.setValignment(txtPopulation, VPos.CENTER);



        // buttons


        btnSave = new Button("Save");
        btnSave.setOnAction(e-> {
            if (validateForm()) {
                System.out.println("Validate: OK");
                if (enumFormState == EnumFormState.EDIT) {
                    City c = lvCities.getSelectionModel().getSelectedItem();
                    save_form(c);
                    enumFormState = EnumFormState.VIEW;
                    changeState(enumFormState, c);
                }
                else if (enumFormState == EnumFormState.ADD) {
                    City c = new City();
                    save_form(c);
                    enumFormState = EnumFormState.VIEW;
                    lvCities.getItems().add(c);
                    lvCities.getSelectionModel().select(c);
                    changeState(enumFormState, c);
                }
            }
        });
        btnCancel = new Button("Cancel");
        btnCancel.setOnAction(e->{
            enumFormState = EnumFormState.VIEW;
            changeState(enumFormState, lvCities.getSelectionModel().getSelectedItem());
        });
        hBoxSaveCancel = new HBox();
        hBoxSaveCancel.getChildren().addAll(btnSave, btnCancel);
        hBoxSaveCancel.setSpacing(10);
        hBoxSaveCancel.setAlignment(Pos.CENTER);
        grid.add(hBoxSaveCancel, 1, 14);
        GridPane.setRowSpan(hBoxSaveCancel, 2);


        // the listview
        lvCities = new ListView<>();
        lvCities.getItems().addAll(kabul, qandahar, herat, mazarelsharif);
        lvCities.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    load_form(newValue);
                    System.out.println(newValue);
                });
        grid.add(lvCities,0, 0);
        GridPane.setRowSpan(lvCities, grid.getRowCount()+1);
        GridPane.setHalignment(lvCities, HPos.LEFT);
        // buttons
        btnNew = new Button();
        btnNew.setGraphic(new ImageView(new Image("add35.png")));
        btnNew.setPrefWidth(lvCities.getWidth()/3-3);
        btnNew.setOnAction(e->{
            enumFormState = EnumFormState.ADD;
            changeState(enumFormState, null);
        });
        btnEdit = new Button();
        btnEdit.setGraphic(new ImageView(new Image("edit35.png")));
        btnEdit.setPrefWidth(lvCities.getWidth()/3-3);
        btnEdit.setOnAction(e->{
            enumFormState = EnumFormState.EDIT;
            changeState(enumFormState, lvCities.getSelectionModel().getSelectedItem());
        });
        btnDelete = new Button();
        btnDelete.setGraphic(new ImageView(new Image("del35.png")));
        btnDelete.setPrefWidth(lvCities.getWidth()/3-3);
        btnDelete.setOnAction(e->{
            MessageBoxOKCancel m = new MessageBoxOKCancel("Are you sure?","Warning!");
            boolean response = m.getResponse();
            if (response) {
                lvCities.getItems().remove(lvCities.getSelectionModel().getSelectedItem());
                if (lvCities.getItems().size()>0)
                    lvCities.getSelectionModel().select(0);
                else {
                    enumFormState = EnumFormState.ADD;
                    changeState(enumFormState, new City());
                }
            }
        });
        hBoxAddEditDel = new HBox();
        hBoxAddEditDel.getChildren().addAll(btnNew,btnEdit,btnDelete);
        hBoxAddEditDel.setSpacing(10);
        hBoxAddEditDel.setAlignment(Pos.CENTER);
        grid.add(hBoxAddEditDel, 0, grid.getRowCount()+1);

        // some more grid work
        GridPane.setColumnSpan(hBoxSaveCancel, 2);
        GridPane.setHalignment(hBoxSaveCancel, HPos.CENTER);
        grid.setPrefWidth(700);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(5));

        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPrefWidth(200);
        col0.setHalignment(HPos.LEFT);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.SOMETIMES);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.SOMETIMES);

        Region rEmpty = new Region();
        grid.add(rEmpty, 3,0);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHgrow(Priority.SOMETIMES);


        grid.getColumnConstraints().addAll(col0, col1, col2, col3);

        // the scene
        Scene scene = new Scene(grid);
        scene.heightProperty().addListener(
                (observable, oldValue, newValue)-> {
                    grid.setPrefHeight(scene.getHeight());
                    lvCities.setPrefHeight(scene.getHeight());
                });
        scene.widthProperty().addListener(
                (observable, oldValue, newValue)-> {
                    grid.setPrefWidth(scene.getWidth());
                });

        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Cities");
        stage.setX((Screen.getPrimary().getVisualBounds().getWidth()-700)/2);
        stage.setY((Screen.getPrimary().getVisualBounds().getHeight()-400)/2);
        stage.setWidth(700);
        stage.setHeight(400);
        stage.initModality(Modality.APPLICATION_MODAL);




        lvCities.getSelectionModel().select(0);
        enumFormState = EnumFormState.VIEW;
        changeState(enumFormState,lvCities.getSelectionModel().getSelectedItem());
        stage.show();

    }

    private boolean validateForm() {
        String errors = "";

        // Name: <=35 chars and non empty
        String name = txtName.getText();
        if (name.length() > 35) {
            errors += "Name must be <= 35 chars\n";
        }
        if (name.isBlank()) {
            errors += "Name can't be empty\n";
        }
        // Country: value should be in the list
        String country = comCountry.getValue().toString();
        ArrayList<String> al = new ArrayList<>();
        for (var item: comCountry.getItems())
            al.add(item.toString());
        if (!al.contains(country)) {
            errors += "Country must be a valid value\n";
        }
        // District: <=20 chars and non empty
        String district = txtDistrict.getText();
        if (district.length() > 20) {
            errors += "District must be <= 20 chars\n";
        }
        if (name.isBlank()) {
            errors += "District can't be empty\n";
        }
        // Population: must be long
        Long population = null;
        try {
            population = Long.valueOf(txtPopulation.getText());
        } catch (NumberFormatException ob) {
            if (txtPopulation.getText().length()>0)
                errors += "Population must be a number\n";
            else
                errors += "Population can't be empty\n";
        }

        if (errors.length()>0) {
            MessageBoxOK mb = new MessageBoxOK(errors, "ERRORS");
            return false;
        }
        else {
            String output =
                    "name: " + name + "\n" +
                            "country: " + country + "\n" +
                            "district: " + district + "\n" +
                            "population: " + population + "\n";
            System.out.println(output);
            return true;
        }
    }

    public void load_form(City c) {
        txtName.setText(c.getName());
        comCountry.setValue(c.getCountryCode());
        txtDistrict.setText(c.getDistrict());
        txtPopulation.setText(c.getPopulation().toString());
    }

    public void save_form(City c) {
        c.setName(txtName.getText());
        c.setCountryCode(comCountry.getValue());
        c.setDistrict(txtDistrict.getText());
        c.setPopulation(Long.valueOf(txtPopulation.getText()));
    }


    public void changeState(EnumFormState fs, City c) {
        switch(fs) {
            case ADD:
                txtName.setEditable(true);
                comCountry.setEditable(true);
                txtDistrict.setEditable(true);
                txtPopulation.setEditable(true);
                hBoxSaveCancel.setVisible(true);
                txtName.setText("");
                comCountry.setValue("");
                txtDistrict.setText("");
                txtPopulation.setText("");
                lvCities.setDisable(true);
                btnNew.setDisable(true);
                btnEdit.setDisable(true);
                btnDelete.setDisable(true);
                break;
            case EDIT:
                txtName.setEditable(true);
                comCountry.setEditable(true);
                txtDistrict.setEditable(true);
                txtPopulation.setEditable(true);
                load_form(c);
                hBoxSaveCancel.setVisible(true);
                lvCities.setDisable(true);
                btnNew.setDisable(true);
                btnEdit.setDisable(true);
                btnDelete.setDisable(true);
                break;
            case VIEW:
                txtName.setEditable(false);
                comCountry.setEditable(false);
                txtDistrict.setEditable(false);
                txtPopulation.setEditable(false);
                load_form(c);
                hBoxSaveCancel.setVisible(false);
                lvCities.setDisable(false);
                btnNew.setDisable(false);
                btnEdit.setDisable(false);
                btnDelete.setDisable(false);
        }
    }
}