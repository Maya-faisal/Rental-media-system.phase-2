package application;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Buttons extends Button{

	public Button AddButton() 
	{
		Button add = new Button("Add");
		add.setTranslateX(650);
		add.setTranslateY(500);
		add.setPrefWidth(100);
		add.setPrefHeight(20);
		Image addicon = new Image("add-user.png");
		ImageView addview = new ImageView(addicon);
		addview.setFitHeight(40);
		addview.setFitWidth(40);
		add.setGraphic(addview);
		
		return add;
		
	}
	
	public Button Addmedia() 
	{
		Button add = new Button("Add");
		add.setTranslateX(650);
		add.setTranslateY(500);
		add.setPrefWidth(100);
		add.setPrefHeight(20);
		Image addicon = new Image("add.png");
		ImageView addview = new ImageView(addicon);
		addview.setFitHeight(40);
		addview.setFitWidth(40);
		add.setGraphic(addview);
		
		return add;
		
	}
	
	public Button RemoveButton()
	{
		Button remove = new Button("Delete");
		remove.setTranslateX(600);
		remove.setTranslateY(500);
		remove.setPrefWidth(130);
		remove.setPrefHeight(20);
		Image removeicon = new Image("remove.png");
		ImageView removeview = new ImageView(removeicon);
		removeview.setFitHeight(40);
		removeview.setFitWidth(40);
		remove.setGraphic(removeview);
		
		return remove;
	}
	
	public Button backButton()
	{
		Button back = new Button("Back");
		back.setTranslateX(800);
		back.setTranslateY(500);
		back.setPrefHeight(20);
		back.setPrefWidth(100);
		Image backicon = new Image("back.png");
		ImageView backview = new ImageView(backicon);
		backview.setFitWidth(40);
		backview.setFitHeight(40);
		back.setGraphic(backview);
		
		return back;
		
	}
	
	
	public Button CustomerButton()
	{
		Button Customer = new Button ("Customer");
		Customer.setPrefHeight(100);
		Customer.setPrefWidth(200);
		Image c = new Image("customer.png");
		ImageView cview = new ImageView(c);
		cview.setFitHeight(40);
		cview.setFitWidth(40);
		Customer.setGraphic(cview);
		
		return Customer;
	}
	
	public Button MediaButton()
	{
		Button Media = new Button ("Media");
		Media.setPrefHeight(100);
		Media.setPrefWidth(200);
		Image m = new Image("social-media.png");
		ImageView mview = new ImageView(m);
		mview.setFitHeight(40);
		mview.setFitWidth(40);
		Media.setGraphic(mview);
		
		return Media;
		
		
	}
	public Button searchcustomerButton()
	{
		Button search = new Button("Search");
		search.setPrefWidth(100);
		search.setPrefHeight(20);
		search.setTranslateX(650);
		search.setTranslateY(500);
		Image searchicon = new Image("search.png");
		ImageView searchview = new ImageView(searchicon);
		searchview.setFitWidth(40);
		searchview.setFitHeight(40);
		search.setGraphic(searchview);
		
		return search;
	}
	
	public Button searchmediaButton()
	{
		Button search = new Button("Search");
		search.setPrefWidth(100);
		search.setPrefHeight(20);
		search.setTranslateX(650);
		search.setTranslateY(500);
		Image searchicon = new Image("searchmedia.png");
		ImageView searchview = new ImageView(searchicon);
		searchview.setFitWidth(40);
		searchview.setFitHeight(40);
		search.setGraphic(searchview);
		
		return search;
	}
	
	public Button RentButton()
	{
		Button Rent = new Button ("Rent");
		Rent.setPrefHeight(100);
		Rent.setPrefWidth(200);
		Image r = new Image("for-rent.png");
		ImageView rview = new ImageView(r);
		rview.setFitHeight(40);
		rview.setFitWidth(40);
		Rent.setGraphic(rview);
		
		return Rent;
	}
	
	public Button UpdateButton()
	{		
	  Button update = new Button("Update");
	  update.setPrefWidth(100);
	  update.setPrefHeight(20);
	  update.setTranslateX(650);
	  update.setTranslateY(500);
	  Image updateicon = new Image("update.png");
	  ImageView updateview = new ImageView(updateicon);
	  updateview.setFitWidth(40);
	  updateview.setFitHeight(40);
	  update.setGraphic(updateview);
	
	 return update;
		
	}
	
	public Button AddToCart() 
	{
		Button addCart = new Button("Add To Cart");
		addCart.setPrefWidth(150);
		addCart.setPrefHeight(20);
		Image addcart = new Image("add-cart.png");
		ImageView cartview = new ImageView(addcart);
		cartview.setFitWidth(40);
		cartview.setFitHeight(40);
		addCart.setGraphic(cartview);
		
		return addCart;
		
	}
	
	public Button ProcessCart() 
	{
		Button pCart = new Button("Process Cart");
		pCart.setPrefWidth(150);
		pCart.setPrefHeight(40);
		Image pcart = new Image("process.png");
		ImageView cartpview = new ImageView(pcart);
		cartpview.setFitWidth(40);
		cartpview.setFitHeight(40);
		pCart.setGraphic(cartpview);
		
		return pCart;
		
	}
	
	public Button removecart()
	{
		Button removeCart = new Button("Remove From Cart");
		removeCart.setPrefWidth(170);
		removeCart.setPrefHeight(20);
		Image removecart = new Image("removecart.png");
		ImageView cartview = new ImageView(removecart);
		cartview.setFitWidth(40);
		cartview.setFitHeight(40);
		removeCart.setGraphic(cartview);
		
		return removeCart;
	}

    public Button interests()
	{
		Button in = new Button("PRINT INTERESTS");
		in.setPrefHeight(20);
		in.setPrefWidth(200);
		Image inte = new Image("paper.png");
		ImageView inteview = new ImageView(inte);
		inteview.setFitWidth(20);
		inteview.setFitHeight(20);
		in.setGraphic(inteview);
		in.setTranslateY(400);
		in.setTranslateX(650);
		
		return in;
		
	}
	
	public Button returned()
	{
		Button r = new Button("Return media");
		r.setPrefHeight(40);
		r.setPrefWidth(150);
		Image re = new Image("return.png");
		ImageView review = new ImageView(re);
		review.setFitWidth(40);
	    review.setFitHeight(40);
		r.setGraphic(review);
		r.setTranslateY(500);
		r.setTranslateX(640);
		return r;
		
	}
	

}
