package com.sample.readdata;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class readXml {

	public static void main(String[] args) {

		File dir = new File("d:\\sampledata\\sample.xml");
		readXml();
	}

	public static void readXml(){
		try {

			File fXmlFile = new File("d:\\sampledata\\sample.xml");
			//File fXmlFile = new File("C:/Users/HP/Desktop/solution.xml");
			/*DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("dict");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("id : " + eElement.getAttribute("id"));
					System.out.println("typeId : " + eElement.getElementsByTagName("typeId").item(0).getTextContent());
					System.out.println("startLocation : " + eElement.getElementsByTagName("startLocation").item(0).getTextContent());
					System.out.println("endLocation : " + eElement.getElementsByTagName("endLocation").item(0).getTextContent());
					System.out.println("timeSchedule : " + eElement.getElementsByTagName("timeSchedule").item(0).getTextContent());
					System.out.println("returnTodepot : " + eElement.getElementsByTagName("returnTodepot").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Document doc = null;
		try {
			doc = dBuilder.parse(fXmlFile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList dictonaryList = doc.getElementsByTagName("dict");

		for (int i = 0; i < dictonaryList.getLength(); i++) {
			Node node = dictonaryList.item(i); // this is node under track info
			System.out.println(node.getTextContent());
		}
		}
		finally{}
}
}
