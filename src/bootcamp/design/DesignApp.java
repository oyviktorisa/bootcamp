package bootcamp.design;

public class DesignApp
{
    private static <T extends AbstractShape> void printShapeNew(T obj) {
        System.out.println ("This is a "+obj.colour+" "+obj.shape);
    }
    
    public static void main (String[] args)
    {
        // abstract class
        Rectangle r1 = new Rectangle ("blue");

        r1.printShape ();

        // anonymous inner class
        AbstractShape round = new AbstractShape("green") {

            @Override
            public void printShape ()
            {
                System.out.println (this.colour+" round go round");
                
            }
            
        };
        
        round.printShape ();
        
        // enum
        Shape s1 = Shape.RECTANGLE;
        s1.printShape ();
        
        //generic
        printShapeNew (r1);
        //printShapeNew (s1); //type mismatch
        printShapeNew (round);
        
        //singleton
        CounterSingleton counter = CounterSingleton.getInstance ();
        System.out.println (counter.getCount ());
        counter.count ();
        CounterSingleton counter2 = CounterSingleton.getInstance ();
        counter2.count ();
        System.out.println (counter.getCount ());
        System.out.println (counter2.getCount ());
    }

}
