import hu.unideb.inf.model.Reservation;
import org.junit.Assert;

public class testPrice {

    public static void testFclassPrice200shouldEqual400(){
        Assert.assertEquals(400,Reservation.FirstClassPrice(200),0);
    }
    public static void testFclassPrice450_5shouldEqual901(){
        Assert.assertEquals(901,Reservation.FirstClassPrice(450.5),0);
    }
    public static void testFclassPrice0shouldEqual0(){
        Assert.assertEquals(0,Reservation.FirstClassPrice(0),0);
    }
    public static void testBclassPrice150shouldEqual300(){
        Assert.assertEquals(300,Reservation.BaseClassPrice(600),0);
    }
    public static void testBclassPrice413shouldEqual206_5(){
        Assert.assertEquals(206.5,Reservation.BaseClassPrice(413),0);
    }
    public static void testBclassPrice0shouldEqual0(){
        Assert.assertEquals(0,Reservation.BaseClassPrice(0),0);
    }

    public static void main(String[] args){
        testFclassPrice200shouldEqual400();
        testFclassPrice450_5shouldEqual901();
        testFclassPrice0shouldEqual0();
        testBclassPrice150shouldEqual300();
        testBclassPrice413shouldEqual206_5();
        testBclassPrice0shouldEqual0();
    }
}
