
public class MAIN {
	public static void main(String[] args) {	

		int i=1;
		int j=1;
		int mesiRataPrestito=82;
		int fermaMesi=60;
		int interesseMensile=4;
		float basePartenza=(float) 29000;
		float prestitoRichiesto=0;
		float rataMensilePrestito=(float)0;
		float percentualeRitiroMensile=(float)0;
		float percentualeDepositoConto = (1-percentualeRitiroMensile);
		float totalePresitoDaRiagare=rataMensilePrestito*mesiRataPrestito;
		float prestitoResiduoDaRipagare=totalePresitoDaRiagare;
		float x=basePartenza+prestitoRichiesto;
		float partenzaIniziale=x;
		float guadagnoAlNettoMensile;
		
		boolean ritiroFissoSenzaPercentuale=true;
		float cifraDaRitirareSceltaMensile=0;
		int quantiMesiRitiroFisso=38;
		
		boolean prestitoPagato=false;
		float guadagnoAnnuo=0;
		boolean ritiroSi=true;
		float ritiratoTotale=0;
		boolean membroPremium=true;
		float ricavoSulConto=0;
		float ricavoSulDeposito=0;

		float depositoTrading=2500;
		float percentualeGuadagnoMensileLordo=8;
		float guadagnoMensileLordoTrading=(depositoTrading/100)*percentualeGuadagnoMensileLordo;
		float tasse = guadagnoMensileLordoTrading/100*26;
		float provvigionePrimeClub = guadagnoMensileLordoTrading/100*20;
		float guadagnoNettoTrading = guadagnoMensileLordoTrading-tasse-provvigionePrimeClub;
		while (x<=100000 && fermaMesi>=i) {
			System.out.println("Deposito trading "+depositoTrading);
			System.out.println("Guadagno lordo "+(guadagnoMensileLordoTrading));
			System.out.println("Guadagno netto "+(guadagnoNettoTrading));
			
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("Mese "+i+" Saldo iniziale: "+x);
			float guadagnoMensile=x/100*interesseMensile;
			if (i>0 && ritiroSi) {
				ritiroSi=true;
				if (ritiroFissoSenzaPercentuale && quantiMesiRitiroFisso>=0) {
					ricavoSulConto=cifraDaRitirareSceltaMensile;
					ricavoSulDeposito=guadagnoMensile-cifraDaRitirareSceltaMensile;
					x=x+guadagnoMensile-cifraDaRitirareSceltaMensile;
					quantiMesiRitiroFisso--;
				}
				else {
					ricavoSulConto=guadagnoMensile*percentualeRitiroMensile;
					ricavoSulDeposito=guadagnoMensile*percentualeDepositoConto;
					x=x+guadagnoMensile*percentualeDepositoConto;
				}
				ritiratoTotale=ritiratoTotale+ricavoSulConto;
				guadagnoAlNettoMensile=ricavoSulConto-rataMensilePrestito;
				System.out.println();
				if (!prestitoPagato && prestitoRichiesto>0)
					System.out.println("Saldo dopo anni: "+i/12+" e mesi: "+i%12+" "+x+" Ritiro mensile "+(percentualeRitiroMensile*100)+"% "+ricavoSulConto+" - rataMensile: "+rataMensilePrestito+" = "+ (guadagnoAlNettoMensile));
				if (prestitoPagato)
					System.out.println("Saldo dopo anni: "+i/12+" e mesi: "+i%12+" "+x+" Ritiro mensile "+(percentualeRitiroMensile*100)+"%: "+((ricavoSulConto)));
				System.out.println("Ritirato totale: "+ritiratoTotale);
				System.out.println("Briete in euro mensili guadagnati: "+ricavoSulDeposito/2);
				System.out.println();
				System.out.println("Residuo prestito da pagare: "+prestitoResiduoDaRipagare);
				System.out.println("Rata mensile del prestito: "+rataMensilePrestito);
				System.out.println("Guadagnato totale sul deposito: "+(x-partenzaIniziale));
				System.out.println("Guadagnato totale sul conto: "+(ritiratoTotale));
				System.out.println();
				System.out.println("Guadagno mensile lordo in percentuale sul deposito: "+(ricavoSulDeposito));
				System.out.println("Guadagno mensile lordo in percentuale sul conto: "+(ricavoSulConto));
				System.out.println("Guadagno mensile netto (tolta rata): "+(guadagnoAlNettoMensile));
				System.out.println();
				prestitoResiduoDaRipagare=prestitoResiduoDaRipagare-rataMensilePrestito;
				guadagnoAnnuo=guadagnoAnnuo+ricavoSulDeposito;
			}
			else {
				x=x+guadagnoMensile;
				System.out.println("Saldo dopo anni: "+i/12+" e mesi: "+i%12+" Guadagno mensile: "+guadagnoMensile);
				ritiroSi=false;
				guadagnoAnnuo=guadagnoAnnuo+guadagnoMensile;
			}			
			if (prestitoResiduoDaRipagare<=0) {
				System.out.println("PRESTITO RIPAGATO!!!!!!!!!!!!");
				prestitoPagato=true;
			}
			if (i%12==0 && membroPremium) {	
				System.out.println("Guadagno annuo: "+ guadagnoAnnuo+" Brite: "+guadagnoAnnuo/8+ " Totale: "+(x+(guadagnoAnnuo/8)));
				x=x+1000;
				x=x-((x/100)*5);
				System.out.println("Pagamento Fi di ingresso al 5%: "+ x/100*5+ " Rimanenete: "+x);
				guadagnoAnnuo=0;
			}
			System.out.println(i+"° Mese Concluso "+"saldo dopo il mese: "+x);
			i++;
			
			System.out.println();	
		}
		System.out.println("Totale anni: "+i/12+" e mesi: "+i%12+" ,totale Mesi: "+i+" Base di partenza: "+basePartenza+" Ritirato totale: "+ ritiratoTotale+ " Saldo nel deposito: "+x);	
	}
}
