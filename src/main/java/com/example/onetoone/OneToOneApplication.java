package com.example.onetoone;

import com.example.onetoone.domain.Address;
import com.example.onetoone.domain.Customer;
import com.example.onetoone.repository.AddressRepository;
import com.example.onetoone.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class OneToOneApplication {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    public static void main(String[] args) {
        SpringApplication.run(OneToOneApplication.class, args);
    }
    @Bean
    public CommandLineRunner runner(){
        return args -> {
            Customer c1 = new Customer("Yin Nyein",24);
            Customer c2 = new Customer("Yee Mon",23);

            Address address1 = new Address("Kyun Chan 1 Street","12345");
            Address address2 = new Address("Kyun Chan 2 Street","45678");

            c1.setAddress(address2);
            c2.setAddress(address1);

            addressRepository.save(address1);
            addressRepository.save(address2);
            customerRepository.save(c1);
            customerRepository.save(c2);

        };
    }

}
