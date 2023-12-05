package matrix;

import java.util.Arrays;

public class Matrix {
 
    private double[][] _data = null;
    private int _x=0, _y=0;

    // Step 1,2 ----------------

    public Matrix() {
        this._x = 0;
        this._y = 0;
    }  
    
    public Matrix(int x, int y) {
        this._x = x;
        this._y = y;
        this._data = new double [this._x][this._y];
    }

    public Matrix(Matrix m_other) {
        this._x = m_other._x;
        this._y = m_other._y;        
        this._data = new double [this._x][this._y];
        for (int i=0; i<this._x; i++) 
            for (int j=0; j<this._y; j++) 
                this._data[i][j] = m_other.getCell(i+1, j+1);
    }    

    public int getSize() {
        return this._x * this._y;
    }

    public String getDruc() {
        String output = "";
        if (this._x == 0 || this._y == 0) {
            output = "[]\n";
            return output;
        }
        for (int j=0; j<this._y; j++) {
            output += "[ ";
            for (int i=0; i<this._x; i++) {
                output += this._data[i][j]+" ";
            }
            output +="]\n";
        }
        return output;
    }

    // Step 3 ----------------

    public void fillCell (int x, int y, double val) {
        if (x <=0 || x > this._x || y <= 0 || y > this._y ) {
            throw new IllegalArgumentException("Row or Column numbers are wrong for this Matrix");
        }
        this._data[x-1][y-1] = val;
    }    

    public void fillX (int y, double... val) {
        if ( val.length != this._x ) {
            throw new IllegalArgumentException("Row (X) count values is wrong for this Matrix");
        } 
        for (int i = 0; i < val.length; i++){
            this.fillCell(i+1, y, val[i]);
        }
    }

    public void fillY (int x, double... val) {
        if ( val.length != this._y ) {
            throw new IllegalArgumentException("Column (Y) count values is wrong for this Matrix");
        } 
        for (int i = 0; i < val.length; i++){
            this.fillCell(x, i+1, val[i]);
        }
    }    


    // Step 4 ----------------
    
    public double getCell (int x, int y) {
        if (x <=0 || x > this._x || y <= 0 || y > this._y ) {
            throw new IllegalArgumentException("Row or Column numbers are wrong for this Matrix");
        }
        return this._data[x-1][y-1];
    } 

    public double[] getX (int y) {
        double[] x_data = new double[this._x];
        for (int i = 0; i < this._x; i++){
            x_data[i] = this.getCell(i+1, y);
        }
        return x_data;
    }

    public double[] getY (int x) {
        double[] y_data = new double[this._y];
        for (int i = 0; i < this._y; i++){
            y_data[i] = this.getCell(x, i+1);
        }
        return y_data;
    }

    // Step 5 ----------------

    public String getRozm() {
        return String.valueOf(_x) + " x " + String.valueOf(_y) + "\n";
    }

    // Step 6 ----------------

    public int getHash() {
        return Arrays.deepHashCode(this._data);
    }

    public boolean isEqual(Matrix m) {
        if ( this == m || this.getHash() == m.getHash()) {
            return true;
        }
        return false;
    }    

    // Step 7 ----------------    

    public int getXSize () {
        return this._x;
    }

    public int getYSize () {
        return this._y;
    }    


    // Step 8 ----------------    

    public Matrix plus(Matrix m_other) {
        if (!this.getRozm().equals(m_other.getRozm())) {
            throw new IllegalArgumentException("Can't add Matrices with differ sizes");
        }
        Matrix m_plus = new Matrix(this._x, this._y); 
        for (int i=0; i<this._x; i++) 
            for (int j=0; j<this._y; j++) 
                m_plus.fillCell(i+1, j+1, this._data[i][j] + m_other.getCell(i+1, j+1));
        return m_plus;
    }    

    public Matrix mulScalar(double k) {
        Matrix m_mulScalar = new Matrix(this._x, this._y); 
        for (int i=0; i<this._x; i++) 
            for (int j=0; j<this._y; j++) 
                m_mulScalar.fillCell(i+1, j+1, this._data[i][j] * k);
        return m_mulScalar;
    }    

    // Step 9 ----------------    

    public void addCell (int x, int y, double val) {
        if (x <=0 || x > this._x || y <= 0 || y > this._y ) {
            throw new IllegalArgumentException("Row or Column numbers are wrong for this Matrix");
        }
        this._data[x-1][y-1] += val;
    }  

    public Matrix mul(Matrix m_other) {
        // Rule: number of columns (X) A = rows (Y) B    A*B=C
        // Result: C has columns (X) from B (X), rows (Y) from A (Y)
        if (this.getXSize() != m_other.getYSize()) {
            throw new IllegalArgumentException("Can't multiply Matrices A*B where A(X) != B(Y)");
        }
        Matrix m_mul = new Matrix(m_other.getXSize(), this.getYSize()); 
        // Loop B(X)=C(X)
        for (int i=0; i<m_other.getXSize(); i++) 
            // Loop A(Y)=C(Y)
            for (int j=0; j<this.getYSize(); j++) 
                // Loop A(X)/B(Y)
                for (int ii=0; ii<this.getXSize(); ii++) 
                    m_mul.addCell(i+1, j+1, this.getCell(ii+1, j+1) * m_other.getCell(i+1, ii+1));
        return m_mul;
    }

    // Step 10 ----------------    

    public Matrix transponse() {
        Matrix m_trans = new Matrix(this.getYSize(), this.getXSize()); 
        for (int i=0; i<this.getYSize(); i++) 
            for (int j=0; j<this.getXSize(); j++) 
                m_trans.fillCell(i+1, j+1, this.getCell(j+1, i+1));
        return m_trans;
    }

    // Step 11 ----------------    

    public Matrix (double... vec) {
        if (vec.length == 0) {
            throw new IllegalArgumentException("Can't create zerro matrix");
        }
        this._x = vec.length;
        this._y = vec.length;        
        this._data = new double [this._x][this._y];
        for (int i=0; i<vec.length; i++) 
            for (int j=0; j<vec.length; j++) 
                if ( i == j ) this._data[i][j] = vec[i];
    }    

    public static void main(String args[]){
        Matrix m1 = new Matrix(0.0, 1.1, 3.0);
        System.out.println(m1.getDruc());        
    }

};