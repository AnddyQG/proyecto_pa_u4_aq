package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {
	
	private static final Logger LOG=LoggerFactory.getLogger(MainInterfacesFuncionales.class);
public static void main(String[]args) {

	
	
	
	//supplier
	//clase
	
	
	IPersonaSupplier<String> supplier1= new PersonaSupplierImpl();
	LOG.info("Supplier Clase : " + supplier1.getNombre());
	//lambdas
	
	IPersonaSupplier<String> supplier2= () -> "Anddy 2";
	LOG.info("Supplier Lambda : " + supplier2.getNombre());
	
	IPersonaSupplier<Integer> supplier3 =() -> Integer.valueOf(5);
	LOG.info("Supplier Lambda: " + supplier3.getNombre());
	
	
	IPersonaSupplier<Persona> supplier4= () -> {Persona per=new Persona();
			per.setApellido("Quisilema");
	per.setNombre("Anddy");
	return per;
	};
	
	LOG.info("Supplier Lambda: " + supplier4.getNombre());
	
	IPersonaSupplier<Persona> supplier5=new PersonaSupplier2Impl();
	LOG.info("Supplier Lambda: " + supplier5.getNombre());
	
	
	//java
	LOG.info("JAVA SUPPLIER");
	Stream<String> lista =Stream.generate( ()-> "Anddy 3").limit(3);
	lista.forEach(cadena -> LOG.info(cadena));
	
	//1. Consumer
	LOG.info("2 . CONSUMER");
	
	
	//clase
	IPersonaConsumer<String> consumer1= new PersonaConsumerImpl();
	consumer1.accept("procesa este dato");
	//lambda
	IPersonaConsumer<String> consumer2= cadena -> LOG.info("mensaje"  + cadena) ;
	consumer2.accept("Procesa este dato 2");
	
	IPersonaConsumer<String> consumer3 = cadena ->{
		LOG.info("mensaje a : " + cadena);
		LOG.info("Mensaje a " + cadena);;
		
	};
	consumer3.accept("procesa este dato 3");
	
	
	//java
	LOG.info("JAVA CONSUMER");
	List<Integer> listaNumeros= Arrays.asList(1,2,3,4,5,6,65,77);
	listaNumeros.forEach(numero -> LOG.info("valor : " + numero));
	
	//3. Predicate
	LOG.info("3.PREDICATE");
	
	
	//LAMBDAS
	IPersonaPredicate<String> predicate1= cadena ->cadena.contains("Z");
	LOG.info("Predicate : " + predicate1.evaluar("AnddyZ"));
	
	
	
	IPersonaPredicate<Integer> predicate2= numero-> {
		if(numero.intValue()>10) {
			return true;
		}else {
			return false;
		}
	};
	LOG.info("Predicate : " + predicate2.evaluar(8));
	
	//Java consumer
	LOG.info("Java PREDICATE");
	Stream<Integer> listaFiltrada=listaNumeros.stream().filter(numero -> numero>=3);
	listaFiltrada.forEach(numero ->LOG.info("VAlor : " + numero));
	
	//4. Function
	LOG.info("4.FUNCTION");
	IPersonaFunction<String, Integer> function= numero ->"Valor : " + numero.toString();
	
	LOG.info(function.aplicar(10));
	
	
	IPersonaFunction<Ciudadano, Persona> function2= per ->{
		Ciudadano ciu= new Ciudadano();
		ciu.setNombreCompleto(per.getNombre() + " " + per.getApellido());
		ciu.setCiudad("Quito");
		return ciu;
		
	};
	Persona per1= new Persona();
	per1.setNombre("Anddy");
	per1.setApellido("Quisilema");
	Ciudadano ciudadanoConv=function2.aplicar(per1);
	LOG.info("Ciudadano convertido : " + ciudadanoConv);
	LOG.info("5.UNARYOPERATOR");
	//java
	LOG.info("JAVA FUNCTION");
	  Stream<String> listaCambiada=listaNumeros.stream().map(numeroLista->{
		
		Integer valorFinal=numeroLista+1;
		String cadena="num: " + valorFinal.toString();
		
		return cadena;
		
	});
	  listaCambiada.forEach(cadena -> LOG.info(cadena));
	
	
	//5. UnaryOperator
	//Lambdas
	IPersonaUnaryOperator<String> unaryOperator= cadena ->{
		String cadenaFinal= cadena.concat("-sufijo");
		return cadenaFinal;
		
	};
	
	LOG.info("UnaryOperator : " + unaryOperator.aplicar("Juliana"));
	
}
}
