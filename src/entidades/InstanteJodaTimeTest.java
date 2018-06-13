package entidades;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Hours;
 
public class InstanteJodaTimeTest {
     
    public static void main(String... args) {        
        // Configurando a data refer�ncia
        DateTimeZone timeZone = DateTimeZone.forID("GMT");
        DateTime dateTime1 = new DateTime(1970, 01, 01, 00, 00, 00, timeZone);
        // Deve ser 0
        System.out.println("Diferenca em milisegundos = " + dateTime1.getMillis());
         
        // Configurando uma hora de diferen�a
        DateTime dateTime2 = dateTime1.plusHours(1);
        // Deve ser de 1 hora = 3600000 milisegundos
        System.out.println("Diferenca em milisegundos = " + dateTime2.getMillis());
        System.out.println("Diferenca em horas = " + Hours.hoursBetween(dateTime1, dateTime2).getHours());
    }    
}