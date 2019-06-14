package Graph;

import java.util.ArrayList;
import java.util.List;
 
public class Node {
    private int value;
    private String color;
 
    public Node(int value) {
        this.value = value;
    }
 
    public int getValue() {
        return value;
    }
 
    public void setValue(int value) {
        this.value = value;
    }
    
    public String getColor() {
    	return color;
    }
    
    public void setColor(String color) {
    	this.color = color;
    }
 
    @Override
    public String toString() {
        return "\n \tNode [value=" + value + "," + "color: "+ color + "]";
    }
}
