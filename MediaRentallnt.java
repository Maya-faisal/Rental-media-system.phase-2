package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface MediaRentallnt 

{

	void write(String filename , ArrayList<String>data) throws IOException;
	ArrayList<String> in(String filename) throws FileNotFoundException;
	boolean addCustomer(String id ,String name , String address ,String mobilenumber , String plan, String cart , String rent) throws IOException;
	boolean uniqueid(String id) throws FileNotFoundException;
	boolean removecustomer(String id) throws FileNotFoundException, IOException;
	String customerinfo(String id) throws FileNotFoundException;
	String mediainfo(String code) throws FileNotFoundException;
	boolean updatecustomer (String oldid , String newid , String name , String address , String mobilenumber , String plan) throws FileNotFoundException, IOException;
	boolean updatemedia(String oldcode , String type ,String code ,String name , int copies , String artist , String songs , String rating , double weight) throws IOException;
	boolean addMovie(String code ,String title , int copiesAvailable , String rating) throws IOException;
	boolean addGame(String code ,String title , int copiesAvaliable , double weight) throws IOException;
	boolean addAlbum(String code ,String title , int copiesAvaliable , String Artist , String songs) throws IOException;
	boolean uniquecode (String code) throws FileNotFoundException;
	boolean removemedia(String code) throws IOException;
	void setLimitedPlanLimit(int value);
	String getAllMediaInfo() throws FileNotFoundException;
	boolean addToCart(String customerid , String mediacode) throws FileNotFoundException, IOException;
    boolean processRequests(String id , String mediacode) throws FileNotFoundException, IOException;
    String printrented(String id) throws FileNotFoundException;
    String printinterests(String id) throws FileNotFoundException;
	boolean returnMedia(String customerid , String mediacode) throws FileNotFoundException, IOException;
	
}
