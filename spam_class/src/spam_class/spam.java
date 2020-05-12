package spam_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.*;
public class spam
{
  public static void main(String[] argument) 
    {
		String file_location="labels.txt";
		try {
			File input_file = new File("spam_words.txt");
         Scanner x= new Scanner(input_file);
			 String proof="";
			 String spam_or_ham=null;
			 	 			 
			  int flag=0;
			 int i=0,j=0;
			  String input_arr[][]=new String[25][500];
			 while (x.hasNextLine()) 
		 {			 
			 String t=x.nextLine();
			if(flag==0)
			{
				input_arr[i][j]=t;
				flag=1;
				j++;				
			}
			else if((t.isEmpty())||t==" ")
			{
			}
			else if(t=="----"||t.equals("----"))
			{
				flag=0;
				j=0;i++;
			}			
			else{
		  StringTokenizer tokenizer = new StringTokenizer(t,"\t\t");
		 while(tokenizer.hasMoreTokens())
		 {
			input_arr[i][j]=tokenizer.nextToken();
			j++;
		 }
			}			
		}
		 BufferedReader buf_read= new BufferedReader(new FileReader(file_location));
		 String buf_line = buf_read.readLine();
		 while (buf_line!= null) {			 
				  StringTokenizer tokens = new StringTokenizer(buf_line," ");
		 while(tokens.hasMoreTokens())
		 {			
			String token_str1=tokens.nextToken();
			for(int p=0;p<25;p++)
		{
			for(int q=1;q<500;q++)
			{
				 if(token_str1.equalsIgnoreCase(input_arr[p][q]))
				{
					proof=proof+input_arr[p][q]+" ";
					spam_or_ham=input_arr[p][0];
				}
			}
		}			
		 }				
				buf_line = buf_read.readLine();			
		 }
		 buf_read.close();	
		File f= new File("dataset");
File[] listOfFiles = f.listFiles();
int spams=0;
int hams=0;int count_value=0;
    for ( i = 0; i <listOfFiles.length; i++) {			
		count_value=0;
		 BufferedReader read= new BufferedReader(new FileReader(listOfFiles[i]));
		 String line = read.readLine();
		 while (line!= null) {
			 
				  StringTokenizer tok = new StringTokenizer(line," ");
		 while(tok.hasMoreTokens())
		 {
			
			String token_str=tok.nextToken();
			for(int p=0;p<25;p++)
		{
			for(int q=1;q<500;q++)
			{
				if(token_str.equalsIgnoreCase(input_arr[p][q]))
				{
					count_value++;
				}
			}
		}			
		 }		
				line = read.readLine();			
		 }
		 if(count_value>0)
		{
			spams++;
		}
		if(count_value==0)
		{
			hams++;
		}	
		 read.close();
	}		 x.close();		
		System.out.println("spams are "+spams);
		System.out.println("hams are "+hams);
		System.out.println("proof is ");	
		
	ArrayList<String> list=new ArrayList<String>();
    String str_arr[]=proof.split(" ");

    String temp_str=str_arr[0];
    list.add(temp_str);	
	for (int y = 1; y < str_arr.length; y++) {
    if (!(list.contains(str_arr[y]))) {
        list.add(str_arr[y]);
    }
    }
	for(int z=0;z<list.size();z++){
      System.out.print(list.get(z)+" ");
    }	
		
		
		System.out.println(" ");
		
	System.out.println(" category it belogs to "+spam_or_ham);
		
		}
		catch (IOException x) {
			x.printStackTrace();
		}							
	}
  }