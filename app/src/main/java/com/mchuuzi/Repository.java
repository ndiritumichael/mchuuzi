package com.mchuuzi;

import com.mchuuzi.models.ProductsModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
    //THe repository class provides dummy data mimicking a database or online source

    private List<ProductsModel> productsModelList = new ArrayList<>();

    private String Kales, Frenchbeans, Carrots, Cabbages, oranges, Onions, Spinach, banana, Sweet_peppers, apples, pineapples;


    public List<ProductsModel> getProductsModelList() {
        banana = "The banana is an anytime fruit of the year as a snack, into your cereals, pancakes, fruit salad & smoothies. Loaded with potassium, good for blood sugar control & digestive health";
        Kales = "Sukuma wiki\n" +
                "\n" +
                "Excellent source of Vit E, A, K & C. Can be steamed, used raw, in salads or juiced";
        Cabbages = "An all time favourite, firmly packed the green cabbage is loaded with vitamins and antioxidants. Perfect when steamed, fried or raw in salads";
        Carrots = "High in Vit C, K & Potassuim, our carrots are colourful, crunchy and sweet. Perfect to snack on, cook and juice";
        oranges = "Oranges have a significant amount of Vit C & potassium. Very low in acid and perfect for juices, salads and smoothies. Embu county currently has plenty of these in season. Prevents kidney stones and anemia\n";
        Onions = "Onions add crunch & pinch to sandwiches, salads and burgers. A cooking favourite for flavour. Has strong anti-inflammatory properties benefiting heart health and cancer fighting compounds";
        Spinach = "Farmed widely due to its impressive nutrient profile, spinach is rich in antioxidants and may reduce risk of chronic disease. Use raw, in smoothies and juices";

        Sweet_peppers = "Great source of Vit B6 & folate. Often referred to as sweet due flavourful taste. Good in salads to bring out the gorgeous colours";
        apples = "These are now coming from Nyeri, very sweet and great for both fruit and juice\n" +
                "\n" +
                "Local organic apples";
        pineapples = "Available all year from our Ugandan farmers, this bold fruit stands out in both sweet and savoury dishes. Very effective in fighting inflammation.";


        ProductsModel product1 = new ProductsModel("Collard-Greens", 50.00, R.drawable.kales, Kales);
        ProductsModel product2 = new ProductsModel("Bananas", 120.00, R.drawable.banana, banana);
        ProductsModel product3 = new ProductsModel("Cabbage", 90.00, R.drawable.cabbage, Cabbages);
        ProductsModel product4 = new ProductsModel("Carrots", 50.00, R.drawable.carrots, Carrots);
        ProductsModel product5 = new ProductsModel("Oranges", 100.00, R.drawable.oranges, oranges);
        ProductsModel product6 = new ProductsModel("Sweet-Pepper", 100.00, R.drawable.pepper, Sweet_peppers);
        ProductsModel product7 = new ProductsModel("Onions", 100.00, R.drawable.onions, Onions);
        ProductsModel product8 = new ProductsModel("Apples", 200.00, R.drawable.apples, apples);
        ProductsModel product9 = new ProductsModel("Pineapples", 100.00, R.drawable.pineapples, pineapples);
        ProductsModel product10 = new ProductsModel("Spinach", 100.00, R.drawable.spinach, Spinach);
        productsModelList.addAll(Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10));


        return productsModelList;
    }
}
