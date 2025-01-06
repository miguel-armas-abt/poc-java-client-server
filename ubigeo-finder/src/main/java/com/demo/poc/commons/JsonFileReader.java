package com.demo.poc.commons;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonFileReader {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  public <T> T readObjectFromFile(String filePath, TypeReference<T> typeReference) {
    try {
      InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
      return objectMapper.readValue(inputStream, typeReference);
    } catch (IOException ioException) {
      throw new RuntimeException("error reading json file: " + ioException.getMessage(), ioException);
    }
  }

  public <T> List<T> readListFromFile(String filePath, TypeReference<List<T>> typeReference) {
    try {
      InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
      return objectMapper.readValue(inputStream, typeReference);
    } catch (IOException ioException) {
      throw new RuntimeException("error reading json file: " + ioException.getMessage(), ioException);
    }
  }

}