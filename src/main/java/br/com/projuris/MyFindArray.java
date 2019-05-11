package br.com.projuris;

import org.springframework.stereotype.Service;

@Service
public class MyFindArray implements FindArray {

	@Override
	public int findArray(int[] array, int[] subArray) {
		 int posicao = 0;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < subArray.length; j++) {

                if (array[i] == subArray[j]) {
                    posicao = i;
                    System.out.println(array[j]);
                    System.out.println(array[i]);
                }
            }
        }

        return posicao;
		 		 
	}
	
}