package bootcamp.design;

public class CounterSingleton
{
    private static CounterSingleton instance = null;
    private static int counter;
    
    private CounterSingleton() {};
    
    public static CounterSingleton getInstance() {
        if(instance==null)
            instance = new CounterSingleton();
        
        return instance;
    }
    
    public static void count() {
        counter++;
    }
    
    public static int getCount() {
        return counter;
    }
}
