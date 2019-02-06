package models;


import java.util.ArrayList;
import java.util.Random;

public class ProductRegistration {

    //Attributes:
    ArrayList<Product> productsList;

    //Helper attributes
    private Random random;

    //Constructor:
    public ProductRegistration() {

        System.out.println("Products registration is started.");

        productsList = new ArrayList<Product>();

        random = new Random();
    }

    //Getters:
    public ArrayList<Product> getProductsList() {
        return this.productsList;
    }

    //Methods:
    public void addProduct(Product p) {
        productsList.add(p);
    }

    // Return the index of the product according to barcode 
    public int findProductByBarcode(long barcode) {

        for (int i = 0; i < productsList.size(); i++) {
            Product p = productsList.get(i);
            if (p.getBarcode() == barcode) {
                return i;
            }

        }
        return -1;
    }

    /**
     * Return the randomly taken one product from that barcode for sale
     * registration
     *
     * @param barcodeB
     * @return
     */
    public Product getRandomProductByBarcodeForSale(long barcodeB) {
        boolean isValidBarcode = false;
        ArrayList<Product> productsBarcodeB = new ArrayList<Product>();
        for (Product p : this.productsList) {
            if (p.getBarcode() == barcodeB) {
                productsBarcodeB.add(p);
                isValidBarcode = true;
            }
        }
        if (!isValidBarcode) {
            return null;
        }
        Product randomProd = productsBarcodeB.get(random.nextInt(productsBarcodeB.size()));
        this.productsList.remove(randomProd);
        return randomProd;
    }

    public Product getRandomProductToRaffle() {
        ArrayList<Product> notRaffledProducts = new ArrayList<Product>();
        for (Product p : this.productsList) {
            if (p.getPrizeTicket() == null) {
                notRaffledProducts.add(p);
            }
        }

        Product randomProd = notRaffledProducts.get(random.nextInt(notRaffledProducts.size()));
        return randomProd;
    }

    public void removeProduct(Product p) {
        productsList.remove(p);
    }

    //Other auxilary methods
    public void printProductDataForRegisterSale() {
        for (Product p : productsList) {
            System.out.println(p.getDescription() + ":" + p.getBarcode());
        }
    }

}
