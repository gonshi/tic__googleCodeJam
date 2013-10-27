import java.io.*;

public class tic{	
	static char[][] c = new char[4][4];
    public static void main( String[] args ) {
		try{
			FileReader f = new FileReader("A-large-practice.in");
			String n = "";
			boolean never = false;
			char ch;
			while((ch = (char)f.read()) != '\n'){
				n = n + ch;
			}
			int _n = Integer.parseInt(n);
			
			for(int i = 0; i < _n; i++){
				never = false;
				for(int j = 0; j < 4; j++){
					for(int k = 0; k < 4; k++){
						c[j][k] = (char)f.read();
						if(c[j][k] == '.') never = true;
					}
					f.read();
				}
				check(i,never);
				f.read();
			}			
		}catch(Exception e){
			System.out.println("error");
		}		
	}
	
	public static void check(int _i,boolean _never){		
		char key;
		//row
		step:for(int i = 0; i < 4;i++){
			if(c[i][0] != 'T') key = c[i][0];
			else key = c[i][1];
			for(int j = 0; j < 4; j++){
				if(c[i][j] != 'T' && c[i][j] != key) continue step;
			}
			if(key == 'X'){
				System.out.println("Case #"+(_i+1)+": X won");
				return;
			}
			else if(key == 'O'){
				System.out.println("Case #"+(_i+1)+": O won");
				return;
			}
		}
		
		//column
		step:for(int i = 0; i < 4;i++){
			if(c[0][i] != 'T') key = c[0][i];
			else key = c[1][i];
			for(int j = 0; j < 4; j++){
				if(c[j][i] != 'T' && c[j][i] != key) continue step;
			}
			if(key == 'X'){
				System.out.println("Case #"+(_i+1)+": X won");
				return;
			}
			else if(key == 'O'){
				System.out.println("Case #"+(_i+1)+": O won");
				return;
			}
		}
		
		//diagonal right down
		if(c[0][0] != 'T') key = c[0][0];
		else key = c[1][1];
		step:for(int i = 0; i < 4;i++){
			if(c[i][i] != 'T' && c[i][i] != key) break;
			if(i==3){
				if(key == 'X'){
					System.out.println("Case #"+(_i+1)+": X won");
					return;
				}
				else if(key == 'O'){
					System.out.println("Case #"+(_i+1)+": O won");
					return;
				}
			}
		}

		//diagonal left down
		if(c[0][3] != 'T') key = c[0][3];
		else key = c[1][2];
		step:for(int i = 0; i < 4;i++){
			if(c[i][3-i] != 'T' && c[i][3-i] != key) break;
			if(i==3){
				if(key == 'X'){
					System.out.println("Case #"+(_i+1)+": X won");
					return;
				}
				else if(key == 'O'){
					System.out.println("Case #"+(_i+1)+": O won");
					return;
				}
			}
		}
		if(_never == true){
			System.out.println("Case #"+(_i+1)+": Game has not completed");
			return;
		}
		else System.out.println("Case #"+(_i+1)+": Draw");
	}
}
