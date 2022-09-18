package application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage){

		MediaRental M = new MediaRental();
		Buttons b = new Buttons();
		Rec r = new Rec();
		
			
		// First Scene
		Button Customer = b.CustomerButton();
		Button Rent = b.RentButton();
		Button Media = b.MediaButton();
		Rectangle rec1 = r.rec1();
		Rectangle rec2 = r.rec2();
		Rectangle rec3 = r.rec3();
		Label L1 = new Label("Media Rental System");
		L1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		L1.setTranslateX(840);
		L1.setTranslateY(660);
		VBox button_box = new VBox();
		button_box.setSpacing(40);
		button_box.setPadding(new Insets(70, 60, 40, 40));
		button_box.getChildren().addAll(Customer, Media, Rent);
		button_box.setTranslateX(400);
		button_box.setTranslateY(100);
		Pane p = new Pane();
		p.getChildren().addAll(rec1, rec2, rec3, button_box, L1);
		Scene s = new Scene(p);

		// customer Scene
		Button op1 = new Button("Add New Customer");
		Button op2 = new Button(" Delete Customer");
		Button op3 = new Button(" Update Information About Customer");
		Button op4 = new Button(" Search A Customer By Id");
		Button op5 = new Button(" Return To Main Page");
		VBox options1 = new VBox();
		options1.setSpacing(20);
		options1.setAlignment(Pos.CENTER);
		options1.setTranslateX(650);
		options1.setTranslateY(200);
		options1.getChildren().addAll(op1, op2, op3, op4, op5);
		Pane cp = new Pane();
		cp.getChildren().add(options1);
		Customer.setOnAction(e -> {
			s.setRoot(cp);
		});

		// back
		Button back1 = b.backButton();
		back1.setOnAction(e -> {
			s.setRoot(cp);
		});

		// Add customer Scene
		GridPane customer = new GridPane();
		customer.add(new Label(" Customer Id"), 0, 0);
		TextField ct1 = new TextField();
		customer.add(ct1, 1, 0);
		customer.add(new Label(" Customer Name"), 0, 1);
		TextField ct2 = new TextField();
		customer.add(ct2, 1, 1);
		ct2.setDisable(true);
		customer.add(new Label(" Customer Address"), 0, 2);
		TextField ct3 = new TextField();
		ct3.setDisable(true);
		customer.add(ct3, 1, 2);
		customer.add(new Label(" Customer mobile number"), 0, 3);
		TextField ct4 = new TextField();
		ct4.setDisable(true);
		customer.add(ct4, 1, 3);
		customer.add(new Label(" Customer Plan"), 0, 4);
		TextField ct5 = new TextField();
		ct5.setDisable(true);
		customer.add(ct5, 1, 4);
		ct5.setPromptText("Limited or UNLimited");
		customer.setVgap(10);
		customer.setHgap(10);
		customer.setTranslateX(650);
		customer.setTranslateY(200);
		Button add1 = b.AddButton();
		
		ct1.setOnKeyTyped(e -> {
			ct2.setDisable(false);
		});

		ct2.setOnKeyTyped(e -> {
			ct3.setDisable(false);
		});

		ct3.setOnKeyTyped(e -> {
			ct4.setDisable(false);
		});

		ct4.setOnKeyTyped(e -> {
			ct5.setDisable(false);
		});
		
		Pane addc = new Pane();
		addc.getChildren().addAll(customer, add1, back1);
		op1.setOnAction(e -> {
			s.setRoot(addc);
		});

		// add the customer
		add1.setOnAction(e -> {
			
			String id = ct1.getText();
			String name = ct2.getText();
			String address = ct3.getText();
			String mobilenumber = ct4.getText();
			String plan = ct5.getText();
			Label done = new Label();
			done.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			done.setTranslateX(720);
			done.setTranslateY(450);

				try {
					if (M.uniqueid(id) && M.addCustomer(id, name, address, mobilenumber, plan , null , null) ) 
					{
						done.setText("CUSTOMER IS ADDED .");
						done.setTextFill(Color.GREEN);
					}

					else
					{
						done.setText("INVALID INFORMATOIN !");
						done.setTextFill(Color.RED);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			addc.getChildren().add(done);
			s.setRoot(addc);
		});

		// back
		Button back2 = b.backButton();
		back2.setOnAction(e -> {
			s.setRoot(cp);
		});

		// Delete Customer Scene
		Label dl1 = new Label(" Enter Customer Id you want to remove");
		TextField dt1 = new TextField();
		HBox Hdelete = new HBox();
		Hdelete.setSpacing(10);
		Hdelete.setTranslateX(600);
		Hdelete.setTranslateY(300);
		Hdelete.getChildren().addAll(dl1, dt1);
		Button remove = b.RemoveButton();
		Pane deletec = new Pane();
		deletec.getChildren().addAll(Hdelete, remove, back2);
		op2.setOnAction(e -> {
			s.setRoot(deletec);
		});

		// remove the customer
		remove.setOnAction(e -> {
			String removeID = dt1.getText();
			Label done = new Label();
			done.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

				try {
					if (M.removecustomer(removeID))
					{
						done.setText("CUSTOMER IS REMOVED");
						done.setTextFill(Color.GREEN);
					}

					else 
					{
						done.setText("INVALID ID!");
						done.setTextFill(Color.RED);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			Pane pDone = new Pane();
			pDone.getChildren().add(done);
			pDone.setTranslateX(700);
			pDone.setTranslateY(450);
			deletec.getChildren().add(pDone);
			s.setRoot(deletec);
		});

		// back
		Button back3 = b.backButton();
		back3.setOnAction(e -> {
			s.setRoot(cp);
		});

		// Update customer information Scene
		GridPane cinfo = new GridPane();
	    Label idd = new Label("Enter ID for the updated customer");
	    TextField fidd = new TextField();
	    HBox theidd = new HBox();
	    theidd.setSpacing(10);
	    theidd.setTranslateX(600);
	    theidd.setTranslateY(50);
	    theidd.getChildren().addAll(idd,fidd);
		TextArea before = new TextArea();
		before.setTranslateY(100);
		before.setTranslateX(700);
		before.setPrefHeight(80);
		before.setPrefWidth(200);		
		cinfo.add(new Label("Customer Id"), 0, 0);
		TextField ut1 = new TextField();
		cinfo.add(ut1, 1, 0);
		cinfo.add(new Label("Customer Name"), 0, 1);
		TextField ut2 = new TextField();
		cinfo.add(ut2, 1, 1);
		cinfo.add(new Label("Customer Address"), 0, 2);
		TextField ut3 = new TextField();
		cinfo.add(ut3, 1, 2);
		cinfo.add(new Label("Customer mobile"), 0, 3);
		TextField ut4 = new TextField();
		cinfo.add(ut4, 1, 3);
		cinfo.add(new Label("Plan"), 0, 4);
		TextField ut5 = new TextField();
		cinfo.add(ut5, 1, 4);
		cinfo.add(new Label("Update Limit"), 0, 5);
		TextField ut6 = new TextField();
		cinfo.add(ut6, 1, 5);
		ut6.setDisable(true);
		cinfo.setHgap(10);
		cinfo.setVgap(10);
		cinfo.setLayoutX(650);
		cinfo.setTranslateY(200);
		Button update1 = b.UpdateButton();
		Pane updatec = new Pane();
		updatec.getChildren().addAll(theidd, cinfo, update1, back3);
		op3.setOnAction(e -> {
			s.setRoot(updatec);
		});

		fidd.setOnAction(e->{

			try {
				before.setText(M.customerinfo(fidd.getText()));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			updatec.getChildren().add(before);
			s.setRoot(updatec);
		});
		
		ut5.setOnAction(e -> {
			if (ut5.getText().equalsIgnoreCase("LIMITED")) {
				ut6.setDisable(false);
				M.setLimitedPlanLimit(Integer.parseInt(ut6.getText()));
			}
		});

		// update the customer
		update1.setOnAction(e -> {
			String theid = ut1.getText();
			String newname = ut2.getText();
			String newaddress = ut3.getText();
			String newmobile = ut4.getText();
			String newPlan = ut5.getText();
			M.setLimitedPlanLimit(Integer.parseInt(ut6.getText()));
			Label update = new Label();
			update.setTranslateY(450);
			update.setTranslateX(750);
			update.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

			try {
				if(M.updatecustomer(fidd.getText(), theid, newname, newaddress, newmobile, newPlan))
				{
					update.setText("UPDATED.");
					update.setTextFill(Color.GREEN);
				}
				
				else
				{
					update.setText("CHECK INFO!");
					update.setTextFill(Color.RED);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			updatec.getChildren().add(update);
			s.setRoot(updatec);
		});

		// back
		Button back4 = b.backButton();
		back4.setOnAction(e -> {
			s.setRoot(cp);
		});

		// Search for Customer Scene
		Label sl1 = new Label("Customer Id");
		TextField st1 = new TextField();
		HBox Hs = new HBox();
		Hs.setSpacing(50);
		Hs.setTranslateX(650);
		Hs.setTranslateY(200);
		Hs.getChildren().addAll(sl1, st1);
		Button search = b.searchcustomerButton();
		Pane searchc = new Pane();
		searchc.getChildren().addAll(Hs, search, back4);
		op4.setOnAction(e -> {
			s.setRoot(searchc);
		});

		// search for the customer
		search.setOnAction(e -> {
			TextArea Search = new TextArea();
			String sID = st1.getText();
		
			try {
				Search.setText(M.customerinfo(sID));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			Search.setPrefWidth(200);
			Search.setPrefHeight(240);
			Search.setLayoutX(670);
			Search.setTranslateY(240);
			searchc.getChildren().add(Search);
			s.setRoot(searchc);

		});

		// return to main scene
		op5.setOnAction(e -> {
			s.setRoot(p);
		});

		// Media Scene
		Button opt1 = new Button("Add New Media");
		Button opt2 = new Button("Delete Media");
		Button opt3 = new Button("Update Information About Media");
		Button opt4 = new Button("Search A Media By Code");
		Button opt5 = new Button("Print All Media Information");
		Button opt6 = new Button("Return To Main Page");
		VBox options2 = new VBox();
		options2.setSpacing(20);
		options2.setTranslateX(650);
		options2.setTranslateY(200);
		options2.setAlignment(Pos.CENTER);
		options2.getChildren().addAll(opt1, opt2, opt3, opt4, opt5, opt6);
		Pane mp = new Pane();
		mp.getChildren().add(options2);
		Media.setOnAction(e -> {
			s.setRoot(mp);
		});

		// back
		Button back6 = b.backButton();
		back6.setOnAction(e -> {
			s.setRoot(mp);
		});

		// Add media scene
		GridPane m = new GridPane();
		m.add(new Label(" Media Code"), 0, 0);
		TextField mt1 = new TextField();
		m.add(mt1, 1, 0);
		m.add(new Label(" Media Name"), 0, 1);
		TextField mt2 = new TextField();
		m.add(mt2, 1, 1);
		mt2.setDisable(true);
		m.add(new Label("Copies Available"), 0, 2);
		TextField Copies = new TextField();
		m.add(Copies, 1, 2);
		Copies.setDisable(true);
		m.add(new Label(" Select Media Kind"), 0, 3);
		String[] media = { "Album", "Game", "Movie" };
		ComboBox<String> combo = new ComboBox<>();
		combo.setValue(null);
		ObservableList<String> kinds = FXCollections.observableArrayList(media);
		combo.getItems().addAll(kinds);
		m.add(combo, 1, 3);
		m.add(new Label("Artist"), 0, 4);
		TextField artist = new TextField();
		artist.setDisable(true);
		m.add(artist, 1, 4);
		m.add(new Label("Songs"), 0, 5);
		TextField song = new TextField();
		song.setDisable(true);
		m.add(song, 1, 5);
		m.add(new Label("Rating"), 0, 6);
		TextField rate = new TextField();
		rate.setDisable(true);
		m.add(rate, 1, 6);
		m.add(new Label("Weight"), 0, 7);
		TextField weight = new TextField();
		weight.setDisable(true);
		m.add(weight, 1, 7);
		m.setVgap(5);
		m.setHgap(5);
		m.setTranslateX(650);
		m.setTranslateY(100);
		Button add2 = b.Addmedia();
		mt1.setOnKeyTyped(e -> {
			mt2.setDisable(false);
		});

		mt2.setOnKeyTyped(e -> {
			Copies.setDisable(false);
		});
		
		Pane addm = new Pane();
		addm.getChildren().addAll(m, add2, back6);
		opt1.setOnAction(e -> {
			s.setRoot(addm);
		});

		// add media according to the choice in the combo
		combo.setOnAction(e -> {

			String selected = combo.getValue();

			if (selected.equalsIgnoreCase("ALBUM")) 
			{
				song.setDisable(false);
				artist.setDisable(false);
				s.setRoot(addm);

				add2.setOnAction(E -> {

					int copiesa = Integer.parseInt(Copies.getText());
					String ArtisT = artist.getText();
					String SonGs = song.getText();
					String CODE = mt1.getText();
					String TiTle = mt2.getText();

					Label result = new Label();
					result.setTranslateX(730);
					result.setTranslateY(450);
					result.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
					
					try {
						if (M.uniquecode(CODE) && M.addAlbum(CODE, TiTle, copiesa, ArtisT, SonGs)) 
						{
							result.setText(("MEDIA IS ADDED ."));
							result.setTextFill(Color.GREEN);
						}

						else 
						{
							result.setText("INVALID INFO!");
							result.setTextFill(Color.RED);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					addm.getChildren().add(result);
					s.setRoot(addm);

				});
			}

			else if (selected.equalsIgnoreCase("MOVIE")) 
			{

				rate.setDisable(false);
				s.setRoot(addm);

				add2.setOnAction(E -> {

					int copiesa = Integer.parseInt(Copies.getText());
					String RatinG = rate.getText();
					String CODE = mt1.getText();
					String TiTle = mt2.getText();

					Label result = new Label();
					result.setTranslateX(730);
					result.setTranslateY(450);
					result.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
					
					try {
						if ( M.uniquecode(CODE) && M.addMovie(CODE, TiTle, copiesa, RatinG) ) 
						{
							result.setText(("MEDIA IS ADDED ."));
							result.setTextFill(Color.GREEN);
						} 
						
						else 
						{
							result.setText("INVALID INFO!");
							result.setTextFill(Color.RED);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					addm.getChildren().add(result);
					s.setRoot(addm);

				});
			}

			else if (selected.equalsIgnoreCase("GAME")) 
			{
                weight.setDisable(false);
				s.setRoot(addm);

				add2.setOnAction(E -> {

					int Copiesg = Integer.parseInt(Copies.getText());
					double WeighT = Double.parseDouble(weight.getText());
					String CODE = mt1.getText();
					String TiTle = mt2.getText();

					Label result = new Label();
					result.setTranslateX(730);
					result.setTranslateY(450);
					result.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
					
					try {
						if (M.uniquecode(CODE) && M.addGame(CODE, TiTle, Copiesg, WeighT))
						{
							result.setText(("MEDIA IS ADDED ."));
							result.setTextFill(Color.GREEN);
						} 
						
						else
						{
							result.setText("INVALID INFO !");
							result.setTextFill(Color.RED);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					addm.getChildren().add(result);
					s.setRoot(addm);

				});
			}

		});

		// back
		Button back7 = b.backButton();
		back7.setOnAction(e -> {
			s.setRoot(mp);
		});

		// delete media scene
		Label dml1 = new Label(" Enter Media code you want to remove");
		TextField dmt1 = new TextField();
		HBox deletemedia = new HBox();
		deletemedia.setSpacing(20);
		deletemedia.setTranslateX(580);
		deletemedia.setTranslateY(300);
		deletemedia.getChildren().addAll(dml1, dmt1);
		Button delete = b.RemoveButton();
		Pane deletem = new Pane();
		deletem.getChildren().addAll(deletemedia, delete, back7);
		opt2.setOnAction(e -> {
			s.setRoot(deletem);
		});

		// delete the media
		delete.setOnAction(e -> {
			String code = dmt1.getText();
			Label del = new Label();
			del.setTranslateX(750);
			del.setTranslateY(400);
			del.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

			try {
				if (M.removemedia(code)) 
				{
					del.setText("DELETED.");
					del.setTextFill(Color.GREEN);
				} 
				
				else 
				{
					del.setText("Check Code!");
					del.setTextFill(Color.RED);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			deletem.getChildren().add(del);
			s.setRoot(deletem);
		});

		// back
		Button back8 = b.backButton();
		back8.setOnAction(e -> {
			s.setRoot(mp);
		});

		// Update media information Scene
		GridPane mu = new GridPane();
		Label COde = new Label("Enter updated media code");
		TextField thecodee = new TextField();
		HBox O = new HBox();
		O.setTranslateX(650);
		O.setTranslateY(100);
		O.setSpacing(20);
		O.getChildren().addAll(COde,thecodee);
		mu.add(new Label(" Enetr Media Code"), 0, 0);
		TextField mut1 = new TextField();
		mu.add(mut1, 1, 0);
		mu.add(new Label(" Media Name"), 0, 1);
		TextField mut2 = new TextField();
		mu.add(mut2, 1, 1);
		mut2.setDisable(true);
		mu.add(new Label("Copies Available"), 0, 2);
		TextField CopieS = new TextField();
		mu.add(CopieS, 1, 2);
		CopieS.setDisable(true);
		mu.add(new Label(" Select Media Kind"), 0, 3);
		String[] mediA = { "Album", "Game", "Movie" };
		ComboBox<String> Combo = new ComboBox<>();
		Combo.setValue(null);
		ObservableList<String> Kinds = FXCollections.observableArrayList(mediA);
		Combo.getItems().addAll(Kinds);
		mu.add(Combo, 1, 3);
		mu.add(new Label("Artist"), 0, 4);
		TextField Artist = new TextField();
		Artist.setDisable(true);
		mu.add(Artist, 1, 4);
		mu.add(new Label("Songs"), 0, 5);
		TextField Song = new TextField();
		Song.setDisable(true);
		mu.add(Song, 1, 5);
		mu.add(new Label("Rating"), 0, 6);
		TextField Rate = new TextField();
		Rate.setDisable(true);
		mu.add(Rate, 1, 6);
		mu.add(new Label("Weight"), 0, 7);
		TextField Weight = new TextField();
		Weight.setDisable(true);
		mu.add(Weight, 1, 7);
		mu.setVgap(5);
		mu.setHgap(5);
		mu.setTranslateX(650);
		mu.setTranslateY(250);
		Button update = b.UpdateButton();
		update.setTranslateY(550);
		back8.setTranslateY(550);
		
		mut1.setOnKeyTyped(e -> {
			mut2.setDisable(false);
		});

		mut2.setOnKeyTyped(e -> {
			CopieS.setDisable(false);
		});
		
		Pane updatem = new Pane();
		updatem.getChildren().addAll(O,mu, update, back8);
		opt3.setOnAction(e -> {
			s.setRoot(updatem);
		});

		thecodee.setOnAction(e->{
			TextArea infom = new TextArea();
			try {
				infom.setText(M.mediainfo(thecodee.getText()));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			infom.setTranslateY(150);
			infom.setTranslateX(700);
			infom.setPrefHeight(80);
			infom.setPrefWidth(200);
			updatem.getChildren().add(infom);
			s.setRoot(updatem);
		});
		
		// update media according to the choice in the combo
		Combo.setOnAction(e -> {

			String selected = Combo.getValue();
			
			if (selected.equalsIgnoreCase("ALBUM")) 
			{
				Artist.setDisable(false);
				Song.setDisable(false);
				s.setRoot(updatem);

				update.setOnAction(E -> {

					int copiesa = Integer.parseInt(CopieS.getText());
					String ArtisT = Artist.getText();
					String SonGs = Song.getText();
					String CODE = mut1.getText();
					String TiTle = mut2.getText();

					Label result = new Label();
					result.setTranslateX(750);
					result.setTranslateY(500);
					result.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
					
					try {
						if (M.updatemedia(thecodee.getText(),selected,CODE, TiTle, copiesa, ArtisT, SonGs, null, 0))
						{
							result.setText("Updated");
							result.setTextFill(Color.GREEN);
						}

						else 
						{
							result.setText("invalid info!");
							result.setTextFill(Color.RED);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					updatem.getChildren().add(result);
					s.setRoot(updatem);

				});
			}

			else if (selected.equalsIgnoreCase("MOVIE")) 
			{
				Rate.setDisable(false);
				s.setRoot(updatem);

				update.setOnAction(E -> {

					int copiesm = Integer.parseInt(CopieS.getText());
					String RatinG = Rate.getText();
					String CODE = mut1.getText();
					String TiTle = mut2.getText();
					
					Label result = new Label();
					result.setTranslateX(750);
					result.setTranslateY(500);
					result.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
					
					try {
						if (M.updatemedia(thecodee.getText(),selected, CODE, TiTle, copiesm, null, null, RatinG, 0))
						{
							result.setText("Updated");
							result.setTextFill(Color.GREEN);
						}

						else 
						{
							result.setText("Invalid Information");
							result.setTextFill(Color.RED);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					updatem.getChildren().add(result);
					s.setRoot(updatem);

				});
			}

			else if (selected.equalsIgnoreCase("GAME")) {

				Weight.setDisable(false);
				s.setRoot(updatem);

				update.setOnAction(E -> {

					int Copiesg = Integer.parseInt(CopieS.getText());
					double WeighT = Double.parseDouble(Weight.getText());
					String CODE = mut1.getText();
					String TiTle = mut2.getText();
					
					Label result = new Label();
					result.setTranslateX(750);
					result.setTranslateY(500);
					result.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
					
					try {
						if (M.updatemedia(thecodee.getText(),selected, CODE, TiTle, Copiesg, null, null, null, WeighT))
						{
							result.setText("Updated");
							result.setTextFill(Color.GREEN);
						}

						else 
						{
							result.setText("Invalid Information");
							result.setTextFill(Color.RED);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					updatem.getChildren().add(result);
					s.setRoot(updatem);

				});
			}

		});

		// back
		Button back9 = b.backButton();
		back9.setOnAction(e -> {
			s.setRoot(mp);
		});

		// search a media by code scene
		Label msl1 = new Label("Media Code");
		TextField mst1 = new TextField();
		HBox sm = new HBox();
		sm.setSpacing(20);
		sm.setTranslateX(650);
		sm.setTranslateY(300);
		sm.getChildren().addAll(msl1, mst1);
		Button msearch = b.searchmediaButton();
		Pane searchm = new Pane();
		searchm.getChildren().addAll(sm, msearch, back9);
		opt4.setOnAction(e -> {
			s.setRoot(searchm);
		});

		// search for the media
		msearch.setOnAction(e -> {
			TextArea Search = new TextArea();
			String mcode = mst1.getText();
			try {
				Search.setText(M.mediainfo(mcode));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Search.setLayoutX(680);
			Search.setTranslateY(350);
			Search.setPrefHeight(100);
			Search.setPrefWidth(200);
			searchm.getChildren().add(Search);
			s.setRoot(searchm);
		});

		// back
		Button back10 = b.backButton();
		back10.setOnAction(e -> {
			s.setRoot(mp);
		});

		// print all media information scene
		TextArea info = new TextArea();
		info.setPrefHeight(200);
		info.setPrefWidth(200);
		info.setTranslateX(650);
		info.setTranslateY(200);
		Pane infO = new Pane();
		infO.getChildren().addAll(info, back10);
		opt5.setOnAction(e -> {
			try {
				info.setText(M.getAllMediaInfo());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			s.setRoot(infO);
		});

		// return to main scene
		opt6.setOnAction(e -> {
			s.setRoot(p);
		});

		// Rent scene
		Button opti1 = new Button("Rent Form");
		Button opti2 = new Button("Interests media");
		Button opti3 = new Button(" Rented Media");
		Button opti4 = new Button(" Return Media");
		Button opti5 = new Button(" Return To Main Page");
		VBox options3 = new VBox();
		options3.setSpacing(20);
		options3.setTranslateX(700);
		options3.setTranslateY(200);
		options3.setAlignment(Pos.CENTER);
		options3.getChildren().addAll(opti1, opti2, opti3, opti4, opti5);
		Pane rp = new Pane();
		rp.getChildren().add(options3);
		Rent.setOnAction(e -> {
			s.setRoot(rp);
		});

		// back
		Button back11 = b.backButton();
		back11.setOnAction(e -> {
			s.setRoot(rp);
		});

		// Rent form scene
		VBox form1 = new VBox();
		Label id = new Label("Customer ID:");
		Label code = new Label("Media Code:");
		Label date = new Label("Rented Date:");
		form1.getChildren().addAll(id, code, date);
		form1.setSpacing(120);
		form1.setTranslateX(600);
		form1.setTranslateY(50);
		VBox form2 = new VBox();
		TextField f1 = new TextField();
		TextArea infoc = new TextArea();
		infoc.setPrefWidth(50);
		infoc.setPrefHeight(70);
		TextField f3 = new TextField();
		TextArea infom = new TextArea();
		infom.setPrefWidth(50);
		infom.setPrefHeight(70);
		TextField f5 = new TextField();
		f5.setText(new Date().toString());
		f5.setMinWidth(200);
		form2.getChildren().addAll(f1, infoc, f3, infom, f5);
		form2.setSpacing(20);
		form2.setTranslateX(800);
		form2.setTranslateY(50);
		Button addtocart = b.AddToCart();
		Button processcart = b.ProcessCart();
		Button removefromcart = b.removecart();
		removefromcart.setTranslateX(500);
		removefromcart.setTranslateY(600);
		back11.setTranslateX(900);
		HBox B = new HBox();
		B.setSpacing(30);
		B.setTranslateX(500);
		B.setTranslateY(500);
		B.getChildren().addAll(addtocart, processcart);
		Pane rent = new Pane();
		rent.getChildren().addAll(form1, form2, B,removefromcart, back11);

		f1.setOnAction(e -> {
			String ID = f1.getText();
		    try {
				infoc.setText(M.customerinfo(ID));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		f3.setOnAction(e -> {
			String Code = f3.getText();
			try {
				infom.setText(M.mediainfo(Code));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		opti1.setOnAction(e -> {
			s.setRoot(rent);
		});
		addtocart.setOnAction(e -> {
			String theid = f1.getText();
			String thecode = f3.getText();
			
			Label cart = new Label();
			cart.setTranslateX(500);
			cart.setTranslateY(450);
			cart.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			
				try {
					if(M.addToCart(theid, thecode))
					{
						cart.setText("Added To Cart.");
						cart.setTextFill(Color.GREEN);
					}
					
					else
					{
						cart.setText("INVALID INFORMATION.");
						cart.setTextFill(Color.RED);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			rent.getChildren().add(cart);
			s.setRoot(rent);
		});
		
		removefromcart.setOnAction(e->{
			String theid = f1.getText();
			String thecode = f3.getText();
			
			Label cart = new Label();
			cart.setTranslateX(500);
			cart.setTranslateY(570);
			cart.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			
			try {
				if(M.removeFromCart(theid, thecode))
				{
					cart.setText("Removed From Cart.");
					cart.setTextFill(Color.GREEN);
				}
				
				else
				{
					cart.setText("INVALID INFORMATION.");
					cart.setTextFill(Color.RED);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			rent.getChildren().add(cart);
			s.setRoot(rent);
			
		});
		processcart.setOnAction(e -> {
			String theid = f1.getText();
			String thecode = f3.getText();

			Label rented = new Label();
			rented.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			rented.setTranslateX(690);
			rented.setTranslateY(450);
			
				try {
					if(M.processRequests(theid , thecode))
					{
						rented.setText("Added to Rented Media");
						rented.setTextFill(Color.GREEN);
					}
					
					else
					{
						rented.setText("INVALID INFORMATION !");
						rented.setTextFill(Color.RED);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			rent.getChildren().add(rented);
			s.setRoot(rent);
		});

		// back
		Button back12 = b.backButton();
		back12.setOnAction(e -> {
			s.setRoot(rp);
		});

		// interests cart
		Label intid = new Label("Enter ID");
		TextField idint = new TextField();
		HBox interests = new HBox();
		interests.setSpacing(40);
		interests.setTranslateX(640);
		interests.setTranslateY(200);
		interests.getChildren().addAll(intid, idint);
		TextArea req = new TextArea();
		req.setTranslateX(650);
		req.setTranslateY(300);
		req.setPrefWidth(200);
		req.setPrefHeight(80);
		Button in = b.interests();
		Pane pint = new Pane();
		pint.getChildren().addAll(interests, req, in, back12);
		opti2.setOnAction(e -> {
			s.setRoot(pint);
		});

		in.setOnAction(e -> {
			try {
				req.setText(M.printinterests(idint.getText()));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		// back
		Button back13 = b.backButton();
		back13.setOnAction(e -> {
			s.setRoot(rp);
		});

		// rented cart
		Label rentid = new Label("Enter ID");
		TextField idrent = new TextField();
		HBox rented = new HBox();
		rented.setSpacing(40);
		rented.setTranslateX(640);
		rented.setTranslateY(200);
		rented.getChildren().addAll(rentid, idrent);
		TextArea result = new TextArea();
		result.setTranslateX(650);
		result.setTranslateY(300);
		result.setPrefWidth(200);
		result.setPrefHeight(80);
		Button iN = b.interests();
		iN.setText("PRINT RENTED");
		Pane RenT = new Pane();
		RenT.getChildren().addAll(rented, result, iN, back13);
		opti3.setOnAction(e -> {
			s.setRoot(RenT);
		});

		iN.setOnAction(e -> {
			try {
				result.setText(M.printrented(idrent.getText()));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			s.setRoot(RenT);
		});

		// back
		Button back14 = b.backButton();
		back14.setOnAction(e -> {
			s.setRoot(rp);
		});

		// return media
		opti4.setOnAction(e -> {
			GridPane returned = new GridPane();
			Label IDC = new Label("Enter customer ID");
			Label CODEM = new Label("Enter Returend Media Code");
			TextField idc = new TextField();
			TextField codem = new TextField();
			TextArea a1 = new TextArea();
			TextArea a2 = new TextArea();
			a1.setPrefHeight(100);
			a1.setPrefWidth(100);
			a2.setPrefHeight(100);
			a2.setPrefWidth(100);
			returned.add(IDC, 0, 0);
			returned.add(idc, 1, 0);
			returned.add(a1, 0, 1);
			returned.add(CODEM, 0, 2);
			returned.add(codem, 1, 2);
			returned.add(a2, 0, 3);
			returned.setVgap(10);
			returned.setHgap(10);
			returned.setTranslateY(200);
			returned.setTranslateX(630);
			Button returnb = b.returned();
			returnb.setTranslateY(550);
			back14.setTranslateY(550);
			Pane rr = new Pane();
			rr.getChildren().addAll(returned, returnb, back14);
			s.setRoot(rr);

			idc.setOnAction(a ->{
				try {
					a1.setText(M.customerinfo(idc.getText()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			codem.setOnAction(A->{
				try {
					a2.setText(M.mediainfo(codem.getText()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			returnb.setOnAction(E -> {
				String theid = idc.getText();
				String thecode = codem.getText();
				Label res = new Label();
				res.setLayoutY(500);
				res.setLayoutX(730);
				res.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

					try {
						if (M.returnMedia(theid, thecode)) {
							res.setText("Media is retured");
							res.setTextFill(Color.GREEN);
						}

						else {
							res.setText("Check your information!");
							res.setTextFill(Color.RED);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			

				rr.getChildren().add(res);
				s.setRoot(rr);

			});
		});

		opti5.setOnAction(e -> {
			s.setRoot(p);
		});

		// show the stage
		primaryStage.setTitle("Media Rental");
		primaryStage.setScene(s);
		primaryStage.setMaximized(true);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}