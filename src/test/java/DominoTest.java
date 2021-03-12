import org.junit.Assert;
import org.junit.Test;

public class DominoTest {
    @Test
    public void TestingNewStructure(){

        Assert.assertEquals(Main.newStructure("||//||\\||/\\|",1) , "||///\\\\||/\\|");
    }

}
