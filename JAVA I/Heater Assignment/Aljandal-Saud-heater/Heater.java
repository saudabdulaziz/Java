
/**
* Heater project

* Simulate the behavior of a heater (thermostat)

* You can set the temperature and increase and decrease the temperature

* @author Aljandal, Saud
* @version 4/25/2017

* MODIFICATIONS:

* private fields have been added[temperature,minimum,maximum,increment].
* Main Heater constructor applies values to the class objects.
* added Heater  constructor with inputs.
* added getTemperature() accessor method.
* added getMinimum() accessor method.
* added getMaximum() accessor method.
* added getIncrement() accessor method.
* added setTemperature() mutator method.
* added setMinimum() mutator method.
* addde setMaximum() mutator method.
* added setIncrement() mutator method.
* added warmer() method.
* added cooler() method.
*/
public class Heater
{
    /**
     * The main class objects. Private with intger type.
     */
    private int temperature;
    private int minimum;
    private int maximum;
    private int increment;
    /**
     * Constructor for objects of class Heater
     */
    public Heater()
    {
     temperature = 50;
     minimum = 0;
     maximum = 100;
     increment = 1;
    }
    
    /**
    * Constructor for objects of class Heater with four intger inputs to assign the values of the class objects.
    * with some conditins, the if statement will check if there is any violate to the heater cinditions. If there is, the default values will 
    * be applied
    */
    public Heater(int temp, int min, int max, int inc)
    {
       
       if (!(min<max))                     
      {System.out.println("Maximum value should be greater that minimum value. The default values will be applied.");
       setTemperature(50);
       setMinimum(0);
       setMaximum(100);
       setIncrement(1);
      }
        
      if (!((min<=temp) && (temp <= max)))
       {System.out.println("Temperature value should be between the minimum and the maximum value. The default values will be applied.");
       setTemperature(50);
       setMinimum(0);
       setMaximum(100);
       setIncrement(1);
      }
             
      if (!(inc>0))                       
       {System.out.println("Increment value should be greater than zero. The default values will be applied.");
       setTemperature(50);
       setMinimum(0);
       setMaximum(100);
       setIncrement(1);
      }
      
      if ((min<max) && (inc>0) && (min<=temp) && (temp <= max)){
       setTemperature(temp);
       setMinimum(min);
       setMaximum(max);
       setIncrement(inc);
      }
    }

    /**
     * accessor method shows the actual temperature.
     * returns the value stored in the temperature object field.
     */
    public int getTemperature()
    {
        return temperature;
    }
    
     /**
     * accessor method shows the minimum temperature.
     * returns the value stored in the minmum object field.
     */
    public int getMinimum()
    {
        return minimum;
    }
    
    /**
     * accessor method shows the maximum temperature.
     * returns the value stored in the maximum object field.
     */
    public int getMaximum()
    {
        return maximum;
    }
    
    /**
     * accessor method shows the increment amount.
     * returns the value stored in the increment object field.
     */
    public int getIncrement()
    {
        return increment;
    }
    
    /**
     * mutator method sets the temperature.
     * changing the value stored in the temperature field.
     */
    public void setTemperature(int temp)
    {
     temperature = temp;
    }
        
    /**
     * mutator method sets the minimum temperature.
     * changing the value stored in the minimum field.
     */
    public void setMinimum(int min)
    {
     minimum = min;
    }
    
    /**
     * mutator method sets the maximum temperature.
     * changing the value stored in the maximum field.
     */
    public void setMaximum(int max)
    {
     maximum = max;
    }
    
    /**
     * mutator method sets the increment amount by an intger input.
     * changing the intger stored in the increment field by the new intger input. MUST be greater than zero.
     */
    public void setIncrement(int inc)
    {
        if(inc <= 0){
            System.out.println("the value should be positive and above zero");
        }else{increment = inc;
        }
    }
    
    /**
     * a warmer method increments the temperature by the increment amount.
     * increasing the value stored in the temperature field by the value stored in increment field. MUST not exceed the intger stored in maximum field.
     */
    public void warmer()
    {
        if ((temperature+increment) > maximum){
            System.out.println("the temperature cannot exceed the maximum value.");
        }else{temperature = temperature + increment;
        }
    }
    
    
    /**
     * a cooler method decrements the temperature by the increment value.
     * decreasing the value stored in temperature field by the value stored in increment field. MUST not be lower the intger stored in minimum field.
     */
    public void cooler()
    {
        if ((temperature-increment) < minimum){
            System.out.println("the temperature cannot be below the minimum value.");
        }else{temperature = temperature - increment;
        }
    }
}
