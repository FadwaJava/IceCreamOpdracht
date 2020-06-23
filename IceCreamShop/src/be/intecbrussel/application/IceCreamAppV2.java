package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;

public class IceCreamAppV2 {

    public static void main(String[] args) throws NoMoreIceCreamException {

        PriceList priceList = new PriceList(1, 2, 2);
        Stock stock = new Stock(2,3,5,9);
        IceCreamSeller iceCreamCar = new IceCreamCar(priceList, stock);
        Eatable orderedIceCreams[] = new Eatable[20];

        try {

            orderedIceCreams[0] = iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.STRAWBERRY});
            orderedIceCreams[0].eat();
            orderedIceCreams[1] = iceCreamCar.orderIceRocket();
            orderedIceCreams[1].eat();
            orderedIceCreams[2] = iceCreamCar.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
            orderedIceCreams[2].eat();
            orderedIceCreams[3] = iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS);
            orderedIceCreams[3].eat();
            orderedIceCreams[4] = iceCreamCar.orderIceRocket();
            orderedIceCreams[4].eat();
            orderedIceCreams[5] = iceCreamCar.orderIceRocket();
            orderedIceCreams[5].eat();

        }

        catch (NoMoreIceCreamException nmice){

            System.out.println("Sorry !! "+ nmice.getMessage());

        }

        finally {

            System.out.println("The total profit of the ice cream Car is :" + iceCreamCar.getProfit());
        }


    }
}
