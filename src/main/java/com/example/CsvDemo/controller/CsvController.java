package com.example.CsvDemo.controller;

import com.example.CsvDemo.service.CsvService;
import com.opencsv.exceptions.CsvException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/csv")
public class CsvController {
    @Autowired
    private CsvService csvService;
    private static Logger logger = Logger.getLogger("Info Logging");

    @GetMapping("/read")
    public List<String[]> readCsv() throws IOException, CsvException {
         logger.info("To Read Data from the csv file");
        String filePath = "C:\\Users\\puppa\\Downloads\\CsvDemo\\CsvDemo\\src\\main\\resources\\Example.csv";
        return csvService.readCsvFile(filePath);
    }

    @GetMapping("/write")
    public void writeCsv(@RequestBody List<Object[]> data) throws IOException {
        logger.info("Write's Data into csv file");
        String filePath = "C:\\Users\\puppa\\Downloads\\CsvDemo\\CsvDemo\\src\\main\\resources\\Example.csv";
        csvService.writeCsvFile(filePath, data);
    }

    @GetMapping("/delete")
    public String deleteByName(@RequestParam String filePath, @RequestParam String nameToDelete) throws IOException, CsvException {
        logger.info("Delete By specified name in the csv file ");
        csvService.deleteByName(filePath, nameToDelete);
        return "Row with name '" + nameToDelete + "' deleted successfully";
    }

    @GetMapping("/find")
    public String[] findRowByName(@RequestParam String filePath, @RequestParam String nameToFind) throws IOException, CsvException {
        logger.info("TO find data by specific name");
        return csvService.findRowByName(filePath, nameToFind);
    }


    @PutMapping("/update")
    public void updateRowByName(@RequestParam String filePath, @RequestParam String nameToUpdate, @RequestBody Object[] newData) throws IOException, CsvException {
        logger.info("To update data by specific name");
        csvService.updateRowByName(filePath, nameToUpdate, newData);
    }

}







