package be.intecbrussel.sellers;

import be.intecbrussel.application.NoMoreIceCreamException;
import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller{

    private PriceList priceList;
    private Stock stock;
    private double profit = 0;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] balls) throws NoMoreIceCreamException {

        Cone preparedCone = prepareCone(balls);
        profit += (priceList.getBallPrice() * balls.length);
        return preparedCone;
    }

    private Cone prepareCone (Cone.Flavor[] balls) throws NoMoreIceCreamException {

        if (stock.getCones() <= 0) {
            throw new NoMoreIceCreamException("No cones anymore ! ");

        } else if (stock.getBalls() < balls.length) {
            throw new NoMoreIceCreamException("No more iceCream Balls !");

        }else
            stock.setCones(stock.getCones() - 1);
            stock.setBalls(stock.getBalls() - balls.length);
            return new Cone(balls);
        }


    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {

        IceRocket preparedIceRocket = prepareRocket();
        profit += priceList.getRocketPrice();
        return preparedIceRocket;
    }

    private IceRocket prepareRocket() throws NoMoreIceCreamException {

        if (stock.getIceRockets() <= 0) {
            throw new NoMoreIceCreamException("No Ice Rockets anymore !");
        } else {
            stock.setIceRockets(stock.getIceRockets() - 1);
            return new IceRocket();
        }
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {

        Magnum preparedMagnum = prepareMagnum(type);
        profit += priceList.getMagnumPrice(type);
        return preparedMagnum;
    }

    private Magnum prepareMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {

        if (stock.getMagni() <= 0) {
            throw new NoMoreIceCreamException("No Magnums anymore ! ");
        } else {
            stock.setMagni(stock.getMagni() - 1);
            return new Magnum(type);
        }
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
