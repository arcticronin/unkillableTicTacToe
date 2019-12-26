import java.util.Scanner;

public class Modules{
    public static void stampaConfigurazioneDiGioco (char[][] conf) {
        System.out.println();
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(conf[i][j]);
                if (j<2)
                    System.out.print(" | ");
            }
            if (i<2){
                System.out.print('\n');
                System.out.print("---------");
                System.out.print('\n');
                }
            else 
                System.out.print('\n');
        }

    }
    
    public static char[][] creaNuovaConfigurazione(){
        char conf[][] = new char[3][3];
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                conf[i][j] = ' ';
        return conf;
    } 
    public static void mossaComputer(char[][] conf){ 
        //Blocco tripletta avversaria e crea tripletta propria 
        for (int i = 0; i<3; i++){ //controllo righe
            if (conf[i][0]==conf[i][1] && conf[i][0]!=' '){
                if (conf[i][2]==' '){
                    conf[i][2]='X';
                    return;
                }
            }
            else if (conf[i][0]==conf[i][2] && conf[i][0]!=' '){
                if (conf[i][1]==' '){
                    conf[i][1]='X';
                    return;
                }
            }
            else if (conf[i][1]==conf[i][2] && conf[i][1]!=' '){
                if (conf[i][0]==' '){
                    conf[i][0]='X';
                    return;
                }
            }
        }
        for (int i = 0; i<3; i++){ //controllo colonne
            if (conf[0][i]==conf[1][i] && conf[0][i]!=' '){
                if (conf[2][i]==' '){
                    conf[2][i]='X';
                    return;
                }
            }
            else if (conf[0][i]==conf[2][i] && conf[0][i]!=' '){
                if (conf[1][i]==' '){
                    conf[1][i]='X';
                    return;
                }
            }
            else if (conf[1][i]==conf[2][i] && conf[1][i]!=' '){
                if (conf[0][i]==' '){
                    conf[0][i]='X';
                    return;
                }
            }
        }
        //controllo le diagonali
        if (conf[1][1]=='O'){
            if (conf[0][0]=='O' && conf[2][2]==' '){
                conf[2][2]='X';
                return;
            }
            if (conf[2][2]=='O' && conf[0][0]==' '){
                conf[0][0]='X';
                return;
            }
            if (conf[0][2]=='O' && conf[2][0]==' '){
                conf[2][0]='X';
                return;
            }
            if (conf[2][0]=='O' && conf[0][2]==' '){
                conf[0][2]='X';
                return;
            }
        }
        //due coppie caselle adiacenti occupate (qualsiasi segno X o O paralleli o perpendicolari)

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (conf[i][j]!=' '){//una casella piena
                    if(j<2){//se sono nelle prime due colonne
                        if (conf[i][j+1]!=' '){//controllo la colonna successiva se è piena
                            if (i<2){//se sono nelle prime due righe
                                if (conf[i+1][j]==' '){//controllo le due caselle sotto, se sono vuote
                                    conf[i+1][j]='X';//segno su quella vuota
                                    return;
                                }
                                else if (conf[i+1][j+1]==' '){
                                    conf[i+1][j+1]='X';
                                    return;
                                }   
                            }
                            if(i>0){//se sono nelle ultime due righe
                                if (conf[i-1][j]==' '){//controllo le due caselle sopra, se sono vuote
                                    conf[i-1][j]='X';//segno su quella vuota
                                    return;
                                }
                                else if (conf[i-1][j+1]==' '){
                                    conf[i-1][j+1]='X';
                                    return;
                                }    
                            }
                        
                        }
                    }
                    if(i<2){//se sono nelle prime due righe
                        if (conf[i+1][j]!=' '){//controllo la riga successiva se è piena
                            if (j<2){//se sono nelle prime due colonne
                                if (conf[i][j+1]==' '){//controllo le due caselle a destra, se sono vuote
                                    conf[i][j+1]='X';//segno su quella vuota
                                    return;
                                }
                                else if (conf[i+1][j+1]==' '){
                                    conf[i+1][j+1]='X';
                                    return;
                                }   
                            }
                            if(j>0){//se sono nelle ultime due colonne
                                if (conf[i][j-1]==' '){//controllo le due caselle a sinistra, se sono vuote
                                    conf[i][j-1]='X';//segno su quella vuota
                                    return;
                                }
                                else if (conf[i+1][j-1]==' '){
                                    conf[i+1][j-1]='X';
                                    return;
                                }    
                            }
                        
                        }
                    }
                }

            }
        }
        //due coppie sulla diagonale
            if (conf[1][1]!=' '){ //se il centro è occupato
                for (int i=0; i<3; i++){
                    for (int j=0; j<3; j++){
                        if (i==0){//se sono sulla prima riga
                            if(j==0){//se sono sulla prima colonna
                                if (conf[i][j]!=' '){//se la casella non  vuota
                                    if (conf[i+1][j]==' '){//riempi quella sotto
                                        conf[i+1][j]='X';
                                        return;
                                    }
                                    else if(conf[i][j+1]==' '){//o quella a destra
                                        conf[i][j+1]='X';
                                        return;
                                    }
                                }
                            }
                            if(j==1){//seconda colonna
                                


                            }

                        }
                    }
                }
            }

                    
                    
                    
                       

        
        
        //controllo i 4 angoli
        
        
        
        
        /*if (conf[0][1]!=' '){
            if (conf[1][0]!=' ' && conf[0][0]==' '){
                conf[0][0]='X';
                return;
            }
            else if (conf[1][2]!=' ' && conf[0][2]==' '){
                    conf[0][2]='X';
                    return;
            }
        }
        if (conf[2][1]!=' '){
            if (conf[1][0]=='X' && conf[2][0]==' '){
                conf[2][0]='X';
                return;
            }
            else if (conf[1][2]!=' ' && conf[2][2]==' '){
                    conf[2][2]='X';
                    return;
            }
        //controllo il centrale 
        if (conf[0][0]!=' '){
            if (conf[1][0]!=' ' && conf[0][0]==' '){
                conf[0][0]='X';
                return;
            }
            else if (conf[1][2]!=' ' && conf[0][2]==' '){
                    conf[0][2]='X';
                    return;
            }
        }
        if (conf[2][1]!=' '){
            if (conf[1][0]=='X' && conf[2][0]==' '){
                conf[2][0]='X';
                return;
            }
            else if (conf[1][2]!=' ' && conf[2][2]==' '){
                    conf[2][2]='X';
                    return;
            }
        
        
        
        
        
        /*if (conf[0][1]=='X'){
            if (conf[1][0]=='X' && conf[0][0]==' '){
                conf[0][0]='X';
                return;
            }
            else if (conf[1][2]=='X' && conf[0][2]==' '){
                    conf[0][2]='X';
                    return;
            }
        }
        if (conf[2][1]=='X'){
            if (conf[1][0]=='X' && conf[2][0]==' '){
                conf[2][0]='X';
                return;
            }
            else if (conf[1][2]=='X' && conf[2][2]==' '){
                    conf[2][2]='X';
                    return;
            }
        }*/
        //occupo la centrale
        if (conf[1][1]==' '){
            conf[1][1]='X';
            return;
        }
        //occupo angolo opposto a avversario
        if (conf[0][0]=='O' && conf[2][2]==' '){
            conf[2][2]='X';
            return;
        }
        if (conf[0][2]=='O' && conf[2][0]==' '){
            conf[2][0]='X';
            return;
        }
        if (conf[2][0]=='O' && conf[0][2]==' '){
            conf[0][2]='X';
            return;
        }
        if (conf[2][2]=='O' && conf[0][0]==' '){
            conf[0][0]='X';
            return;
        }
        //occupo casella d'angolo vuota
        if (conf[0][0]==' '){
            conf[0][0]='X';
            return;
        }
        if (conf[0][2]==' '){
            conf[0][2]='X';
            return;
        }
        if (conf[2][0]==' '){
            conf[2][0]='X';
            return;
        }
        if (conf[2][2]==' '){
            conf[2][2]='X';
            return;
        }
        //occupo casella libera
        for (int i=0;i<3;i++)
            for(int j=0; j<3; j++){
                if (conf[i][j]==' '){
                    conf[i][j]='X';
                    return;
                }
            }
    
        


    }

    public static int verificaVittoria(char conf[][]){        
        for (int i = 0; i<3; i++){ //controllo righe
            if (conf[i][0]!=' '&&conf[i][0]==conf[i][1]&&conf[i][0]==conf[i][2]){
                if (conf[i][0]=='O')
                    return 1;
                else
                    return -1;
                }
          }
          for (int i = 0; i<3; i++){ //controllo colonne
            if (conf[0][i]!=' '&&conf[0][i]==conf[1][i]&&conf[0][i]==conf[2][i]){
                if (conf[0][i]=='O')
                    return 1;
                else
                    return -1;
                }
          }
          //controllo le diagonali
          if(conf[0][0]!=' '&&conf[0][0]==conf[1][1]&&conf[1][1]==conf[2][2]){
            if (conf[0][0]=='O')
                return 1;
            else
                return -1;
          }
          if(conf[0][2]!=' '&&conf[1][1]==conf[0][2]&&conf[2][0]==conf[1][1]){
            if (conf[0][2]=='O')
                return 1;
            else
                return -1;
          }      
        return 0;
    }

    public static void mossaUtente( char conf[][]){
        System.out.println("fai la tua mossa (QWE.ASD.ZXC)");
        boolean valid=false;
        Scanner temp = new Scanner(System.in);
        while (valid==false){
            
            int x=-1, y=-1;
            String ins = temp.next();
            switch(ins.charAt(0)){
                case 'q':
                case 'Q':
                    x=0;
                    y=0;
                break;
                case 'w':
                case 'W':
                    x=0;
                    y=1;
                break;
                case 'e':
                case 'E':
                    x=0;
                    y=2;
                break;
                case 'a':
                case 'A':
                    x=1;
                    y=0;
                break;
                case 's':
                case 'S':
                    x=1;
                    y=1;
                break;
                case 'd':
                case 'D':
                    x=1;
                    y=2;
                break;
                case 'z':
                case 'Z':
                    x=2;
                    y=0;
                break;
                case 'x':
                case 'X':
                    x=2;
                    y=1;
                break;
                case 'c':
                case 'C':
                    x=2;
                    y=2;
                break;
                default:
                break;
            }
            if (conf[x][y] == ' '){
                conf[x][y] = 'O';
                valid=true;
            }
            else {
                System.out.println("casella già occupata!!!");
                stampaConfigurazioneDiGioco(conf);
            }
        }

    }
    public static boolean isFull (char[][] conf){
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                if (conf[i][j]==' ')
                    return false;
        
        return true;
    }
}