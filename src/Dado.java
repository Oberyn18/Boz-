
public class Dado {
	private int numeroLados;
	private int ultimolado = -1;
			
	public void setUltimolado(int ultimolado) {
		this.ultimolado = ultimolado;
	}
	
	public Dado(){
		this.numeroLados = 6;
	}
	
	public Dado(int n){
		this.numeroLados = n;
	}
	

	public int getLado() {
		return ultimolado;
	}
	
	public int rolar(){
		Random r = new Random();
		return 1 + r.getIntRand(numeroLados);
	}
	
	/* public static void main(java.lang.String[] args){
		Dado d = new Dado(10);
		int i = 20000;
		while(i > 0){
			System.out.println(d.rolar());
			i--;
		}
	}
	*/
	
	@Override
	public java.lang.String toString(){
		switch(numeroLados){
		case 1: return "+-----+\n|     |\n|  *  |\n|     |\n+-----+\n"; 
		case 2: return "+-----+\n|    *|\n|     |\n|*    |\n+-----+\n"; 
		case 3: return "+-----+\n|    *|\n|  *  |\n|*    |\n+-----+\n"; 
		case 4: return "+-----+\n|*   *|\n|     |\n|*   *|\n+-----+\n"; 
		case 5: return "+-----+\n|*   *|\n|  *  |\n|*   *|\n+-----+\n"; 
		case 6: return "+-----+\n|*   *|\n|*   *|\n|*   *|\n+-----+\n"; 
		default: return "Nao e possivel mostrar os numeros do dado";
		}
	}
}
