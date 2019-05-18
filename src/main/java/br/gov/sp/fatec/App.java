package br.gov.sp.fatec;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import br.gov.sp.fatec.service.AlunoService;
import br.gov.sp.fatec.model.*;

@SpringBootApplication
public class App 
{
	public static void main( String[] args )
    {
		SpringApplication.run(App.class, args);
		
    }
    
}
