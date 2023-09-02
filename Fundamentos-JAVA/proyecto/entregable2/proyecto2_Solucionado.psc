Algoritmo proyecto2_Solucionado
	Definir numJuegos,puntajeTotal,puntajeEquipoCasa,puntajeOponente Como Real
	Definir nombreEquipoCasa,nombreEquipoOponente,snitchCasa,snitchOponente,partidos Como Real
	Repetir
		Escribir 'Número de juegos: '
		Leer numJuegos
		Si numJuegos<0 Entonces
			Escribir 'Número inválido'
		FinSi
	Hasta Que numJuegos<0
	Para i<-1 Hasta numJuegos Hacer
		Escribir 'Juego',i,'contra: '
		Leer nombreEquipoOponente
		Repetir
			Escribir 'Marcador de ',nombreEquipoCasa,': '
			Leer puntajeEquipoCasa
			Si puntajeEquipoCasa<0 Entonces
				Escribir 'Número inválido'
			FinSi
		Hasta Que puntajeEquipoCasa<0
		Escribir 'Atrapó la snitch: '
		Leer snitchCasa
		Si snitchCasa=="Si" O snitchCasa=="si" O snitchCasa=="SI" Entonces
			Escribir snitchCasa="*"
		SiNo
			Si snitchCasa=="No" O snitchCasa=="no" O snitchCasa=="No" Entonces
				Escribir snitchCasa=""
			SiNo
				Escribir 'Respuesta inválida'
			FinSi
		FinSi
		Repetir
			Escribir 'Marcado de ',nombreEquipoOponente,': '
			Si puntajeOponente<0 Entonces
				Escribir 'Número inválido.'
			FinSi
		Hasta Que puntajeOponente<0
		Escribir 'Atrapó la snith: '
		Leer snitchOponente
		Si snitchOponente=='Si' O snitchOponente=='si' O snitchOponente=='SI' Entonces
			Escribir snitchOponente='*'
		SiNo
			Si snitchOponente=='No' O snitchOponente=='no' O snitchOponente=='No' Entonces
				Escribir snitchOponente=''
			SiNo
				Escribir 'Respuesta inválida'
			FinSi
		FinSi
		puntajeTotal = puntajeTotal + puntajeEquipoCasa
		partidos = partidos + nombreEquipoCasa + " vs " + nombreEquipoOponente + ": " + puntajeEquipoCasa + snitchCasa + "-" + puntajeOponente + snitchOponente

	FinPara
	Escribir partidos
	Escribir "Puntaje total: " + puntajeTotal
FinAlgoritmo
