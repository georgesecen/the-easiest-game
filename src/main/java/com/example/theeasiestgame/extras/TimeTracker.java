package com.example.theeasiestgame.extras;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class TimeTracker {

    private File filePath = new File("timeLeaderboard.txt");

    private static LocalTime startTime = null;

    public TimeTracker(){};


    public void startTimer(){
        startTime = LocalTime.now();
    }

    public ArrayList<Integer> getTimesFromFile(){ // Returns all the times from file to list
        ArrayList<Integer> timesList = new ArrayList<>();
        // Reading from file
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.filePath));
            while((line = in.readLine()) != null){
                if(line != ""){
                    timesList.add(Integer.parseInt(line));
                }
            }
            in.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return timesList;
    }

    public int endTimer(){ // Calculates how many minutes, seconds, nanoseconds have passed since the timer started and adds data to file, returns time in seconds
        if(startTime != null) {

            LocalTime currentTime = LocalTime.now();
            LocalTime minutesDifference = currentTime.minus(Duration.ofMinutes(startTime.getMinute()));
            LocalTime secondsDifference = currentTime.minus(Duration.ofSeconds(startTime.getSecond()));
            LocalTime nanoSecondDifference = currentTime.minus(Duration.ofNanos(startTime.getNano()));

            // Actual minutes and seconds from when timer started
            int minutes = minutesDifference.getMinute();
            int seconds = secondsDifference.getSecond();

            // Adding new time to file
            // Getting current file contents
            String fileData = getFileContent();

            // Total seconds
            int totalSeconds = (minutes * 60) + seconds;

            // Adding new time to current file content string (uses space to seperate minutes from seconds)
//        String newTime = String.valueOf(minutes) + " " + String.valueOf(seconds);
            String newTime = String.valueOf(totalSeconds);
            fileData += newTime; //+ "\n";

            // Writing new data to file
            logTime(fileData);


            // Resets the timer
            clearTimer();

            // Returns time in seconds
            return totalSeconds;
        }
        return 0;
    }

    public void logTime(String times){ // Writes the new time to file
        try {
            FileWriter myWriter = new FileWriter(this.filePath);
            myWriter.write(times);
            myWriter.close();
        }catch (IOException e) {
            System.out.println("Something went wrong check CoinTracker class.");
            e.printStackTrace();
        }
    }

    public String getFileContent(){ // Gets all of the data in timer file
        // Reading from file
        String fileData = "";
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.filePath));
            while((line = in.readLine()) != null){
                fileData += line + "\n";
            }
            in.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return fileData;
    }

    public void clearTimer(){
        startTime = null;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
}
