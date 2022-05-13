/*
package ru.myOnlineShop.model.dataBase;

import ru.myOnlineShop.model.exeption.InvalidCategoryProduct;
import ru.myOnlineShop.model.product.Product;
import ru.myOnlineShop.model.product.food.Food;
import ru.myOnlineShop.model.product.food.bakery.Bakery;
import ru.myOnlineShop.model.product.food.dairyProduct.DairyProduct;
import ru.myOnlineShop.model.product.nonFood.NonFood;
import ru.myOnlineShop.model.product.nonFood.homeTechnics.BigHomeTechnics;
import ru.myOnlineShop.model.product.nonFood.homeTechnics.HomeElectronics;
import ru.myOnlineShop.model.product.nonFood.homeTechnics.SmallHomeTechnics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProductDataBase implements DataBase {
    private Product product;
    public ArrayList<Product> productBase = new ArrayList<>();
    public Map<String, ArrayList<Product>> productBasePrice = new HashMap<>();

    public Map<String, ArrayList<Product>> addInBase(String categoryProduct, ArrayList<Product> productBase) {

        productBasePrice.put(categoryProduct.toLowerCase(), productBase);
        return productBasePrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public ArrayList<Product> findElement(String typeProduct) throws InvalidCategoryProduct {
        if (productBasePrice.containsKey(typeProduct)) {
            return productBasePrice.get(typeProduct);
        } else {
            throw new InvalidCategoryProduct("Такой категории пока нет в ассортименте", typeProduct);
        }

    }


    @Override
    public void dataBaseWrite(HttpServletRequest request, HttpServletResponse response) {
        try (FileWriter fw = new FileWriter("dataBase/dataBaseCatalog/ProductDataBase.txt", true)) {
            fw.write(String.valueOf(product));
            fw.write("\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void dataBaseRead() {
        try (BufferedReader br = new BufferedReader(new FileReader("dataBase/dataBaseCatalog/ProductDataBase.txt"))) {

            String currentLine = "";
            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
                if (!currentLine.isEmpty()) {
                    productBase.add(convertStringToBase(currentLine));
                }
            }
            //System.out.println(productBase);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product convertStringToBase(String currentLine) {
        String[] splitted = currentLine.split(" , ");
        Product product = new Product();

        for (String s : splitted) {
            getСategoryAndSet(s, product);
            getTypeAndSet(s, product);
            getNameAndSet(s, product);
            getPriceAndSet(s, product);
            getItemAndSet(product);
            getQuantityAndSet(s, product);

        }

        return product;
    }

    @Override
    public void exportFromDataBase() {
        try (FileWriter dbExport = new FileWriter("dataBase/dataBaseCatalog/ProductDataBaseExport.txt");
             FileWriter dbPrice = new FileWriter("dataBase/dataBaseCatalog/Pricelist.txt");
             FileWriter dbBakery = new FileWriter("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseFood/dataBaseBakery/dataBaseBakery.txt");
             FileWriter dbDairyProduct = new FileWriter("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseFood/dataBaseDairyProduct/dataBaseDairyProduct.txt");
             FileWriter dbBigHomeTechnics = new FileWriter("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseNonFood/dataBaseBigHomeTechnics.txt");
             FileWriter dbSmallHomeTechnics = new FileWriter("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseNonFood/dataBaseSmallHomeTechnics.txt");
             FileWriter dbHomeElectronics = new FileWriter("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseNonFood/dataBaseHomeElectronics.txt");
             FileWriter dbNonFood = new FileWriter("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseNonFood/dataBaseNonFood.txt");
             FileWriter dbFood = new FileWriter("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseFood/dataBaseFood.txt")) {
            Collections.sort(productBase);
            for (Product product : productBase) {
                dbExport.write(product + "\n");
                dbPrice.write(product + " <br>" + "\n");
                switch (product.getTypeProduct()) {
                    case "Выпечка":
                        dbBakery.write(product + "\n");
                        break;
                    case "Молочные продукты":
                        dbDairyProduct.write(product + "\n");
                        break;
                    case "Крупная бытовая техника":
                        dbBigHomeTechnics.write(product + "\n");
                        break;
                    case "Мелкая бытовая техника":
                        dbSmallHomeTechnics.write(product + "\n");
                        break;
                    case "Бытовая электроника":
                        dbHomeElectronics.write(product + "\n");
                        break;
                }
                if (product.getCategoryProduct().equals("Непродовольственные товары"))
                    dbNonFood.write(product + "\n");
                if (product.getCategoryProduct().equals("Продукты питания"))
                    dbFood.write(product + "\n");
            }
            dbExport.flush();
            dbBakery.flush();
            dbDairyProduct.flush();
            dbBigHomeTechnics.flush();
            dbSmallHomeTechnics.flush();
            dbHomeElectronics.flush();
            dbNonFood.flush();
            dbFood.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void importToDataBase() {
        try (BufferedReader dataBaseBakery = new BufferedReader(new FileReader("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseFood/dataBaseBakery/dataBaseBakery.txt"));
             BufferedReader dataBaseDairyProduct = new BufferedReader(new FileReader("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseFood/dataBaseDairyProduct/dataBaseDairyProduct.txt"));
             BufferedReader dataBaseBigHomeTechnics = new BufferedReader(new FileReader("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseNonFood/dataBaseBigHomeTechnics.txt"));
             BufferedReader dataBaseSmallHomeTechnics = new BufferedReader(new FileReader("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseNonFood/dataBaseSmallHomeTechnics.txt"));
             BufferedReader dataBaseHomeElectronics = new BufferedReader(new FileReader("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseNonFood/dataBaseHomeElectronics.txt"));
             BufferedReader dataBaseNonFood = new BufferedReader(new FileReader("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseNonFood/dataBaseNonFood.txt"));
             BufferedReader dataBaseFood = new BufferedReader(new FileReader("dataBase/dataBaseCatalog/dataBaseCategory/dataBaseFood/dataBaseFood.txt"))) {

            String currentLineBakery = "";
            String currentLineDairyProduct = "";
            String currentLineBigHomeTechnics = "";
            String currentLineSmallHomeTechnics = "";
            String currentLineHomeElectronics = "";
            String currentLineNonFood = "";
            String currentLineFood = "";
            while ((currentLineBakery = dataBaseBakery.readLine()) != null) {
                if (!currentLineBakery.isEmpty()) {
                    Bakery.bakeryList.add(convertStringToBase(currentLineBakery));
                    addInBase("Выпечка", (ArrayList<Product>) Bakery.bakeryList);
                }
            }
            while ((currentLineDairyProduct = dataBaseDairyProduct.readLine()) != null) {
                if (!currentLineDairyProduct.isEmpty()) {
                    DairyProduct.dairyProductList.add(convertStringToBase(currentLineDairyProduct));
                    addInBase("Молочные продукты", (ArrayList<Product>) DairyProduct.dairyProductList);
                }
            }
            while ((currentLineBigHomeTechnics = dataBaseBigHomeTechnics.readLine()) != null) {
                if (!currentLineBigHomeTechnics.isEmpty()) {
                    BigHomeTechnics.bigHomeTechnicsList.add(convertStringToBase(currentLineBigHomeTechnics));
                    addInBase("Крупная бытовая техника", (ArrayList<Product>) BigHomeTechnics.bigHomeTechnicsList);
                }
            }
            while ((currentLineSmallHomeTechnics = dataBaseSmallHomeTechnics.readLine()) != null) {
                if (!currentLineSmallHomeTechnics.isEmpty()) {
                    SmallHomeTechnics.smallHomeTechnicsList.add(convertStringToBase(currentLineSmallHomeTechnics));
                    addInBase("Мелкая бытовая техника", (ArrayList<Product>) SmallHomeTechnics.smallHomeTechnicsList);
                }

            }
            while ((currentLineHomeElectronics = dataBaseHomeElectronics.readLine()) != null) {
                if (!currentLineHomeElectronics.isEmpty()) {
                    HomeElectronics.homeElectronicsList.add(convertStringToBase(currentLineHomeElectronics));
                    addInBase("Бытовая электроника", (ArrayList<Product>) HomeElectronics.homeElectronicsList);
                }


            }
            while ((currentLineNonFood = dataBaseNonFood.readLine()) != null) {
                if (!currentLineNonFood.isEmpty()) {
                    NonFood.nonFood.add(convertStringToBase(currentLineNonFood));
                    addInBase("Непродовольственные товары", (ArrayList<Product>) NonFood.nonFood);
                }


            }
            while ((currentLineFood = dataBaseFood.readLine()) != null) {
                if (!currentLineFood.isEmpty()) {
                    Food.food.add(convertStringToBase(currentLineFood));
                    addInBase("Продукты питания", (ArrayList<Product>) Food.food);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void getСategoryAndSet(String s, Product product) {
        if (s != null && s.contains("Категория товара:")) {
            product.setCategoryProduct(s.split(":")[1]);
        }
    }

    private static void getTypeAndSet(String s, Product product) {
        if (s != null && s.contains("Тип товара:")) {
            product.setTypeProduct(s.split(":")[1]);
        }
    }

    private static void getNameAndSet(String s, Product product) {
        if (s != null && s.contains("Наименование товара:")) {
            product.setNameProduct(s.split(":")[1]);
        }
    }

    private static void getPriceAndSet(String s, Product product) {
        if (s != null && s.contains("Цена:")) {
            product.setPrice(Double.parseDouble(s.split(":")[1]));
        }
    }

    private static void getItemAndSet(Product product) {
        product.setItem(product.generateItem(product));
    }

    private static void getQuantityAndSet(String s, Product product) {
        if (s != null && s.contains("Количество:")) {
            product.setQuantity(Integer.parseInt(s.split(":")[1]));
        }
    }

}


*/
