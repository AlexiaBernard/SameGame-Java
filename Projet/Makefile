### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 


### REGLES ESSENTIELLES ###

Main.class : Main.java Fenetre.class
	${JC} ${JCFLAGS} Main.java

Fenetre.class : Fenetre.java Grille.class GrilleF.class Couleur.class
	${JC} ${JCFLAGS} Fenetre.java

Grille.class : Grille.java Bloc.class Surlignement.class Etoile.class Paliers.class
	${JC} ${JCFLAGS} Grille.java

GrilleF.class : GrilleF.java Bloc.class Surlignement.class Etoile.class Fenetre.java Paliers.class
	${JC} ${JCFLAGS} GrilleF.java

Surlignement.class : Surlignement.java Bloc.class Score.class Fin.class Etoile.class
	${JC} ${JCFLAGS} Surlignement.java

Bloc.class : Bloc.java 
	${JC} ${JCFLAGS} Bloc.java

Score.class : Score.java
	${JC} ${JCFLAGS} Score.java

Fin.class : Fin.java Fermeture.class Fenetre.java Etoile.class
	${JC} ${JCFLAGS} Fin.java

Fermeture.class : Fermeture.java
	${JC} ${JCFLAGS} Fermeture.java

Etoile.class : Etoile.java
	${JC} ${JCFLAGS} Etoile.java

Paliers.class : Paliers.java
	${JC} ${JCFLAGS} Paliers.java

Couleur.class : Couleur.java
	${JC} ${JCFLAGS} Couleur.java
	

### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean : 
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###