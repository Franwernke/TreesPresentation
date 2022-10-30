import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Item {
    private String name;
    final private List<Item> children;

    private Item father;

    public Item(String Name) {
        name = Name;
        children = new ArrayList<>();
    }

    public Item(String name, Item father) {
        this.name = name;
        this.children = new ArrayList<>();
        this.father = father;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(String itemName) {
        children.add(new Item(itemName, this));
    }

    public void deleteSubItem(String itemName) {
        children.removeIf((currentItem)-> currentItem.getName().equals(itemName));
    }
}

public class FileSystem {
    public Item root;

    public FileSystem() {
        root = new Item("root");
    }
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
    }
}
