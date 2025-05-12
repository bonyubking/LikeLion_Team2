package com.workshop13.num08;

import java.util.ArrayList;

public class ShapeTest {

	public static void main(String[] args) {
		
        ArrayList<Shape> list = new ArrayList<>();
        
        list.add(new Rectangle(4,7,5));
        list.add(new Rectangle(5,4,6));
		
        list.add(new Circle(6, 6, 7));
        list.add(new Circle(7, 8, 3));
        
        System.out.println("구분        길이   X좌표   Y좌표   Area   Circumference");
        for (Shape i : list) {
        	if (i instanceof Rectangle) {
        		
        		Rectangle r = (Rectangle) i;
            	System.out.printf("Rectangle   %d    %d     %d      %.0f      %.0f", r.getWidth(),i.getPoint().getX(),i.getPoint().getY(),i.getArea(),i.getCircumference());
            	System.out.println();
        	}
        	
        	else if (i instanceof Circle) {
        		
        		Circle r = (Circle) i;
            	System.out.printf("Circle   %d    %d     %d      %.0f      %.0f", r.getRadius(),i.getPoint().getX(),i.getPoint().getY(),i.getArea(),i.getCircumference());
            	System.out.println();
        	}
        	
        }
        
        for (Shape s : list) {
            s.move(10, 10);
        }
        
        System.out.println("이동 후 ....");
        
        System.out.println("구분        길이   X좌표   Y좌표   Area   Circumference");
        for (Shape i : list) {
        	if (i instanceof Rectangle) {
        		
        		Rectangle r = (Rectangle) i;
            	System.out.printf("Rectangle   %d    %d     %d      %.0f      %.0f", r.getWidth(),i.getPoint().getX(),i.getPoint().getY(),i.getArea(),i.getCircumference());
            	System.out.println();
        	}
        	
        	else if (i instanceof Circle) {
        		
        		Circle r = (Circle) i;
            	System.out.printf("Circle   %d    %d     %d      %.0f      %.0f", r.getRadius(),i.getPoint().getX(),i.getPoint().getY(),i.getArea(),i.getCircumference());
            	System.out.println();
        	}
        	
        }
        
        
	}

}
