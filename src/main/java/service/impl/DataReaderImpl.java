package service.impl;

import entity.AllData;
import service.DataReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DataReaderImpl implements DataReader {
    private final static String filePath = "src/main/resources/data.txt";
    private List<String> stringFromFile = new ArrayList<>();

    @Override
    public Map<String, List<String>> getData(AllData allData) {
        readAllData();
        for (String s : stringFromFile) {
            String[] strings = s.split(" ");
            String cardNum = strings[0];
            String cardPin = strings[1];
            String cardBalance = strings[2];
            List<String> pinAndBalance = new ArrayList<>();
            pinAndBalance.add(cardPin);
            pinAndBalance.add(cardBalance);
            allData.getData().put(cardNum, pinAndBalance);
        }
        return allData.getData();
    }

    private void readAllData() {
        try {
            stringFromFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
