package be.intecbrussel.eatables;

public class Magnum implements Eatable{

    private MagnumType type;

    public enum MagnumType{
        MILKCHOCOLATE, WHITECHOCOLATE, BLACKCHOCOLATE, ALPINENUTS, ROMANTICSTRAWBERRIES;
    }

    public Magnum(){

    }

    public Magnum (MagnumType type){
        this.type = type;
    }

    public MagnumType getType() {
        return type;
    }

    @Override
    public void eat() {
        System.out.println("Eating a magnum of " + type);
    }
}
