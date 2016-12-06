package br.com.cs.desafio.teste;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import br.com.cs.desafio.model.Customer;
import br.com.cs.desafio.model.Phone;

/**
 * 
 * Teste de Integra��o
 * Teste Unit�rio
 * @author Aline Santos
 *
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CustomerTeste {
	
	 public static final String REST_SERVICE_URI = "http://localhost:8080/api";

  
  
  public void getHello2(){
      System.out.println("Testing getUser API----------");
      RestTemplate restTemplate = new RestTemplate();
      String message = restTemplate.getForObject(REST_SERVICE_URI+"/hello/", String.class);
      System.out.println(message);
  }
  
  @Test
/* POST */
public  void createUser() {
    System.out.println("Testing create User API----------");
    RestTemplate restTemplate = new RestTemplate();
    Customer customer = new Customer();
    customer.setName("Jo�o da Silva");
    customer.setEmail("joao@silva.org");
    customer.setPassword("hunter2");
    
    Phone phone1 = new Phone();
    phone1.setDdd("11");
    phone1.setNumber("123456987");
    
    Phone phone2 = new Phone();
    phone2.setDdd("21");
    phone2.setNumber("123654789");
    
    
    List<Phone> phones = new ArrayList<>();
    phones.add(phone1);
    phones.add(phone2);
    
    customer.setPhones(phones);
    
    URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/customers/", customer, Customer.class);
    System.out.println(uri.toASCIIString());
}
  
   
  /* GET Customer por Email */
  private static void getUser(){
      RestTemplate restTemplate = new RestTemplate();
      Customer user = restTemplate.getForObject(REST_SERVICE_URI+"/customers/joao@gmail.com", Customer.class);
      System.out.println(user);
  }

}
