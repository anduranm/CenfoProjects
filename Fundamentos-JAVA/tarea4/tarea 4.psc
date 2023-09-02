Funcion entradaDatos()
	menu()
FinFuncion

Funcion menu()
	Definir opcionEscoger Como Caracter
	Escribir 'Bienvenido al Nacional de Fuerza y Luz de Costa Rica seleccione la opción a solicitar:'
	Mientras opcionEscoger<>'Q' O opcionEscoger<>'q' Hacer
		Escribir 'Ingrese una opción:'
		Escribir 'A. Calcular el mes con más consumo'
		Escribir 'B. Calcular la eco-factura del mes'
		Escribir 'C. Calcular la eco-factura para locales comerciales'
		Escribir 'Q. Salir'
		Leer opcionEscoger
		Segun opcionEscoger  Hacer
			'A','a':
				mesMayorConsumo()
			'B','b':
				calcularEcoFactura()
			'C','c':
				calcularEcoFacturaComercial()
			'Q','q':
				Escribir 'Saliendo del programa...'
		FinSegun
	FinMientras
FinFuncion

Funcion mesMayorConsumo()
	Definir mayorConsumo,consumo Como Real
	Definir elMayorConsumo,nombreMes Como Caracter
	mayorConsumo <- 0
	Para i<-1 Hasta 6 Hacer
		Escribir 'Ingrese el nombre del mes #',i,': '
		Leer elMayorConsumo
		Escribir 'Ingrese el consumo en KWH para el mes de ',nombreMes,': '
		Leer consumo
		Si (consumo>mayorConsumo) Entonces
			mayorConsumo <- consumo
			elMayorConsumo <- nombreMes
		FinSi
	FinPara
	Escribir 'el mes con mayor consumo fue: ',elMayorConsumo
FinFuncion

Funcion calcularEcoFactura()
	Definir mesEcofactura Como Caracter
	Definir consumoPunta,consumoValle,consumoNoct Como Real
	// definir total, montoIVA, montoAlumbradoPublico, montoTributoBomberos, totalconsumidoEnMes, montoEnergia como real
	Escribir 'Ingrese el nombre del mes que desea facturar: '
	Leer mesEcofactura
	Escribir 'Ingrese el consumo en horario punta (KWH): '
	Leer consumoPunta
	Escribir 'Ingrese el consumo en horario valle (KWH): '
	Leer consumoValle
	Escribir 'Ingrese el consumo en horario nocturno (KWH): '
	Leer consumoNoct
	totalConsumidoEnMes <- consumoPunta+consumoValle+consumoNoct
	// montoEnergia <- montoEnergia(consumoPunta, ConsumoValle, consumoNoct)
	// montoAlumbradoPuBLICO = MontoAlumbradoPublico(totalConsumidoEnMes)
	// montoTributoBomberos = montoTributoBomberos(totalConsumidoEnMes)
	// montoIVA = montoIVA(totalConsumidoEnMes. montoEnergia)
	// total = montoEnergia + montoAlumbradoPublico + montoTributoBomberos + montoIVA
	Escribir 'Eco-factura del mes de '+mesEcofactura
	Escribir 'Consumo total de KMH consumidos en el mes: ',totalConsumiEnMes,'KMH'
	// Escribir "Monto correspondinete a Energia: " montoEnergia, "colones"
	// Escribir "Monto correspondiente a alumbrado publico: ", montoAlumbradoPublico, "colones"
	// Escribir "Monto correspondiente al tributo a bomberos:", montoTributoBomberos, "colones"
	// Escribir "Monto correspondiente al IVA: ", montoIVA, "colones"
	Escribir 'Total a pagar en la factura: '+total+' colones'
FinFuncion

Funcion monto <- montoEnergia(consumoPunta,consumoValle,consumoNoct)
	Definir monto Como Real
	Si (consumoPunta+consumoValle+consumoNoct<=500) Entonces
		consumoPunta <- consumoPunta*167.72
		consumoValle <- consumoValle*68.75
		consumoNoct <- consumoNoct*28.77
	SiNo
		consumoNoct <- consumoPunta*207.39
		consumoValle <- consumoValle*83.71
		consumoNoct <- consumoNoct*38.74
	FinSi
	monto <- costoPunta+costoValle+costoNoct
FinFuncion

Funcion monto <- montoAlumbradoPublico(totalConsumidoEnMes)
	Definir monto Como Real
	monto <- totalConsumidoEnMes*0.04
FinFuncion

Funcion monto <- montoTributoBomberos(totalConsumidoEnMes)
	Definir monto Como Real
	monto <- totalConsumidoEnMes*0.01
FinFuncion

Funcion monto <- montoIVA(totalConsumidoEnMes,montoEnergia)
	Definir monto Como Real
	Si (totalConsumidoEnMes>=280) Entonces
		monto <- montoEnergiaa*0.13
	SiNo
		monto <- 0
	FinSi
FinFuncion

Funcion calcularEcoFacturaComercial()
	Definir mesEcofactura Como Caracter
	// definir totalConsumidoEnMes,consumoPotencia,montoEnergia,montoPotencia,totalPagar,montoAlumbradoPublico,montoTributoBomberos,montoIVA como real
	Escribir 'Ingrese el nombre del mes que desea facturar: '
	Leer mesEcofactura
	Escribir 'Ingrese el total de KWH consumidos en el mes por energía: '
	Leer totalConsumidoEnMes
	Escribir 'Ingrese el total de KW consumidos en el mes por potencia: '
	Leer consumoPotencia
	// montoEnergia = montoEnergiaComercial(totalConsumidoEnMes)
	montoPotencia <- montoPotenciaComercial(consumoPotencia)
	// montoAlumbradoPublico = montoAlumbradoPublico(totalConsumidoEnMes)
	// montoTributoBomberos = montoTributoBomberos(totalConsumidoEnMes)
	// montoIVA = montoIVA(totalConsumidoEnMes, montoPotencia)
	// totalPagar = montoEnergia + montoPotencia + montoAlumbradoPublico + montoTributoBomberos + montoIVA
	Escribir 'Eco-factura para locales comerciales del mes de '+mesEcofactura
	Escribir 'Total de KWH consumidos en el mes: '+totalConsumidoEnMes
	Escribir 'Total de KW consumidos por potencia en el mes: '+consumoPotencia
	// Escribir "Monto correspondiente a energía: " + montoEnergia
	Escribir 'Monto correspondiente a potencia: '+montoPotencia
	// Escribir "Monto correspondiente a alumbrado público: " + montoAlumbradoPublico
	// Escribir "Monto correspondiente al tributo a bomberos: " + montoTributoBomberos
	// Escribir "Monto correspondiente al IVA: " + montoIVA
	Escribir 'Total a pagar en la factura: '+totalPagar
FinFuncion

Funcion monto <- montoEnergiaComercial(totalConsumidoEnMes)
	Definir monto Como Real
	Si totalConsumidoEnMes<=3000 Entonces
		monto <- 221160
	SiNo
		monto <- 221160+(totalConsumidoEnMes-3000)*73.72
	FinSi
FinFuncion

Funcion monto <- montoPotenciaComercial(consumoPotencia)
	Definir monto Como Real
	Si consumoPotencia<=8 Entonces
		monto <- 92311.68
	SiNo
		monto <- 92311.68+(consumoPotencia-8)*11538.96
	FinSi
FinFuncion

Algoritmo tarea3
	entradaDatos()
FinAlgoritmo
