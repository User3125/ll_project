package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AnimalFactory {

	private static final String ORIGIN = "src/input.xml";
	protected List<Animal> zoo;
	
	private static AnimalFactory instance = null;
	
	public static AnimalFactory getInstance() {
		if (instance == null) {
			synchronized(AnimalFactory.class) {
				if (instance == null) {
					instance = new AnimalFactory();
				}
			}
		}
		return instance;
	}
	
	private AnimalFactory() {
		this.zoo = new ArrayList<Animal>();
		
		separate(0);
        System.out.println("        XML REGISTRY OF THE ZOO LIVESTOCK         ");
        separate(0);
		try {
	         File inputFile = new File(ORIGIN);
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder;
	         dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         XPath xPath =  XPathFactory.newInstance().newXPath();
	         String expression = "/animal/*";	        
	         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
	         for (int i = 0; i < nodeList.getLength(); i++) {
	             Node nNode = nodeList.item(i);
	             Element eElement = (Element) nNode;
	             switch (nNode.getNodeName()) {
	             case "cat":
	                 //System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
	            	 zoo.add(new Cat(eElement.getElementsByTagName("name").item(0).getTextContent(),
	            			 Double.parseDouble(eElement.getElementsByTagName("weight").item(0).getTextContent()),
	            			 Double.parseDouble(eElement.getElementsByTagName("weight").item(0).getTextContent()), getFamily(eElement)));
	            	 break;
	             case "dog":
	            	 //System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
	            	 zoo.add(new Dog(eElement.getElementsByTagName("name").item(0).getTextContent(),
	            			 Double.parseDouble(eElement.getElementsByTagName("weight").item(0).getTextContent()),
	            			 Double.parseDouble(eElement.getElementsByTagName("weight").item(0).getTextContent()), getFamily(eElement)));
	            	 break;
	             case "pigeon":
	            	 //System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
	            	 zoo.add(new Pigeon(eElement.getElementsByTagName("name").item(0).getTextContent(),
	            			 Double.parseDouble(eElement.getElementsByTagName("weight").item(0).getTextContent()),
	            			 Double.parseDouble(eElement.getElementsByTagName("weight").item(0).getTextContent()), getFamily(eElement)));
	            	 break;
            	 default:
            		 break;
	             }
	         }
	         System.out.println("The reading of registry completed successfully.");
	         separate(0);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
	
	public void serveList() {
		System.out.println("The list of animals kept in the zoo:");
		separate(0);
      	System.out.println(padLeft("No", 2) + ". " + padRight("Name", 25) + " " + padRight("Species", 10) + " " + padRight("Family", 10));
		separate(1);
        for (int i=0; i<zoo.size(); i++) {
        	System.out.println(padIntLeft(String.valueOf(i+1), 2) + ". " + padRight(zoo.get(i).getName(), 25) + " " + padRight(zoo.get(i).getSpecies(), 10) + " " + padRight(zoo.get(i).getFamily(), 10));
        }
		separate(0);
	}
	
	public void serveDetails(int id) {
		System.out.println("The details for entry no." + id + ":");
		separate(1);
		try {
			zoo.get(id-1).show();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("We are sorry, there is no such entry.");
		}
		
		separate(0);
	}
	
	public void separate(int type) {
		switch (type) {
		case 0:
			System.out.println("==================================================");
			break;
		case 1:
			System.out.println("--------------------------------------------------");
			break;
		default:
			break;
		}
	}

	private String getFamily(Element eElement) {
		String result = "none";
		String isMammal = "none";
		String isBird = "none";
		String isBug = "none";
		String isSpider = "none";
		try {
			isMammal = eElement.getElementsByTagName("mammal").item(0).getTextContent();
			if (isMammal.equals("1")) {
				result = "mammal";
			}
		} catch (NullPointerException e) {}
		try {
			isBird = eElement.getElementsByTagName("bird").item(0).getTextContent();
			if (isBird.equals("1")) {
				result = "bird";
			}
		} catch (NullPointerException e) {}
		try {
			isBug = eElement.getElementsByTagName("bug").item(0).getTextContent();
			if (isBug.equals("1")) {
				result = "bug";
			}
		} catch (NullPointerException e) {}
		try {
			isSpider = eElement.getElementsByTagName("spider").item(0).getTextContent();
			if (isSpider.equals("1")) {
				result = "spider";
			}
		} catch (NullPointerException e) {}
		return result;
	}
	
	public static String padIntLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s).replace(' ', '0');  
	}
	
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}

	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}

}
