import java.util.Arrays;
import java.util.List;

public class InventorySearchSort {

    // Binary search for a product by name
    public static Product binarySearchByName(Product[] products, String name) {
        // First sort products alphabetically by name
        Arrays.sort(products, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String productName = products[mid].getName();

            int comparison = productName.compareToIgnoreCase(name);

            if (comparison == 0) {
                return products[mid]; // Found the product
            } else if (comparison < 0) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return null; // Product not found
    }

    // Merge sort to sort products by price
    public static void mergeSortByPrice(Product[] products) {
        if (products.length <= 1) {
            return;
        }

        mergeSort(products, 0, products.length - 1);
    }

    private static void mergeSort(Product[] products, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(products, left, mid);
            mergeSort(products, mid + 1, right);

            // Merge the sorted halves
            merge(products, left, mid, right);
        }
    }

    private static void merge(Product[] products, int left, int mid, int right) {
        // Create temporary arrays
        Product[] leftArray = new Product[mid - left + 1];
        Product[] rightArray = new Product[right - mid];

        // Copy data to temporary arrays
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = products[left + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = products[mid + 1 + i];
        }

        // Merge the temporary arrays
        int i = 0, j = 0;
        int k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].getPrice() <= rightArray[j].getPrice()) {
                products[k] = leftArray[i];
                i++;
            } else {
                products[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray if any
        while (i < leftArray.length) {
            products[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray if any
        while (j < rightArray.length) {
            products[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Sort products by price (low to high)
    public static List<Product> sortByPrice(List<Product> products) {
        Product[] productsArray = products.toArray(new Product[0]);
        mergeSortByPrice(productsArray);
        return Arrays.asList(productsArray);
    }

    // Sort products by quantity (high to low)
    public static void sortByQuantity(Product[] products) {
        Arrays.sort(products, (p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity()));
    }
}