package de.odenthma.geocache.xmppstuff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.ServiceDiscoveryManager;
import org.jivesoftware.smackx.packet.DiscoverItems;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormType;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.Node;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.PublishModel;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.Subscription;

public class PubSub {
	
	private XMPPConnection connection;
	private PubSubManager mgr;
	public static String benutzer;
	 private AccountManager ac;

	
//	 public boolean connect(String hostname, int port) {
		 public boolean connect() {
	        if (connection != null && connection.isConnected()) {
	            return true;
	        }

	        ConnectionConfiguration config = new ConnectionConfiguration(hostname,
	                port);
	        connection = new XMPPConnection(config);
	        ac = new AccountManager(connection);

	        try {
	        	connection.connect();
	        	mgr = new PubSubManager(connection, "pubsub."
	                    + connection.getHost());

	        } catch (XMPPException e) {
	            return false;
	        }
	        
	        this.benutzer = hostname;
	        
	        return true;
	    }
	
	 public boolean login(String username, String password) {

	        try 
	        {
	        	connection.login(username, password);
	        } 
	        catch (XMPPException e) {
	            return false;
	        }
	        
	        this.benutzer = username;
	        
	        return true;
	    }

	    public boolean register(String username, String password) {
	        try {
	            ac.createAccount(username, password);
	        } 
	        catch (XMPPException e) {
	            return false;
	        }

	        return true;
	    }
	    
	public void disconnect(){
		
		connection.disconnect();
		System.out.println("Verbindung geschlossen");
		
	}
	
	public void setBenutzer(String benutzer){
		this.benutzer=benutzer;
	}
	
	public String getBenutzer(){
		return benutzer;
	}

	public void createNode(String node, Boolean payload) throws XMPPException{
		 ConfigureForm form = new ConfigureForm(FormType.submit);
	        form.setAccessModel(AccessModel.open);
	        form.setDeliverPayloads(payload);
	        form.setNotifyRetract(true);
	        form.setPersistentItems(true);
	        form.setPublishModel(PublishModel.open);

			deleteNode(node);
			LeafNode leaf = mgr.createNode(node);
			leaf.sendConfigurationForm(form);

//		LeafNode leaf = mgr.createNode(node);
//        ConfigureForm form = new ConfigureForm(FormType.submit);
//        form.setAccessModel(AccessModel.open);
//        form.setDeliverPayloads(payload);
//        form.setNotifyRetract(true);
//        form.setPersistentItems(true);
//        form.setPublishModel(PublishModel.open);
//        leaf.sendConfigurationForm(form);
//        System.out.println(node + " angelegt\n");
        
	}
	
	public void deleteNode(String node) {
		
		try {
			mgr.deleteNode(node);
			System.out.println(node + " gelöscht\n");
		} 
		catch (XMPPException e) {
			System.out.println(node + " kann nicht gelˆscht werden\n");
		}
		
		
	}
	
	public void subscribe(String nodeName) throws XMPPException{
		
		LeafNode node = mgr.getNode(nodeName);
        node.addItemEventListener(new ItemEventCoordinator<Item>());
        node.subscribe(connection.getUser());
        System.out.println(connection.getUser()+" hat "+nodeName+" abonniert\n");
		
	}
	
	public void unsubscribe(String nodeName) throws XMPPException{
		
		LeafNode node = mgr.getNode(nodeName);
        node.addItemEventListener(new ItemEventCoordinator<Item>());
        node.unsubscribe(connection.getUser());
        System.out.println(connection.getUser()+" hat abonnement von "+nodeName+" gekündigt\n");
		
	}
	
	public void getAllSubscriptions() throws XMPPException{
		
		List<Subscription> subscriptions = mgr.getSubscriptions();
		System.out.println("Abonennten aller Nodes:");
		System.out.println(subscriptions.toString());
		System.out.println("");
		
	}
	
	public Boolean isSubscriberof(String nodeName) throws XMPPException{
		LeafNode node = mgr.getNode(nodeName);
		for(int i = 0; i<node.getSubscriptions().size(); i++){
			if(node.getSubscriptions().get(i).getJid().equals(connection.getUser())){
				System.out.println(connection.getUser()+" ist abonnent von: "+nodeName);
				return true;
			}
		}
		System.out.println(connection.getUser()+" ist kein abonnent von: "+nodeName);
		return false;
	}
	
	public void getSubscriptionFromNode(String nodeName) throws XMPPException{
		
		LeafNode node = mgr.getNode(nodeName);
		List<Subscription> subscription = node.getSubscriptions();
		System.out.println("Abonennten von "+nodeName+":");
		System.out.println(subscription.toString());
		System.out.println("");
		
	}
	
	public void addMessage(String Id, String nodeName) throws XMPPException {
		LeafNode node = mgr.getNode(nodeName);
		node.publish(new Item(Id));
		System.out.println("Item wurde erzeugt");
		System.out.println("");
		
	}
	
	public void deleteMessage(String Id, String nodeName) throws XMPPException {
		LeafNode node = mgr.getNode(nodeName);
		node.deleteItem(Id);
		System.out.println("Item wurde gelöscht");
		System.out.println("");
		
	}
	
	public void printMessage(String nodeName, int Id) throws XMPPException{
		LeafNode node = (LeafNode) mgr.getNode(nodeName);
		System.out.println(node.getItems(node.getSubscriptions().get(0).getId()).get(Id));

	}
	
	public int getMessageSize(String nodeName) throws XMPPException{
		LeafNode node = (LeafNode) mgr.getNode(nodeName);
		return node.getItems().size();
	}


	public void printAllMessagesFromNode(String nodeName) throws XMPPException{
		
		LeafNode node = (LeafNode) mgr.getNode(nodeName);
		System.out.println("Alle Messages von "+nodeName+":");
		for(int i=0;i<node.getItems(node.getSubscriptions().get(0).getId()).size();i++){
			
			System.out.println(node.getItems(node.getSubscriptions().get(0).getId()).get(i));
		
		}
		System.out.println("");

	}

	public boolean addPayloadMessage(String Id, String nodeName, String c_id, String datum,  String lat, String lon) throws XMPPException {
		
//		LeafNode node = (LeafNode) mgr.getNode(nodeName);
//		SimplePayload payload = new SimplePayload("subs", null, "<location><item><push kategorie=\"" + nodeName + "\" titel=\"" + c_id + "\" datum=\"" + datum + "\" lat=\"" + lat + "\" lon=\"" + lon  +"\"></push></item></location>");
//		PayloadItem<SimplePayload> item = new PayloadItem<SimplePayload>(Id, payload);
//		node.publish(item);
//		System.out.println("Item wurde erzeugt");
		String payload_data = "<location><item><push kategorie=\"" + nodeName + "\" titel=\"" + c_id + "\" datum=\"" + datum + "\" lat=\"" + lat + "\" lon=\"" + lon  +"\"></push></item></location>";

        LeafNode node = null;
        
        if(payload_data.length() == 0) {
            System.err.println("No payload given!");
            return false;
        }
        
        try {
            node = mgr.getNode(nodeName);
        } catch (XMPPException e) {

            // Node was not found
            System.err.println("Node was not found! I am gonna create one now.");
            
            if (e.getXMPPError().getCode() == 404) {
                // Node not found
                try {
                    node = mgr.createNode(node_id);
                    node.sendConfigurationForm(createForm(FormType.submit,
                            true, true, PublishModel.open, AccessModel.open));
                    node.unsubscribe(this.username + "@" + this.hostname);
                } catch (XMPPException e1) {
                    // Node could not be created
                    System.err.println("Node could not be created!");
                    return false;
                }
            }
            else {
                System.err.println("Unknown errorcode: " + e.getXMPPError().getCode());
                return false;
            }
        }

        if (node != null) {

            SimplePayload payload = new SimplePayload("palette", "",
                    payload_data);
            PayloadItem<SimplePayload> item = new PayloadItem<SimplePayload>(
                    null, payload);

            try {
                node.send(item);
            } 
            catch (XMPPException e) {
                // Item could not be send
                e.printStackTrace();
                System.err.println("Item could not be sent!");
                return false;
            }
        }

        return true;
		
	}
	
	public List<String> getNodes() throws XMPPException{
		
//		ServiceDiscoveryManager sdMgr;
//		sdMgr = ServiceDiscoveryManager.getInstanceFor(connection);
//		List<String> list = new ArrayList<String>();
//		for (Iterator<DiscoverItems.Item> iterator = sdMgr.discoverItems("pubsub.localhost").getItems(); iterator.hasNext();) {
//			DiscoverItems.Item item = (DiscoverItems.Item) iterator.next();
//			list.add(item.getNode());
//		}
//		System.out.println("Verfügbare Nodes:");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println("");
//		
//		return list;
		
		List<String> entries = new ArrayList<String>();

        try {
            DiscoverItems itms = mgr.discoverNodes(null);

            Iterator<DiscoverItems.Item> it = itms.getItems();

            for (; it.hasNext();) {
                entries.add(it.next().getNode());
            }

        } catch (XMPPException e) {
            e.printStackTrace();
        }

        return entries;
		
	}
	public Node getNode(String node) throws XMPPException{
		
//		ServiceDiscoveryManager sdMgr;
//		sdMgr = ServiceDiscoveryManager.getInstanceFor(connection);
//		List<String> list = new ArrayList<String>();
//		for (Iterator<DiscoverItems.Item> iterator = sdMgr.discoverItems("pubsub.localhost").getItems(); iterator.hasNext();) {
//			DiscoverItems.Item item = (DiscoverItems.Item) iterator.next();
//			list.add(item.getNode());
//		}
//		System.out.println("Verfügbare Nodes:");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println("");
	
		
		return mgr.getNode(node);
	}

}