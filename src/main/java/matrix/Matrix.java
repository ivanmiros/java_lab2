package matrix;


public class Matrix {
 
    private int[][] _data = null;
    private int _x=0, _y=0;

    public Matrix(int x, int y) {
        this._x = x;
        this._y = y;
        _data = new int [this._x][this._y];
    }

    public Matrix() {
        this._x = 0;
        this._y = 0;
        _data = new int [this._x][this._y];
    }    

    public Matrix(Matrix m_other) {
        this._data = m_other._data.clone();
        this._x = m_other._x;
        this._y = m_other._y;        
        _data = new int [this._x][this._y];
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

    

    public static void main(String args[]){
        Matrix m = new Matrix(2, 2);
        //System.out.println("Matrix size: "+ m.GetSize());
        System.out.println(m.Druc());
    }

};