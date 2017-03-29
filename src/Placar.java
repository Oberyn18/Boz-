import java.util.Arrays;

public class Placar {
	
	private int[] posicoes = new int[10];
	
	public Placar(){
		for(int i = 0; i < 10; i++)
			posicoes[i] = 0;
	}
	
	
	public void add(int posicao, int[] dados) throws IllegalArgumentException{
			if ( posicoes[posicao-1] > 0 || posicao > 10 || posicao < 1 ){
				throw new IllegalArgumentException("Posicao ingressada nao existe ou já está ocupada.");
			}
			int sum;
			if(posicao == 10 || posicao == 9){
				posicao -= 1;
				Arrays.sort(dados);
				int flag = dados[0], contador = 1;
				for(int i = 1; i < dados.length; i++){
					if(dados[i] != flag){
						contador = 1;
						flag = dados[i];
					}else{
						contador++;
					}
				}
				if(posicao+1 == 10){
					System.out.println("Contador: " + contador);
					if(contador >= 5) posicoes[posicao] += 40;
					else System.out.println("Os dados nao forman uma QUINA.");
					
				}else{
					if(contador >= 4) posicoes[posicao] += 30;
					else System.out.println("Os dados nao forman uma QUADRA.");
				}	
			}else if(posicao == 8){
				posicao -= 1;
				Arrays.sort(dados);
				boolean isOne = false, isTwo = false, isThree = false, isFour = false, isFive = false, isSix = false;
				for(int i = 0; i < dados.length; i++){
					if(dados[i] == 1) isOne = true;
					else if(dados[i] == 2) isTwo = true;
					else if(dados[i] == 3) isThree = true;
					else if(dados[i] == 4) isFour = true;
					else if(dados[i] == 5) isFive = true;
					else if(dados[i] == 6) isSix = true;
				}
				if((isOne && isTwo && isThree && isFour && isFive) || (isTwo && isThree && isFour && isFive && isSix)){
					posicoes[posicao] += 20;
				}else{
					System.out.println("Os dados nao forman uma SEQUENCIA");
				}
			}else if(posicao == 7){
				posicao -= 1;
				Arrays.sort(dados);
				int contador = 1;
				int lastIndex = -1;
				int flag = dados[0];
				for(int i = 0; i < dados.length; i++){
					if(dados[i] == flag) contador++;
					else{
						lastIndex = i;
						flag = dados[i];
						if(i <= 2){
							break;
						}else{
							contador = 1;
						}
					}
				}
				if(contador >= 5){
					posicoes[posicao] += 15;
				}else if(contador >= 3){
					// I need to find two more numbers which are equal
					contador = 0;
					for(int i = lastIndex + 1; i < dados.length; i++){
						if(dados[i] == flag) contador++;
						else{
							flag = dados[i];
							contador = 0;
						}
					}
					if(contador >= 2){
						posicoes[posicao] += 15;						
					}else{
						// I can't find a FULL HAND
						System.out.println("Os dados nao forman uma FULL HAND");
					}
				}else if(contador >= 2){
					// I need to find three more numbers which are equal
					contador = 0;
					for(int i = lastIndex + 1; i < dados.length; i++){
						if(dados[i] == flag) contador++;
						else{
							flag = dados[i];
							contador = 0;
						}
					}
					if(contador >= 3){
						posicoes[posicao] += 15;
					}else{
						// I can't find a FULL HAND
						System.out.println("Os dados nao forman uma FULL HAND");
					}
				}else{
					// I can't find a FULL HAND
					System.out.println("Os dados nao forman uma FULL HAND");
				}
			}else{
				sum = 0;
				for(int i = 0; i < dados.length; i++){
					if(dados[i] == posicao){
						sum += dados[i];
					}
				}
				posicoes[posicao-1] += sum;
			}
		}
	
	public int getScore(){
		int sum = 0;
		for(int i = 0; i < posicoes.length; i++){
			sum += posicoes[i];
		}
		return sum;
	}
	
	@Override
	public java.lang.String toString(){
		String[] printable = new String[10];
		int[] sizes = new int[10];
		for(int i = 0; i < posicoes.length; i++){
			if(posicoes[i] == 0)
				printable[i] = "("+Integer.toString(i+1)+")";
			else
				printable[i] = Integer.toString(posicoes[i]);
			sizes[i] = printable[i].length();
		}
		int i;
		// LINE 1 //////////////////////////////////////////
		String print = printable[0];
		i = sizes[0];
		while(i <= 7){
			print += " ";
			i++;
		}
		print += "|";
		// This is what it rests to fill with spaces
		i = 10 - sizes[6];
		for(int j = 0; j < i/2; j++)
			print += " ";
		print += printable[6];
		for(int j = i/2; j < i; j++)
			print += " ";
		print += "|";
		i = sizes[3];
		while(i < 7){
			print += " ";
			i++;
		}
		print += (printable[3] + "\n");
		// LINE 2 //////////////////////////////////////////
		for(i = 0; i < 27; i++)
			print += "-";
		print += "\n";
		// LINE 3 //////////////////////////////////////////
		print += printable[1];
		i = sizes[1];
		while(i <= 7){
			print += " ";
			i++;
		}
		print += "|";
		// This is what it rests to fill with spaces
		i = 10 - sizes[7];
		for(int j = 0; j < i/2; j++)
			print += " ";
		print += printable[7];
		for(int j = i/2; j < i; j++)
			print += " ";
		print += "|";
		i = sizes[4];
		while(i < 7){
			print += " ";
			i++;
		}
		print += (printable[4] + "\n");
		// LINE 4 //////////////////////////////////////////
		for(i = 0; i < 27; i++)
			print += "-";
		print += "\n";
		// LINE 5 //////////////////////////////////////////
		print += printable[2];
		i = sizes[2];
		while(i <= 7){
			print += " ";
			i++;
		}
		print += "|";
		// This is what it rests to fill with spaces
		i = 10 - sizes[8];
		for(int j = 0; j < i/2; j++)
			print += " ";
		print += printable[8];
		for(int j = i/2; j < i; j++)
			print += " ";
		print += "|";
		i = sizes[5];
		while(i < 7){
			print += " ";
			i++;
		}
		print += (printable[5] + "\n");
		// LINE 6 //////////////////////////////////////////
		for(i = 0; i < 27; i++)
			print += "-";
		print += "\n";
		// LINE 7 /////////////////////////////////////////
		for(i = 0; i < 7; i++)
			print +=  " ";
		print += " |";
		i = 10 - sizes[9];
		for(int j = 0; j < i/2; j++)
			print += " ";
		print += printable[9];
		for(int j = i/2; j < i; j++)
			print += " ";
		print += "|\n";
		// LINE 8 //////////////////////////////////////////
		for(i = 0; i < 7; i++)
			print +=  " ";
		print += " +----------+\n";
		return print;
	}
	
	/*
	public static void main(java.lang.String[] args){
		Placar p = new Placar();
		int[] arreglo = {2,2,2,2,5,2,7,1,2,1};
		p.add(2, arreglo);
		int arreglo2[] = {1, 9, 2, 2, 3, 4, 5, 10, 10, 10};
		p.add(8, arreglo2);
		System.out.print(p.toString());
	}
	*/
}	
