package com.example.theeasiestgame.extras;

import java.io.*;
import java.util.ArrayList;

public class ShopTracker {
    private File filePath = new File("shopItems.txt");

    public ShopTracker() {}

    public ArrayList<Integer> getShopDataFromFile(){ // Returns all list of item status' 0 means not purchased 1 means user hs purchased already
        ArrayList<Integer> shopItemsList = new ArrayList<>();
        // Reading from file
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.filePath));
            while((line = in.readLine()) != null){
                if(line != ""){
                    shopItemsList.add(Integer.parseInt(line));
                }
            }
            in.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return shopItemsList;
    }

    public void updateShopsFileFromList(ArrayList<Integer> list){ // Updates the file from arraylist
        String data = "";

        // Building the string to write to file
        for (Integer i : list) {
            data += i + "\n";
        }

        // Actually writing the data to file
        try {
            FileWriter myWriter = new FileWriter(this.filePath);
            myWriter.write(data);
            myWriter.close();
        }catch (IOException e) {
            System.out.println("Something went wrong check CoinTracker class.");
            e.printStackTrace();
        }
    }

    
}
