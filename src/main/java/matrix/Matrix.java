package matrix;


public class Matrix {
 
    private double[][] _data = null;
    private int _x=0, _y=0;

    public Matrix(int x, int y) {
        this._x = x;
        this._y = y;
        _data = new double [this._x][this._y];
    }

    public Matrix() {
        this._x = 0;
        this._y = 0;
        _data = new double [this._x][this._y];
    }    

    public Matrix(Matrix m_other) {
        this._data = m_other._data.clone();
        this._x = m_other._x;
        this._y = m_other._y;        
        _data = new double [this._x][this._y];
    }    

    public int GetSize() {
        return this._x * this._y;
    }

    public String Druc() {
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

    public static void main(String args[]){
        Matrix m = new Matrix(4, 2);
        m.fillY(1, 2.1, 2.2);
        //System.out.println("Matrix size: "+ m.GetSize());
        System.out.println(m.Druc());
    }

};