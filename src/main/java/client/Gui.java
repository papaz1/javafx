package client;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.PriceCalculate;
import pricing.PriceService;
import util.Settings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gui extends Application {
    private TableView table;
    private ObservableList<TableViewModel> tableData;

    public void start(Stage stage) throws Exception {
        Button buttonSearch = new Button("Search");
        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout);
        scene.setOnKeyPressed(event -> {
                    if (event.getCode() == (KeyCode.ENTER)) {
                        buttonSearch.fire();
                    }
                }
        );
        table = new TableView();
        tableData = FXCollections.observableArrayList();

        PriceService priceService = new PriceService();

        stage.setTitle("OPP");
        stage.setWidth(590);
        stage.setHeight(640);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        Label labelSite = new Label("Site");
        gridPane.add(labelSite, 0, 0);
        TextField textFieldSite = new TextField();
        textFieldSite.setMaxWidth(45);
        textFieldSite.setPromptText("site");
        gridPane.add(textFieldSite, 1, 0);

        Label labelArticle = new Label("Article");
        gridPane.add(labelArticle, 0, 1);
        TextField textFieldArticle = new TextField();
        textFieldArticle.setMinWidth(320);
        textFieldArticle.setPromptText("article1,article2,article3");
        gridPane.add(textFieldArticle, 1, 1);


        buttonSearch.setDisable(true);
        buttonSearch.setOnAction(event -> {
            List<String> articles;
            try {
                articles = parseArticles(textFieldArticle.getCharacters());
                buttonSearch.setDisable(true);
                PriceCalculate priceCalculate = priceService.readPrice(articles, textFieldSite.getCharacters().toString());
                List<TableViewModel> tableViewModel = TableViewModelFactory.createTableViewModel(priceCalculate);
                populateTable(tableViewModel);
                buttonSearch.setDisable(false);
            } catch (Exception e) {
                buttonSearch.setDisable(false);
                Text text = new Text(e.getMessage());
                text.setWrappingWidth(300);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.getDialogPane().setContent(text);
                alert.showAndWait();
            }
        });

        textFieldArticle.setOnKeyReleased(event -> {
            checkInputValue(textFieldSite, textFieldArticle, buttonSearch);
        });
        textFieldSite.setOnKeyReleased(event -> {
            checkInputValue(textFieldSite, textFieldArticle, buttonSearch);
        });

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(buttonSearch);
        gridPane.add(hBox, 1, 2);

        TableColumn colSale = new TableColumn("ItemId");
        colSale.setCellValueFactory(new PropertyValueFactory<TableViewModel, String>("saleItemId"));
        makeHeaderWrappable(colSale);
        colSale.setMinWidth(120);

        TableColumn colRegularSales = new TableColumn("RegSalesPrice");
        colRegularSales.setCellValueFactory(new PropertyValueFactory<TableViewModel, String>("regularSalesUnitPrice"));
        makeHeaderWrappable(colRegularSales);
        colRegularSales.setMinWidth(110);

        TableColumn colExtendedAmount = new TableColumn("ExtAmount");
        colExtendedAmount.setCellValueFactory(new PropertyValueFactory<TableViewModel, String>("extendedAmount"));
        makeHeaderWrappable(colExtendedAmount);
        colExtendedAmount.setMinWidth(110);

        TableColumn colExtendedDiscountAmount = new TableColumn("ExtDiscAmount");
        colExtendedDiscountAmount.setCellValueFactory(new PropertyValueFactory<TableViewModel, String>("extendedDiscountAmount"));
        makeHeaderWrappable(colExtendedDiscountAmount);
        colExtendedDiscountAmount.setMinWidth(110);

        TableColumn colCurrency = new TableColumn("Currency");
        colCurrency.setMinWidth(100);
        makeHeaderWrappable(colCurrency);
        colCurrency.setCellValueFactory(new PropertyValueFactory<TableViewModel, String>("currency"));

        table.getColumns().addAll(colSale, colRegularSales, colExtendedAmount, colExtendedDiscountAmount, colCurrency);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(gridPane, table);
        VBox.setVgrow(table, Priority.ALWAYS);

        layout.setCenter(vbox);
        stage.setScene(scene);
        stage.show();

        /*
          This is done here just to verify that the settings file exists. It's a singleton
          class so there won't be an unnecssary creation of the object.
         */
        try {
            final Settings settings = Settings.getInstance();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Settings file not found");
            alert.setOnHidden(new EventHandler<DialogEvent>() {
                @Override
                public void handle(DialogEvent event) {
                    System.exit(0);
                }
            });
            alert.showAndWait();
        }
    }

    private void leftAlignColumHeaderText(TableColumn column) {
        column.getStyleClass().add("leftAlignedTableColumnHeader");
    }

    private void populateTable(List<TableViewModel> tableViewModels) {
        tableData.clear();
        for (TableViewModel tableVioewModel : tableViewModels) {
            tableData.add(tableVioewModel);
        }
        table.setItems(tableData);
        table.refresh();
    }

    private void checkInputValue(TextField textFieldSite, TextField textFieldArticle, Button buttonSearch) {
        if (!textFieldArticle.getCharacters().toString().trim().isEmpty() &&
                !textFieldSite.getCharacters().toString().trim().isEmpty()) {
            buttonSearch.setDisable(false);
        } else {
            buttonSearch.setDisable(true);
        }
    }

    private List<String> parseArticles(CharSequence textFieldArticleCharacters) throws Exception {
        List<String> articles = new ArrayList<>();
        String articlesInput = textFieldArticleCharacters.toString();

        String[] numberOfArticleNumbers = articlesInput.split(",");
        int numberOfCommas = 0;
        for (int i = 0; i < articlesInput.length(); i++) {
            if (articlesInput.charAt(i) == ',') {
                numberOfCommas++;
            }
        }

        if (numberOfCommas >= numberOfArticleNumbers.length) {
            throw new Exception("Incorrect article format");
        }

        Scanner scanner = new Scanner(articlesInput);
        scanner.useDelimiter(",");

        if (articlesInput.isEmpty()) {
            throw new Exception("Incorrect article format");
        }

        while (scanner.hasNext()) {
            String partOfString = scanner.next();
            articles.add(partOfString);
        }
        return articles;
    }

    private void makeHeaderWrappable(TableColumn col) {
        Label label = new Label(col.getText());
        label.setStyle("-fx-padding: 8px;");
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER_LEFT);
        label.setTextAlignment(TextAlignment.LEFT);

        StackPane stack = new StackPane();
        stack.getChildren().add(label);
        stack.prefWidthProperty().bind(col.widthProperty().subtract(5));
        label.prefWidthProperty().bind(stack.prefWidthProperty());
        col.setText(null);
        col.setGraphic(stack);
    }
}
