// Agent sleep in project badHabitsT3

/* Initial beliefs and rules */

horary_user_sleep("00:00:00").
user(wake).

/* Initial goals */
!user_sleep.																	//preciso descobrir que horas o dono dorme? 

/* Planos */

+!user_sleep: true 
	<- 	waiting(timesleep); 													//entro no banco e procuro o horario que meu dono dorme
		checked(timesleep);														//depois de achar eu atualizo minha crença 'horary_user_sleep(timesleep)'
		finish(timesleep);														//finalizo meu chekin
		.print("alguem quer saber que horas o dono dorme?");
		.broadcast(tell, "alguem quer saber que horas o dono dorme?").  		//aviso pra galera 


+!kqml_received(horary, _ , "alguém quer saber que horas são?" , _ ) : true 	//preciso saber as horas para saber se o meu dono esta dormindo
	<- 	.print("eu quero saber");
		.send(horary, askOne, horary_now(_), A);								//peço as horas pro agente horary
		.print("recebi a hora", A);
		+A.																		//atualizo a minha crença sobre o horario
		

+horary_now(_): true															//se a minha crença sobre o horario mudar
	<- 	.print("vou ver se o dono ta dormindo");
		!bedtime; 																//eu comparo pra ver se o meu dono ta dormindo
		.print("alguém quer saber se o dono ta dormindo?");
		.broadcast(tell, "alguém quer saber se o dono ta dormindo?").			//aviso pra galera se o dono ta dormindo
		

+!bedtime: horary_now(_) & horary_user_sleep(_) 
	<- 	comparetime(timenow, timesleep).
		
+!checkuser: true 
	<- 	.print("vou ver se o dono ta dormindo");
		.print("horario pode ver as horas?");
		.send(horary, achieve, timenowsleep);
		.wait(2000);
		.print("horario que horas são?");
		.send(horary, askOne, horary_now(_), A);
		+A.
		
		
		
//+!quantashorasateodonodormir: true 											//preciso saber quanto tempo falta pro dono dormir
//	<- 	contagemregressiva(dormir).





























//+user(sleep): true 
//	<-	.send(strategy, achieve, usuario(dormindo) );
//	 	.print("usuario dormindo").
//		
//+user(wake): user(sleep) 
//	<-	.send(strategy, achieve, usuario(acordado) );
//	 	.print("usuario acordado").
//        
//+user(wake): user(wake) 
//	<-	.send(strategy, achieve, usuario(acordado) );
//	 	.print("usuario continua acordado").
//	
//+user(sleep): user(sleep)
//	<-	.send(strategy, achieve, usuario(dormindo) );
//	 	.print("usuario continua dormindo").	
	