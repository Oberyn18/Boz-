import java.util.Arrays;

public class Placar {
	
	private int[] posicoes = new int[10];
	
	public Placar(){
		for(int i = 0; i < 10; i++)
			posicoes[i] = 0;
	}
	
	
	public void add(int posicao, int[] dados) throws 
		IllegalArgumentException{
			if ( posicoes[posicao] > 0 || posicao > 10 || posicao < 0 ) 
				throw new IllegalArgumentException("Posicao ingressada nao existe ou já está ocupada.");
			int sum;
			if(posicao == 10 || posicao == 9){
				sum = 0;
				int flag = dados[0], contador = 0;
				for(int i = 1; i < dados.length; i++){
					if(dados[i] != flag){
						contador = 0;
						flag = dados[i];
					}else{
						contador++;
					}
				}
				if(posicao == 10){
					if(contador >= 5) posicoes[posicao] += 40;
					else System.out.println("Os dados nao forman uma QUINA.");
					
				}else{
					if(contador >= 4) posicoes[posicao] += 30;
					else System.out.println("Os dados nao forman uma QUADRA.");
				}	
			}else if(posicao == 8){			
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
				Arrays.sort(dados);
				int contador = 0;
				int lastIndex = -1;
				int flag = dados[0];
				for(int i = 0; i < dados.length; i++){
					if(dados[i] == flag) contador++;
					else{
						lastIndex = i;
						flag = dados[i];
						break;
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
				posicoes[posicao] += sum;
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
	public String toString(){
		
		(1)    |   (7)    |   (4) 
		--------------------------\n
		(2)    |   20     |   (5) \n
		--------------------------\n
		(3)    |   30     |   (6) \n
		--------------------------\n
		       |   (10)   |
		       +----------+ 
	}
}
