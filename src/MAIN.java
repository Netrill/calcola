
public class MAIN {
	public static void main(String[] args) {	
		//36000  28 mesi partendo da 8000, 23 mesi partendo da 10.000 ,20 partendo da 12000
		
		//Prestito 6000 rata 363 mesi 18
		//Prestito 10.000 rata 327.20 mesi 36 non è male. 1° mese 72 euro
		//Prestito 10.000 rata 465.90 mesi 24   1° mese 72 euro
		//Prestito 15.000 rata 219.2 mesi 108
		//Prestito 15.000 rata 285.2 mesi 72
		//Prestito 15.000 rata 490. 8 mesi 36 1° mese 9 euro
		//Prestito 15.000 rata 907,50 in 18 mesi
		//Prestito 20.0000 rata 313.7€ mesi 96 prima rata -54€ dopo due anni 50.000 e 7 euro di prestito rimanente
		//Prestito 20.0000 rata 654.30€ mesi 36 prima rata -54€ dopo due anni 50.000 e 7 euro di prestito rimanente
		float basePartenza=(float) 19500;
		float prestitoRichiesto=0;
		float rataMensilePrestito=(float)0;
		int   fermaMesi=25;
		float percentualeRitiroMensile=(float) 0;
		float percentualeDepositoConto = (1-percentualeRitiroMensile);
		int   mesiRataPrestito=4;
		float totalePresitoDaRiagare=rataMensilePrestito*mesiRataPrestito;
		float prestitoResiduoDaRipagare=totalePresitoDaRiagare;
		float x=basePartenza+prestitoRichiesto;
		float partenzaIniziale=x;
		float guadagnoAlNettoMensile;
		int i=1;
		int j=1;
		boolean ritiroFissoSenzaPercentuale=false;
		float cifraDaRitirareSceltaMensile=100;
		boolean prestitoPagato=false;
		float guadagnoAnnuo=0;
		boolean ritiroSi=true;
		float ritiratoTotale=0;
		boolean membroPremium=true;
		float ricavoSulConto=0;
		float ricavoSulDeposito=0;
		while (x<=100000000 && fermaMesi>=i) {
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("Mese "+i+" Saldo iniziale: "+x);
			float guadagnoMensile=x/100*4;
			if (i>0 && ritiroSi) {
				x=x+guadagnoMensile*percentualeDepositoConto;
				ritiroSi=true;
				if (ritiroFissoSenzaPercentuale) {
					ricavoSulConto=cifraDaRitirareSceltaMensile;
					ricavoSulDeposito=guadagnoMensile-cifraDaRitirareSceltaMensile;
				}
				else {
					ricavoSulConto=guadagnoMensile*percentualeRitiroMensile;
					ricavoSulDeposito=guadagnoMensile*percentualeDepositoConto;
				}
				ritiratoTotale=ritiratoTotale+ricavoSulConto;
				guadagnoAlNettoMensile=ricavoSulConto-rataMensilePrestito;
				System.out.println();
				if (!prestitoPagato && prestitoRichiesto>0)
					System.out.println("Saldo dopo anni: "+i/12+" e mesi: "+i%12+" "+x+" Ritiro mensile "+(percentualeRitiroMensile*100)+"% "+ricavoSulConto+" - rataMensile: "+guadagnoAlNettoMensile);
				if (prestitoPagato)
					System.out.println("Saldo dopo anni: "+i/12+" e mesi: "+i%12+" "+x+" Ritiro mensile "+(percentualeRitiroMensile*100)+"%: "+((ricavoSulConto)));
				System.out.println("Ritirato totale: "+ritiratoTotale);
				System.out.println("Briete in euro mensili guadagnati: "+ricavoSulDeposito/2);
				prestitoResiduoDaRipagare=prestitoResiduoDaRipagare-rataMensilePrestito;
				System.out.println();
				System.out.println("Residuo prestito da pagare: "+prestitoResiduoDaRipagare);
				System.out.println("Rata mensile del prestito: "+rataMensilePrestito);
				System.out.println("Guadagnato totale sul deposito: "+(x-partenzaIniziale));
				System.out.println();
				System.out.println("Guadagno mensile lordo in percentuale sul deposito: "+(ricavoSulDeposito));
				System.out.println("Guadagno mensile lordo in percentuale sul conto: "+(ricavoSulConto));
				System.out.println("Guadagno mensile netto (tolta rata): "+(guadagnoAlNettoMensile));
				System.out.println();
				guadagnoAnnuo=guadagnoAnnuo+ricavoSulDeposito;
			}
			else {
				x=x+guadagnoMensile;
				System.out.println("Saldo dopo anni: "+i/12+" e mesi: "+i%12+" Guadagno mensile: "+guadagnoMensile);
				ritiroSi=true;
				guadagnoAnnuo=guadagnoAnnuo+guadagnoMensile;
			}			
			if (prestitoResiduoDaRipagare<=0) {
				System.out.println("PRESTITO RIPAGATO!!!!!!!!!!!!");
				prestitoPagato=true;
			}
			if (i%12==0 && membroPremium) {	
				System.out.println("Guadagno annuo: "+ guadagnoAnnuo+" Brite: "+guadagnoAnnuo/2+ " Totale: "+(x+(guadagnoAnnuo/2)));
				//x=x+guadagnoAnnuo/2;
				x=x-((x/100)*5);
				System.out.println("Pagamento Fi di ingresso al 5%: "+ x/100*5+ " Rimanenete: "+x);
				guadagnoAnnuo=0;
			}
			System.out.println(i+"° Mese Concluso "+"saldo dopo il mese: "+x);
			i++;
			
			System.out.println();	
		}
		System.out.println("Totale anni: "+i/12+" e mesi: "+i%12+" Base di partenza: "+basePartenza+" Ritirato totale: "+ ritiratoTotale+ " Saldo nel deposito: "+x);	
	}
}
