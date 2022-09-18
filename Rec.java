package application;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Rec extends Rectangle{
	
	public Rectangle rec1()
	{
		Rectangle rec1 = new Rectangle(700,100,500,500);
		rec1.setFill(Color.TRANSPARENT);
		rec1.setStroke(Color.DARKBLUE);
		return rec1;
		
	}
	
	public Rectangle rec2()
	{
		Rectangle rec2 = new Rectangle(750,150,400,400);
		rec2.setFill(Color.TRANSPARENT);
		rec2.setStroke(Color.BLUE);
		Image recimage = new Image("content.png");
		rec2.setFill(new ImagePattern(recimage));
		return rec2;
	}
	
	public Rectangle rec3()
	{
		Rectangle rec3 = new Rectangle(750,650,400,50);
		rec3.setFill(Color.TRANSPARENT);
		rec3.setStroke(Color.DARKBLUE);
		return rec3;
	}
	

}
