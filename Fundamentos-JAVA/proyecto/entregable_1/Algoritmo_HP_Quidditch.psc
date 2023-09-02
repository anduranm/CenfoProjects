Algoritmo Algoritmo_HP_Quidditch
	Escribir 'Selecciones el equipo: \n 1.Maryland \n 2.Texas hill \n 3.New York \n 4.The Warriors \n 5.The Lost Boys \n 6.Boom Train'
	Leer team_name
	Si team_name>0 Y team_name<7 Entonces
		Segun team_name  Hacer
			1:
				Escribir '1.Maryland'
				teamName <- 'Maryland'
			2:
				Escribir '2.Texas hill'
				teamName <- 'Texas hill'
			3:
				Escribir '3.New York'
				teamName <- 'New york'
			4:
				Escribir '4.The Warriors'
				teamName <- 'The Warriors'
			5:
				Escribir '5.The Lost Boys'
				teamName <- 'The Lost Boys'
			6:
				Escribir '6.Boom Train'
				teamName <- 'Boom Train'
		FinSegun
		Escribir 'Ingrese puntaje de todos los partidos: '
		Leer pts_partidos
		Escribir 'Ingrese número de juegos ejecutados: '
		Leer numJuegos
		Escribir 'Ingrese el número de oponentes diferentes: '
		Leer numOponentes
		Si numJuegos>0 Entonces
			Si numOponentes>0 Y numOponentes<7 Entonces
				Si numJuegos>1 Entonces
					totalFinalPts <- numOponentes+numJuegos+pts_partidos
					Escribir 'El equipo ',team_name,'.',teamName,'  Tiene un total de: ',totalFinalPts,' Puntos.'
				SiNo
					Si numOponentes=1 Entonces
						totalFinalPts <- numOponentes+numJuegos+pts_partidos
						Escribir 'El equipo ',team_name,'.',teamName,'  Tiene un total de: ',totalFinalPts,' Puntos.'
					SiNo
						Escribir 'Si el juego fue uno no pueden haber más de 2 oponentes.'
					FinSi
				FinSi
			SiNo
				Escribir 'El número de oponentes es inválido,'
			FinSi
		SiNo
			Escribir 'El número de juegos es inválido.'
		FinSi
	SiNo
		Escribir 'Equipo no existe.'
	FinSi
FinAlgoritmo
