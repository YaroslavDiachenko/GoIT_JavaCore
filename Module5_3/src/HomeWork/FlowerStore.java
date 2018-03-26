package HomeWork;


import HomeWork.Entities.Camomile;
import HomeWork.Entities.Flower;
import HomeWork.Entities.Rose;
import HomeWork.Entities.Tulip;

import java.util.ArrayList;

public class FlowerStore {
    int wallet;

    public Flower[] sell(int roses, int camomiles, int tulips) {
        Flower[] bouquet = new Flower[roses + camomiles + tulips];
        for (int i = 0; i < roses; i++) {
            bouquet[i] = new Rose();
            wallet += bouquet[i].getPrice();
        }
        for (int i = roses; i < bouquet.length - tulips; i++) {
            bouquet[i] = new Camomile();
            wallet += bouquet[i].getPrice();
        }
        for (int i = roses + camomiles; i < bouquet.length; i++) {
            bouquet[i] = new Tulip();
            wallet += bouquet[i].getPrice();
        }
        return bouquet;
    }

    public Flower[] sellSequence(int roses, int camomiles, int tulips) {
        ArrayList<Flower> bouquet = new ArrayList<>();
        while(roses+camomiles+tulips > 0) {
            if(roses > 0) {
                Rose rose = new Rose();
                bouquet.add(rose);
                wallet += rose.getPrice();
                roses--;
            }
            if(camomiles > 0) {
                Camomile camomile = new Camomile();
                bouquet.add(camomile);
                wallet += camomile.getPrice();
                camomiles--;
            }
            if(tulips > 0) {
                Tulip tulip = new Tulip();
                bouquet.add(tulip);
                wallet += tulip.getPrice();
                tulips--;
            }
        }
        return bouquet.toArray(new Flower[bouquet.size()]);
    }

    void showBouquet(Flower[] bouquet) {
        if (bouquet.length == 0) System.out.println("There are no flowers in bouquet.");
        else {
            for (int i = 0; i < bouquet.length; i++) {
                if(i == bouquet.length-1) System.out.println(bouquet[i].getClass().getSimpleName());
                else System.out.print(bouquet[i].getClass().getSimpleName() + ", ");
            }
        }
    }
}
