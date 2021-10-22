import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stamping
{
    String timeStamp = "";
    
    /**
     * Bu sınıf gün ay yıl saat dakika saniye bilgisini hafızada zamanDamgasi adlı değişkene atar.
     *
     * @author guvenerene
     */
    public void TimeStamping(){
        Date nowTime = new Date();

        SimpleDateFormat df = new SimpleDateFormat("dd,MM,yyyy_hh,mm,ss");

        timeStamp=df.format(nowTime);


    }
    public String getTimeStamping(){
        TimeStamping();
        return timeStamp;
    }
}