package com.example.CsvDemo.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Service
public class CsvService {

    public List<String[]> readCsvFile(String filePath) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            return csvReader.readAll();
        }
    }

    public void writeCsvFile(String filePath, List<Object[]> data) throws IOException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath, true))) {
            for (Object[] row : data) {

                String[] stringRow = new String[row.length];
                for (int i = 0; i < row.length; i++) {
                    stringRow[i] = String.valueOf(row[i]);
                }
                csvWriter.writeNext(stringRow);
            }
        }
        }
        public void deleteByName(String filePath, String nameToDelete) throws IOException, CsvException {
        List<String[]> records = readCsvFile(filePath);
        Iterator<String[]> iterator = records.iterator();

        boolean deleted = false;
        while (iterator.hasNext()) {
            String[] record = iterator.next();
            if (record.length > 0 && record[0].equals(nameToDelete)) {
                iterator.remove();
                deleted = true;
                break;
            }
        }

        if (deleted) {
            try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
                csvWriter.writeAll(records);
            }
            System.out.println("Row with name '" + nameToDelete + "' deleted successfully");
        } else {
            System.out.println("Row with name '" + nameToDelete + "' not found");
        }
    }



    public String[] findRowByName(String filePath, String nameToFind) throws IOException, CsvException {
        List<String[]> records = readCsvFile(filePath);

        for (String[] record : records) {
            if (record.length > 0 && record[0].equals(nameToFind)) {
                return record;
            }
        }

        return null;
    }

    public void updateRowByName(String filePath, String nameToUpdate, Object[] newData) throws IOException, CsvException {
        List<String[]> records = readCsvFile(filePath);
        Iterator<String[]> iterator = records.iterator();

        while (iterator.hasNext()) {
            String[] record = iterator.next();
            if (record.length > 0 && record[0].equals(nameToUpdate)) {

                for (int i = 0; i < newData.length; i++) {
                    record[i] = String.valueOf(newData[i]);
                }
                break;
            }
        }

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            csvWriter.writeAll(records);
        }
    }
}




