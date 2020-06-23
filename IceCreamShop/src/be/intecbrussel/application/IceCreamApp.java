package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;

public class IceCreamApp {

    public static void main(String[] args) throws NoMoreIceCreamException {

        PriceList priceList = new PriceList(1, 2, 2);

        IceCreamSeller iceCreamSalon = new IceCreamSalon(priceList);

        Eatable orderedIceCreams[] ={iceCreamSalon.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.STRAWBERRY}),

        iceCreamSalon.orderIceRocket(), iceCreamSalon.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE), iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS)};

        for (Eatable e:orderedIceCreams){
            e.eat();
        }

        System.out.println("The total profit of the ice cream salon is :" + iceCreamSalon.getProfit());

    }
}
