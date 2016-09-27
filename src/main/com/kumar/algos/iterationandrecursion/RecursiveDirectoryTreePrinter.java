package main.com.kumar.algos.iterationandrecursion;

import java.io.File;
import java.util.Stack;

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
	
	public void  iterativeFolderPrinter(File file){

		File[] fList = file.listFiles();
		Stack<File> st = new Stack<File>();
		Stack<Integer> paddingSt = new Stack<Integer>();
		String sps = "";
		int pad = 0;

		while(true){
			for(File f : fList ){

				if(f.isDirectory()){
					//System.out.print(sps+f.getName()+"\n");
					
					st.add(f);
					paddingSt.add(pad+1);
					//System.out.println(f.getName() +" "+ (pad+1));
				}else{
					System.out.print(sps+f.getName()+"\n");
				}
			}
			if(st.isEmpty()){
				break;
			}
			pad = paddingSt.pop();
			sps = getPadding(pad);
			System.out.println(sps+sps.length()+st.peek().getName());
			sps+=" ";
			fList = st.pop().listFiles();
		}

	}

	public String getPadding(int numSpaces){
		String s= "";
		for(int i = 0 ; i < numSpaces; i++){
			s= s + " ";
		}
		return s;
	}


}
