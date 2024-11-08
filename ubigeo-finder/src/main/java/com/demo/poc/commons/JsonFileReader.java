package com.demo.poc.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonFileReader {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  public <T> T readObjectFromFile(Class<T> type, String filePath) {
    try {
      InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
      return objectMapper.readValue(inputStream, type);
    } catch (IOException ioException) {
      throw new IllegalArgumentException("Error reading JSON file", ioException);
    }
  }

  public <T> List<T> readListFromFile(Class<T> type, String filePath) {
    try {
      InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
      return objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, type));
    } catch (IOException ioException) {
      throw new IllegalArgumentException("Error reading JSON file", ioException);
    }
  }

}