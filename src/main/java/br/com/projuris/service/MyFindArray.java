package br.com.projuris.service;

import org.springframework.stereotype.Service;

import br.com.projuris.repository.FindArray;

@Service
public class MyFindArray implements FindArray {

	@SuppressWarnings("unused")
	@Override
	public int findArray(int[] array, int[] subArray) {
		int posicao = -1;
		
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < subArray.length; j++) {

                if (array[i] == subArray[j]) {
                    posicao = i;
                };
                
                break;
            }
        }

        return posicao;
		 		 
	}
	
}