// Agent strategy in project badHabitsT5

/* Initial beliefs and rules */

//!verseta(dormindo).

/* Initial goals */


/* Plans */

+!choose_plan_wz: true <- 
    .random([plan_wz1, plan_wz2, plan_wz3],X);
    !X.
+!choose_plan_wu: true <- 
    .random([plan_wu1, plan_wu2, plan_wu2],X);
    !X.
+!choose_plan_sz: true <- 
    .random([plan_sz1, plan_sz2, plan_sz3],X);
    !X.
+!choose_plan_su: true <- 
    .random([plan_su1, plan_su2, plan_su3],X);
    !X.


//PLANOS PARA LUZ APAGADA E DONO ACORDADO
+!plan_wz1:  true
   	<- 	.print("plano wz 1");
   		postRequestLampOn;
   		postRequestLampOff.
+!plan_wz2:  true
   	<- 	.print("plano wz 2");
   		postRequestLampOn;
   		postRequestLampOff.
+!plan_wz3:  true
   	<- 	.print("plano wz 3");
   		postRequestLampOn;
   		postRequestLampOff.
   
   
//PLANOS PARA LUZ ACESA E DONO ACORDADO
+!plan_wu1:  true
   	<- 	.print("plano wu 1");
   		postRequestLampOn;
   		postRequestLampOff.
+!plan_wu2:  true
   	<- 	.print("plano wu 2");
   		postRequestLampOn;
   		postRequestLampOff.
+!plan_wu3:  true
   	<- 	.print("plano wu 3");
   		postRequestLampOn;
   		postRequestLampOff.
   	
   	
//PLANOS PARA LUZ APAGADA E DONO DORMINDO
+!plan_sz1:  true
   	<- 	.print("plano sz 1");
   		postRequestLampOn;
   		postRequestLampOff.
+!plan_sz2:  true
   	<- 	.print("plano sz 2");
   		postRequestLampOn;
   		postRequestLampOff.
+!plan_sz3:  true
   	<- 	.print("plano sz 3");
   		postRequestLampOn;
   		postRequestLampOff.


//PLANOS PARA LUZ ACESA E DONO DORMINDO
+!plan_su1:  true
   	<- 	.print("plano su 1");
   		postRequestLampOn;
   		postRequestLampOff.
+!plan_su2:  true
   	<- 	.print("plano su 2");
   		postRequestLampOn;
   		postRequestLampOff.
+!plan_su3:  true
   	<- 	.print("plano su 3");
   		postRequestLampOn;
   		postRequestLampOff.

//+!verseta(dormindo): true 
//	<- 	.send(lamp, askOne, check(status));
//		.send(sleep, askOne, bedtime);
//		!okok(teste).
//
//+!usuario(acordado): true
//	<-	+usuario(acordado);
//		!ver(lamp).
//		
//+!usuario(acordado): usuario(acordado)
//	<-	!ver(lamp).
//	
//+!usuario(dormindo): true
//	<- 	+usuario(dormindo);
//		!ver(lamp).
//		
//+!usuario(dormindo): usuario(dormindo)
//	<- 	!ver(lamp).
//
//+!status(acessa):  true
//   	<- 	+status(acessa);
//   		!ver(sleep).
//
//+!status(acessa):  status(acessa)
//   	<- 	!ver(sleep).
//
//+!status(apagada): true
//   	<- 	+status(apagada);
//   		!ver(sleep).
//
//+!status(apagada): status(apagada)
//   	<- 	!ver(sleep).
//
//
//+!ver(lamp): true
//	<- 	.send(lamp, askOne, check(status)). 
//	
//+!ver(sleep): true
//	<- 	.send(sleep, askOne, bedtime). 
//   
//+usuario(acordado): status(acessa) <- .print("acredito que meu usuario esta acordado").
//+usuario(dormindo): status(acessa) <- .print("plano para desligar a luz, ou outros").
//+usuario(acordado): status(apagada) <- .print("acredito que meu usuario esta acordado").
//+usuario(dormindo): status(apagada) <- .print("meu usuario bateu a meta").
//
//+status(acessa): usuario(acordado)  <- .print("acredito que meu usuario esta acordado").
//+status(acessa): usuario(dormindo)  <- .print("plano para desligar a luz, ou outros").
//+status(apagada): usuario(acordado)  <- .print("acredito que meu usuario esta acordado").
//+status(apagada): usuario(dormindo)  <- .print("meu usuario bateu a meta").
//    	
//+!okok(teste): status(acessa) & usuario(dormindo)
//	<- 	.print("plano para desligar a luz, ou outros");
//		?oknao(teste).
//	
//+!oknao(teste): status(acessa) & usuario(acordado)
//	<- 	.print("acredito que meu usuario esta acordado");
//		?naook(teste).
//	
//+!naook(teste): status(apagada) & usuario(acordado)
//	<- 	.print("acredito que meu usuario esta acordado");
//		?naonao(teste).
//
//+!naonao(teste): status(apagada) & usuario(dormindo)
//	<- .print("meu usuario bateu a meta");	
//		?okok(teste).
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	