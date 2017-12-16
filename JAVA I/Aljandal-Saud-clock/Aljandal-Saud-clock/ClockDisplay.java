
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * Modifications:
 * The original project was a 24 hour clock. The project has been modified to work as a 12
 * hour clock.
 * Author: Aljandal, Saud 5/8/2017.
 * constructor ClockDisplay() has been modified by adding a default time representation + changing the limit value.
 * constructor ClockDisplay(int hour, int minute) has been modified by changing the limit value.
 * method timeTick() has been modified by adding if-statements.
 * method setTime(int hour, int minute) has been modified by adding if-statement.
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display

    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 12:59.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        setTime(12,59); // SINCE I CANNOT MODIFY OTHER METHODS, this used as a default start for this Constructor.
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * Name: timeTick.
     * Description: This method should get called once every minute - it makes
     * the clock display go one minute forward.
     * If the minutes field equals to zero, hours field will be incremented.
     * Also, if the time is 12;59, the minutes rolling over will increment the hours field by one. but we cannot
     * start the 12-hour clock by 0 hour. the second if-statement will make it equal to 01:00 by incrementing the hours 
     * field.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0){  // it just rolled over!
            hours.increment();
            
        }
        if(hours.getValue() == 0){  // which means the time passes 12:59 with a minute!
            hours.increment();
            
        }
        
        updateDisplay();
    }

    /**
     * name: setTime.
     * Description: Set the time of the display to the specified hour and
     * minute. Check if the specified hour is more than 12. If so, substrct 12 from the
     * specified hour to meet the 12-hour clock system.
     * also, there is no 00:00 in the 12-hour clock. if the user typed 00:11 for instance,
     * this should be represented as 12:11, either AM or PM. And that what the first if statement does.
     */
    public void setTime(int hour, int minute)
    {
        minutes.setValue(minute);
        if (hour > 12){
            hours.setValue(hour -12);
            updateDisplay();
        }else{
            hours.setValue(hour);
        }
        
        if (hours.getValue() ==0){
            hours.setValue(12);
            updateDisplay();
        }
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }

    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
        minutes.getDisplayValue();
    }
}
