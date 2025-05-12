package com.sec13.myNio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class F_FileWalk extends SimpleFileVisitor<Path>{
	
	private long totalSize = 0;
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
		totalSize += attrs.size();
		return super.visitFile(file,  attrs);
	}
	
	public long getTotalSize() {
		return totalSize;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		Path start = Paths.get(".");
		F_FileWalk visitor = new F_FileWalk();
		Files.walkFileTree(start, visitor);
		System.out.println("Total size :" + visitor.getTotalSize());
	}

}
