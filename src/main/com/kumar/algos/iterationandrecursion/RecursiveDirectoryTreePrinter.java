package main.com.kumar.algos.iterationandrecursion;

import java.io.File;

public final class RecursiveDirectoryTreePrinter {
	private static final String SPACES = " ";
	
	public static void main(String args[]){
		
		print(new File("C:\\Manoj\\Progamming\\JAVA"),SPACES);
		
	}
	
	public static void print(File f,String sps){
		
		System.out.print(sps);
		if(f.isDirectory()){
			System.out.print(f.getName()+" -->>\n");
		}else{
			System.out.print(f.getName()+"\n");
		}
		if(f.isDirectory()){
			print(f.listFiles(),sps+SPACES);
		}
	}

	public static void print(File[] fs, String sps){
		for(File f : fs){
			print(f,sps+SPACES);
		}
	}

}
