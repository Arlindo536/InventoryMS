public class InventoryNode {
    private Product product;
    private InventoryNode next;

    public InventoryNode(Product product) {
        this.product = product;
        this.next = null;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public InventoryNode getNext() {
        return next;
    }

    public void setNext(InventoryNode next) {
        this.next = next;
    }
}