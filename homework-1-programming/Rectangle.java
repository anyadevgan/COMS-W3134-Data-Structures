public class Rectangle implements RectangleInterface, Comparable<Rectangle> { 
    
    private double length;
    private double width;
    
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    
    public double getLength(){
        return this.length;
    }
    
    public double getWidth(){
        return this.width;
    }
    
    public void setLength(double length){
        this.length = length;
    }
    
    public void setWidth(double width){
        this.width = width;
    }
    
    public int compareTo(Rectangle a){
        if(this.getTotalPerimeter() < a.getTotalPerimeter()){
            return -1;
        }
        else if(this.getTotalPerimeter() > a.getTotalPerimeter()){
            return 1;
        }
        return 0;
    }
    
    public double getTotalPerimeter(){
        return (this.length * 2) + (this.width * 2);
    }
}
