package br.com.api.controller;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@GetMapping("/health")
	public boolean retornarRequisicoes() {
		return true;
	}
	
	@GetMapping("/dataHora")
	public String teste() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String dataFormatada = dateFormat.format(date);
		
		//String dataFinal = dataFormatada.replaceFirst(" "," - ");
		//dataFormatada.replaceFirst(regex, replacement)
		
		String dataFinal = dateFormat.toString();
		XMLGregorianCalendar resultado = null;	
		try {
			resultado = stringToXMLGregorianCalendar("01/01/0001");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		return resultado.toString();
	}
	
	
	@GetMapping("/data2")
	public String data2() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String dataFormatada = dateFormat.format(date);
		 
		return dataFormatada;
	}

	@GetMapping("/array")
	public int teste2() {
		int posicao = 2;
		int[] dias = { 45, 82, 33, 34, 35, 10 };

		for (int i = 0; i < dias.length; i++) {

		}

		return dias[posicao];
	}

	@GetMapping("/data")
	public int teste3() {
		Date d = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		String nome = "";
		int dia = c.get(c.DAY_OF_WEEK);
		switch (dia) {
		case Calendar.SUNDAY:
			nome = "Domingo";
			break;
		case Calendar.MONDAY:
			nome = "Segunda";
			break;
		case Calendar.TUESDAY:
			nome = "Terça";
			break;
		case Calendar.WEDNESDAY:
			nome = "Quarta";
			break;
		case Calendar.THURSDAY:
			nome = "Quinta";
			break;
		case Calendar.FRIDAY:
			nome = "Sexta";
			break;
		case Calendar.SATURDAY:
			nome = "sábado";
			break;
		}
		System.out.println(nome);
		return dia;
	}
	
	
	
	 public XMLGregorianCalendar stringToXMLGregorianCalendar(String s) 
		     throws ParseException, 
		            DatatypeConfigurationException
		 {
		 XMLGregorianCalendar result = null;
		 Date date;
		 SimpleDateFormat simpleDateFormat;
		 GregorianCalendar gregorianCalendar;
		 
		 simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		                date = simpleDateFormat.parse(s);        
		                gregorianCalendar = 
		                    (GregorianCalendar)GregorianCalendar.getInstance();
		                gregorianCalendar.setTime(date);
		                result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		                return result;
		 }

}
