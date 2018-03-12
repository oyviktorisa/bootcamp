package bootcamp.design;

public class Rectangle extends AbstractShape
{
    public Rectangle(String colour) {
        super(colour);
        this.shape = "rectangle";
        this.angle = 4;
    }

    @Override
    public void printShape ()
    {
        System.out.println ("square! square! "+this.colour+" square!");

    }

}
