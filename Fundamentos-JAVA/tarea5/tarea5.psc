Funcion playGame()
	Para i<-1 Hasta 10 Hacer
		Escribir 'Ronda',i
		Escribir 'Tu turno de disparar:'
		hacerDisparo()
		Escribir 'Turno del ordenador:'
		computerShoot()
	FinPara
	imprimirGanador()
	resetGame()
	imprimirMenu()
FinFuncion

Funcion imprimirGanador()
	Definir resultadosDePartida Como Caracter
	Escribir '¡Fin del juego!'
	Escribir 'Puntos del jugador: ',playerPoints
	Escribir 'Puntos del Computador: ',computerPoints
	Si playerPoints>computerPoints Entonces
		resultadosDePartida <- 'Ganaste!'
	FinSi
	Si playerPoints<computerPoints Entonces
		resultadosDePartida <- 'Perdiste!'
	SiNo
		resultadosDePartida <- 'Empate!'
	FinSi
	Escribir resultadosDePartida
FinFuncion

Funcion hacerDisparo()
	Dimension shootPlayer[20]
	Dimension shotPlayerPositions[20]
	Dimension computerShips[20]
	playerPoints <- 0
	Repetir
		Definir validPosition Como Logico
		Escribir '(1-20) Seleccione la posicion a disparar: '
		Leer position
		Si position<0 O position>=20 Entonces
			Escribir 'Posicion invalida. Intente de nuevo.'
			validPosition <- false
		FinSi
		Si shootPlayer[position] Entonces
			Escribir 'Ya has disparado en esta posicion. Intente de nuevo.'
			validPosition <- false
		SiNo
			validPosition <- true
			shootPlayer[position] <- true
			shotPlayerPositions[playerPoints] <- position
			playerPoints <- playerPoints+computerShips[position]
			Si computerShips[position]<>0 Entonces
				Escribir '¡Acertaste!'
			SiNo
				Escribir '¡Agua!'
			FinSi
		FinSi
	Hasta Que !validPosition
FinFuncion

Funcion computerShoot()
	Dimension shotComputerPositions[20]
	Dimension shootComputer[20]
	Dimension playerShips[20]
	Definir random Como Real
	random <- azar(20)
	Definir validPosition Como Logico
	Repetir
		position <- azar(20)
		Si shootComputer[position] Entonces
			validPosition <- false
		SiNo
			validPosition <- true
			shootComputer[position] <- true
			shotComputerPositions[computerPoints] <- position
			computerPoints <- computerPoints+playerShips[position]
			Si playerShips[position]<>0 Entonces
				Escribir 'El ordenador ha disparado en la posicion ',(position+1),' y ha acertado.'
			SiNo
				Escribir 'El ordenador ha disparado en la posicion ',(position+1),' y ha fallado.'
			FinSi
		FinSi
	Hasta Que !validPosition
FinFuncion

Funcion inicializarBarcosJugador()
	Dimension usedPlayerPositions[20]
	Dimension playerShips[20]
	Definir numShips,position Como Real
	numShips <- 5
	Definir validPosition Como Logico
	Para i<-0 Hasta numShips Hacer
		Repetir
			Escribir '(1-20) Seleccione la posicion de su barco ',(i+1),': '
			Leer position
			position <- position-1
			Si position<0 O position>=20 Entonces
				Escribir 'Posicion invalida. Intente de nuevo.'
				validPosition <- validPosition=false
			FinSi
			Si usedPlayerPositions[position] Entonces
				Escribir 'Esta posicion ya esta ocupada. Intente de nuevo.'
				validPosition <- validPosition=false
			SiNo
				validPosition <- validPosition=true
				usedPlayerPositions[position] <- true
				playerShips[position] <- i+1
			FinSi
		Hasta Que !validPosition
	FinPara
FinFuncion

Funcion inicializarBarcosComputadora()
	Dimension usedComputerPositions[20]
	Dimension computerShips[20]
	Definir numShips,position Como Real
	numShips <- 5
	Definir validPosition Como Logico
	Definir random Como Real
	random <- azar(20)
	Para i<-0 Hasta numShips Con Paso PASO Hacer
		Mientras !validPosition Hacer
			position <- azar(20)
			Si usedComputerPositions[position] Entonces
				validPosition <- false
			SiNo
				validPosition <- true
				usedComputerPositions[position] <- true
				computerShips[position] <- i+1
			FinSi
		FinMientras
	FinPara
FinFuncion

Funcion imprimirBarcos()
	Escribir 'Barcos del jugador:'
	Para i<-0 Hasta playerShips Con Paso PASO Hacer
		Escribir playerShips,' '
	FinPara
	Para i<-0 Hasta computerShips Con Paso PASO Hacer
		Escribir computerShips,' '
	FinPara
FinFuncion

Funcion imprimirMenu()
	Definir battleShipsPlaced,reposition Como Logico
	battleShipsPlaced <- false
	reposition <- true
	Definir choiseReposition Como Caracter
	Definir firstTime,computerPoints,playerPoints Como Real
	Definir seleccion Como Real
	Mientras loopMenu==true Hacer
		Si firstTime==0 Entonces
			Escribir 'BIENVENIDO A BATTLESHIP'
			Escribir 'Preparate para la batalla, posiciona tus barcos.'
		FinSi
		Repetir
			Escribir 'MENU'
			Escribir '1. Posiciona los barcos'
			Escribir '2. Imprime la posicion de los barcos'
			Escribir '3. Jugar'
			Escribir '4. Salir'
			Leer selecction
		Hasta Que selecction<1 O selecction>4
		Segun selecction  Hacer
			1:
				Si reposition==false Entonces
					Escribir '(Si o No) Quieres volver a posicionar los barcos?'
					Leer choiseReposition
					Si choiseReposition=='Si' Entonces
						resetShips()
						reposition <- true
						inicializarBarcosJugador()
						inicializarBarcosComputadora()
						Escribir Posicionados
						battleShipsPlaced <- true
						reposition <- false
						imprimirMenu()
					FinSi
					Si choiseReposition=='No' Entonces
						imprimirMenu()
					SiNo
						Escribir 'Respuesta inválida'
					FinSi
				FinSi
				Si reposition==true Entonces
					inicializarBarcosJugador()
					inicializarBarcosComputadora()
					Escribir 'Posicionados'
					battleShipsPlaced <- true
					firstTime <- firstTime+1
					reposition <- false
					imprimirMenu()
				FinSi
			2:
				Si battleShipsPlaced==false Entonces
					Escribir 'Primero posiciona tus barcos.'
					firstTime <- firstTime+1
					imprimirMenu()
				SiNo
					imprimirBarcos()
				FinSi
			3:
				Si battleShipsPlaced==false Entonces
					Escribir 'Primero posiciona tus barcos.'
					firstTime <- firstTime+1
					imprimirMenu()
				SiNo
					playGame()
				FinSi
			4:
				Escribir 'Adios..!'
				loopMenu <- false
		FinSegun
	FinMientras
FinFuncion

Funcion resetShips()
	Dimension playerShips[20]
	Dimension computerShips[20]
	Dimension usedComputerPositions[20]
	Dimension usedComputerPositions[20]
	Dimension shootPlayer[20]
	Dimension shootComputer[20]
FinFuncion

Funcion resetGame
	Dimension playerShips[20]
	Dimension computerShips[20]
	Dimension usedComputerPositions[20]
	Dimension usedComputerPositions[20]
	Dimension shootPlayer[20]
	Dimension shootComputer[20]
	Dimension shotPlayerPositions[20]
	Dimension shotComputerPositions[20]
	battleShipsPlaced <- false
	reposition <- true
	choiseReposition <- ''
	firstTime <- 0
	computerPoints <- 0
	playerPoints <- 0
FinFuncion

Funcion starExe
	imprimirMenu()
FinFuncion

Algoritmo tarea5
	starExe()
FinAlgoritmo
