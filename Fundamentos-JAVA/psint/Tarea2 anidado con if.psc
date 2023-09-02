Algoritmo renova_li
	Leer pts
	Si (pts > 0) Entonces
		Si (pts>0) y (pts<5)  Entonces
			Escribir "Tiene que renovar y pagar 5mil vigencia de 6 años"
		SiNo
			Si (pts>4) y (pts<9) Entonces
				Escribir "Tiene que renovar la licencia y pagar 10 mil la vigencia sera de 6 años."
			SiNo
				Si (pts>8) y (pts<12) Entonces
					Escribir "Tiene que renovar la licencia, pagar 10mil por renovacion y sera vigente 3 años."
				SiNo
					Si pts>11 Entonces
						Escribir "No puede renovar la licencia."
					SiNo
						Escribir "Dato no valido."
					FinSi
				FinSi
			FinSi
		FinSi
	SiNo
		Escribir "Usted no tiene saldos pendientes"
	FinSi
FinAlgoritmo
