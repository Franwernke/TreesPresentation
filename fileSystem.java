import java.util.List;

class Item {
    public String name;
    public List<Item> children;

    public Item (String Name) {
        name = Name;
    }
}

public class fileSystem {
    public Item root;
    public static void main(String[] args) {
        //root = new Item("root");
        //root.children.add(new Item("Documents"));
       // root.children.add(new Item("WorkSpace"));
        //root.children.add(new Item("Photos"));
        //root.children.add(new Item("Videos"));
    }
}
