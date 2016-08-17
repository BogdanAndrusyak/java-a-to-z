package andrusyak.storage;

import andrusyak.models.Item;

import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 8/16/2016.
 */
public interface ItemStorage {

    void addItem(Item item);

    List<Item> getAllItems();

    void updateItem(Item item);

    void updateDoneOnly(Item item);

    void deleteItem(int id);
}
