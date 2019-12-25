import java.util.Scanner;

public class tris{
    public static void main(String[] args) {
    char[][] campo;
    campo = Modules.creaNuovaConfigurazione();
    Modules.stampaConfigurazioneDiGioco(campo);
    Scanner temp = new Scanner(System.in); 
    System.out.println("il campo è descritto dalle terzine \nQ W E, \nA S D, \nZ X C sulla tastiera");
    System.out.println("Vuoi eseguire la prima mossa? (y/N)");
    String t = temp.next();
    if (t.charAt(0) == 'y')
        Modules.mossaUtente(campo);
    Modules.stampaConfigurazioneDiGioco(campo);
    
    while(Modules.isFull(campo)==false && Modules.verificaVittoria(campo)==0){
        Modules.mossaComputer(campo);
        Modules.stampaConfigurazioneDiGioco(campo);
        if (Modules.isFull(campo)==false && Modules.verificaVittoria(campo)==0){
            Modules.mossaUtente(campo);
            Modules.stampaConfigurazioneDiGioco(campo);
        }
    }
    if (Modules.isFull(campo)==true && Modules.verificaVittoria(campo)==0)
        System.out.println("\nPATTA, non ha vinto nessuno");
    else if(Modules.verificaVittoria(campo)==1)
        System.out.println("\nCongratulazioni!!!!");
    else if(Modules.verificaVittoria(campo)==-1)
        System.out.println("\nIl computer ti ha stracciato!");
    Modules.stampaConfigurazioneDiGioco(campo);
    System.out.println('\n');
    }
}