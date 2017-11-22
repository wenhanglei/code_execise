package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class ConvertEncoding {
	
	public static void getFileName(File f, List<File> files) {
		if(!f.exists() || f == null) return;
		for(File file : f.listFiles()) {
			if(file.isDirectory()) {
				getFileName(file, files);
			}else if(file.isFile()) files.add(file);
		}
	}
	
	public static void main(String[] args) {
		String dirPath = "/E:/think_in_java/code_exercise/src";
//		String dirPath = "/e:/test";
		File f = new File(dirPath);
		List<File> files = new LinkedList<File>();
		getFileName(f, files);
		for(File fi : files){
			try{
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(
						new FileInputStream(fi)));
				StringBuilder sb = new StringBuilder();
				String line = reader.readLine();
				while(line != null){
					String nextLine = reader.readLine();
					if(nextLine == null) sb.append(line);
					else sb.append(line + "\n");
					line = nextLine;
				}
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(
						new FileOutputStream(fi), "utf-8"));
				writer.write(sb.toString());
				writer.flush();
				writer.close();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}