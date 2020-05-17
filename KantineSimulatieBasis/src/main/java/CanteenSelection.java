package main.java;

import java.util.*;

public class CanteenSelection {
    // interne opslag voorraad
    private HashMap<String, ArrayList<Article>> selection;
    private HashMap<String, Integer> startingStock;
    private HashMap<String, Double> prices;

    /**
     * Constructor. The first argument is a list with article names, the second argument is a list with prices and
     * the third argument is a list with amounts(of products in stock). Keep Note!: the dimensions of the
     * three arrays need to be the same
     */
    public CanteenSelection(String[] articleName, double[] price, int[] amount) {
        selection = new HashMap<String, ArrayList<Article>>();
        startingStock = new HashMap<String, Integer>();
        prices = new HashMap<String, Double>();
        for (int i = 0; i < articleName.length; i++) {
            ArrayList<Article> articles = new ArrayList<Article>();
            for (int j = 0; j < amount[i]; j++) {
                articles.add(new Article(articleName[i], price[i]));
            }
            startingStock.put(articleName[i], amount[i]);
            prices.put(articleName[i], price[i]);
            selection.put(articleName[i], articles);
        }

        System.out.println(startingStock.get("Coffee"));
    }

    private void vulVoorraadAan(String productName) {
        ArrayList<Article> currentStock = selection.get(productName);
        int startingAmount = startingStock.get(productName);
        int currentAmount = currentStock.size();
        double prijs = prices.get(productName);
        for (int j = currentAmount; j < startingAmount; j++) {
            currentStock.add(new Article(productName, prijs));
        }
        selection.put(productName, currentStock);
    }

    /*
     * Private methode om de lijst van artikelen te krijgen op basis van de naam van het artikel.
     * Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Article> getArrayList(String productnaam) {
        return selection.get(productnaam);
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. Retourneert null als de
     * stapel leeg is.
     */
    private Article getArticle(ArrayList<Article> stapel) {
        if (stapel == null) {
            return null;
        }
        if (stapel.size() == 0) {
            return null;
        } else {
            Article a = stapel.get(0);
            stapel.remove(0);
            if (stapel.size() <= 10)
                vulVoorraadAan(a.getName());
            return a;
        }
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken. Retouneert null als artikel
     * niet bestaat of niet op voorraad is.
     *
     * @param productName (van artikel)
     * @return artikel (of null)
     */
    public Article getArticle(String productName) {
        return getArticle(getArrayList(productName));
    }
}
