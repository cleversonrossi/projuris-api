package br.com.projuris.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import br.com.projuris.repository.FindCharachter;

@Service
public class MyFindChar implements FindCharachter {

	@Override
	public char findChar(String word) {
		char[] charArray = word.toCharArray();
		char retorno = ' ';
		char auxChar;
		int cont = 0;
		
		for(int i = 0; i < word.length(); i++) {
			auxChar = word.charAt(i);
		
			for(int j = i+1; j < word.length(); j++) {
				if (auxChar==word.charAt(j)) {
					cont++;
				}
			}
		}
		
		for (char letra : charArray) {
			if (cont > 0 && StringUtils.countMatches(word, String.valueOf(letra)) == 1) {
				retorno = letra;
				break;
			}
		}

      return retorno;
	}

}
