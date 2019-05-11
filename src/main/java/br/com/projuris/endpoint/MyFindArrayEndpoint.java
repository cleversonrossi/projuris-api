package br.com.projuris.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projuris.repository.FindArray;

@RestController
@RequestMapping("/myArray")
public class MyFindArrayEndpoint {

	@Autowired
	private FindArray findArray;
	
	@RequestMapping(path = "/findArray", method = RequestMethod.GET)
	public int findArray(@RequestParam int[] array, @RequestParam int[] subArray) {
		
		return findArray.findArray(array, subArray);
	}
}
