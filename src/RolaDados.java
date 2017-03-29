
public class RolaDados {
	
	private Dado[] dados;
	private int cantidad;
	private int[] valores;
	
	public RolaDados(int n) {
		
		this.cantidad = n;
		this.dados = new Dado[n + 1];
		this.valores = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			dados[i] = new Dado();
		}
	}
	
	public int[] rolar() {
		for (int i = 1; i <= this.cantidad; i++) {
			valores[i] = dados[i].rolar();
		}
		
		return valores;
	}
	
	public int[] rolar(boolean[] quais) {
		for (int i = 0; i < quais.length; i++) {
			if (quais[i]) valores[i + 1] = dados[i + 1].rolar();
		}
		
		return valores;
	}
	
	public int[] rolar(String s) {
		for (int i = 0; i < s.length(); i += 2) {
			int num = Character.getNumericValue(s.charAt(i)); 
			valores[num] = dados[num].rolar();
		}
		return valores;
	}
	
	public String toString() {
		String d = "";
		
		for (int i = 1; i <= this.cantidad; i++) {
			d += " " + i + "         ";
		}
		
		d += "\n";
		
		int com = 0, fin = 7;
		
		for (int f = 0; f < 5; f++) {
			for (int i = 1; i <= this.cantidad; i++) {
				String s = dados[i].toString();
				
				for (int j = com; j < fin; j++){
					d += s.charAt(j);
				}
				
				d += "    ";
			}
			
			d += "\n";
			
			com += 8;
			fin = com + 7;
		}
				
		return d;
	}
}
