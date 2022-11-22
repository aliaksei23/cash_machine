package service.impl;

import entity.AllData;
import service.DataWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DataWriterImpl implements DataWriter {

    private final static String filePath = "src/main/resources/data.txt";

    private AllData allData;

    public DataWriterImpl(AllData allData) {
        this.allData = allData;
    }

    @Override
    public void writeData() {
        File file = new File(filePath);

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, List<String>> entry :
                    allData.getData().entrySet()) {
                bf.write(entry.getKey() + " "
                        + entry.getValue().get(0) + " " + entry.getValue().get(1));
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

