package component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class ExitText extends Label {

	private final String FONT_PATH = "src/component/res/PressStart2P-vaV7.ttf";

	public ExitText(String text, Paint color) {
		// TODO Auto-generated constructor stub
		setPrefSize(800, 75);
		setPadding(new Insets(40));
		setText(text);
		setWrapText(true);
		setLabelFont(color);
	}

	private void setLabelFont(Paint color) {
		// TODO Auto-generated method stub
		try {
			setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 32));
			setTextFill(color);
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 32));
		}
	}
}
