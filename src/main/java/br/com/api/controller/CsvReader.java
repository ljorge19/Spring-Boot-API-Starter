package br.com.api.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvReader {

	@GetMapping("/ReadCsv")
	public List<String> retornarRequisicoes() throws IOException {
		
		Path path = Paths.get("C:\\Users\\Leandro Jorge\\Desktop\\Atividades.csv");
		String line = "";
		List<String> dados = new ArrayList<String>();
		
		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			
			try {
				while((line = reader.readLine()) != null) {
					String[] values = line.split(";"); 
					System.out.println(line);
					dados.add(line);
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return dados;
	}
	

}
