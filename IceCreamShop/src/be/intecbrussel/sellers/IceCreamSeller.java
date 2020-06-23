package be.intecbrussel.sellers;

import be.intecbrussel.application.NoMoreIceCreamException;
import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public interface IceCreamSeller extends Profitable {

    default Cone orderCone(Cone.Flavor[] balls) throws NoMoreIceCreamException {
        return new Cone(balls);
    }

    IceRocket orderIceRocket() throws NoMoreIceCreamException;

    default Magnum orderMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {
        return new Magnum(type);
    }


}
