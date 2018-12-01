package BlackBox;

import BlackBox.Setups.SortSetup;
import org.junit.Test;

public class SortAlgorithmBlackBoxTest extends SortSetup {

    @Test
    public void dummyTest(){
        int[] input = new int[]{2,1};
        int[] expectedOutput = new int[]{1,2};
        sortAlgorithmPUT.run(input,expectedOutput);
    }

    @Test
    public void nullInputTest() {
        int[] input = null;
        int[] expectedOutput = null;
        sortAlgorithmPUT.run(input, expectedOutput);
    }

    @Test
    public void emptyInputTest() {
        int[] input = new int[0];
        int[] expectedOutput = new int[0];
        sortAlgorithmPUT.run(input, expectedOutput);
    }

    @Test
    public void singleInputTest() {
        int[] input = new int[]{1};
        int[] expectedOutput = new int[]{1};
        sortAlgorithmPUT.run(input, expectedOutput);
    }

    @Test
    public void maxValueInputTest() {
        int[] input = new int[]{Integer.MAX_VALUE, 1, 1};
        int[] expectedOutput = new int[]{1,1,Integer.MAX_VALUE};
        sortAlgorithmPUT.run(input,expectedOutput);
    }

    @Test
    public void minValueInputTest() {
        int[] input = new int[]{Integer.MIN_VALUE, 1, 1};
        int[] expectedOutput = new int[]{Integer.MIN_VALUE, 1, 1};
        sortAlgorithmPUT.run(input,expectedOutput);
    }

    @Test
    public void duplicateTest() {
        int[] input = new int[]{3,3,3,2,2,2,-1,-1,-1};
        int[] expectedOutput = new int[] {-1, -1, -1, 2, 2, 2, 3, 3, 3};
        sortAlgorithmPUT.run(input, expectedOutput);
    }

    @Test
    public void putItemToRight() {
        int[] input = new int[]{8, 7, 6, 5, 1, -1, 4, 3, 2, 1};
        int[] expectedOutput = new int[] {-1, 1, 1, 2, 3, 4, 5, 6, 7, 8};
        sortAlgorithmPUT.run(input, expectedOutput);
    }

    @Test
    public void newTest1() {
        int[] input = new int[]{8, 7, 6, -1, 5, 1, -1, 4, 3, 2, 1, -1, -1};
        int[] expectedOutput = new int[] {-1, -1, -1, -1, 1, 1, 2, 3, 4, 5, 6, 7, 8};
        sortAlgorithmPUT.run(input, expectedOutput);
    }

    @Test
    public void sorted() {
        int[] input = new int[]{-1, 0, 1, 2, 3};
        int[] expectedOutput = new int[]{-1, 0, 1, 2, 3};
        sortAlgorithmPUT.run(input, expectedOutput);
    }

    @Test
    public void newTest2() {
        int[] input = new int[]{-2, -2, 8, 8, 8, 7, 6, -1, 4, 5, 1, -1, 4, 4, 4, 4, 4, 3, 2, 1, -1, -1};
        int[] expectedOutput = new int[] {-2, -2, -1, -1, -1, -1, 1, 1, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 8, 8};
        sortAlgorithmPUT.run(input, expectedOutput);
    }

}


