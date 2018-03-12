package bootcamp.design;

public abstract class AbstractShape
{
    String shape;
    String colour;
    int angle;
    
    public AbstractShape(String colour) {
        this.colour = colour;
    }
    
    public abstract void printShape();
    
    public String getColour() {
        return this.colour;
    }
}
