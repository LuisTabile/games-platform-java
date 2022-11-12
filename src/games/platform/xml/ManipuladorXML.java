package games.platform.xml;

import games.platform.logger.AppLogger;
import games.platform.utils.LoggerGlobal;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ManipuladorXML {

    /**
     * Criação de um objeto Document
     */
    public static Document newDocument() {
        try {

            DocumentBuilderFactory dbF = DocumentBuilderFactory.newInstance();
            return dbF.newDocumentBuilder().newDocument();

        } catch (ParserConfigurationException ex) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro ao conectar o Banco de Dados. " + ex.getMessage());
            return null;
        }
    }

    /**
     * Obtenção de um objeto XPath Expression
     */
    public static XPathExpression getXPathExpression(String xpath) {
        try {

            XPath localxpath = XPathFactory.newInstance().newXPath();
            XPathExpression expr = localxpath.compile(xpath);
            return expr;

        } catch (XPathExpressionException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static String xmlParaString(Document doc) {
        try {

            Source source = new DOMSource(doc);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Result result = new StreamResult(stream);
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.setOutputProperty(OutputKeys.INDENT, "yes");
            xformer.transform(source, result);
            return stream.toString();

        } catch (TransformerFactoryConfigurationError | IllegalArgumentException | TransformerException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static Document stringParaXml(String text) {
        try {

            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            return builder.parse(new ByteArrayInputStream(text.getBytes()));

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex);
            return null;
        }
    }

    // Leitura de um Arquivo XML
    // Montar um objeto Document a partir de um arquivo texto XML
    public static Document readXmlFile(String filename) {
        try {

            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            return builder.parse(filename);

        } catch (IOException | SAXException | ParserConfigurationException ex) {
            System.out.println(ex);
            return null;
        }
    }

    // Transformar um objeto Document em um arquivo texto XML
    public static void writeXmlFile(Document doc, String filename) {
        try {

            Source source = new DOMSource(doc);
            File file = new File(filename);
            Result result = new StreamResult(file);

            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.setOutputProperty(OutputKeys.INDENT, "yes");
            xformer.transform(source, result);

        } catch (TransformerException | TransformerFactoryConfigurationError ex) {
            System.out.println(ex);
        }
    }
}
