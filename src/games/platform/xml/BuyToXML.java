package games.platform.xml;

import games.platform.logger.AppLogger;
import games.platform.models.Buy;
import games.platform.models.Client;
import games.platform.models.Game;
import games.platform.models.Publisher;
import games.platform.utils.LoggerGlobal;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BuyToXML {
    
    private static Document doc;
    
    public static void mountXMLFromBuys(ArrayList<Buy> buys) {

        try {
            
            doc = ManipuladorXML.newDocument();

            Element root = doc.createElement("Compras");
            doc.appendChild(root);
            
            buys.forEach((buy) -> {
                root.appendChild(mountXMLToBuy(buy));
            });

            ManipuladorXML.writeXmlFile(doc, "./compras.xml");
            
        } catch (Exception e) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro ao conectar o Banco de Dados. " + e.getMessage());
        }

    }
    
    private static Element mountXMLToBuy(Buy buy){
        Element rootBuy = doc.createElement("Venda");

        Element id = doc.createElement("Id");
        id.setTextContent(String.valueOf(buy.getId()));
        rootBuy.appendChild(id);
        
        Element client = mountXMLToClient(buy.getClient());
        rootBuy.appendChild(client);

        Element game = mountXMLToGame(buy.getGame());
        rootBuy.appendChild(game);

        return rootBuy;
    }
    
    public static Element mountXMLToClient(Client client){
        Element rootClient = doc.createElement("Cliente");

        Element id = doc.createElement("Id");
        id.setTextContent(String.valueOf(client.getId()));
        rootClient.appendChild(id);

        Element name = doc.createElement("Nome");
        name.setTextContent(client.getName());
        rootClient.appendChild(name);
        
        return rootClient;
    }
    
    private static Element mountXMLToGame(Game game){
        Element rootGame = doc.createElement("Jogo");

        Element id = doc.createElement("Id");
        id.setTextContent(String.valueOf(game.getId()));
        rootGame.appendChild(id);

        Element name = doc.createElement("Nome");
        name.setTextContent(game.getName());
        rootGame.appendChild(name);
        
        Element price = doc.createElement("Preço");
        price.setTextContent(String.valueOf(game.getPrice()));
        rootGame.appendChild(price);
        
        Element publisher = mountXMLToPublisher(new Publisher(game.getPublisherId(), game.getPublisherName()));
        rootGame.appendChild(publisher);
        
        return rootGame;
    }
    
    
    private static Element mountXMLToPublisher(Publisher publisher){
        Element rootClient = doc.createElement("Editora");

        Element id = doc.createElement("Id");
        id.setTextContent(String.valueOf(publisher.getId()));
        rootClient.appendChild(id);

        Element name = doc.createElement("Nome");
        name.setTextContent(publisher.getName());
        rootClient.appendChild(name);
        
        return rootClient;
    }
    
}
