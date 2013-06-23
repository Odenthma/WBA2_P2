package de.odenthma.geocache.xmppstuff;

import java.util.List;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.packet.DiscoverInfo;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PubSubManager;

public class test {

	public static void main(String[] args) throws XMPPException{
		PubSub ps = new PubSub();
//			ps.connect(hostname, port, username, password);
//		ps.createNode("orte", true);
		
//		ps.createNode("test2", false);
//				ps.deleteNode("Tsdasdassss");
//				ps.createNode("cache", true);
//				ps.getNodes();

//				ps.subscribe("cache");
//				ps.getSubscriptionFromNode("cache");
//				ps.isSubscriberof("cache");

//				ps.subscribe("orte");
//				ps.unsubscribe("Elektroniks");
////
//				ps.getAllSubscriptions();
//				ps.getSubscriptionFromNode("cache");
////
				ps.addPayloadMessage("0", "orte", "MeinOrtGM", "22.06.2013", "14:44", "sdas.2231" );
//				ps.addMessage("1","cache");
//				ps.printMessage("cache", 1);
//				ps.deleteMessage("1", "TestKnotenSPL");
				ps.printAllMessagesFromNode("orte");


				ps.disconnect();
	}
	
	
	public static void register(){
		 ch = new ConnectionHandler();
		 
		if (ch.connect(hostname, port)) {
			 if (ch.register(username, password)) {
                System.out.println("Connection and Registration Success!");
            } 
            else {
            	 System.out.println("Registrierung fehlgeschlagen!");
            }
        } 
		else {
        	 System.out.println("Verbindungsherstellung fehlgeschlagen!");
        }
	}
	public static void login(){
		ch = new ConnectionHandler();

        if (ch.connect(hostname, port)) {

            if (ch.login(username, password)) {
                // success
                System.out.println("Connection and Login Success!");
            } 
            else {
            	 System.out.println("Anmeldung fehlgeschlagen!");
            }
        } 
        else {
        	 System.out.println("Verbindungsherstellung fehlgeschlagen!");
        }
        setConnectionHandler();
	}
	public static void publish() throws XMPPException{
		
		ch.publishWithPayload("meins", "testpayloads");
		
	}
	
	 public static void setConnectionHandler() {

		 ch.addItemListener(new ItemListener());
	    }
}
