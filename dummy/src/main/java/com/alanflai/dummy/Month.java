package com.alanflai.dummy;

import java.util.Calendar;
import java.util.Locale;

public class Month {

    private Calendar cal;

    public static final String[] MONTH_LIST = {"gen","feb","mar",
                                         "apr","may","jun",
                                         "jul","aug","sep",
                                         "ott","nov","dic"};

    public static final String[] DAY_OF_WEEK =  {"Gio","Ven","Sab",
                                                "Dom","Lun","Mar",
                                                "Mer"};
    /** 
     * month
     * The costructor of the class 
     */
    public Month(){
        cal = Calendar.getInstance(); 

        // print current first day of the week
        int day = cal.getFirstDayOfWeek();
        System.out.println("Current first day of the week:" + day);

        Locale defLoc = Locale.getDefault();
        System.out.println("Default localization : " + defLoc);

        // set first day of the week as something else
        cal.setFirstDayOfWeek(Calendar.MONDAY);

        System.out.println(Calendar.MONDAY);

        // print altered first day of the week
        day = cal.getFirstDayOfWeek();;
        System.out.println("Altered first day of the week:" + day);
    }

    /**
     * list: show a list of the months in a year
     * @param <no input parameter> 
     * */                                            
    public static void  list() {
        System.out.println("Month List");
        for(int i = 0; i < 12; i++){
            System.out.println("Month (" + (i+1) + "): " + Month.MONTH_LIST[i]);
        }
    }

    /**
     * list: shows the day in the assigend month
     * @param year, the year of interest
     * @param month, number of the month
     */
    public void list(int iYear,int iMonth){

        if(iMonth == 0 || iMonth > 12) {
            System.out.println("Error: wrong month number!!!");
            return;
        }
        iMonth = iMonth -1;
        
        String dummy = null;


        // point the calendar to the first day of the assigned month
        cal.set(iYear,iMonth,1);

        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("Month: " + Month.MONTH_LIST[iMonth] + 
                           " max day: " + maxDay);
        for(int i = 1; i <= maxDay; i++){
            cal.set(iYear,iMonth,i);
            dummy =  Month.getDayOfTheWeek(cal.get(Calendar.DAY_OF_WEEK));
            System.out.println("Giorno: " + i + " " + dummy + " id:" + cal.get(Calendar.DAY_OF_WEEK));
        }
        
    }

    /**
     * monthToId: return the number associated to the month's name
     * @param name, month'name
     * @return the id associated to month's name
     */
    public static int monthToId(String name){
        if(name == null) return(0);
        if(name.length() != 3) return (0);

        for(int i = 0; i < 12; i++){
            if(Month.MONTH_LIST[i].equals(name.toLowerCase())) return(i+1);
        }
        return(0);
    }

     /**
     * getDayOfTheWeek: return the name of the week from its id number
     * @param index: day of the week id
     * @return the name of the day
     */
    public static String getDayOfTheWeek(int index){
        String res;
        if(index <= 0 || index > 7){
            res = null;
        }
        else {
            switch (index) {
                case Calendar.MONDAY:
                    res = "Lun";
                    break;
                case Calendar.TUESDAY:
                    res = "Mar";
                case Calendar.THURSDAY:
                    res = "Mer";
                    break;
                case Calendar.WEDNESDAY:
                    res = "Gio";
                    break;
                case Calendar.FRIDAY:
                    res = "Ven";
                    break;
                case Calendar.SATURDAY:
                    res = "Sab";
                    break;
                case Calendar.SUNDAY:
                    res = "Dom";
                    break;
                default:
                    res = "undefined";
                    break;
            }
        }
        return(res);
    }
}