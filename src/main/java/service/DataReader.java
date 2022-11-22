package service;

import entity.AllData;

import java.util.List;
import java.util.Map;

public interface DataReader {

    Map<String, List<String>> getData(AllData allData);
}
