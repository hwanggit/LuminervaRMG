/* Import JavaFX packages */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import java.util.Random;
import java.lang.Math;

/* Random Math Generator Widget: generates random algebra or 
   trigonometry questions and accumulates points for solving them */

public class RandomMathGenerator extends Application {

    @Override
    public void start(Stage stage) {
		// Create score label
		var scoreWrapper = new Object(){
			int score = 0;
		};
		Label scoreLbl = new Label();
		Label scoreText = new Label("Score: ");
		scoreLbl.getStyleClass().add("score");
		scoreLbl.setText(scoreWrapper.score+"");
		scoreText.setStyle("-fx-font-size: 15px;");
	
		// Add padding for top menu
		Region hpadding = new Region();
		hpadding.getStyleClass().add("padding");	
	
		// Add padding for side menu
		Region vpadding = new Region();
		vpadding.getStyleClass().add("padding");

		// Make app title
		Label appName = new Label("Random Math Generator");
		appName.getStyleClass().add("title");

		// Create menu items
		MenuItem Trig = new MenuItem("Trigonometry");
		MenuItem Algebra = new MenuItem("Algebra");	
		MenuItem Any = new MenuItem("Any");

		// Create menu button
		MenuButton modeBtn = new MenuButton("Any", null, Any, Trig, Algebra);
		modeBtn.getStyleClass().add("mode");
		
		// Replace button text with selected item on click
		Trig.setOnAction(e -> {
            modeBtn.setText(Trig.getText());
        });
		Algebra.setOnAction(e -> {
			modeBtn.setText(Algebra.getText());
		});
		Any.setOnAction(e -> {
			modeBtn.setText(Any.getText());
		});
	
		// Create generate button
		Button generate = new Button("Generate");
		generate.getStyleClass().add("generate");
				
		// Create side menu
		VBox banner = new VBox();
		banner.getChildren().addAll(modeBtn, vpadding, scoreText, scoreLbl);
		banner.setVgrow(vpadding, Priority.ALWAYS);
		
		// Create top menu
		HBox titleBanner = new HBox();
		titleBanner.getChildren().addAll(appName, hpadding, generate);
		titleBanner.setHgrow(hpadding, Priority.ALWAYS);		
	
		// Align side menu
		StackPane sideMenu = new StackPane();
		sideMenu.getChildren().addAll(banner);
		sideMenu.getStyleClass().add("background");
		
		// Align top menu
		StackPane topMenu = new StackPane();
		topMenu.getChildren().addAll(titleBanner);
		topMenu.getStyleClass().add("background");
		
		// Add display question area
		Label question = new Label();
		question.getStyleClass().add("question");				

		// Prompt to ask the user to select option
		Label prompt = new Label("Find a solution for X");
		
		// Add 4 choices
		Button choiceA = new Button();
		Button choiceB = new Button();		
		Button choiceC = new Button();		
		Button choiceD = new Button();
		StyleButton(choiceA, "");		
		StyleButton(choiceB, "");		
		StyleButton(choiceC, "");		
		StyleButton(choiceD, "");		
			
		// Create options
		String [] options = new String[4];
		
		// Store right answer
		var correctWrapper = new Object(){
			String correct = "";
		};	

		// When click generate, generate new equation
		generate.setOnAction(e -> {
			if (modeBtn.getText() == "Algebra" || modeBtn.getText() == "Any") {
				correctWrapper.correct = options[getRandAlgebra(question, options)];
				StyleButton(choiceA, options[0]);		
				StyleButton(choiceB, options[1]);		
				StyleButton(choiceC, options[2]);		
				StyleButton(choiceD, options[3]);		
			}			
		});
		
		// Set option click actions
		choiceA.setOnAction(e -> {
			// Get the correct text
			String correct = correctWrapper.correct;
			
			// Get color of button
			String color = "" + choiceA.getBackground().getFills().get(0).getFill();
			if (!color.equals("0xf0df91ff")) {
				return;
			}
	
			if (correct != "" && choiceA.getText() != "") {
				if (choiceA.getText().equals(correct)) {
					choiceA.setStyle("-fx-background-color: green;");
					scoreWrapper.score++;
					scoreLbl.setText(scoreWrapper.score+"");
				}
				else {
					scoreWrapper.score--;
					scoreLbl.setText(scoreWrapper.score+"");
					choiceA.setStyle("-fx-background-color: red;");
				}
			}	
		});
		
		choiceB.setOnAction(e -> {
			// Get the correct text
			String correct = correctWrapper.correct;

			// Get color of button
			String color = "" + choiceB.getBackground().getFills().get(0).getFill();
			if (!color.equals("0xf0df91ff")) {
				return;
			}
				
			if (correct != "" && choiceB.getText() != "") {
				if (choiceB.getText().equals(correct)) {
					choiceB.setStyle("-fx-background-color: green;");
					scoreWrapper.score++;
					scoreLbl.setText(scoreWrapper.score+"");
				}
				else {
					scoreWrapper.score--;
					scoreLbl.setText(scoreWrapper.score+"");
					choiceB.setStyle("-fx-background-color: red;");
				}
			}	
		});
		
		choiceC.setOnAction(e -> {
			// Get the correct text
			String correct = correctWrapper.correct;

			// Get color of button
			String color = "" + choiceC.getBackground().getFills().get(0).getFill();
			if (!color.equals("0xf0df91ff")) {
				return;
			}
				
			if (correct != "" && choiceC.getText() != "") {
				if (choiceC.getText().equals(correct)) {
					choiceC.setStyle("-fx-background-color: green;");
					scoreWrapper.score++;
					scoreLbl.setText(scoreWrapper.score+"");
				}
				else {
					scoreWrapper.score--;
					scoreLbl.setText(scoreWrapper.score+"");
					choiceC.setStyle("-fx-background-color: red;");
				}
			}	
		});
		
		choiceD.setOnAction(e -> {
			// Get the correct text
			String correct = correctWrapper.correct;

			// Get color of button
			String color = "" + choiceD.getBackground().getFills().get(0).getFill();
			if (!color.equals("0xf0df91ff")) {
				return;
			}
				
			if (correct != "" && choiceD.getText() != "") {
				if (choiceD.getText().equals(correct)) {
					choiceD.setStyle("-fx-background-color: green;");
					scoreWrapper.score++;
					scoreLbl.setText(scoreWrapper.score+"");
				}
				else {
					scoreWrapper.score--;
					scoreLbl.setText(scoreWrapper.score+"");
					choiceD.setStyle("-fx-background-color: red;");
				}
			}	
		});
				
		// Create layout for question area
		VBox questionArea = new VBox();
		questionArea.getChildren().addAll(question, prompt, choiceA, choiceB, choiceC, choiceD);
		questionArea.setAlignment(Pos.CENTER);
		questionArea.setSpacing(30);

		// Create main display area for questions	
		StackPane displayArea = new StackPane();
		displayArea.getChildren().add(questionArea);
			
		// Main layout, set top and left menus
		BorderPane layout = new BorderPane();
		layout.setTop(topMenu);
		layout.setLeft(sideMenu);
		layout.setCenter(displayArea);

		// Create scene and add styles
		Scene scene = new Scene(layout, 800, 600);
        scene.getStylesheets().add("Styles/gamestyles.css");
		
		// Stage scene and show
		stage.setScene(scene);
        stage.setTitle("Luminerva RMG");
		stage.show();
    }
	

	/* Add width style to button */
	public void StyleButton(Button thisBtn, String option) {
		thisBtn.getStyleClass().add("choice");	
		thisBtn.setStyle("-fx-background-color: #F0DF91");
		thisBtn.setText(option);
	}
	
	/* Get random algebra question, returns index of right answer */
	public int getRandAlgebra(Label question, String [] options) {
		// Create new random object
		Random newQuadratic = new Random();
			
		// If determinant is less than 0, generate new random number
		int a = 0, b = 0, c = 0;
		int determinant = -1;
		
		while (determinant < 0) {
			// Get first coefficient cant equal 0
			a = newQuadratic.nextInt(201) - 100;
			while (a == 0) {
				a = newQuadratic.nextInt(201) - 100;
			}

			// Get second and third coefficients
			b = newQuadratic.nextInt(201) - 100;
			c = newQuadratic.nextInt(201) - 100;
			determinant = b*b - 4*a*c;
		}

		// Build equation
		String equation = "";
		if (a == 1) {
			equation += "x²";
		}
		else if (a == -1) {
			equation += "-x²";
		}
		else {
			equation += a + "x²";
		}
		
		// Add coefficient 2
		if (b > 0) {
			if (b == 1) {
				equation += " + x";
			}
			else if (b == -1) {
				equation += " - x";
			}	
			else {
				equation += " + " + b + "x";
			}
		}
		else if (b < 0) {
			equation += " - " + b*(-1) + "x";
		}
		else {}

		// Add coefficient 3 
		if (c > 0) {
			equation += " + " + c;
		}
		else if (c < 0) {
			equation += " - " + c*(-1);
		}
		else {}
		
		// Set label text
		question.setText(equation);
		
		// Solve quadratic equation
		Double numerator = ((double)b)*(-1) + Math.sqrt((double)determinant);
		Double numerator2 = ((double)b)*(-1) - Math.sqrt((double)determinant);
		Double denomenator = 2*(double)a;
		Double result1 = Math.round(numerator/denomenator * 100.0) / 100.0;
		Double result2 = Math.round(numerator/denomenator * 100.0) / 100.0;
	
		// Choose random index to place answer
		int randResult = newQuadratic.nextInt(2);
		int randInd = newQuadratic.nextInt(4);	
		if (randResult == 1) {
			options[randInd] = result2 + "";
		}
		else {
			options[randInd] = result1 + "";
		}

		// Generate random answers for other 3 spots
		for (int i=0; i<4; i++) {
			if (i != randInd) {
				options[i] = Math.round(newQuadratic.nextDouble() * 100.0) / 100.0  + "";
			}
		}
		
		return randInd;
	}

	/* Start the app */
    public static void main(String[] args) {
        launch();
    }
}

