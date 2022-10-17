package com.ll.exam;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class Util {
    public static void saveToFile(String path, String body) {
        try (RandomAccessFile stream = new RandomAccessFile(path, "rw");
             FileChannel channel = stream.getChannel()) {
            byte[] strBytes = body.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
            buffer.put(strBytes);
            buffer.flip();
            channel.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void mkdir(String path) {
        File dir = new File(path);
        dir.mkdir();
    }

    public static String readFromFile(String path) {
        try (RandomAccessFile reader = new RandomAccessFile(path, "r")) {
            String body = "";

            String line = null;
            while ((line = reader.readLine()) != null) {
                body += new String(line.getBytes("iso-8859-1"), "utf-8") + "\n";
            }

            return body.trim();
        } catch (IOException e) {
        }

        return "";

    }

    public static void deleteDir(String test_data) {
        Path rootPath = Paths.get(test_data);
        try (Stream<Path> walk = Files.walk(rootPath)) {
            walk.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {

        }
    }
}
