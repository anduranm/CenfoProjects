Algoritmo sin_titulo
	Definir nivel,team,beca,totalEstudiantes Como Real
	Definir i,j Como Real
	encuesta <- 1
	Definir totalEstudiantes,estudiantesSinEquipo,estudiantesNivel1,estudiantesNivel2,estudiantesNivel3,estudiantesNivel4,estudiantesNivel5 Como Real
	Definir estudiantesBasket,estudiantesNatacion,estudiantesAjedrez,estudiantesBecados,estudiantesSinBecas,estudiantesBecaDeportiva,estudiantesBecaAcademica Como Real
	Definir porcentajeNoBecados,porcentajeBecados Como Real
	// año1
	Definir estudiantesNivel1Annio1,estudiantesNivel2Annio1,estudiantesNivel3Annio1,estudiantesNivel4Annio1,estudiantesNivel5Annio1 Como Real
	Definir estudiantesBasketAnnio1,estudiantesNatacionAnnio1,estudiantesAjedrezAnnio1,estudiantesBecadosAnnio1,estudiantesSinBecasAnnio1,estudiantesBecaDeportivaAnnio1,estudiantesBecaAcademicaAnnio1 Como Real
	// año 2
	Definir estudiantesNivel1Annio2,estudiantesNivel2Annio2,estudiantesNivel3Annio2,estudiantesNivel4Annio2,estudiantesNivel5Annio2 Como Real
	Definir estudiantesBasketAnnio2,estudiantesNatacionAnnio2,estudiantesAjedrezAnnio2,estudiantesBecadosAnnio2,estudiantesSinBecasAnnio2,estudiantesBecaDeportivaAnnio2,estudiantesBecaAcademicaAnnio2 Como Real
	// año 3
	Definir estudiantesNivel1Annio3,estudiantesNivel2Annio3,estudiantesNivel3Annio3,estudiantesNivel4Annio3,estudiantesNivel5Annio3 Como Real
	Definir estudiantesBasketAnnio3,estudiantesNatacionAnnio3,estudiantesAjedrezAnnio3,estudiantesBecadosAnnio3,estudiantesSinBecasAnnio3,estudiantesBecaDeportivaAnnio3,estudiantesBecaAcademicaAnnio3 Como Real
	Para a<-1 Hasta 3 Hacer
		Mientras totalEstudiantes<=0 Hacer
			Escribir 'Total estudiantes año 1'
			Leer totalEstudiantes
			Si totalEstudiantes<=0 Entonces
				Escribir 'Digite un numero valido'
			FinSi
		FinMientras
		Para encuesta<-1 Hasta totalEstudiantes Hacer
			Escribir 'Estudiante de año ',a,' número: ',encuesta
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
					estudiantesNivel4 <- nivel+1
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
			Segun a  Hacer
				1:
					totalEstudiantesAnnio1 <- totalEstudiantesAnnio1+1
				2:
					totalEstudiantesAnnio2 <- totalEstudiantesAnnio2+1
				3:
					totalEstudiantesAnnio3 <- totalEstudiantesAnnio2+1
			FinSegun
		FinPara
		Segun expresion  Hacer
			1:
				totalEstudiantesAnnio1 <- totalEstudiantes
				estudiantesSinEquipoAnnio1 <- estudiantesSinEquipo
				estudiantesNivel1Annio1 <- estudiantesNivel1
				estudiantesNivel2Annio1 <- estudiantesNivel2
				estudiantesNivel3Annio1 <- estudiantesNivel3
				estudiantesNivel4Annio1 <- estudiantesNivel4
				estudiantesNivel5Annio1 <- estudiantesNivel5
				estudiantesBasketAnnio1 <- estudiantesBasket
				estudiantesNatacionAnnio1 <- estudiantesNatacion
				estudiantesAjedrezAnnio1 <- estudiantesAjedrez
				estudiantesBecadosAnnio1 <- estudiantesBecados
				estudiantesSinBecasAnnio1 <- estudiantesSinBecas
				estudiantesBecaDeportivaAnnio1 <- estudiantesBecaDeportiva
				estudiantesBecaAcademicaAnnio1 <- estudiantesBecaAcademica
			2:
				totalEstudiantesAnnio2 <- totalEstudiantes
				estudiantesSinEquipoAnnio2 <- estudiantesSinEquipo
				estudiantesNivel1Annio2 <- estudiantesNivel1
				estudiantesNivel2Annio2 <- estudiantesNivel2
				estudiantesNivel3Annio2 <- estudiantesNivel3
				estudiantesNivel4Annio2 <- estudiantesNivel4
				estudiantesNivel5Annio2 <- estudiantesNivel5
				estudiantesBasketAnnio2 <- estudiantesBasket
				estudiantesNatacionAnnio2 <- estudiantesNatacion
				estudiantesAjedrezAnnio2 <- estudiantesAjedrez
				estudiantesBecadosAnnio2 <- estudiantesBecados
				estudiantesSinBecas <- estudiantesSinBecasAnnio2
				estudiantesBecaDeportivaAnnio2 <- estudiantesBecaDeportiva
				estudiantesBecaAcademicaAnnio2 <- estudiantesBecaAcademica
			3:
				totalEstudiantesAnnio3 <- totalEstudiantes
				estudiantesSinEquipoAnnio3 <- estudiantesSinEquipo
				estudiantesNivel1Annio3 <- estudiantesNivel1
				estudiantesNivel2Annio3 <- estudiantesNivel2
				estudiantesNivel3Annio3 <- estudiantesNivel3
				estudiantesNivel4Annio3 <- estudiantesNivel4
				estudiantesNivel5Annio3 <- estudiantesNivel5
				estudiantesBasketAnnio3 <- estudiantesBasket
				estudiantesNatacionAnnio3 <- estudiantesNatacion
				estudiantesAjedrezAnnio3 <- estudiantesAjedrez
				estudiantesBecadosAnnio3 <- estudiantesBecados
				estudiantesSinBecasAnnio3 <- estudiantesSinBecas
				estudiantesBecaDeportivaAnnio3 <- estudiantesBecaDeportiva
				estudiantesBecaAcademicaAnnio3 <- estudiantesBecaAcademica
		FinSegun
		totalEstudiantes <- 0
		estudiantesSinEquipo <- 0
		estudiantesNivel1 <- 0
		estudiantesNivel2 <- 0
		estudiantesNivel3 <- 0
		estudiantesNivel4 <- 0
		estudiantesNivel5 <- 0
		estudiantesBasket <- 0
		estudiantesNatacion <- 0
		estudiantesAjedrez <- 0
		estudiantesBecados <- 0
		estudiantesSinBecas <- 0
		estudiantesBecaDeportiva <- 0
		estudiantesBecaAcademica <- 0
	FinPara
	Para a<-1 Hasta 3 Hacer
		Segun a  Hacer
			1:
				estudiantesSinEquipo <- estudiantesSinEquipoAnnio1
				estudiantesNivel1 <- estudiantesNivel1Annio1
				estudiantesNivel2 <- estudiantesNivel2Annio1
				estudiantesNivel3 <- estudiantesNivel3Annio1
				estudiantesNivel4 <- estudiantesNivel4Annio1
				estudiantesNivel5 <- estudiantesNivel5Annio1
				estudiantesBasket <- estudiantesBasketAnnio1
				estudiantesNatacion <- estudiantesNatacionAnnio1
				estudiantesAjedrez <- estudiantesAjedrezAnnio1
				estudiantesBecados <- estudiantesBecadosAnnio1
				estudiantesSinBecas <- estudiantesSinBecasAnnio1
				estudiantesBecaDeportiva <- estudiantesBecaDeportivaAnnio1
				estudiantesBecaAcademica <- estudiantesBecaAcademicaAnnio1
				totalEstudiantes <- totalEstudiantesAnnio1
			2:
				estudiantesSinEquipo <- estudiantesSinEquipoAnnio2
				estudiantesNivel1 <- estudiantesNivel1Annio2
				estudiantesNivel2 <- estudiantesNivel2Annio2
				estudiantesNivel3 <- estudiantesNivel3Annio2
				estudiantesNivel4 <- estudiantesNivel4Annio2
				estudiantesNivel5 <- estudiantesNivel5Annio2
				estudiantesBasket <- estudiantesBasketAnnio2
				estudiantesNatacion <- estudiantesNatacionAnnio2
				estudiantesAjedrez <- estudiantesAjedrezAnnio2
				estudiantesBecados <- estudiantesBecadosAnnio2
				estudiantesSinBecasAnnio2 <- estudiantesSinBecas
				estudiantesBecaDeportiva <- estudiantesBecaDeportivaAnnio2
				estudiantesBecaAcademica <- estudiantesBecaAcademicaAnnio2
				totalEstudiantes <- totalEstudiantesAnnio2
			3:
				estudiantesSinEquipo <- estudiantesSinEquipoAnnio3
				estudiantesNivel1 <- estudiantesNivel1Annio3
				estudiantesNivel2 <- estudiantesNivel2Annio3
				estudiantesNivel3 <- estudiantesNivel3Annio3
				estudiantesNivel4 <- estudiantesNivel4Annio3
				estudiantesNivel5 <- estudiantesNivel5Annio3
				estudiantesBasket <- estudiantesBasketAnnio3
				estudiantesNatacion <- estudiantesNatacionAnnio3
				estudiantesAjedrez <- estudiantesAjedrezAnnio3
				estudiantesBecados <- estudiantesBecadosAnnio3
				estudiantesSinBecas <- estudiantesSinBecasAnnio3
				estudiantesBecaDeportiva <- estudiantesBecaDeportivaAnnio3
				estudiantesBecaAcademica <- estudiantesBecaAcademicaAnnio3
				totalEstudiantes <- totalEstudiantesAnnio3
		FinSegun
		Escribir 'Resultado de analisis del año:',a
		Escribir 'Total de estudiantes de cada año'
		Para i<-1 Hasta 5 Hacer
			Segun a  Hacer
				1:
					Escribir estudiantesNivel1
				2:
					Escribir estudiantesNivel2
				3:
					Escribir estudiantesNivel3
				4:
					Escribir estudiantesNivel4
				5:
					Escribir estudiantesNivel5
			FinSegun
		FinPara
		porcentajeBecados <- (estudiantesBecados*100)/totalEstudiantes
		porcentajeNoBecados <- (estudiantesSinBecas*100)/totalEstudiantes
		Escribir 'Porcentaje Becados',porcentajeBecados
		Escribir 'Porcentaje No Becados',porcentajeNoBecados
		Escribir 'Mensual becas deportivas',(estudiantesBecaDeportiva*80000)
		Escribir 'Anual becas deportivas',(estudiantesBecaDeportiva*80000*11)
		Escribir 'Mensual beca academica',(estudiantesBecaAcademica*50000)
		Escribir 'Anual beca academica',(estudiantesBecaAcademica*50000*11)
		Escribir 'Total estudiantes por equipo'
		Escribir 'no pertenecen',estudiantesSinEquipoAnnio1
		Escribir 'Baloncesto',estudiantesBasketAnnio1
		Escribir 'Natacion',estudiantesNatacionAnnio1
		Escribir 'Ajedrez ',estudiantesAjedrezAnnio1
	FinPara
FinAlgoritmo
