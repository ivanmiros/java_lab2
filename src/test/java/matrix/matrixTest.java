package matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import matrix.Matrix;

public class matrixTest {

   

    @Test
    public void EmptyMatrix() {
        Matrix m = new Matrix();
        assertEquals(0, m.GetSize());
    }    

    @Test
    public void CreateMatrix() {
        Matrix m = new Matrix(5,3);
        assertEquals(15, m.GetSize());
    }   
    
    @Test
    public void CopyMatrix() {
        Matrix m1 = new Matrix(5,3);
        Matrix m2 = new Matrix(m1);
        assertEquals(15, m2.GetSize());
    }    
    
}