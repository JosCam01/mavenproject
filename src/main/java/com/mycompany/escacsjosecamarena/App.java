package com.mycompany.escacsjosecamarena;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        //MESURES TAULER//
        int fil, col;
        fil = Teclat.lligInt("Disme les files del tauler (5/9)");
        col = Teclat.lligInt("Disme les columnes del tauler (5/9)");
        while (fil < 5 || fil > 9 && col < 5 || col > 9) {
            System.out.println("El numero de files i columnes deuen estar entre 5 i 9");
            fil = Teclat.lligInt("Disme les files del tauler (5/9)");
            col = Teclat.lligInt("Disme les columnes del tauler (5/9)");
        }
        //VARIABLES PER AL MENÚ//
        char[][] tauler = new char[fil][col];
        char pieza;
        int opcio;
        boolean eixir = true;
        char buit = '_';
        char mov = '#';
        //DEFINIR PEÇES//
        final char torre = 'T';
        final char alfil = 'A';
        final char dama = 'D';
        final char caballo = 'C';
        final char rey = 'R';
        //TAULER//
        System.out.print(" ");
        for (int i = 0; i < col; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        for (int i = 0; i < fil; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < col; j++) {
                tauler[i][j] = buit;
                System.out.print(tauler[i][j]);
                System.out.print(" ");
            }
            System.out.println(i);
        }
        System.out.print(" ");
        for (int i = 0; i < col; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        while (eixir) {

            //MENÚ//            
            System.out.println("----------------------------");
            System.out.println("--------MENÚ-AJEDRÉZ--------");
            System.out.println("----------------------------");
            System.out.println("1- Posar una peça.");
            System.out.println("2- Moviments d'una peça.");
            System.out.println("3- Esborrar moviments.");
            System.out.println("4- Esborrar tauler.");
            System.out.println("5- Eixir.");
            System.out.println("-----------------------------");

            opcio = Teclat.lligInt("Introdueix una opció: ");

            if (opcio == 1) {
                System.out.println("Torre: 'T'");
                System.out.println("Alfil: 'A'");
                System.out.println("Caball: 'C'");
                System.out.println("Dama: 'D'");
                System.out.println("Rey: 'R'");
                pieza = Teclat.lligChar("Quina peça vols afegir al tauler", "T" + "A" + "C" + "D" + "R");
                if (pieza == 'T' || pieza == 't') {
                    pieza = torre;
                }
                if (pieza == 'A' || pieza == 'a') {
                    pieza = alfil;
                }
                if (pieza == 'C' || pieza == 'c') {
                    pieza = caballo;
                }
                if (pieza == 'D' || pieza == 'd') {
                    pieza = dama;
                }
                if (pieza == 'R' || pieza == 'r') {
                    pieza = rey;
                }
                int pfil = Teclat.lligInt("En quina fila vols colocar la peça? ");
                int pcol = Teclat.lligInt("En quina columna vols colocar la peça? ");
                while (pfil > fil || pcol > col) {
                    System.out.println("Introdueix coordenades valides: ");
                    pfil = Teclat.lligInt("En quina fila vols colocar la peça? ");
                    pcol = Teclat.lligInt("En quina columna vols colocar la peça? ");
                }
                tauler[pfil][pcol] = pieza;
                System.out.println("");

            }
            if (opcio == 2) {
                System.out.println("------------------------------");
                System.out.println("-----Moviments-de-la-peça-----");
                System.out.println("------------------------------");
                int pfil = Teclat.lligInt("En quina fila esta la peça? ");
                int pcol = Teclat.lligInt("En quina columna esta la peça? ");
                //MOVIMENTS TORRE//
                if (tauler[pfil][pcol] == torre) {
                    //TORRE DALT//
                    for (int i = pfil - 1; i >= 0; i--) {
                        if (tauler[i][pcol] == buit || tauler[i][pcol] == mov) {
                            tauler[i][pcol] = mov;
                        } else {
                            break;
                        }
                    }
                    //TORRE BAIX//
                    for (int i = pfil + 1; i < fil; i++) {
                        if (tauler[i][pcol] == buit || tauler[i][pcol] == mov) {
                            tauler[i][pcol] = mov;
                        } else {
                            break;
                        }
                    }
                    //TORRE ESQUERRA//
                    for (int i = pcol - 1; i >= 0; i--) {
                        if (tauler[pfil][i] == buit || tauler[pfil][i] == mov) {
                            tauler[pfil][i] = mov;
                        } else {
                            break;
                        }
                    }
                    //TORRE DRETA//
                    for (int i = pcol + 1; i < col; i++) {
                        if (tauler[pfil][i] == buit || tauler[pfil][i] == mov) {
                            tauler[pfil][i] = mov;
                        } else {
                            break;
                        }
                    }
                }
                //MOVIMENTS ALFIL//
                if (tauler[pfil][pcol] == alfil) {
                    //ALFIL DALT-ESQUERRA//
                    for (int i = pfil - 1, x = pcol - 1; i >= 0 && x >= 0; i--, x--) {
                        if (tauler[i][x] == buit || tauler[i][x] == mov) {
                            tauler[i][x] = mov;
                        } else {
                            break;
                        }
                    }
                    //ALFIL DALT-DRETA//
                    for (int i = pfil - 1, x = pcol + 1; i >= 0 && x < col; i--, x++) {
                        if (tauler[i][x] == buit || tauler[i][x] == mov) {
                            tauler[i][x] = mov;
                        } else {
                            break;
                        }
                    }
                    //ALFIL BAIX-ESQUERRA//
                    for (int i = pfil + 1, x = pcol - 1; i < fil && x >= 0; i++, x--) {
                        if (tauler[i][x] == buit || tauler[i][x] == mov) {
                            tauler[i][x] = mov;
                        } else {
                            break;
                        }
                    }
                    //ALFIL BAIX-DRETA//
                    for (int i = pfil + 1, x = pcol + 1; i < fil && x < col; i++, x++) {
                        if (tauler[i][x] == buit || tauler[i][x] == mov) {
                            tauler[i][x] = mov;
                        } else {
                            break;
                        }
                    }
                }
                //MOVIMENTS DAMA//
                if (tauler[pfil][pcol] == dama) {
                    //DAMA DALT//
                    for (int i = pfil - 1; i >= 0; i--) {
                        if (tauler[i][pcol] == buit || tauler[i][pcol] == mov) {
                            tauler[i][pcol] = mov;
                        } else {
                            break;
                        }
                    }
                    //DAMA BAIX//
                    for (int i = pfil + 1; i < fil; i++) {
                        if (tauler[i][pcol] == buit || tauler[i][pcol] == mov) {
                            tauler[i][pcol] = mov;
                        } else {
                            break;
                        }
                    }
                    //DAMA ESQUERRA//
                    for (int i = pcol - 1; i >= 0; i--) {
                        if (tauler[pfil][i] == buit || tauler[pfil][i] == mov) {
                            tauler[pfil][i] = mov;
                        } else {
                            break;
                        }
                    }
                    //DAMA DRETA//
                    for (int i = pcol + 1; i < col; i++) {
                        if (tauler[pfil][i] == buit || tauler[pfil][i] == mov) {
                            tauler[pfil][i] = mov;
                        } else {
                            break;
                        }
                    }
                    //DAMA DALT-ESQUERRA//
                    for (int i = pfil - 1, x = pcol - 1; i >= 0 && x >= 0; i--, x--) {
                        if (tauler[i][x] == buit || tauler[i][x] == mov) {
                            tauler[i][x] = mov;
                        } else {
                            break;
                        }
                    }
                    //DAMA DALT-DRETA//
                    for (int i = pfil - 1, x = pcol + 1; i >= 0 && x < col; i--, x++) {
                        if (tauler[i][x] == buit || tauler[i][x] == mov) {
                            tauler[i][x] = mov;
                        } else {
                            break;
                        }
                    }
                    //DAMA BAIX-ESQUERRA//
                    for (int i = pfil + 1, x = pcol - 1; i < fil && x >= 0; i++, x--) {
                        if (tauler[i][x] == buit || tauler[i][x] == mov) {
                            tauler[i][x] = mov;
                        } else {
                            break;
                        }
                    }
                    //DAMA BAIX-DRETA//
                    for (int i = pfil + 1, x = pcol + 1; i < fil && x < col; i++, x++) {
                        if (tauler[i][x] == buit || tauler[i][x] == mov) {
                            tauler[i][x] = mov;
                        } else {
                            break;
                        }
                    }
                }
                //MOVIMENTS CAVALL//
                if (tauler[pfil][pcol] == caballo) {
                    if (pfil + 2 < fil && pcol + 1 < col) {
                        if (tauler[pfil + 2][pcol + 1] == mov || tauler[pfil + 2][pcol + 1] == buit) {
                            tauler[pfil + 2][pcol + 1] = mov;
                        }
                    }
                    if (pfil + 2 < fil && pcol - 1 >= 0) {
                        if (tauler[pfil + 2][pcol - 1] == mov || tauler[pfil + 2][pcol - 1] == buit) {
                            tauler[pfil + 2][pcol - 1] = mov;
                        }
                    }
                    if (pfil - 2 >= 0 && pcol + 1 < col) {
                        if (tauler[pfil - 2][pcol + 1] == mov || tauler[pfil - 2][pcol + 1] == buit) {
                            tauler[pfil - 2][pcol + 1] = mov;
                        }
                    }
                    if (pfil - 2 >= 0 && pcol - 1 >= 0) {
                        if (tauler[pfil - 2][pcol - 1] == mov || tauler[pfil - 2][pcol - 1] == buit) {
                            tauler[pfil - 2][pcol - 1] = mov;
                        }
                    }
                    if (pfil + 1 < fil && pcol + 2 < col) {
                        if (tauler[pfil + 1][pcol + 2] == mov || tauler[pfil + 1][pcol + 2] == buit) {
                            tauler[pfil + 1][pcol + 2] = mov;
                        }
                    }
                    if (pfil + 1 < fil && pcol - 2 >= 0) {
                        if (tauler[pfil + 1][pcol - 2] == mov || tauler[pfil + 1][pcol - 2] == buit) {
                            tauler[pfil + 1][pcol - 2] = mov;
                        }
                    }
                    if (pfil - 1 >= 0 && pcol + 2 < col) {
                        if (tauler[pfil - 1][pcol + 2] == mov || tauler[pfil - 1][pcol + 2] == buit) {
                            tauler[pfil - 1][pcol + 2] = mov;
                        }
                    }
                    if (pfil - 1 >= 0 && pcol - 2 >= 0) {
                        if (tauler[pfil - 1][pcol - 2] == mov || tauler[pfil - 1][pcol - 2] == buit) {
                            tauler[pfil - 1][pcol - 2] = mov;
                        }
                    }
                }
                //MOVIMENTS REY//
                if (tauler[pfil][pcol] == rey) {
                    if (pfil - 1 >= 0) {
                        if (tauler[pfil - 1][pcol] == mov || tauler[pfil - 1][pcol] == buit) {
                            tauler[pfil - 1][pcol] = mov;
                        }
                    }
                    if (pfil + 1 < fil) {
                        if (tauler[pfil + 1][pcol] == mov || tauler[pfil + 1][pcol] == buit) {
                            tauler[pfil + 1][pcol] = mov;
                        }
                    }
                    if (pcol - 1 >= 0) {
                        if (tauler[pfil][pcol - 1] == mov || tauler[pfil][pcol - 1] == buit) {
                            tauler[pfil][pcol - 1] = mov;
                        }
                    }
                    if (pcol + 1 < col) {
                        if (tauler[pfil][pcol + 1] == mov || tauler[pfil][pcol + 1] == buit) {
                            tauler[pfil][pcol + 1] = mov;
                        }
                    }
                    if (pfil - 1 >= 0 && pcol - 1 >= 0) {
                        if (tauler[pfil - 1][pcol - 1] == mov || tauler[pfil - 1][pcol - 1] == buit) {
                            tauler[pfil - 1][pcol - 1] = mov;
                        }
                    }
                    if (pfil - 1 >= 0 && pcol + 1 < col) {
                        if (tauler[pfil - 1][pcol + 1] == mov || tauler[pfil - 1][pcol + 1] == buit) {
                            tauler[pfil - 1][pcol + 1] = mov;
                        }
                    }
                    if (pfil + 1 < fil && pcol - 1 >= 0) {
                        if (tauler[pfil + 1][pcol - 1] == mov || tauler[pfil + 1][pcol - 1] == buit) {
                            tauler[pfil + 1][pcol - 1] = mov;
                        }
                    }
                    if (pfil + 1 < fil && pcol + 1 < col) {
                        if (tauler[pfil + 1][pcol + 1] == mov || tauler[pfil + 1][pcol + 1] == buit) {
                            tauler[pfil + 1][pcol + 1] = mov;
                        }
                    }
                }
            }
            if (opcio == 3) {
                for (int i = 0; i < fil; i++) {
                    for (int j = 0; j < col; j++) {
                        if (tauler[i][j] == mov) {
                            tauler[i][j] = buit;
                        }
                    }
                }
            }

            if (opcio == 4) {
                for (int i = 0; i < fil; i++) {
                    System.out.println("");
                    for (int j = 0; j < col; j++) {
                        tauler[i][j] = buit;
                        System.out.print(tauler[i][j]);
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
            if (opcio == 5) {
                char confeixida = Teclat.lligChar("Estas segur que que vols eixir? (S,s,N,n) ");
                if (confeixida == 'S' || confeixida == 's') {
                    eixir = false;
                }
            }
            System.out.print(" ");
            for (int i = 0; i < col; i++) {
                System.out.print(" " + i);
            }
            System.out.println("");
            for (int i = 0; i < fil; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < col; j++) {
                    System.out.print(tauler[i][j] + " ");
                }
                System.out.println(i);
            }
            System.out.print(" ");
            for (int i = 0; i < col; i++) {
                System.out.print(" " + i);
            }
            System.out.println("");
        }
    }
}
