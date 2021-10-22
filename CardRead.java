import java.util.Scanner;
import java.io.IOException;

import java.io.File;

public class CardRead
{
    private static String saveSrc ="/home/pi/Documents/ErSisKayit/";
    private static String reading="";
    
    /**
     * Bu sınıf RFID kartın ID bilgisini hafızada tutma işlemini icra eder.
     *
     * @author guvenerene
     */
    public static void cardRead()
    {
        Interface.init("/home/pi/pi-rfid/Read.py");

        try {
            RfidListener reader = new RfidListener();
            reader.read();

            System.out.println("Id: " + reader.getId());
            reading = String.valueOf(reader.getId());
        } catch (IOException ioe) {

        }

        //kayitYolu += okunan;
        //File dosya = new File(okunan);
        //dosya.mkdir();
    }

    public String getSaveSrc()
    {
        return saveSrc;
    }
    public void setSaveSrc()
    {
        saveSrc="/home/pi/Documents/ErSisKayit/";
    }

    public String getReading()
    {
        return reading;
    }
}
