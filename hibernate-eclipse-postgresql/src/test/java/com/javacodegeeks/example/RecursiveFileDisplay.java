package com.javacodegeeks.example;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gson.Gson;

public class RecursiveFileDisplay {

	public static void main(String[] args) {
		File currentDir = new File("C:\\Users\\Nalin\\Documents\\angular-workspace\\Angular8TestingProject"); // current directory
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(displayDirectoryContents(currentDir)));
	}

	public static ArrayList<HashMap<String, Object>> displayDirectoryContents(File dir) {
		
		ArrayList<HashMap<String, Object>> fileList=new ArrayList<HashMap<String,Object>>();
		File[] files = dir.listFiles();
		for (File file : files) {
			if(file.getName().startsWith(".")) {
				continue;
			}
			if (file.isDirectory()) {
//					System.out.println("directory:" + file.getCanonicalPath());
				LinkedHashMap<String, Object> fileHash1 = new LinkedHashMap<String, Object>();
				fileHash1.put("name", file.getName());
				fileHash1.put("type", "folder");
//				fileHash1.put("path",file.getAbsolutePath());
				fileHash1.put("chield",displayDirectoryContents(file));
				fileList.add(fileHash1);
//					fileList.add(e)
//					fileHash.put("path",file.getPath());
//					displayDirectoryContents(file);
			} else {
				LinkedHashMap<String, Object> fileHash = new LinkedHashMap<String, Object>();
				fileHash.put("name", file.getName());
				fileHash.put("type", "file");
				fileHash.put("path",file.getAbsolutePath());
				fileList.add(fileHash);
//					System.out.println("     file:" + file.getCanonicalPath());
			}
		}
		return fileList;
	}

}