package matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import matrix.Matrix;

public class matrixTest {

   

    @Test
    public void emptyMatrix() {
        Matrix m = new Matrix();
        assertEquals(0, m.GetSize());
    }    

    @Test
    public void createMatrix() {
        Matrix m = new Matrix(5,3);
        assertEquals(15, m.GetSize());
    }   
    
    @Test
    public void copyMatrix() {
        Matrix m1 = new Matrix(5,3);
        Matrix m2 = new Matrix(m1);
        assertEquals(15, m2.GetSize());
    }    
    
    @Test
    public void checkDrucEmpty() {
        Matrix m1 = new Matrix(0,0);
        assertEquals("[]\n", m1.Druc());
    }  

    @Test
    public void checkDruc2x2() {
        Matrix m1 = new Matrix(2,2);
        assertEquals("[ 0.0 0.0 ]\n[ 0.0 0.0 ]\n", m1.Druc());
    }  

    @Test
    public void checkWrongFillCell() {
        Matrix m1 = new Matrix(2,2);
        Exception exception = assertThrows(IllegalArgumentException.class,()-> m1.fillCell(-1, 1, 1.5));
    }      

    @Test
    public void checkCorrectFillCell() {
        Matrix m1 = new Matrix(2,2);
        m1.fillCell(1, 1, 1.5);
        assertEquals("[ 1.5 0.0 ]\n[ 0.0 0.0 ]\n",m1.Druc());
    }  

    @Test
    public void checkFillRow() {
        Matrix m1 = new Matrix(4,2);
        m1.fillX(1, 1.1, 1.2, 1.3, 1.4);
        assertEquals("[ 1.1 1.2 1.3 1.4 ]\n[ 0.0 0.0 0.0 0.0 ]\n",m1.Druc());
    }  
    
    @Test
    public void checkFillColumn() {
        Matrix m1 = new Matrix(4,2);
        m1.fillY(1, 2.1, 2.2);
        assertEquals("[ 2.1 0.0 0.0 0.0 ]\n[ 2.2 0.0 0.0 0.0 ]\n",m1.Druc());
    }  

}