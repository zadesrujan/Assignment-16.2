package replace;



	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;

	public class StringInTextFile {
		
		//class defines instance and class fields,methods and inner classes as
		//well as specifying the interfaces the class implements and the 
		//immediate superclass of the class
	  
		    static void modifyFile(String filePath, String oldString, String newString)
		    {
		       //create a file object by passing the path of the file to be modified
		    	File fileToBeModified = new File(filePath);
	//Initialize oldContent with an empty string.This String Object hold all the old content of the input file	         
		        String oldContent = "";
	//Create BufferedReader object to read the input text file line by line	         
	//BufferedReader is used to read the text from a character based inputStream.It is to read data line
		        BufferedReader reader = null;
		         //object is created
		        FileWriter writer = null;
		         
		        try
		        {
		            reader = new BufferedReader(new FileReader(fileToBeModified));
		             
		            //Reading all the lines of input text file one by one and append it to oldContent
		           
		            String line = reader.readLine();
		             //reads the line
		            while (line != null) 
		            {
		                oldContent = oldContent + line + System.lineSeparator();
		                 //old content will take old content with line separator
		                line = reader.readLine();
		            }
		             
		 //Replace all the occurances of oldString with newString using replaceAll() method.Yow will get a newContent
		             
		            String newContent = oldContent.replaceAll(oldString, newString);
		             
		            //Rewriting the input text file with newContent
		    //Now create Filewriter object to write newContent back into the input text file fileToBeModified         
		             writer = new FileWriter(fileToBeModified);
		 //Rewrite the filetoBeModified with newContent using write() method of Filewriter object  
		            writer.write(newContent);
		            //write will take the new content
		        }
		        catch (IOException e)
		        //IOException is for when input or output is failed or interrupted
		        {
		            e.printStackTrace();
		        }
		        finally
		        //this is used to execute important code such as closing connection,it always executed whether is handled or not
		        {
		        	/*the code is prone to exceptions is placed in the try block
		        	 *when exception occurs that exception occurred is handled by the 
		        	 *catch block associated with it
		        	 */
		            try
		            {
		                //Closing the resources
		                 
		                reader.close();
		  //this method closes the stream and releases any system resources associated with it
		                 writer.close();
		 //this method closes the stream,flushing it first          
		            } 
		            catch (IOException e) 
		            {
		            	//prints stacktrace for this throwable object
		                e.printStackTrace();
		            }
		        }
		    }
		     
		    public static void main(String[] args)
		  //static is used for memory management
	//void is used to define the return type of the method
	//String[] args is actually an array of java.lang.String type and it's name is args here
					
		    {
		        modifyFile("D:/student.txt", "10", "95");
		         //here the modify file will modify the text which is in given directory
		        System.out.println("modifications are completed");
		     
		    }
		}
