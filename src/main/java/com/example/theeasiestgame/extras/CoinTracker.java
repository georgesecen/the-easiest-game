package com.example.theeasiestgame.extras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CoinTracker {

    private File filePath = new File("coinCount.txt");

    public CoinTracker(){};

    public int getCoinCount(){ // Returns the count from file
        try {
            //File coinCountFile = new File(this.filePath);
            Scanner scanner = new Scanner(this.filePath);

            String coinCount = scanner.nextLine();
            scanner.close();
            return Integer.parseInt(coinCount);

        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong check CoinTracker class.");
            e.printStackTrace();
            return -1;
        }
    }

    public void editCoinCount(int amount){ // Can make the coin count any value you specify
        try {
            FileWriter myWriter = new FileWriter(this.filePath);
            myWriter.write(String.valueOf(amount));
            myWriter.close();
        }catch (IOException e) {
            System.out.println("Something went wrong check CoinTracker class.");
            e.printStackTrace();
        }
    }

    public void addToCoinCount(int amount){ // Adds value to existing coin count
        int currentCount = getCoinCount();
        int newAmount = currentCount + amount;

        editCoinCount(newAmount);
    }
}

