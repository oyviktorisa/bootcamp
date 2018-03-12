package bootcamp.design;

public enum Shape {
    RECTANGLE("square",4),
    ROUND("round",0),
    TRIANGLE("triangle",3);
    
    String form;
    int angle;
    
    private Shape(String form,int angle) {
        this.form = form;
        this.angle = angle;
    }
    
    public String getForm() {
        return this.form;
    }
    
    public int getAngle() {
        return this.angle;
    }
    
    public void printShape() {
        System.out.println (this.form+" has "+this.angle+" angle");
    }
}
