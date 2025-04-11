package com.sec13.myNio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class e_FileWalk extends SimpleFileVisitor<Path> {

    private BufferedWriter writer;

    public e_FileWalk(Path snapshotFile) throws IOException {
        this.writer = Files.newBufferedWriter(snapshotFile); //shapshot.csv 로 쓰기 객체를 생성함 
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String path = file.toString();
        long size = attrs.size();
        FileTime lastModified = attrs.lastModifiedTime();
        writer.write(path + "," + size + "," + lastModified + "\n");
        return FileVisitResult.CONTINUE;
    }


    public void close() throws IOException {
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("/Users/heeyeon/dev/likelion/test");
        Path snapshotFile = Paths.get("/Users/heeyeon/dev/likelion/test/snapshot.csv");
        e_FileWalk visitor = new e_FileWalk(snapshotFile); //FileVisitor를 implements한 클래스로 4개의 메소드를 재정의함 
        Files.walkFileTree(start, visitor); //(Path, FileVisitor)
        visitor.close();
        System.out.println("Snapshot created: " + snapshotFile);
    }
}