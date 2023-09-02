Algoritmo sin_titulo
	Definir nivel,team,beca,totalEstudiantes Como Real
	Definir i,j Como Real
	encuesta <- 1
	Definir estudiantesSinEquipo,estudiantesNivel1,estudiantesNivel2,estudiantesNivel3,estudiantesNIvel4,estudiantesNivel5 Como Real
	Definir estudiantesBasket,estudiantesNatacion,estudiantesAjedrez,estudiantesBecados,estudiantesSinBecas,estudiantesBecaDeportiva,estudiantesBecaAcademica Como Real
	Definir porcentajeBecados,porcentajeNoBecados Como Real
	Escribir 'Total estudiantes'
	Leer totalEstudiantes
	Para encuesta<-1 Hasta totalEstudiantes Hacer
		Escribir 'Estudiante numero ',encuesta
		Mientras nivel<1 O nivel>5 Hacer
			Escribir 'nivel que pertenece'
			Leer nivel
			Si nivel<1 O nivel>5 Entonces
				Escribir 'Numero invalido'
			FinSi
		FinMientras
		Segun nivel  Hacer
			1:
				estudiantesNivel1 <- nivel+1
			2:
				estudiantesNivel2 <- nivel+1
			3:
				estudiantesNivel3 <- nivel+1
			4:
				estudiantesNIvel4 <- nivel+1
			5:
				estudiantesNivel5 <- nivel+1
		FinSegun
		nivel <- 0
		Mientras team<0 O team>3 Hacer
			Escribir 'Quiere formar parte de team'
			Leer team
			Si team<0 O team>3 Entonces
				Escribir 'Numero invalido'
			FinSi
		FinMientras
		Segun team  Hacer
			0:
				estudiantesSinEquipo <- team+1
			1:
				estudiantesBasket <- team+1
			2:
				estudiantsNatacion <- team+1
			3:
				estudiantesAjedrez <- team+1
		FinSegun
		team <- -1
		Mientras beca<0 O beca>1 Hacer
			Escribir 'cuenta con beca'
			Leer beca
			Si beca=1 Entonces
				Mientras tipoBeca<1 O tipoBeca>2 Hacer
					Escribir 'con cual beca cuenta academica 1 deportiva 2'
					Leer tipoBeca
					Si tipoBeca<1 O tipoBeca>2 Entonces
						Escribir 'numero invalido'
					FinSi
				FinMientras
				Segun tipoBeca  Hacer
					1:
						estudiantesBecaDeportiva <- tipoBeca+1
					2:
						estudiantesBecaAcademica <- tipoBeca+1
				FinSegun
				tipoBeca <- 0
			FinSi
			Si beca<0 O beca>1 Entonces
				Escribir 'Respuesta invalida'
			FinSi
		FinMientras
		Segun beca  Hacer
			0:
				estudiantesSinBecas <- beca+1
			1:
				estudiantesBecados <- beca+1
		FinSegun
		beca <- -1
		j <- j+1
	FinPara
	Para i<-1 Hasta 5 Hacer
		Segun i  Hacer
			1:
				Escribir estudiantesNivel1
			2:
				Escribir estudiantesNivel2
			3:
				Escribir estudiantesNivel3
			4:
				Escribir estudiantsNivel4
			5:
				Escribir estudiantsNivel5
		FinSegun
	FinPara
	porcentajeBecados <- (estudiantesBecados*100)/j
	porcentajeNoBecados <- (estudiantesSinBecas*100)/j
	Escribir 'Porcentaje Becados',porcentajeBecados
	Escribir 'Porcentaje No Becados',porcentajeNoBecados
	Escribir 'Mensual becas deportivas',(estudiantesBecaDeportiva*80000)
	Escribir 'Anual becas deportivas',(estudiantesBecaDeportiva*80000*11)
	Escribir 'Mensual beca academica',(estudiantesBecaAcademica*50000)
	Escribir 'Anual beca academica',(estudiantesBecaAcademica*50000*11)
	Escribir 'Total estudiantes por equipo'
	Escribir 'no pertenecen',estudiantesSinEquipo
	Escribir 'Baloncesto',estudiantesBasket
	Escribir 'Natacion',estudiantesNatacion
	Escribir 'Ajedrez ',estudiantesAjedrez
FinAlgoritmo
