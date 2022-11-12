package games.platform.xml;

import games.platform.models.Deposit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;

public class ReadDepositXML {
    public static Deposit getDepositFromFile(String filename) throws Error {

        try {
            Document doc = ManipuladorXML.readXmlFile(filename);
            if (doc == null) {
                throw new Error("Arquivo não encontrado");
            }

            XPathExpression e1 = ManipuladorXML.getXPathExpression("//deposito/id");
            int client_id = (int) ((double) e1.evaluate(doc, XPathConstants.NUMBER));

            XPathExpression e2 = ManipuladorXML.getXPathExpression("//deposito/value");
            float deposit_value = (float) ((double) e2.evaluate(doc, XPathConstants.NUMBER));

            return new Deposit(client_id, deposit_value);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(ReadDepositXML.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("Erro ao ler o arquivo");
        }

    }

}
