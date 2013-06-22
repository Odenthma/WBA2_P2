package de.odenthma.geocache.xmppstuff;

import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class ItemEventCoordinator<T extends Item> implements ItemEventListener<Item>{

	@Override
	public void handlePublishedItems(ItemPublishEvent<Item> items){

		System.out.println("Item count: " + items.getItems().size());
		System.out.println(items.getItems().get(0));

	}
}
