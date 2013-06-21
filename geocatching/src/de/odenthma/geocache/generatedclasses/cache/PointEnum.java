package de.odenthma.geocache.generatedclasses.cache;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlEnumValue;

public enum PointEnum {
	    ONE(1.0),
	    ONE2(1.5),
	    TWO(2.0),
	    TWO2(2.5),
	    THREE(3.0),
	    THREE2(3.5),
	    FOUR(4.0),
	    FOUR2(4.5),
	    FIVE(5.0);
	    private static ArrayList<Double> values = new ArrayList<Double> ();
	    private final double value;

	    PointEnum(double v) {
	        value = v;
	    }
	    public static ArrayList<Double> getAll(){
	    	values.add(ONE.value());
	    	values.add(ONE2.value());
	    	values.add(TWO.value());
	    	values.add(TWO2.value());
	    	values.add(THREE.value());
	    	values.add(THREE2.value());
	    	values.add(FOUR.value());
	    	values.add(FOUR2.value());
	    	values.add(FIVE.value());
	    	return values;
	    	
	    }
	    public double value() {
	        return value;
	    }

	    public static PointEnum fromValue(double v) {
	        for (PointEnum c: PointEnum.values()) {
	            if (c.value==v) {
	                return c;
	            }
	        }
	        throw new IllegalArgumentException(""+v);
	    }

	}

