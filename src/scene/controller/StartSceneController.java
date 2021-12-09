package scene.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import component.BackButton;
import component.HaDozButton;
import component.HowToLabel;
import component.StartSubScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import scene.manager.SceneManager;

public class StartSceneController extends Controller {

	private static final int HEIGHT = 576;
	private static final int WIDTH = 1024;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;

	private final static int MENU_BUTTONS_START_X = 437;
	private final static int MENU_BUTTONS_START_Y = 276;
	
	private StartSubScene startSubScene;
	private StartSubScene sceneToHide;

	private List<HaDozButton> menuBtn;
	private ArrayList<String> keyPath = new ArrayList<>(Arrays.asList("A_keycap.png","D_keycap.png","W_keycap.png","S_keycap.png","spacebar_keycap.png",
			"left_arrow_keycap.png","right_arrow_keycap.png","up_arrow_keycap.png","down_arrow_keycap.png","enter_keycap.png"));
	public StartSceneController() {
		// TODO Auto-generated constructor stub
		menuBtn = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createHowButton();
		createStartButton();
		createExitButton();
		createBackground();
		createSubScene();
		
	}

	public StartSceneController(String fXMLPath, Controller controllerCaller) {
		super(fXMLPath, controllerCaller);
		// TODO Auto-generated constructor stub
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
	}

	@Override
	public void setSceneManager(SceneManager scenemanager) {
		// TODO Auto-generated method stub

	}

	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

	private void addMenuButton(HaDozButton btn) {
		btn.setLayoutX(MENU_BUTTONS_START_X);
		btn.setLayoutY(MENU_BUTTONS_START_Y + menuBtn.size() * 100);

		menuBtn.add(btn);
		mainPane.getChildren().add(btn);
	}
	private void createSubScene() {
		startSubScene = new StartSubScene();
		mainPane.getChildren().add(startSubScene);
		
		HowToLabel label = new HowToLabel("How To Play");
		label.setLayoutX(200);
		label.setLayoutY(-150);
//		Image A = new Image(keyPath.get(0));Image D = new Image(keyPath.get(1));
//		Image W = new Image(keyPath.get(2));Image S = new Image(keyPath.get(3));
//		Image spacebar = new Image(keyPath.get(4));Image left = new Image(keyPath.get(5));
//		Image right = new Image(keyPath.get(6));Image up = new Image(keyPath.get(7));
//		Image down = new Image(keyPath.get(8));Image enter = new Image(keyPath.get(9));
		ImageView panel = new ImageView(new Image("/scene/controller/res/HowToplay.png"));
		panel.setFitHeight(0.45*panel.prefHeight(1));
        panel.setFitWidth(0.45*panel.prefWidth(1));
		panel.relocate((double)(125), (double)(130));
		ImageView ryu = new ImageView(new Image("/scene/controller/res/ryu.gif"));
		ImageView ken = new ImageView(new Image("/scene/controller/res/ken.gif"));
		ryu.setFitHeight(0.4*ryu.prefHeight(1));
        ryu.setFitWidth(0.4*ryu.prefWidth(1));
		ryu.relocate((double)(440), (double)(167));
		ken.setFitHeight(0.4*ken.prefHeight(1));
        ken.setFitWidth(0.4*ken.prefWidth(1));
        ken.setScaleX(-1);
		ken.relocate((double)(550), (double)(160));
		BackButton bBtn = new BackButton();
		bBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				startSubScene.setToHide(true);
				startSubScene.moveSubScene();
			}
		});
		bBtn.setLayoutX(605);
		bBtn.setLayoutY(80);
		
		startSubScene.getPane().getChildren().addAll(label,panel,ryu,ken,bBtn);
		
	}
	
	private void createStartButton() {
		HaDozButton sBtn = new HaDozButton("Start !");
		addMenuButton(sBtn);
	}

	private void createHowButton() {
		HaDozButton hBtn = new HaDozButton("How To Play");
		addMenuButton(hBtn);
		
		hBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// transition to sub scene
				startSubScene.moveSubScene();
			}
		});
	}

	private void createExitButton() {
		HaDozButton eBtn = new HaDozButton("Exit");
		addMenuButton(eBtn);
		
		eBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				mainStage.close();
			}
		});
	}
	
	private void createLogo() {
		
	}

	private void createBackground() {
		Image backgroundImage = new Image("/scene/controller/res/RoadInJapan.png", 1024, 576, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}

}
