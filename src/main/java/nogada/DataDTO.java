package nogada;

import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class DataDTO {

	private String A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;
    public DataDTO(Row row) {
        this.A = getStringValueFromCell(row, 0);
        this.B = getStringValueFromCell(row, 1);
        this.C = getStringValueFromCell(row, 2);
        this.D = getStringValueFromCell(row, 3);
        this.E = getStringValueFromCell(row, 4);
        this.F = getStringValueFromCell(row, 5);
        this.G = getStringValueFromCell(row, 6);
        this.H = getStringValueFromCell(row, 7);
        this.I = getStringValueFromCell(row, 8);
        this.J = getStringValueFromCell(row, 9);
        this.K = getStringValueFromCell(row, 10);
        this.L = getStringValueFromCell(row, 11);
        this.M = getStringValueFromCell(row, 12);
        this.N = getStringValueFromCell(row, 13);
        this.O = getStringValueFromCell(row, 14);
        this.P = getStringValueFromCell(row, 15);
        this.Q = getStringValueFromCell(row, 16);
        this.R = getStringValueFromCell(row, 17);
        this.S = getStringValueFromCell(row, 18);
        this.T = getStringValueFromCell(row, 19);
        this.U = getStringValueFromCell(row, 20);
        this.V = getStringValueFromCell(row, 21);
        this.W = getStringValueFromCell(row, 22);
        this.X = getStringValueFromCell(row, 23);
        this.Y = getStringValueFromCell(row, 24);
        this.Z = getStringValueFromCell(row, 25);   
    }

    private String getStringValueFromCell(Row row, int cellIndex) {
    	String cellValue = "";
    	Cell cell = row.getCell(cellIndex);
        if (cell != null) {
            CellType cellType = cell.getCellType();
            switch (cellType) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    double numericValue = cell.getNumericCellValue();
                    if (numericValue == Math.floor(numericValue)) {
                        // 소수점 이하 자리수가 없는 경우
                        DecimalFormat decimalFormat = new DecimalFormat("#");
                        cellValue = decimalFormat.format(numericValue);
                    } else {
                        // 소수점 이하 자리수가 있는 경우
                        cellValue = String.valueOf(numericValue);
                    }
                    break;
                default:
                    break;
            }
        }
        return cellValue;
    }
    
    
	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public String getE() {
		return E;
	}

	public void setE(String e) {
		E = e;
	}

	public String getF() {
		return F;
	}

	public void setF(String f) {
		F = f;
	}

	public String getG() {
		return G;
	}

	public void setG(String g) {
		G = g;
	}

	public String getH() {
		return H;
	}

	public void setH(String h) {
		H = h;
	}

	public String getI() {
		return I;
	}

	public void setI(String i) {
		I = i;
	}

	public String getJ() {
		return J;
	}

	public void setJ(String j) {
		J = j;
	}

	public String getK() {
		return K;
	}

	public void setK(String k) {
		K = k;
	}

	public String getL() {
		return L;
	}

	public void setL(String l) {
		L = l;
	}

	public String getM() {
		return M;
	}

	public void setM(String m) {
		M = m;
	}

	public String getN() {
		return N;
	}

	public void setN(String n) {
		N = n;
	}

	public String getO() {
		return O;
	}

	public void setO(String o) {
		O = o;
	}

	public String getP() {
		return P;
	}

	public void setP(String p) {
		P = p;
	}

	public String getQ() {
		return Q;
	}

	public void setQ(String q) {
		Q = q;
	}

	public String getR() {
		return R;
	}

	public void setR(String r) {
		R = r;
	}

	public String getS() {
		return S;
	}

	public void setS(String s) {
		S = s;
	}

	public String getT() {
		return T;
	}

	public void setT(String t) {
		T = t;
	}

	public String getU() {
		return U;
	}

	public void setU(String u) {
		U = u;
	}

	public String getV() {
		return V;
	}

	public void setV(String v) {
		V = v;
	}

	public String getW() {
		return W;
	}

	public void setW(String w) {
		W = w;
	}

	public String getX() {
		return X;
	}

	public void setX(String x) {
		X = x;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}

	public String getZ() {
		return Z;
	}

	public void setZ(String z) {
		Z = z;
	}
	
	
}
