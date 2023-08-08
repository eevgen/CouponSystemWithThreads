import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "AvailableCoupons.txt";

    public static void main(String[] args) throws Exception {
        Tasks tasks = new Tasks();
        LinkedList<String> list = new LinkedList<>();

        Thread takingThread = new Thread(() -> {
            tasks.putMessage(list);
        });
        Thread puttingThread = new Thread(() -> {
            tasks.getMessage(list);
        });
        takingThread.start();
        puttingThread.start();

    }
}