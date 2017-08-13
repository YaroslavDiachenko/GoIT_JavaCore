package HomeWork;


public class Main {
    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();

        String fileName1 = "/Users/test/IdeaProjects/GoIT_JavaCore/Module5_3/files/Bouquet1.txt";
        String fileName2 = "/Users/test/IdeaProjects/GoIT_JavaCore/Module5_3/files/Bouquet2.txt";

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