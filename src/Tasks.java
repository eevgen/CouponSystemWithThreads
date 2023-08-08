import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.BatchUpdateException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tasks {

    private Lock lock = new ReentrantLock();
    private BufferedReader bf;

    public Tasks(){
        try {
            bf = new BufferedReader(new FileReader("/Users/jeka/Documents/ProjectsJava/CouponSystemWithThreads/src/AvailableCoupons"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String typeMessage() {
        return (new Scanner(System.in)).nextLine();
    }

    public void putMessage(LinkedList<String> messageList){
        lock.lock();
        try {
            String message = typeMessage();
            messageList.add(message);
            System.out.println("I am putting coupon to the list");
        } finally {
            lock.unlock();
        }
    }

    public void getMessage(LinkedList<String> messageList){
        lock.lock();
        try {
            String message = messageList.getLast();
            System.out.println("I am taking coupon from a list");
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(message.equals(line)?"Success in using coupon " + message : "Coupon is wrong");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}
