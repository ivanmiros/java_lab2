package matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import matrix.Matrix;

public class matrixTest {

   
    // Step 2 ----------------

    @Test
    public void step2EmptyMatrix() {
        Matrix m = new Matrix();
        assertEquals(0, m.getSize());
    }    

    @Test
    public void step2CreateMatrix() {
        Matrix m = new Matrix(5,3);
        assertEquals(15, m.getSize());
    }   
    
    @Test
    public void step2CopyMatrix() {
        Matrix m1 = new Matrix(5,3);
        Matrix m2 = new Matrix(m1);
        assertEquals(15, m2.getSize());
    }    
    
    @Test
    public void step2DrucEmpty() {
        Matrix m1 = new Matrix(0,0);
        assertEquals("[]\n", m1.getDruc());
    }  

    @Test
    public void step2Druc2x2() {
        Matrix m1 = new Matrix(2,2);
        assertEquals("[ 0.0 0.0 ]\n[ 0.0 0.0 ]\n", m1.getDruc());
    }  

    // Step 3 ----------------

    @Test
    public void step3WrongFillCell() {
        Matrix m1 = new Matrix(2,2);
        Exception exception = assertThrows(IllegalArgumentException.class,()-> m1.fillCell(-1, 1, 1.5));
    }      

    @Test
    public void step3CorrectFillCell() {
        Matrix m1 = new Matrix(2,2);
        m1.fillCell(1, 1, 1.5);
        assertEquals("[ 1.5 0.0 ]\n[ 0.0 0.0 ]\n",m1.getDruc());
    }  

    @Test
    public void step3FillRow() {
        Matrix m1 = new Matrix(4,2);
        m1.fillX(1, 1.1, 1.2, 1.3, 1.4);
        assertEquals("[ 1.1 1.2 1.3 1.4 ]\n[ 0.0 0.0 0.0 0.0 ]\n",m1.getDruc());
    }  
    
    @Test
    public void step3FillColumn() {
        Matrix m1 = new Matrix(4,2);
        m1.fillY(1, 2.1, 2.2);
        assertEquals("[ 2.1 0.0 0.0 0.0 ]\n[ 2.2 0.0 0.0 0.0 ]\n",m1.getDruc());
    }  

    // Step 4 ----------------

    @Test
    public void step4GetCell() {
        Matrix m1 = new Matrix(4,2);
        m1.fillCell(2, 1, 2.1);
        assertEquals(2.1,m1.getCell(2, 1));
    }  

    @Test
    public void step4GetX() {
        Matrix m1 = new Matrix(4,2);
        m1.fillCell(2, 1, 2.1);
        double[] reference = new double [] {0.0, 2.1, 0.0, 0.0}; 
        assertArrayEquals(reference,m1.getX(1));
    }  

    @Test
    public void step4GetY() {
        Matrix m1 = new Matrix(4,2);
        m1.fillCell(2, 1, 2.1);
        double[] reference = new double [] {2.1, 0.0}; 
        assertArrayEquals(reference,m1.getY(2));
    } 

    // Step 5 ----------------

    @Test
    public void step5GetRozm() {
        Matrix m1 = new Matrix(4,2);
        m1.fillY(1, 2.1, 2.2);
        assertEquals("4 x 2\n",m1.getRozm());
    } 
    
    // Step 6 ----------------

    @Test
    public void step6GetHash() {
        Matrix m1 = new Matrix(4,2);
        m1.fillY(1, 2.1, 2.2);
        assertEquals(-401279905,m1.getHash());
    } 
    
    @Test
    public void step6IsEqual() {
        Matrix m1 = new Matrix(4,2);
        m1.fillY(1, 2.1, 2.2);
        Matrix m2 = new Matrix(4,2);
        m2.fillY(1, 2.1, 2.2);
        assertEquals(true,m1.isEqual(m2));
    } 

    @Test
    public void step6NotEqual() {
        Matrix m1 = new Matrix(4,2);
        m1.fillY(1, 2.1, 2.2);
        Matrix m2 = new Matrix(4,2);
        m2.fillY(1, 2.1, 2.1);
        assertEquals(false,m1.isEqual(m2));
    } 

    // Step 7 ----------------
    
    @Test
    public void step7XSize() {
        Matrix m1 = new Matrix(4,2);
        assertEquals(4, m1.getXSize());
    } 

    @Test
    public void step7YSize() {
        Matrix m1 = new Matrix(4,2);
        assertEquals(2, m1.getYSize());
    } 

    @Test
    public void step7CreateImmutable() {
        Matrix m = new Matrix(4,2);
        IMatrix im = new IMatrix(m);
        assertEquals(m.getHash(), im.getHash());
    } 

    @Test
    public void step7ChangeImmutable() {
        IMatrix im = new IMatrix(4,2);
        Exception exception = assertThrows(IllegalArgumentException.class,()-> im.fillCell(1, 1, 1.5));
    }     

    // Step 8 ----------------
    @Test
    public void step8AddMatrix() {
        Matrix m1 = new Matrix(4, 2);
        Matrix m2 = new Matrix(4, 2);
        m1.fillY(1, 1.1, 1.2);
        m2.fillY(3, 3.1, 3.2);  
        Matrix m3 = m1.plus(m2);
        assertEquals("[ 1.1 0.0 3.1 0.0 ]\n[ 1.2 0.0 3.2 0.0 ]\n",m3.getDruc());
    }   

    // Step 9 ---------------- 
    @Test
    public void step9MulScalar() {
        Matrix m1 = new Matrix(4,2);
        Matrix m2 = new Matrix(3,4);
        m1.fillX(1, 1, 2, 3, 4);
        m1.fillX(2, 1, 1, 1, 0);
        m2.fillX(1, 1, 2, 3);    
        m2.fillX(2, 4, 5, 6);          
        m2.fillX(3, 7, 8, 9);    
        m2.fillX(4, 1, 1, 1);          
        Matrix m3 = m1.mul(m2);
        assertEquals("[ 34.0 40.0 46.0 ]\n[ 12.0 15.0 18.0 ]\n",m3.getDruc());
    }  
    

}