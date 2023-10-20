
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class OrderComparisonTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }


    String[] corporateNames = {"Kroger","Petsmart","Ikea","Lowes","Target","Ramen Spot","Plaza Art","Microsoft"};
    double[] volume = {62.9,59.6,92.2,74.0,51.7,42.8,35.9,46.9};
    double[] weight = {421.3,713.6,950.4,667.8,794.2,276.4,46.2,110.4};
    double[] profit = {1294.96,7339.17,6259.38,4983.74,8483.47,1738.55,524.91,9066.42};

    String[] newCorporateNames = {"Apple","AT&T","Intel","Boeing","IBM","Beauvine","Galaxy Diner","Deep Groove","Williams"};
    double[] newVolume = {75.43,20.23,27.20,24.13,73.81,33.03,51.28,9.37};
    double[] newWeight = {760.73,170.73,807.42,152.83,139.09,590.61,908.35,440.38};
    double[] newProfit = {3536.38,9702.12,4344.78,2743.13,1555.80,5176.58,2995.66,1909.92};





    @Test
    public void calcAvgGivenVolumeDataTest(){
        double actual = OrderComparison.calcAvg(volume);
        double expected = 58.2499;
        assertEquals("When checking the result of calcAvg we",expected,actual,.001);
    }

    @Test
    public void calcAvgUnknownDataTest(){
        double actual = OrderComparison.calcAvg(newVolume);
        double expected = 39.31;
        assertEquals("When checking the result of calcAvg we",expected,actual,.001);
    }

    @Test
    public void findHighValueGivenDistanceDataTest(){
        double actual = OrderComparison.findHighValue(volume);
        double expected = 92.2;
        assertEquals("When checking the result of findHighValue we",expected,actual,.001);
    }

    @Test
    public void findHighValueUnknownDataTest(){
        double actual = OrderComparison.findHighValue(newVolume);
        double expected = 75.43;
        assertEquals("When checking the result of findHighValue we",expected,actual,.001);
    }

    @Test
    public void findLeastValueGivenProfitDataTest(){
        double actual = OrderComparison.findLeastValue(profit);
        double expected = 524.91;
        assertEquals("When checking the result of findLeastValue we",expected,actual,.001);
    }

    @Test
    public void findLeastValueUnknownDataTest(){
        double actual = OrderComparison.findLeastValue(newProfit);
        double expected = 1555.8;
        assertEquals("When checking the result of findLeastValue we",expected,actual,.001);
    }

    @Test
    public void findHighestTwoValuesGivenVolumeDataTest(){
        String[] actual = OrderComparison.findHighestTwo(corporateNames,volume);
        assertEquals("When checking the result of findHighestTwo we expected the first element of the resulting array to be","Ikea",actual[0]);
        assertEquals("When checking the result of findHighestTwo we expected the second element of the array to be", "Lowes",actual[1]);
    }

    @Test
    public void findHighestTwoValuesUnknownDataTest(){
        String[] actual = OrderComparison.findHighestTwo(newCorporateNames,newVolume);
        assertEquals("When checking the result of findHighestTwo we expected the first element of the resulting array to be","Apple",actual[0]);
        assertEquals("When checking the result of findHighestTwo we expected the second element of the array to be", "IBM",actual[1]);
    }

    @Test
    public void findLeastTwoValuesGivenVolumeDataTest(){
        String[] actual = OrderComparison.findLeastTwo(corporateNames,weight);
        assertEquals("When checking the result of findLeastTwo we expected the first element of the resulting array to be","Plaza Art",actual[0]);
        assertEquals("When checking the result of findLeastTwo we expected the second element of the array to be", "Microsoft",actual[1]);
    }

    @Test
    public void findLeastTwoValuesUnknownDataTest(){
        String[] actual = OrderComparison.findLeastTwo(newCorporateNames,newWeight);
        assertEquals("When checking the result of findLeastTwo we expected the first element of the resulting array to be","IBM",actual[0]);
        assertEquals("When checking the result of findLeastTwo we expected the second element of the array to be", "Boeing",actual[1]);
    }

    @Test
    public void findCompanyGivenDataTest(){
        boolean actual = OrderComparison.findCompany(corporateNames,"Target");
        assertTrue("When checking the result of findCompany the given array contained \"Target\" and should return true",actual);

        actual = OrderComparison.findCompany(corporateNames,"Mattel");
        assertFalse("When checking the result of findCompany the given array does not contain \"Mattel\" and should return false",actual);
    }

    @Test
    public void findCompanyUnknownDataTest(){
        boolean actual = OrderComparison.findCompany(newCorporateNames,"Beauvine");
        assertTrue("When checking the result of findCompany the given array contained \"Beauvine\" and should return true",actual);

        actual = OrderComparison.findCompany(newCorporateNames,"Maymont");
        assertFalse("When checking the result of findCompany the given array does not contain \"Maymont\" and should return false",actual);
    }

    @Test
    public void mainMethodValidCompany(){
        String input = "Target";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OrderComparison.main(null);
        String[] rawOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("When checking the first line of output we","The average order volume is: 58.25",rawOutput[0].trim());
        assertEquals("When checking the second line of output we","The average order weight is: 497.54",rawOutput[1].trim());
        assertEquals("When checking the third line of output we","The highest volume order is: 92.20",rawOutput[2].trim());
        assertEquals("When checking the fourth line of output we","The least profitable order is: $524.91",rawOutput[3].trim());
        assertEquals("When checking the fifth line of output we","The companies whose orders have the highest two volumes are:",rawOutput[4].trim());
        assertEquals("When checking the sixth line of output we","Ikea",rawOutput[5].trim());
        assertEquals("When checking the seventh line of output we","Lowes",rawOutput[6].trim());
        assertEquals("When checking the eighth line of output we","The companies whose orders have the lowest two weights are:",rawOutput[7].trim());
        assertEquals("When checking the ninth line of output we","Plaza Art",rawOutput[8].trim());
        assertEquals("When checking the tenth line of output we","Microsoft",rawOutput[9].trim());
        assertEquals("When checking the tenth line of output we","Enter a company:",rawOutput[10].trim());
        assertEquals("When checking the tenth line of output we","Target is a company in the array.",rawOutput[11].trim());
        assertTrue("You should not have more than 12 lines of output!",rawOutput.length < 13);
    }

    @Test
    public void mainMethodInvalidCompany(){
        String input = "Bandcamp";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OrderComparison.main(null);
        String[] rawOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("When checking the first line of output we","The average order volume is: 58.25",rawOutput[0].trim());
        assertEquals("When checking the second line of output we","The average order weight is: 497.54",rawOutput[1].trim());
        assertEquals("When checking the third line of output we","The highest volume order is: 92.20",rawOutput[2].trim());
        assertEquals("When checking the fourth line of output we","The least profitable order is: $524.91",rawOutput[3].trim());
        assertEquals("When checking the fifth line of output we","The companies whose orders have the highest two volumes are:",rawOutput[4].trim());
        assertEquals("When checking the sixth line of output we","Ikea",rawOutput[5].trim());
        assertEquals("When checking the seventh line of output we","Lowes",rawOutput[6].trim());
        assertEquals("When checking the eighth line of output we","The companies whose orders have the lowest two weights are:",rawOutput[7].trim());
        assertEquals("When checking the ninth line of output we","Plaza Art",rawOutput[8].trim());
        assertEquals("When checking the tenth line of output we","Microsoft",rawOutput[9].trim());
        assertEquals("When checking the tenth line of output we","Enter a company:",rawOutput[10].trim());
        assertEquals("When checking the tenth line of output we","Bandcamp is not a company in the array.",rawOutput[11].trim());
        assertTrue("You should not have more than 12 lines of output!",rawOutput.length < 13);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


}
