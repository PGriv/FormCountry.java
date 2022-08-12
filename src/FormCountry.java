import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.*;


public class FormCountry {
    Stage stage;
    Label lblCode, lblName, lblContinent, lblRegion,
            lblSurfaceArea, lblIndepYear, lblPopulation,
            lblLifeExpectancy, lblGNP, lblLocalName,
            lblGovernmentForm, lblHeadOfState, lblCapital, lblCode2;
    TextField txtCode, txtName, txtRegion,
            txtSurfaceArea, txtIndepYear, txtPopulation,
            txtLifeExpectancy, txtGNP, txtLocalName,
            txtGovernmentForm, txtHeadOfState, txtCapital, txtCode2;
    ComboBox<String> comContinent;
    ListView<Country> lvCountries;
    Button btnNew, btnEdit, btnDelete;
    Button btnSave, btnCancel;
    HBox hBoxAddEditDel, hBoxSaveCancel;
    EnumFormState enumFormState;

    private Country aruba, afghanistan, angola, anguilla;


    public FormCountry() {

        aruba = new Country("ABW", "Aruba", "North America",
                "Caribbean", 193.0, null, 103000L,
                78.4, 828.0, 793.0,"Aruba",
                "Nonmetropolitan Territory of the Netherlands",
                "Beatrix", 129, "AW");
        afghanistan = new Country("AFG", "Afghanistan", "Asia",
                "Southern and Central Asia", 652090.0, 1919, 22720000L,
                45.9, 5976.0, null,"Afganistan",
                "Islamic Emirate",
                "Mohammad Omar", 1, "AF");
        angola = new Country("AGO", "Angola", "Africa",
                "Central Africa", 1246700.0, 1975, 12878000L,
                38.3, 6648.0, 7984.0,"Angola",
                "Republic",
                "Jose Eduardo dos Santos", 56, "AO");
        anguilla = new Country("AIA", "Anguilla", "North America",
                "Caribbean", 96.0, null, 8000L,
                76.1, 63.2, null,"Anguilla",
                "Dependent Territory of the UK",
                "Elisabeth II", 62, "AI");

        // the grid
        GridPane grid = new GridPane();
        grid.setHgap(3);
        grid.setVgap(5);




        // code
        lblCode = new Label("Code: ");
        txtCode = new TextField();

        grid.add(lblCode,1,0);
        GridPane.setHalignment(lblCode, HPos.RIGHT);
        GridPane.setValignment(lblCode, VPos.CENTER);

        grid.add(txtCode,2,0);
        GridPane.setHalignment(txtCode, HPos.LEFT);
        GridPane.setValignment(txtCode, VPos.CENTER);


        // name

        lblName = new Label("Name: ");
        txtName = new TextField();

        grid.add(lblName,1,1);
        GridPane.setHalignment(lblName, HPos.RIGHT);
        GridPane.setValignment(lblName, VPos.CENTER);

        grid.add(txtName,2,1);
        GridPane.setHalignment(txtName, HPos.LEFT);
        GridPane.setValignment(txtName, VPos.CENTER);


        // continent

        lblContinent = new Label("Continent: ");

        comContinent = new ComboBox<String>();
        comContinent.setEditable(true);
        comContinent.getItems().addAll("Africa", "Antarctica", "Asia", "Europe", "North America", "Oceania", "South America");
        new AutoCompleteComboBoxListener<>(comContinent);

        grid.add(lblContinent,1,2);
        GridPane.setHalignment(lblContinent, HPos.RIGHT);
        GridPane.setValignment(lblContinent, VPos.CENTER);

        grid.add(comContinent,2,2);
        GridPane.setHalignment(comContinent, HPos.LEFT);
        GridPane.setValignment(comContinent, VPos.CENTER);


        // region

        lblRegion = new Label("Region: ");

        txtRegion = new TextField();

        grid.add(lblRegion,1,3);
        GridPane.setHalignment(lblRegion, HPos.RIGHT);
        GridPane.setValignment(lblRegion, VPos.CENTER);

        grid.add(txtRegion,2,3);
        GridPane.setHalignment(txtRegion, HPos.LEFT);
        GridPane.setValignment(txtRegion, VPos.CENTER);


        // surface

        lblSurfaceArea = new Label("Surface Area: ");

        txtSurfaceArea = new TextField();

        grid.add(lblSurfaceArea,1,4);
        GridPane.setHalignment(lblSurfaceArea, HPos.RIGHT);
        GridPane.setValignment(lblSurfaceArea, VPos.CENTER);

        grid.add(txtSurfaceArea,2,4);
        GridPane.setHalignment(txtSurfaceArea, HPos.LEFT);
        GridPane.setValignment(txtSurfaceArea, VPos.CENTER);


        // independence year

        lblIndepYear = new Label("Independence Year: ");

        txtIndepYear = new TextField();

        grid.add(lblIndepYear,1,5);
        GridPane.setHalignment(lblIndepYear, HPos.RIGHT);
        GridPane.setValignment(lblIndepYear, VPos.CENTER);

        grid.add(txtIndepYear,2,5);
        GridPane.setHalignment(txtIndepYear, HPos.LEFT);
        GridPane.setValignment(txtIndepYear, VPos.CENTER);


        // population

        lblPopulation = new Label("Population: ");

        txtPopulation = new TextField();

        grid.add(lblPopulation,1,6);
        GridPane.setHalignment(lblPopulation, HPos.RIGHT);
        GridPane.setValignment(lblPopulation, VPos.CENTER);

        grid.add(txtPopulation,2,6);
        GridPane.setHalignment(txtPopulation, HPos.LEFT);
        GridPane.setValignment(txtPopulation, VPos.CENTER);


        // life expectancy

        lblLifeExpectancy = new Label("Life Expectancy: ");

        txtLifeExpectancy = new TextField();

        grid.add(lblLifeExpectancy,1,7);
        GridPane.setHalignment(lblLifeExpectancy, HPos.RIGHT);
        GridPane.setValignment(lblLifeExpectancy, VPos.CENTER);

        grid.add(txtLifeExpectancy,2,7);
        GridPane.setHalignment(txtLifeExpectancy, HPos.LEFT);
        GridPane.setValignment(txtLifeExpectancy, VPos.CENTER);


        // GNP

        lblGNP = new Label("GNP: ");

        txtGNP = new TextField();

        grid.add(lblGNP,1,8);
        GridPane.setHalignment(lblGNP, HPos.RIGHT);
        GridPane.setValignment(lblGNP, VPos.CENTER);

        grid.add(txtGNP,2,8);
        GridPane.setHalignment(txtGNP, HPos.LEFT);
        GridPane.setValignment(txtGNP, VPos.CENTER);


        // local name

        lblLocalName = new Label("Local Name: ");

        txtLocalName = new TextField();

        grid.add(lblLocalName,1,9);
        GridPane.setHalignment(lblLocalName, HPos.RIGHT);
        GridPane.setValignment(lblLocalName, VPos.CENTER);

        grid.add(txtLocalName,2,9);
        GridPane.setHalignment(txtLocalName, HPos.LEFT);
        GridPane.setValignment(txtLocalName, VPos.CENTER);


        // government form

        lblGovernmentForm = new Label("Government Form: ");

        txtGovernmentForm = new TextField();

        grid.add(lblGovernmentForm,1,10);
        GridPane.setHalignment(lblGovernmentForm, HPos.RIGHT);
        GridPane.setValignment(lblGovernmentForm, VPos.CENTER);

        grid.add(txtGovernmentForm,2,10);
        GridPane.setHalignment(txtGovernmentForm, HPos.LEFT);
        GridPane.setValignment(txtGovernmentForm, VPos.CENTER);


        // head of state

        lblHeadOfState = new Label("Head of State: ");

        txtHeadOfState = new TextField();

        grid.add(lblHeadOfState,1,11);
        GridPane.setHalignment(lblHeadOfState, HPos.RIGHT);
        GridPane.setValignment(lblHeadOfState, VPos.CENTER);

        grid.add(txtHeadOfState,2,11);
        GridPane.setHalignment(txtHeadOfState, HPos.LEFT);
        GridPane.setValignment(txtHeadOfState, VPos.CENTER);


        // capital

        lblCapital = new Label("Capital: ");

        txtCapital = new TextField();

        grid.add(lblCapital,1,12);
        GridPane.setHalignment(lblCapital, HPos.RIGHT);
        GridPane.setValignment(lblCapital, VPos.CENTER);

        grid.add(txtCapital,2,12);
        GridPane.setHalignment(txtCapital, HPos.LEFT);
        GridPane.setValignment(txtCapital, VPos.CENTER);


        // code 2

        lblCode2 = new Label("Code2: ");

        txtCode2 = new TextField();

        grid.add(lblCode2,1,13);
        GridPane.setHalignment(lblCode2, HPos.RIGHT);
        GridPane.setValignment(lblCode2, VPos.CENTER);

        grid.add(txtCode2,2,13);
        GridPane.setHalignment(txtCode2, HPos.LEFT);
        GridPane.setValignment(txtCode2, VPos.CENTER);


        // buttons


        btnSave = new Button("Save");
        btnSave.setOnAction(e-> {
            if (validateForm()) {
                System.out.println("Validate: OK");
                if (enumFormState == EnumFormState.EDIT) {
                    Country c = lvCountries.getSelectionModel().getSelectedItem();
                    save_form(c);
                    enumFormState = EnumFormState.VIEW;
                    changeState(enumFormState, c);
                }
                else if (enumFormState == EnumFormState.ADD) {
                    Country c = new Country();
                    save_form(c);
                    enumFormState = EnumFormState.VIEW;
                    lvCountries.getItems().add(c);
                    lvCountries.getSelectionModel().select(c);
                    changeState(enumFormState, c);
                }
            }
        });
        btnCancel = new Button("Cancel");
        btnCancel.setOnAction(e->{
            enumFormState = EnumFormState.VIEW;
            changeState(enumFormState, lvCountries.getSelectionModel().getSelectedItem());
        });
        hBoxSaveCancel = new HBox();
        hBoxSaveCancel.getChildren().addAll(btnSave, btnCancel);
        hBoxSaveCancel.setSpacing(10);
        hBoxSaveCancel.setAlignment(Pos.CENTER);
        grid.add(hBoxSaveCancel, 1, 14);
        GridPane.setRowSpan(hBoxSaveCancel, 2);


        // the listview
        lvCountries = new ListView<>();
        loadFile("countries.data");
        lvCountries.getItems().addAll(aruba, afghanistan, angola, anguilla);
        lvCountries.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    load_form(newValue);
                    System.out.println(newValue);
                });
        grid.add(lvCountries,0, 0);
        GridPane.setRowSpan(lvCountries, grid.getRowCount()+1);
        GridPane.setHalignment(lvCountries, HPos.LEFT);
        // buttons
        btnNew = new Button();
        btnNew.setGraphic(new ImageView(new Image("add35.png")));
        btnNew.setPrefWidth(lvCountries.getWidth()/3-3);
        btnNew.setOnAction(e->{
            enumFormState = EnumFormState.ADD;
            changeState(enumFormState, null);
        });
        btnEdit = new Button();
        btnEdit.setGraphic(new ImageView(new Image("edit35.png")));
        btnEdit.setPrefWidth(lvCountries.getWidth()/3-3);
        btnEdit.setOnAction(e->{
            enumFormState = EnumFormState.EDIT;
            changeState(enumFormState, lvCountries.getSelectionModel().getSelectedItem());
        });
        btnDelete = new Button();
        btnDelete.setGraphic(new ImageView(new Image("del35.png")));
        btnDelete.setPrefWidth(lvCountries.getWidth()/3-3);
        btnDelete.setOnAction(e->{
            MessageBoxOKCancel m = new MessageBoxOKCancel("Are you sure?","Warning!");
            boolean response = m.getResponse();
            if (response) {
                lvCountries.getItems().remove(lvCountries.getSelectionModel().getSelectedItem());
                if (lvCountries.getItems().size()>0)
                    lvCountries.getSelectionModel().select(0);
                else {
                    enumFormState = EnumFormState.ADD;
                    changeState(enumFormState, new Country());
                }
            }
        });
        hBoxAddEditDel = new HBox();
        hBoxAddEditDel.getChildren().addAll(btnNew,btnEdit,btnDelete);
        hBoxAddEditDel.setSpacing(10);
        hBoxAddEditDel.setAlignment(Pos.CENTER);
        grid.add(hBoxAddEditDel, 0, grid.getRowCount()+1);

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

        Scene scene = new Scene(grid);
        scene.heightProperty().addListener(
                (observable, oldValue, newValue)-> {
                    grid.setPrefHeight(scene.getHeight());
                    lvCountries.setPrefHeight(scene.getHeight());
                });
        scene.widthProperty().addListener(
                (observable, oldValue, newValue)-> {
                    grid.setPrefWidth(scene.getWidth());
                });

        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Countries");
        stage.setX((Screen.getPrimary().getVisualBounds().getWidth()-700)/2);
        stage.setY((Screen.getPrimary().getVisualBounds().getHeight()-600)/2);
        stage.setWidth(700);
        stage.setHeight(600);
        stage.initModality(Modality.APPLICATION_MODAL);




        lvCountries.getSelectionModel().select(0);
        enumFormState = EnumFormState.VIEW;
        changeState(enumFormState,lvCountries.getSelectionModel().getSelectedItem());
        stage.setOnCloseRequest(e->{
            saveFile("countries.data");
        });
        stage.show();

    }

    private boolean validateForm() {
        String errors = "";

        String code = txtCode.getText();
        if (code.length() != 3) {
            errors += "Code must be 3 characters\n";
        }

        String name = txtName.getText();
        if (name.length() > 52) {
            errors += "Name must be less or equal than 52 characters\n";
        }
        if (name.isBlank()) {
            errors += "Name can not be empty\n";
        }

        String continent = comContinent.getValue();
        if (!comContinent.getItems().contains(continent)) {
            errors += "Continent must be included in the list\n";
        }

        String region = txtRegion.getText();
        if (region.length() > 26) {
            errors += "Region must be less or equal to 26 characters\n";
        }
        if (region.isBlank()) {
            errors += "Region can not be empty\n";
        }

        Double surfaceArea = null;
        try {
            surfaceArea = Double.valueOf(txtSurfaceArea.getText());
        } catch (NumberFormatException ob) {
            errors += "Surface Area must be a number\n";
        }

        Integer indepYear = null;
        try {
            indepYear = Integer.valueOf(txtIndepYear.getText());
            if (indepYear>9999)
                errors += "Invalid IndepYear\n";
        } catch (NumberFormatException ob) {
            if (txtIndepYear.getText().length()>0)
                errors += "Indep Year must be a number\n";
        }

        Long population = null;
        try {
            population = Long.valueOf(txtPopulation.getText());
            if (population<0 || population>10000000000L)
                errors += "Invalid Population\n";
        } catch (NumberFormatException ob) {
            errors += "Population must be a number\n";
        }

        Double lifeExpectancy = null;
        try {
            lifeExpectancy = Double.valueOf(txtLifeExpectancy.getText());
        } catch (NumberFormatException ob) {
            if (txtLifeExpectancy.getText().length()!=0)
                errors += "Life Expectancy must be a number\n";
        }

        Double GNP = null;
        try {
            GNP = Double.valueOf(txtGNP.getText());
        } catch (NumberFormatException ob) {
            if (txtGNP.getText().length()!=0)
                errors += "GNP must be a number\n";
        }

        String localName = txtLocalName.getText();
        if (localName.length() > 45) {
            errors += "Local Name must be less or equal to 26 characters\n";
        }
        if (localName.isBlank()) {
            errors += "Local Name can not be empty\n";
        }

        String governmentForm = txtGovernmentForm.getText();
        if (governmentForm.length() > 45) {
            errors += "GovernmentForm must be less or equal to 45 characters\n";
        }
        if (governmentForm.isBlank()) {
            errors += "Government Form can not be empty\n";
        }

        String headOfState = txtHeadOfState.getText();
        if (headOfState.length() > 60) {
            errors += "GovernmentForm must be less or equal to 60 characters\n";
        }

        Integer capital = null;
        try {
            capital = Integer.valueOf(txtCapital.getText());
        } catch (NumberFormatException ob) {
            if (txtCapital.getText().length()!=0)
                errors += "Capital must be an integer\n";
        }

        String code2 = txtCode2.getText();
        if (code2.length() != 2) {
            errors += "Code2 must be 2 characters\n";
        }
        if (code2.isBlank()) {
            errors += "Code2 can not be empty\n";
        }

        if (errors.length()>0) {
            MessageBoxOK mb = new MessageBoxOK(errors, "ERRORS");
            return false;
        }
        else {
            String output =
                    "code: " + code + "\n" +
                            "name: " + name + "\n" +
                            "continent: " + continent + "\n" +
                            "region: " + region + "\n" +
                            "surface area: " + surfaceArea + "\n" +
                            "independence year: " + indepYear + "\n" +
                            "population: " + population + "\n" +
                            "life expectancy: " + lifeExpectancy + "\n" +
                            "GNP: " + GNP + "\n" +
                            "local name: " + localName + "\n" +
                            "government form: " + governmentForm + "\n" +
                            "head of state: " + headOfState + "\n" +
                            "capital: " + capital + "\n" +
                            "code2: " + code2 + "\n";
            System.out.println(output);
            return true;
        }
    }

    public void load_form(Country c) {
        txtCode.setText(c.getCode());
        txtName.setText(c.getName());
        comContinent.setValue(c.getContinent());
        txtRegion.setText(c.getRegion());
        txtSurfaceArea.setText(c.getSurfaceArea().toString());
        txtIndepYear.setText(c.getIndepYear()==null?"":c.getIndepYear().toString());
        txtPopulation.setText(c.getPopulation().toString());
        txtLifeExpectancy.setText(c.getLifeExpectancy()==null?"":c.getLifeExpectancy().toString());
        txtGNP.setText(c.getGNP()==null?"":c.getGNP().toString());
        txtLocalName.setText(c.getLocalName());
        txtGovernmentForm.setText(c.getGovernmentForm());
        txtHeadOfState.setText(c.getHeadOfState()==null?"":c.getHeadOfState());
        txtCapital.setText(c.getCapital()==null?"":c.getCapital().toString());
        txtCode2.setText(c.getCode2());
    }

    public void save_form(Country c) {
        c.setCode(txtCode.getText());
        c.setName(txtName.getText());
        c.setContinent(comContinent.getValue());
        c.setRegion(txtRegion.getText());
        c.setSurfaceArea(Double.valueOf(txtSurfaceArea.getText()));
        c.setIndepYear(txtIndepYear.getText().equals("")?null:Integer.valueOf(txtIndepYear.getText()));
        c.setPopulation(Long.valueOf(txtPopulation.getText()));
        c.setLifeExpectancy(txtLifeExpectancy.getText().equals("")?null:Double.valueOf(txtLifeExpectancy.getText()));
        c.setGNP(txtGNP.getText().equals("")?null:Double.valueOf(txtGNP.getText()));
        c.setLocalName(txtLocalName.getText());
        c.setGovernmentForm(txtGovernmentForm.getText());
        c.setHeadOfState(txtHeadOfState.getText().equals("")?null:txtHeadOfState.getText());
        c.setCapital(txtCapital.getText().equals("")?null:Integer.valueOf(txtCapital.getText()));
        c.setCode2(txtCode2.getText());
    }


    public void changeState(EnumFormState fs, Country c) {
        switch(fs) {
            case ADD:
                txtCode.setEditable(true);
                txtName.setEditable(true);
                comContinent.setEditable(true);
                txtRegion.setEditable(true);
                txtSurfaceArea.setEditable(true);
                txtIndepYear.setEditable(true);
                txtPopulation.setEditable(true);
                txtLifeExpectancy.setEditable(true);
                txtGNP.setEditable(true);
                txtLocalName.setEditable(true);
                txtGovernmentForm.setEditable(true);
                txtHeadOfState.setEditable(true);
                txtCapital.setEditable(true);
                txtCode2.setEditable(true);
                txtCode.setText("");
                txtName.setText("");
                comContinent.setValue("");
                txtRegion.setText("");
                txtSurfaceArea.setText("");
                txtIndepYear.setText("");
                txtPopulation.setText("");
                txtLifeExpectancy.setText("");
                txtGNP.setText("");
                txtLocalName.setText("");
                txtGovernmentForm.setText("");
                txtHeadOfState.setText("");
                txtCapital.setText("");
                txtCode2.setText("");
                hBoxSaveCancel.setVisible(true);
                lvCountries.setDisable(true);
                btnNew.setDisable(true);
                btnEdit.setDisable(true);
                btnDelete.setDisable(true);
                break;
            case EDIT:
                txtCode.setEditable(true);
                txtName.setEditable(true);
                comContinent.setEditable(true);
                txtRegion.setEditable(true);
                txtSurfaceArea.setEditable(true);
                txtIndepYear.setEditable(true);
                txtPopulation.setEditable(true);
                txtLifeExpectancy.setEditable(true);
                txtGNP.setEditable(true);
                txtLocalName.setEditable(true);
                txtGovernmentForm.setEditable(true);
                txtHeadOfState.setEditable(true);
                txtCapital.setEditable(true);
                txtCode2.setEditable(true);
                load_form(c);
                hBoxSaveCancel.setVisible(true);
                lvCountries.setDisable(true);
                btnNew.setDisable(true);
                btnEdit.setDisable(true);
                btnDelete.setDisable(true);
                break;
            case VIEW:
                txtCode.setEditable(false);
                txtName.setEditable(false);
                comContinent.setEditable(false);
                txtRegion.setEditable(false);
                txtSurfaceArea.setEditable(false);
                txtIndepYear.setEditable(false);
                txtPopulation.setEditable(false);
                txtLifeExpectancy.setEditable(false);
                txtGNP.setEditable(false);
                txtLocalName.setEditable(false);
                txtGovernmentForm.setEditable(false);
                txtHeadOfState.setEditable(false);
                txtCapital.setEditable(false);
                txtCode2.setEditable(false);
                load_form(c);
                hBoxSaveCancel.setVisible(false);
                lvCountries.setDisable(false);
                btnNew.setDisable(false);
                btnEdit.setDisable(false);
                btnDelete.setDisable(false);

        }
    }
    public  void  saveFile(String filename){
        File f = new File(filename);

        try(ObjectOutputStream os= new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(f)))){
            for(var country:lvCountries.getItems())
                os.writeObject(country);
        }catch (IOException ignored){
        }
    }
    public void loadFile(String filename){
        File f = new File(filename);
        try(ObjectInputStream os = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(f)))){
            while (true)
                lvCountries.getItems().add((Country) os.readObject());
        }catch (IOException | ClassNotFoundException ignored){
        }
    }
}