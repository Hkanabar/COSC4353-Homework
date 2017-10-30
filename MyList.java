// Harshin Kanabar
// COSC 4353
// Assignment 0
// 09/11/2017
package MyList.Homework;

import java.util.Scanner;
import java.lang.Double;
import org.apache.commons.cli.*;
public class MyList implements Comparable {

	public static void main(String[] args) {
		//MyList aList = new MyList();
		int result = -1;
		
		Options userInput = new Options();
		Option type = Option.builder("t").longOpt("type").hasArg().numberOfArgs(1).required(true).build();
		Option key = Option.builder("k").longOpt("key").hasArg().numberOfArgs(1).required(true).build();
		Option vals = Option.builder("l").longOpt("list").hasArg().numberOfArgs(Option.UNLIMITED_VALUES).valueSeparator(' ').required(true).build();
		userInput.addOption(type);
		userInput.addOption(key);
		userInput.addOption(vals);
		CommandLineParser theparser = new DefaultParser();
		CommandLine cmd;
		try {
			cmd = theparser.parse(userInput,args);		
		} catch(ParseException e) {
			e.printStackTrace();
			System.exit(0);
			return;
		}
		String theType = cmd.getOptionValue("type");
		String[] stringVals = cmd.getOptionValues("list");
		if(theType.equals("i")) {
			Integer[] mylist = new Integer[stringVals.length];
			int mykey = Integer.parseInt(cmd.getOptionValue("key"));
			for(int x = 0; x< stringVals.length; x++) {
				mylist[x] = Integer.parseInt(stringVals[x]);
			}
			result = binSearch(mylist, mykey);
			
		}
		else if(theType.equals("s")) {
			String mykey = cmd.getOptionValue("key");
			result = binSearch(stringVals,mykey);
		}
		else {
			System.exit(1);
		}
		System.out.println(result);
	}
		
	
//		Scanner input = new Scanner(System.in);
//		String theNums = "";
//		System.out.println("Enter the list of numbers:");
//		
//		theNums = input.nextLine();
//		String[] tokens = theNums.split(" ");
//		
//		Double[] theList = new Double[tokens.length];
//		
//		for(int x = 0; x <tokens.length; x++)
//		{
//			theList[x] = Double.parseDouble(tokens[x]);
//		}
//		
//		Double[] sorted = sortList(theList);
//		for(int a = 0; a<theList.length; a++){	
//		System.out.print(theList[a]+ " ");
//		}
//		System.out.println("");
//		for (int b = 0; b<sorted.length;b++ )
//			System.out.print(sorted[b]+ " ");
//		System.out.println("Enter the key to search for:");
//		
//		double theKey = input.nextDouble();
//		
//		int keyFound = binSearch(sorted, theKey);
//		if(keyFound == 1){
//			for(int x =0; x<theList.length; x++)
//			{
//				if(theList[x] == theKey)
//					System.out.println(x);
//			}
//		}
//		else
//			System.out.println("The key was not found!");
//		}
	
		

	
	
	static int binSearch(Comparable[] theList, 	Comparable key)
	{
		
		if(theList.length == 0)
			return -1;
		int low = 0;
		int high = theList.length -1;
		while(high>=low){
			int mid = (high+low)/2;
			if(theList[mid].compareTo(key) ==0) 
				return 1;
			else if (theList[mid].compareTo(key)<0)
				low = mid+1;
			else if (theList[mid].compareTo(key)>0)
				high = mid-1;
		}
		
		return 0;
	}
	
	static Double[] sortList(Double[] unsorted) 
	{
		
		 Double[] temp = new Double[unsorted.length];
		 for(int x = 0; x<unsorted.length; x++)
			 temp[x]= unsorted[x];
		 Double val;
	        for (int i = 1; i < temp.length; i++) {
	            for(int j = i ; j > 0 ; j--){
	                if(temp[j] < temp[j-1]){
	                    val = temp[j];
	                    temp[j] = temp[j-1];
	                    temp[j-1] = val;
	                }
	            }
	        }
	        return temp;
	}





	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
