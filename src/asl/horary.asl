// Agent horary in project badHabitsT5

/* Initial beliefs and rules */

horary_now(timenow).

/* Initial goals */

!timenow. 																		//preciso saber que horas s�o?

/* Plans */

+!timenow : true 
   <- 	timecheck(timenow); 													//"entro no banco" e procuro o horario de agora
		checked(timenow);														//depois de achar eu atualizo minha cren�a 'horary_now(timenow)'
		finish(timenow);														//finalizo meu chekin
		.print("algu�m quer saber que horas s�o?");
		.broadcast(tell, "algu�m quer saber que horas s�o?").					//aviso pra galera	


+!timenowsleep: true
   <- 	.print("vou checar as horas")
   		timecheck(timenow); 													//"entro no banco" e procuro o horario de agora
		checked(timenow);														//depois de achar eu atualizo minha cren�a 'horary_now(timenow)'
		finish(timenow).														//finalizo meu chekin
