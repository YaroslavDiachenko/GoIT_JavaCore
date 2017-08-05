package Practice.Objects;

import Practice.Features.Brand;
import Practice.Goods;

public class Clothes extends Goods {
    Brand brand = new Brand();

    @Override
    public void show() {
        super.show();
        System.out.println();
    }
}
