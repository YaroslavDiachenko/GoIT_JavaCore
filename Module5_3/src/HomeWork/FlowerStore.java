package HomeWork;


public class FlowerStore {
//    Flower[] bouquet;

    public Flower[] sell(int roses, int camomiles, int tulips) {
        Flower[] bouquet = new Flower[roses + camomiles + tulips];



        return bouquet;
    }

    void printBouquet(Flower[] bouquet) {
        for(Flower i : bouquet) {
//            (i instanceof Rose) ?
        }


    }

    public static void main(String[] args) {
        Rose rose = new Rose();
        System.out.println(rose.getClass());
    }
}
