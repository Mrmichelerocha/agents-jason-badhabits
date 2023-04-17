// Agent horary in project badHabitsT5

/* Initial beliefs and rules */

horary_now(timenow).

/* Initial goals */

!timenow. 																		//preciso saber que horas são?

/* Plans */

+!timenow : true 
   <- 	timecheck(timenow); 													//"entro no banco" e procuro o horario de agora
		checked(timenow);														//depois de achar eu atualizo minha crença 'horary_now(timenow)'
		finish(timenow);														//finalizo meu chekin
		.print("alguém quer saber que horas são?");
		.broadcast(tell, "alguém quer saber que horas são?").					//aviso pra galera	


+!timenowsleep: true
   <- 	.print("vou checar as horas")
   		timecheck(timenow); 													//"entro no banco" e procuro o horario de agora
		checked(timenow);														//depois de achar eu atualizo minha crença 'horary_now(timenow)'
		finish(timenow).														//finalizo meu chekin
