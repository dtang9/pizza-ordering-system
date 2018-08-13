package order;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OrderSystem extends Application {
	public void start(Stage welcomeStage) throws Exception {
		
		Label welcomeLabel = new Label("Welcome to our Pizza Restaurant!");
		ImageView pizzaImageView = new ImageView("file:res/images/pizza.png");
		pizzaImageView.setFitHeight(100);
		pizzaImageView.setFitWidth(100);
		Button startButton = new Button("Start");
		
		Button continueButton = new Button("Continue");
		GridPane welcomePane = new GridPane();
		welcomePane.setAlignment(Pos.CENTER);
		welcomePane.setVgap(8);
		welcomePane.add(welcomeLabel, 3, 1);
		welcomePane.add(pizzaImageView, 3, 2);
		welcomePane.add(startButton, 3, 3);
		
		Scene welcomeScene = new Scene(welcomePane, 200, 200);
		welcomeStage.setTitle("Order System");
		welcomeStage.setScene(welcomeScene);
		welcomeStage.show();
		
		Label customerInfoLabel = new Label("Customer Information");
		Label nameLabel = new Label("Name: ");
		Label streetLabel = new Label("Street: ");
		Label cityLabel = new Label("City: ");
		Label zipcodeLabel = new Label("Zipcode: ");
		Label phoneLabel = new Label("Phone: ");
		TextField nameField = new TextField();
		TextField streetField = new TextField();
		TextField cityField = new TextField();
		TextField zipcodeField = new TextField();
		TextField phoneField = new TextField();

		GridPane customerInfoPane = new GridPane();
		customerInfoPane.setAlignment(Pos.CENTER);
		customerInfoPane.setVgap(8);
		
		customerInfoPane.add(customerInfoLabel, 1, 0);
		customerInfoPane.add(nameLabel, 1, 1);
		customerInfoPane.add(streetLabel, 1, 2);
		customerInfoPane.add(cityLabel, 1, 3);
		customerInfoPane.add(zipcodeLabel, 1, 4);
		customerInfoPane.add(phoneLabel, 1, 5);
		
		customerInfoPane.add(nameField, 2, 1);
		customerInfoPane.add(streetField, 2, 2);
		customerInfoPane.add(cityField, 2, 3);
		customerInfoPane.add(zipcodeField, 2, 4);
		customerInfoPane.add(phoneField, 2, 5);
		
		customerInfoPane.add(continueButton, 2, 6);
		
		Scene customerScene = new Scene(customerInfoPane, 300, 300);

		Label pizzaCustomizationLabel = new Label("Customize your pizza");
		Label meatLabel = new Label("Meat: ");
		Label vegetableLabel = new Label("Vegetable: ");
		Label cheeseLabel = new Label("Cheese: ");
		Label crustLabel = new Label("Crust: ");
		Label sizeLabel = new Label("Size: ");
		Label numOfPizzaLabel = new Label("Number of Pizza: ");
		
		ComboBox<String> meatComboBox = new ComboBox<String>();
		meatComboBox.getItems().addAll("Pepperoni", "Sausage", "Bacon", "None");
		meatComboBox.setValue("Pepperoni");
		
		ComboBox<String> vegetableComboBox = new ComboBox<String>();
		vegetableComboBox.getItems().addAll("Olive", "Tomato", "Mushroom", "Onion", "None");
		vegetableComboBox.setValue("None");
		
		ComboBox<String> cheeseComboBox = new ComboBox<String>();
		cheeseComboBox.getItems().addAll("Normal", "Light", "None");
		cheeseComboBox.setValue("Normal");
		
		ComboBox<String> crustComboBox = new ComboBox<String>();
		crustComboBox.getItems().addAll("Original", "Thin", "Pan");
		crustComboBox.setValue("Original");
		
		ComboBox<String> sizeComboBox = new ComboBox<String>();
		sizeComboBox.getItems().addAll("Large", "Medium", "Small");
		sizeComboBox.setValue("Medium");
		
		Spinner<Integer> numOfPizzaSpinner = new Spinner(1, 20, 1);
		
		TextField priceField = new TextField();
		Button checkoutButton = new Button("Check out");
		GridPane pizzaPane = new GridPane();
		pizzaPane.setAlignment(Pos.CENTER);
		pizzaPane.setVgap(8);
		
		pizzaPane.add(pizzaCustomizationLabel, 1, 0);
		pizzaPane.add(meatLabel, 1, 1);
		pizzaPane.add(vegetableLabel, 1, 2);
		pizzaPane.add(cheeseLabel, 1, 3);
		pizzaPane.add(crustLabel, 1, 4);
		pizzaPane.add(sizeLabel, 1, 5);
		pizzaPane.add(numOfPizzaLabel, 1, 6);
		
		pizzaPane.add(meatComboBox, 2, 1);
		pizzaPane.add(vegetableComboBox, 2, 2);
		pizzaPane.add(cheeseComboBox, 2, 3);
		pizzaPane.add(crustComboBox, 2, 4);
		pizzaPane.add(sizeComboBox, 2, 5);
		pizzaPane.add(numOfPizzaSpinner, 2, 6);
		pizzaPane.add(priceField, 2, 7);
		pizzaPane.add(checkoutButton, 2, 8);
		
		Scene pizzaScene = new Scene(pizzaPane, 300, 300);
		
		startButton.setOnAction(e -> {
			welcomeStage.setScene(customerScene);
			welcomeStage.show();
		});
		
		continueButton.setOnAction(e -> {
			Customer customer = new Customer(nameField.getText(), streetField.getText(),
			   cityField.getText(), zipcodeField.getText());
			welcomeStage.setScene(pizzaScene);
		});
		
		checkoutButton.setOnAction(e -> {
			Pizza myPizza = new Pizza(meatComboBox.getValue(), vegetableComboBox.getValue(),
			   cheeseComboBox.getValue(), crustComboBox.getValue(), sizeComboBox.getValue(),
			   numOfPizzaSpinner.getValue());
			priceField.setText(myPizza.getPrice());
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
