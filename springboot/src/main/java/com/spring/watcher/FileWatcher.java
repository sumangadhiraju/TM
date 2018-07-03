package com.spring.watcher;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import com.spring.util.CommonUtil;

public class FileWatcher implements Runnable{

	public void fileWatch() {
		    
		 String path = CommonUtil.getResources("");
		 Path myDir = Paths.get(path);    
			try {
		        WatchService watcher = myDir.getFileSystem().newWatchService();
		        myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, 
		        StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

		        WatchKey watckKey = watcher.take();

		        List<WatchEvent<?>> events = watckKey.pollEvents();
		        for (WatchEvent event : events) {
		             if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
		                 System.out.println("Created: " + event.context().toString());
		             }
		             if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
		                 System.out.println("Delete: " + event.context().toString());
		             }
		             if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
		                 System.out.println("Modify: " + event.context().toString());
		             }
		         }
		        
		     } catch (Exception e) {
		         System.out.println("Error: " + e.toString());
		     }
	}
	
	
	public static void main(String args[]) {
		//fileWatch();
	}


	@Override
	public void run() {
		fileWatch();
		
	}
}
