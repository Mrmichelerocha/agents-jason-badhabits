// Agent lamp in project badHabitsT3

/* Initial beliefs and rules */

// inicialmente, acredito que estou desligada:
status(luz, 0).

/* Initial goals */

!check(status).																	//preciso checar se estou ligada ou desligada

/* Plans */

+!check(status): true
	<- 	waiting(status);														//entro no banco e procuro meu status
		checked(status);														//depois de achar eu atualizo minha crença 'status(luz, X)'
		finish(status)															//finalizo meu chekin
		.print("sleep pode checar se o dono ta dormindo");
		.send(sleep, achieve, checkuser );
		.wait(15000);															//espero "1/2h" ate checar de novo meu status
		!check(status).

+!kqml_received(sleep,tell,"alguém quer saber se o dono ta dormindo?",_):true 	//preciso saber se o dono está dormindo para não estar acesa
	<- 	.print("eu quero saber");
		.send(sleep, askOne, user(_), A);										//peço a informação para o agente sleep
		+A;																		//atualizo minha crença
		.print("meu dono está:", A);
		!plan(A);	
		.print("vou ver que plano usar").															
		

+!plan(user(wake)): status(luz, 0)
	<- 	.print("entrei no plano wz");
		.send(strategy, achieve, choose_plan_wz).
+!plan(user(wake)):  status(luz, 1)
	<- 	.print("entrei no plano wu");
		.send(strategy, achieve, choose_plan_wu).
+!plan(user(sleep)): status(luz, 1)
	<-	.print("entrei no plano su");
	 	.send(strategy, achieve, choose_plan_su).
+!plan(user(sleep)): status(luz, 0)
	<- 	.print("entrei no plano sz");
		.send(strategy, achieve, choose_plan_sz).




//+status(luz, 0):  true
//   <- 	.send(strategy, achieve, status(apagada) );
//   		.print("continuo apagada").		
//   		
//+status(luz, 0):  status(luz, 1)
//   <- 	.send(strategy, achieve, status(apagada) );
//   		.print("estava on e agora estou off").  
//   		
//+status(luz, 0):  status(luz, 0)
//   <- 	.send(strategy, achieve, status(apagada) );
//   		.print("estava off e continuo off").
//   		
//+status(luz, 1):  status(luz, 1)
//   <- 	.send(strategy, achieve, status(apagada) );
//   		.print("estava on e continuo on").	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//+!kqml_received(sleep,tell,"alguem quer saber que horas o dono dorme?",_):true 	//preciso saber que horas o dono dorme 
//	<- 	.send(sleep, askOne, horary_user_sleep(_), A);
//		+A;
//		.print("lamp sabe a hora que o dono dorme:", A).
//		
//+!kqml_received(horary, _ , "alguém quer saber que horas são?" , _ ) : true 	//preciso saber que horas são
//	<- 	.send(horary, askOne, horary_now(_), A);
//		+A;
//		.print("recebi a hora", A).

		
