Algoritmo Promedio_Numeros_Enteros
	contador = 1
	acumulador = 0
	Escribir "Ingrese la cantidad de numeros a promediar: "
	Leer cantidad
	Mientras contador <= cantidad Hacer
		Escribir "Ingrese el n�mero entero: "
		Leer numero
		acumulador = acumulador + numero
		contador = contador + 1
	FinMientras
	promedio = acumulador / cantidad
	Escribir "El promedio de los n�meros es de: ", promedio
FinAlgoritmo
