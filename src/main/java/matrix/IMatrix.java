package matrix;

public class IMatrix extends Matrix {
 
    public IMatrix() {
        super();
    }  

    public IMatrix(int x, int y) {
        super(x, y);
    }

    public IMatrix(Matrix m_other) {
        super(m_other);
    }

    // Override forbidden functions

    @Override
    public void fillCell (int x, int y, double val) {
        throw new IllegalArgumentException("Immutable Matrix not to be changed");
    } 

    public void fillX (int y, double... val) {
        throw new IllegalArgumentException("Immutable Matrix not to be changed");
    }

    public void fillY (int x, double... val) {
        throw new IllegalArgumentException("Immutable Matrix not to be changed");
    }  

}
