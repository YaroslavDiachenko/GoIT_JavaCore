package HomeWork;


import HomeWork.Entities.Camomile;
import HomeWork.Entities.Flower;
import HomeWork.Entities.Rose;
import HomeWork.Entities.Tulip;
import HomeWork.Util.FlowersLoader;

public class Main {
    public static void main(String[] args) {
        Flower flower1 = new Rose();
        Flower flower2 = new Tulip();
        Flower flower3 = new Camomile();

        System.out.println(flower1.getPrice());
        System.out.println(flower2.getPrice());
        System.out.println(flower3.getPrice());



        FlowerStore flowerStore = new FlowerStore();

        String fileName1 = "files\\Bouquet1.txt";
        String fileName2 = "files\\Bouquet2.txt";

//        Flower[] bouquet1 = flowerStore.sell(4,2,3);
//        Flower[] bouquet2 = flowerStore.sellSequence(4,2,3);
//        FlowersSaver.save(fileName1, bouquet1);
//        FlowersSaver.save(fileName2, bouquet2);

        Flower[] bouquet1 = FlowersLoader.load(fileName1);
        Flower[] bouquet2 = FlowersLoader.load(fileName2);
        flowerStore.showBouquet(bouquet1);
        flowerStore.showBouquet(bouquet2);
    }
}