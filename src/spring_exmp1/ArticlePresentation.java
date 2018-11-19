package spring_exmp1;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.lang.reflect.Method;

import spring_exmp1.implementations.ArticleData2;
import spring_exmp1.implementations.ArticleMetier;
import spring_exmp1.interfaces.IArticleData;
import spring_exmp1.interfaces.IArticleMetier;

public class ArticlePresentation {

	public static void main(String[] args) {
		try {
			File fXmlFile = new File("src/config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			Node dataClassNode = doc.getElementsByTagName("data-class").item(0);
			
			String dataClassName = dataClassNode.getTextContent();
			System.out.println("\nCurrent Element :" + dataClassName);
			
			Node metierClassNode = doc.getElementsByTagName("metier-class").item(0);
			
			String metierClassName = metierClassNode.getTextContent();
			System.out.println("\nCurrent Element :" + metierClassName);
			
			Class cData = Class.forName(dataClassName);
			IArticleData articleData = (IArticleData) cData.newInstance();

			Class cMetier = Class.forName(metierClassName);
			IArticleMetier articleMetier = (IArticleMetier) cMetier.newInstance();

			Method meth = cMetier.getMethod("setArticleData", new Class[] { IArticleData.class });
			meth.invoke(articleMetier, new Object[] { articleData });
			System.out.println(articleMetier.computePrice());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
