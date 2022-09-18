
package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MediaRental implements MediaRentallnt {

	private int MaximumLimit = 2;
	
	public ArrayList<String> in(String filename) throws FileNotFoundException
	{
		ArrayList<String> data = new ArrayList<>();
		String info;
		
		Scanner s = new Scanner(new File(filename));
		while(s.hasNext())
		{
			info = s.nextLine();
			data.add(info);
		}
		
		return data;
	}
	
	public void write(String filename , ArrayList<String>data) throws IOException

	{
		FileWriter fw = new FileWriter(new File(filename));
		
		for(int i = 0 ; i < data.size() ; i++)
		{
			fw.write(data.get(i)+"\r\n");
		}
		
		fw.close();
		
	}
	
    private boolean Check_Plan(String plan)
	{
		if (plan != null && (plan.equalsIgnoreCase("UNLIMITED") || plan.equalsIgnoreCase("LIMITED")))
		{
			return true;
		}

		else 
		{
			return false;
		}

	}

	public boolean addCustomer(String id, String name, String address, String mobilenumber, String plan , String cart , String rent) throws IOException
	{
		boolean b = false;
	    ArrayList<String> data = in("customer.txt");
	 
	    if (id != null && name != null && address != null && mobilenumber != null && Check_Plan(plan)) 
	  {
		 data.add(id+"-"+name+"-"+address+"-"+mobilenumber+"-"+plan+"-"+cart+"-"+rent);
		 write("customer.txt",data);
	     b = true;			
	  }
		return b;

	}
	
	public boolean uniqueid(String id) throws FileNotFoundException
	{
		boolean unique = true;
		ArrayList<String> data = in("customer.txt");
		String [] info;
		
		for(int i = 0 ; i < data.size() ; i++)
		{
			info = data.get(i).split("-");
			
			if(info[0].equalsIgnoreCase(id))
			{
				unique = false;
				break;
			}
		}
		
		return unique;
	}
	
	public boolean removecustomer(String id) throws IOException
	{
		
		boolean r = false;
		
		ArrayList<String> data = in("customer.txt");
		String [] info;
        
			for (int i = 0; i < data.size() ; i++)
			{
				info = data.get(i).split("-");
				
				if(info[0].equalsIgnoreCase(id))
				{
					data.remove(i);
					write("customer.txt",data);
					r= true;
				}
			}
			
		return r;	
	}

	public void setLimitedPlanLimit(int value)

	{
		this.MaximumLimit = value;
	}
	
	public String customerinfo(String id) throws FileNotFoundException
	{
		String result = "Error,cann't" + "\n" + "find customer";
        ArrayList<String> data = in("customer.txt");
        String [] info;
        
        for(int i = 0 ; i < data.size() ; i++)
        {
        	info = data.get(i).split("-");
        	info[5] = printinterests(id);
        	info[6] = printrented(id);
 
        	if(info[0].equalsIgnoreCase(id))
        	{
    			result =  "ID: " + info[0] + "\n" + "\n"+
						"Name: " + info[1] + "\n" + "\n" +
    					"Address: "+ info[2]+ "\n" + "\n" +
						"Mobile Number: "+ info[3] + "\n" + "\n"+
    					"Plan: "+ info[4] + "\n"+ "\n"+
						"limit: " + MaximumLimit +"\n" +"\n"+
    			        "Request: "+ "\n"+ ""+info[5]+"\n"+
    					"Rented: "+"\n"+""+info[6]+"\n";
    
    			break;
        	}
        	
        }
		
		return result;
	}

    public boolean updatecustomer(String oldid , String newid, String name, String address, String mobilenumber, String plan) throws IOException
	{	
		boolean u = false;
		ArrayList<String> data = in("customer.txt");
		String [] info;
		String [] media;
		String interests = "";
		String rented = "";
		
		for(int j = 0 ; j < data.size() ; j++)
		{
			media = data.get(j).split("-");
			
			if(media[0].equalsIgnoreCase(oldid))
			{
				interests = media[5];
				rented = media[6];
				break;
			}
			
		}
		
		for(int i = 0 ; i < data.size() ; i++)
		{
			info = data.get(i).split("-");
			
			if(info[0].equalsIgnoreCase(oldid))
			{
				data.set(i, newid+"-"+name+"-"+address+"-"+mobilenumber+"-"+plan+"-"+interests+"-"+rented);
				write("customer.txt",data);
				u = true;
				break;
			}
		}
		
		return u;
	}

	private boolean Check_Rating(String rating)

	{
		if (rating != null && (rating.equalsIgnoreCase("HR") || rating.equalsIgnoreCase("DR") || rating.equalsIgnoreCase("AC"))) 
		{
			return true;
		}

		else 
		{
			throw new RuntimeException("INVALID RATING , CHOOSE HR OR AC OR DR !");
		}
	}

	public boolean addMovie(String code, String title, int copiesAvailable, String rating) throws IOException

	{
		boolean m = false;
		ArrayList<String> data = in("media.txt");

		if (code != null && title != null && copiesAvailable > 0 && Check_Rating(rating))

		{
			data.add(code+"-"+title+"-"+copiesAvailable+"-"+rating);
			 write("media.txt",data);
		     m = true;	
		}

		return m;
	}

	public boolean addGame(String code, String title, int copiesAvailable, double weight) throws IOException 
	{
		boolean g = false;
		ArrayList<String> data = in("media.txt");
		
		if (code != null && title != null && copiesAvailable > 0 && weight > 0) 
		{
			data.add(code+"-"+title+"-"+copiesAvailable+"-"+weight);
			 write("media.txt",data);
		     g = true;
		}

		return g;
	}

	public boolean addAlbum(String code, String title, int copiesAvailable, String artist, String songs) throws IOException
	{
		boolean a = false;
		ArrayList<String> data = in("media.txt");
		
		if (code != null && title != null && copiesAvailable > 0 && artist != null && songs != null) 
		{
			data.add(code+"-"+title+"-"+copiesAvailable+"-"+artist+"-"+songs);
			write("media.txt",data);
			a = true;
		}

		return a;
	}
	
	public boolean uniquecode (String code) throws FileNotFoundException
	{
		boolean unique = true;
		ArrayList<String> data = in("media.txt");
		String [] info;
		
		for(int i =  0 ; i < data.size() ; i++)
		{
			info = data.get(i).split("-");
			
			if(info[0].equalsIgnoreCase(code))
			{
				unique = false;
				break;
			}
			
		}
		
		return unique;
	}
	
	public boolean removemedia(String code) throws IOException 
	{
		boolean r = false;
		
		ArrayList<String> data = in("media.txt");
		String [] info;
        
			for (int i = 0; i < data.size() ; i++)
			{
				info = data.get(i).split("-");
				
				if(info[0].equalsIgnoreCase(code))
				{
					data.remove(i);
					write("media.txt",data);
					r= true;
				}
			}
			
		return r;	
	}

	public String mediainfo(String code) throws FileNotFoundException 
	{
		String result = "Error can't" + "\n" + "find media !";
		ArrayList<String> data = in("media.txt");
		String [] info;
    
		for(int i = 0 ; i < data.size() ; i++)
		{
			info = data.get(i).split("-");
			
			if(info[0].equalsIgnoreCase(code))
			{
				result = "Code: "+info[0]+"\n"+
			             "Title: "+info[1]+"\n"+
						 "Copies: "+info[2]+"\n";
				
				if(info.length == 5)
				{
					result += "Artist: "+info[3]+"\n"+
							  "Songs: "+info[4]+"\n";
				}
				
				else if(info.length == 4)
				{
					if(info[3].equalsIgnoreCase("HR") || info[3].equalsIgnoreCase("DR") || info[3].equalsIgnoreCase("AC"))
					{
						result += "Rating: "+info[3]+"\n";
					}
					
					else
					{
						result += "Weight: "+info[3]+"\n";
					}
				}
			         
				break;
			}
			
		}

		return result;
	}
	
	public boolean updatemedia(String oldcode , String type, String newcode, String title, int copies, String artist, String songs,String rating, double weight) throws IOException 
	{
		boolean M = false;
		ArrayList<String> data = in("media.txt");
		String [] info;
		
		for (int i = 0; i < data.size(); i++) 
		{
			info = data.get(i).split("-");
			
			if (info[0].equalsIgnoreCase(oldcode)) 
			{
				if(type.equalsIgnoreCase("ALBUM"))
				{
					data.set(i, newcode+"-"+title+"-"+copies+"-"+artist+"-"+songs);
					write("media.txt",data);
					M=true;
					break;
				}
				
				else if(type.equalsIgnoreCase("GAME"))
				{
					data.set(i, newcode+"-"+title+"-"+copies+"-"+weight);
					write("media.txt",data);
					M=true;
					break;
				}
				
				else
				{
					data.set(i, newcode+"-"+title+"-"+copies+"-"+rating);
					write("media.txt",data);
					M=true;
					break;
				}
			}	
	   }
		
		return M;
	}
	
	public String getAllMediaInfo() throws FileNotFoundException 
	{

		ArrayList<String> data = in("media.txt");
		String [] info;
		String result = "";

		for (int i = 0; i < data.size(); i++) 
		{
			info = data.get(i).split("-");
			result += mediainfo(info[0]) + "\n";
			
		}

		return result;

	}

	public boolean addToCart(String customerid, String mediacode) throws IOException
	{
		boolean done = false;
		ArrayList<String> cus = in("customer.txt");
		String [] info;
		
		for(int i = 0 ; i < cus.size() ; i++)
		{
			info = cus.get(i).split("-");
			
			{
				if(info[0].equalsIgnoreCase(customerid))
				{
					if(!info[5].contains(mediacode) && Check_Copies(mediacode))
					{
						if(!info[5].equalsIgnoreCase("null"))
						{
						  info[5] += "," + mediacode;
						}
						
						else if (info[5].equalsIgnoreCase("null"))
						{
							info[5] = mediacode;
						}
						
						cus.set(i, info[0]+"-"+info[1]+"-"+info[2]+"-"+info[3]+"-"+info[4]+"-"+info[5]+"-"+info[6]);
						write("customer.txt",cus);
						done = true;
					}
					
					else
					{
						break;
					}
				}
			}
			
		}
		
		return done;
	}

	public boolean removeFromCart(String customerid, String mediacode) throws IOException
	{
		boolean done = false;
		ArrayList<String> cus = in("customer.txt");
		String [] info;
		String [] in;
		String res = "";
		for(int i = 0 ; i < cus.size() ; i++)
		{
			info = cus.get(i).split("-");
			
			{
				if(info[0].equalsIgnoreCase(customerid))
				{
					if(info[5].contains(mediacode))
					{
						in = info[5].split(",");
						
						if(in.length == 1)
						{
							res = null;
						}
							
						else
						{
							for(int j = 0 ; j < in.length ; j++)
							{
								if(!in[j].equalsIgnoreCase(mediacode))
								{
									res = in[j] +",";
								}
							}
						}
						
						cus.set(i, info[0]+"-"+info[1]+"-"+info[2]+"-"+info[3]+"-"+info[4]+"-"+res+"-"+info[6]);
						write("customer.txt",cus);
						Edit_Copies(mediacode);
						done = true;
					}
					
					else
					{
						break;
					}
				}
			}
			
		}
		
		return done;
	}
	
    private boolean Check_Copies(String mediacode) throws IOException
	{
		boolean ThereIsCopy = false;
		ArrayList<String> data = in("media.txt");
		String [] info;
		String newcopy = "";
		
		for(int i = 0 ; i < data.size() ; i++)
		{
			info = data.get(i).split("-");
			
			if(info[0].equalsIgnoreCase(mediacode))
			{
				
				if(Integer.parseInt(info[2]) > 0 )
				{
					int num = Integer.parseInt(info[2]) - 1 ;
					newcopy = Integer.toString(num);
		            ThereIsCopy = true;
		            
		            if(info.length == 4)
					{
					  data.set(i, info[0]+"-"+info[1]+"-"+newcopy+"-"+info[3]);
					  break;
					}
					
					else
					{
						data.set(i, info[0]+"-"+info[1]+"-"+newcopy+"-"+info[3]+"-"+info[4]);
						break;
					}
					
				}
			}
			
		}
		
		write("media.txt",data);
         
		return ThereIsCopy;
		
	}

	public boolean processRequests(String customerid , String mediacode) throws IOException
	{
		boolean p = false;
		ArrayList<String> cus = in("customer.txt");
		String [] info;
		String limit ="";
		
		for(int i = 0 ; i < cus.size() ; i++)
		{
			info = cus.get(i).split("-");
		
			if(info[0].equalsIgnoreCase(customerid))
			{
				limit = info[4];
				
				if(info[5].contains(mediacode) && !info[6].contains(mediacode))
				{
					if(limit.equalsIgnoreCase("unlimited"))
					{
						if(info[6].equalsIgnoreCase("null"))
						{
							info[6] = mediacode;
						}
						
						else
						{
							info[6] += ","+mediacode;
						}
						
						cus.set(i, info[0]+"-"+info[1]+"-"+info[2]+"-"+info[3]+"-"+info[4]+"-" +info[5] +"-"+info[6]);
						write("customer.txt",cus);
						p = true;
						break;
					}
					
					else if(limit.equalsIgnoreCase("limited"))
					{
					    String [] thelimit = info[6].split(",");
					    
						if( thelimit.length < MaximumLimit)
						{
							if(info[6].equalsIgnoreCase("null"))
							{
								info[6] = mediacode;
							}
							
							else
							{
								info[6] += ","+mediacode;
							}
							
							cus.set(i, info[0]+"-"+info[1]+"-"+info[2]+"-"+info[3]+"-"+info[4]+"-"+info[5]+"-"+info[6]);
							write("customer.txt",cus);
							p = true;
							break;
						}
							
					}
						
				}
			}

		}
		
		return p;
	}

	public String printinterests(String id) throws FileNotFoundException 
	{
		ArrayList<String> data = in("customer.txt");
		String [] info;
		String [] cart;
		String p = " no interests";
		
		for(int i = 0 ; i< data.size() ; i++)
		{
			info = data.get(i).split("-");
			
			if(info[0].equalsIgnoreCase(id))
			{
				cart = info[5].split(",");
				p = "";
				
				for(int j = 0 ; j < cart.length ; j++)
				{
					p += mediainfo(cart[j]) +"\n";
					
				}
			}
		
		}
		
		return p;
	}

	public String printrented(String id) throws FileNotFoundException 
	{
		ArrayList<String> data = in("customer.txt");
		String [] info;
		String [] cart;
		String p = "no rented";
		
		for(int i = 0 ; i< data.size() ; i++)
		{
			info = data.get(i).split("-");
			
			if(info[0].equalsIgnoreCase(id))
			{
				cart = info[6].split(",");
				p = "";
				
				for(int j = 0 ; j < cart.length ; j++)
				{
					p += mediainfo(cart[j]) +"\n";
					
				}
			}
		
		}
		
		return p;

	}

	public boolean returnMedia(String customerid, String mediacode) throws IOException

	{
		boolean Return = false;
        ArrayList<String> data = in("customer.txt");
        String [] info;
        String []rent;
        String [] cart;
        String res = "";
        String Res = "";
        
        for(int i = 0 ; i < data.size() ; i++)
        {
        	info = data.get(i).split("-");
        	
        	if(info[0].equalsIgnoreCase(customerid))
        	{
        		if(info[6].contains(mediacode))
        		{
        			rent = info[6].split(",");
        			cart = info[5].split(",");
        			
        			if(rent.length == 1)
        			{
        				res = "null";
        			}
        			
        			else
        			{
        				for(int j = 0 ; j < rent.length ; j++)
            			{
            				if(!rent[j].equalsIgnoreCase(mediacode))
            				{
            					res += rent[j] + ",";
            				}	
            			}
        			}
        			
        			if(cart.length == 1 )
        			{
        				Res = "null";
        			}
        			
        			else
        			{
        				for(int k = 0 ; k < cart.length ; k++)
            			{
            				if(!cart[k].equalsIgnoreCase(mediacode))
            				{
            					Res += cart[k] + ",";
            				}
            			}
       
        			}
        		
                	data.set(i, info[0]+"-"+info[1]+"-"+info[2]+"-"+info[3]+"-"+info[4]+"-"+Res+"-"+res);
            		Edit_Copies(mediacode);
            		write("customer.txt",data);
            		Return = true;
            		break;
        		}
        	}
        }

		return Return;
	}

    private boolean Edit_Copies(String mediacode) throws IOException
	{
		boolean edit = false;
		ArrayList<String> data = in("media.txt");
		String [] info;
		String newcopy = "";
		
		for(int i = 0 ; i < data.size() ; i++)
		{
			info = data.get(i).split("-");
			
			if(info[0].equalsIgnoreCase(mediacode))
			{
					int num = Integer.parseInt(info[2]) + 1 ;
					newcopy = Integer.toString(num);
		            edit = true;
		            
		            if(info.length == 4)
					{
					  data.set(i, info[0]+"-"+info[1]+"-"+newcopy+"-"+info[3]);
					  break;
					}
					
					else
					{
						data.set(i, info[0]+"-"+info[1]+"-"+newcopy+"-"+info[3]+"-"+info[4]);
						break;
					}
			}
			
		}
		
		write("media.txt",data);
         
		return edit;
   }
}
