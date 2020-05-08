package com.alanflai.dummy;

import java.util.Calendar;
import java.util.Date;

/**
 * App
 * 
 * Rel. 1.0.0
 * 
 * Calendario dell'anno, per ogni giorno del mese determina
 * e stampa il giorno della settimana.
 **/
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "******************* Calendario 2020 ****************" );

        Month.list();

        String input01 = "DIC";
        String input02 = "Nov";
        String input03 = "N";

        System.out.println("Index of " + input01 + " is " + Month.monthToId(input01.toLowerCase()));
        System.out.println("Index of " + input02 + " is " + Month.monthToId(input02.toLowerCase()));
        System.out.println("Index of " + input03 + " is " + Month.monthToId(input03.toLowerCase()));

        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);

        System.out.println(data.toString());

        System.out.println("Giorno: " + cal.get(Calendar.DAY_OF_WEEK));
        System.out.println("Giorno: " + Month.getDayOfTheWeek(cal.get(Calendar.DAY_OF_WEEK)));

        Month oMonth = new Month();

        // 2020 Year Months
        
        for(int i=0; i < 12; i++){

            System.out.println("Mese: " + Month.MONTH_LIST[i]);
            oMonth.list(2020,i+1);
        }

    }
}
