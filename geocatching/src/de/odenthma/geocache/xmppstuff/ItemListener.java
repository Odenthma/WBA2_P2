package de.odenthma.geocache.xmppstuff;

import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class ItemListener implements ItemEventListener<Item> {

//    private JTextPane logger_field;

    public ItemListener() {
//        this.logger_field = logger_field;
    }

    @Override
    public void handlePublishedItems(ItemPublishEvent<Item> event) {
        for (Item curr : event.getItems()) {
            System.out.println(((PayloadItem<SimplePayload>) curr).getPayload().toXML()+ "\n");
        }
    }
}