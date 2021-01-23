
package com.example.kuiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccesBDInterne extends SQLiteOpenHelper {
    /**
     * Nom de la base de données interne
     */
    public final static String NOM_BASE = "Kuiz_database";

    /**
     * Version de la base de données interne
     */
    public final static int VERSION_BASE = 19;


    /**
     * Nom de la table profil
     */
    public final static String NOM_TABLE_PROFIL = "profil";
    /**
     * Nom du champ id_profil de la table des profils
     */
    public final static String PROFIL_ID_PROFIL = "profil_id_profil";
    /**
     * Nom du champ pseudo_profil de la table des profils
     */
    public final static String PROFIL_PSEUDO_PROFIL = "profil_pseudo_profil";


    /**
     * Nom de la table Quiz
     */
    public final static String NOM_TABLE_QUIZ = "quiz";
    /**
     * Nom du champ id_quiz de la table des quizs
     */
    public final static String QUIZ_ID_QUIZ = "quiz_id_quiz";
    /**
     * Nom du champ score_quiz de la table des quizs
     */
    public final static String QUIZ_SCORE_QUIZ = "quiz_score_quiz";
    /**
     * Nom du champ id_profil de la table des quizs, référence le même champ de la table des profils
     */
    public final static String QUIZ_ID_PROFIL = "quiz_id_profil";
    /**
     * Nom du champ id_difficulte de la table des quizs, référence le même champ de la table profil
     */
    public final static String QUIZ_ID_DIFFICULTE = "quiz_id_difficulte";


    /**
     * Nom de la table Contenir_Quiz_Question
     */
    public final static String NOM_TABLE_CONTENIR_QUIZ_QUESTION = "Contenir_Quiz_Question";
    /**
     * Nom du champ id_quiz de la table Contenir_Quiz_Question, référence le même champ de la table quiz
     */
    public final static String CONTENIR_QUIZ_QUESTION_ID_QUIZ = "Contenir_Quiz_Question_id_quiz";
    /**
     * Nom du champ id_question de la table Contenir_Quiz_Question, référence le même champ de la table question
     */
    public final static String CONTENIR_QUIZ_QUESTION_ID_QUESTION = "Contenir_Quiz_Question_id_question";


    /**
     * Nom de la table Difficulte
     */
    public final static String NOM_TABLE_DIFFICULTE = "difficulte";
    /**
     * Nom du champ id_difficulte de la table difficulte
     * */
    public final static String DIFFICULTE_ID_DIFFICULTE = "difficulte_id_difficulte";
    /**
     * Nom du champ temps_reponse de la table difficulte
     */
    public final static String DIFFICULTE_TEMPS_REPONSE = "difficulte_id_temp_reponse";


    /**
     * Nom de la table bonus
     */
    public final static String NOM_TABLE_BONUS = "bonus";
    /**
     * Nom du champ id_bonus de la table bonus
     */
    public final static String BONUS_ID_BONUS = "bonus_id_bonus";
    /**
     * Nom du champ intitule_bonus de la table bonus
     */
    public final static String BONUS_INTITULE_BONUS = "bonus_intitule_bonus";


    /**
     * Nom de la table Contenir_Difficulte_Bonus
     */
    public final static String NOM_TABLE_CONTENIR_DIFFICULTE_BONUS = "Contenir_Difficulte_Bonus";
    /**
     * Nom du champ id_difficulte de la table Contenir_Difficulte_Bonus, référence le même champ de la table difficulte
     */
    public final static String CONTENIR_DIFFICULTE_BONUS_ID_DIFFICULTE = "Contenir_Difficulte_Bonus_id_difficulte";
    /**
     * Nom du champ id_bonus de la table Contenir_Difficulte_Bonus, référence le même champ de la table bonus
     */
    public final static String CONTENIR_DIFFICULTE_BONUS_ID_BONUS = "Contenir_Difficulte_Bonus_id_bonus";


    /**
     * Nom de la table question
     */
    public final static String NOM_TABLE_QUESTION = "question";
    /**
     * Nom du champ id_question de la table question
     */
    public final static String QUESTION_ID_QUESTION = "question_id_question";
    /**
     * Nom du champ intitule_question de la table question
     */
    public final static String QUESTION_INTITULE_QUESTION = "question_intitule_question";


    /**
     * Nom de la table reponse
     */
    public final static String NOM_TABLE_REPONSE = "reponse";
    /**
     * Nom du champ id_reponse de la table reponse
     */
    public final static String REPONSE_ID_REPONSE = "reponse_id_reponse";
    /**
     * Nom du champ id_question de la table reponse, référence le même champ de la table question
     */
    public final static String REPONSE_ID_QUESTION = "reponse_id_question";
    /**
     * Nom du champ intitule_reponse de la table reponse
     */
    public final static String REPONSE_INTITULE_REPONSE = "reponse_intitule_reponse";
    /**
     * Nom du champ veracite_reponse de la table reponse
     */
    public final static String REPONSE_VERACITE_REPONSE = "reponse_veracite_reponse";


    /**
     * Nom de la table des themes
     */
    public final static String NOM_TABLE_THEME = "theme";
    /**
     * Nom du champ id_theme de la table des themes
     */
    public final static String THEME_ID_THEME = "theme_id_theme";
    /**
     * Nom du champ nom_theme de la table des themes
     */
    public final static String THEME_NOM_THEME = "theme_nom_theme";


    /**
     * Nom de la table Contenir_Theme_Question
     */
    public final static String NOM_TABLE_CONTENIR_THEME_QUESTION = "Contenir_Theme_Question";
    /**
     * Nom du champ id_theme de la table Contenir_Theme_Question, référence le même champ de la table theme
     */
    public final static String CONTENIR_THEME_QUESTION_ID_THEME = "Contenir_Theme_Question_id_theme";
    /**
     * Nom du champ id_question de la table Contenir_Theme_Question, référence le même champ de la table question
     */
    public final static String CONTENIR_THEME_QUESTION_ID_QUESTION = "Contenir_Theme_Question_id_question";


    /**
     * Constructeur de AccesBDInterne
     *
     * @param context activity parente
     */
    public AccesBDInterne(Context context) {
        super(context, AccesBDInterne.NOM_BASE, null, AccesBDInterne.VERSION_BASE);
    }


    /**
     * Code exécuté à la création de la base de données
     *
     * @param sqLiteDatabase base de données
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + AccesBDInterne.NOM_TABLE_PROFIL + "(" +
                AccesBDInterne.PROFIL_ID_PROFIL + " integer primary key autoincrement, " +
                AccesBDInterne.PROFIL_PSEUDO_PROFIL + " text not null " +
                "); ");

        sqLiteDatabase.execSQL("create table " + AccesBDInterne.NOM_TABLE_QUIZ + "(" +
                AccesBDInterne.QUIZ_ID_QUIZ + " integer primary key autoincrement, " +
                AccesBDInterne.QUIZ_SCORE_QUIZ + " integer not null, " +
                AccesBDInterne.QUIZ_ID_PROFIL + " integer not null, " +
                AccesBDInterne.QUIZ_ID_DIFFICULTE + " integer not null " +
                "); ");

        sqLiteDatabase.execSQL("create table " + AccesBDInterne.NOM_TABLE_CONTENIR_QUIZ_QUESTION + "(" +
                AccesBDInterne.CONTENIR_QUIZ_QUESTION_ID_QUESTION + " integer not null, " +
                AccesBDInterne.CONTENIR_QUIZ_QUESTION_ID_QUIZ + " integer not null " +
                "); ");

        sqLiteDatabase.execSQL("create table " + AccesBDInterne.NOM_TABLE_DIFFICULTE + "(" +
                AccesBDInterne.DIFFICULTE_ID_DIFFICULTE + " integer primary key autoincrement, " +
                AccesBDInterne.DIFFICULTE_TEMPS_REPONSE + " integer not null " +
                "); ");

        sqLiteDatabase.execSQL("create table " + AccesBDInterne.NOM_TABLE_BONUS + "(" +
                AccesBDInterne.BONUS_ID_BONUS + " integer primary key autoincrement, " +
                AccesBDInterne.BONUS_INTITULE_BONUS + " text not null " +
                "); ");

        sqLiteDatabase.execSQL("create table " + AccesBDInterne.NOM_TABLE_CONTENIR_DIFFICULTE_BONUS + "(" +
                AccesBDInterne.CONTENIR_DIFFICULTE_BONUS_ID_DIFFICULTE + " integer not null, " +
                AccesBDInterne.CONTENIR_DIFFICULTE_BONUS_ID_BONUS + " integer not null " +
                "); ");

        sqLiteDatabase.execSQL("create table " + AccesBDInterne.NOM_TABLE_QUESTION + "(" +
                AccesBDInterne.QUESTION_ID_QUESTION + " integer primary key autoincrement, " +
                AccesBDInterne.QUESTION_INTITULE_QUESTION + " text not null " +
                "); ");

        sqLiteDatabase.execSQL("create table " + AccesBDInterne.NOM_TABLE_REPONSE + "(" +
                AccesBDInterne.REPONSE_ID_REPONSE + " integer primary key autoincrement, " +
                AccesBDInterne.REPONSE_ID_QUESTION + " integer not null, " +
                AccesBDInterne.REPONSE_INTITULE_REPONSE + " text not null, " +
                AccesBDInterne.REPONSE_VERACITE_REPONSE + " boolean not null " +
                "); ");

        sqLiteDatabase.execSQL("create table " + AccesBDInterne.NOM_TABLE_THEME + "(" +
                AccesBDInterne.THEME_ID_THEME + " integer primary key autoincrement, " +
                AccesBDInterne.THEME_NOM_THEME + " text not null " +
                "); ");

        sqLiteDatabase.execSQL("create table " + AccesBDInterne.NOM_TABLE_CONTENIR_THEME_QUESTION + "(" +
                AccesBDInterne.CONTENIR_THEME_QUESTION_ID_THEME + " integer not null, " +
                AccesBDInterne.CONTENIR_THEME_QUESTION_ID_QUESTION + " integer not null " +
                "); ");


        remplis_bdd(sqLiteDatabase);
    }

    private void remplis_bdd(SQLiteDatabase sqLiteDatabase){
        //zone profils
        ContentValues tuple = new ContentValues();

        tuple.put(AccesBDInterne.PROFIL_ID_PROFIL, 0);
        tuple.put(AccesBDInterne.PROFIL_PSEUDO_PROFIL, "test");
        sqLiteDatabase.insert(AccesBDInterne.NOM_TABLE_PROFIL, null, tuple);

        tuple.put(AccesBDInterne.PROFIL_ID_PROFIL, 1);
        tuple.put(AccesBDInterne.PROFIL_PSEUDO_PROFIL, "test2");
        sqLiteDatabase.insert(AccesBDInterne.NOM_TABLE_PROFIL, null, tuple);

        //zone themes
        ajoute_theme(sqLiteDatabase,"Culture générale",0);
        //15 question(s)

        ajoute_theme(sqLiteDatabase,"Films",1);
        //15 question(s)

        ajoute_theme(sqLiteDatabase,"Sport",2);
        //16 question(s)

        ajoute_theme(sqLiteDatabase,"Science",3);
        //15 question(s)

        ajoute_theme(sqLiteDatabase,"Musique",4);
        //15 question(s)

        ajoute_theme(sqLiteDatabase,"Art",5);
        //15 question(s)

        ajoute_theme(sqLiteDatabase,"Géographie",6);
        //15 question(s)

        ajoute_theme(sqLiteDatabase,"Histoire",7);
        //15 question(s)


        //zone questions
        ajoute_question(sqLiteDatabase, "Quelle pièce est absolument à protéger dans un jeu d’échec ?", "Le roi", "La reine", "Le fou", "Le pion", 0, 0);
        ajoute_question(sqLiteDatabase, "Quel est la capitale de l’Australie ?", "Canberra", "Sydney", "Melbourne", "Perth", 1, 6);
        ajoute_question(sqLiteDatabase, "Quelle année a suivi l’an 1 avant JC ?", "L’an 1 après JC", "L'an 0", "L’an 2 avant JC", "L’an 2 après JC", 2, 7);
        ajoute_question(sqLiteDatabase, "Combien de nouvelles chaînes sont apparus grâce à la TNT ?", "12", "16", "8", "20", 3, 0);
        ajoute_question(sqLiteDatabase, "Combien y a-t-il de signes astrologiques chinois ?", "12", "14", "8", "10", 4, 0);
        ajoute_question(sqLiteDatabase, "Quel est le 2ème nom de l’hippocampe ?", "Le cheval de mer", "L'âne de mer", "Le cheval de terre", "Bob l'éponge", 5, 0);
        ajoute_question(sqLiteDatabase, "Combien de dieu trône a l’Olympe ?", "12", "8", "16", "20", 6, 7);
        ajoute_question(sqLiteDatabase, "Qu’appelle-t-on la canopée ?", "Le sommet d'une forêt", "Une sorte de bateau", "Un long siège à dossier", "Une espèce de champignon", 7, 0);
        ajoute_question(sqLiteDatabase, "Quelle est la voiture dans Retour vers le futur ?", "Delorean", "Twingo", "Limousine", "Multipla", 8, 1);
        ajoute_question(sqLiteDatabase, "Quel ville est surnommé « big Apple » aux USA ?", "New York", "Washington DC", "Los Angeles", "Chicago", 9, 6);
        ajoute_question(sqLiteDatabase, "De combien de syllabes est composé un alexandrin ?", "12", "10", "8", "6", 10, 5);
        ajoute_question(sqLiteDatabase, "Qui a écrit les misérables ?", "Victor Hugo", "Émile Zola", "Jules Verne", "Michel Vinciguerra", 11, 5);
        ajoute_question(sqLiteDatabase, "En quelle année le Titanic a-t-il coulé dans l'océan Atlantique le 15 avril, lors de son premier voyage au départ de Southampton?", "1912", "1750", "1812", "1950", 12, 7);
        ajoute_question(sqLiteDatabase, "Quel est le titre du premier film Carry On réalisé et sorti en 1958?", "Continuer sergent", "Le Cuirassé Potemkine", "La Ruée vers l'or", "La Passion de Jeanne d'Arc", 13, 1);
        ajoute_question(sqLiteDatabase, "Quel est le nom de la plus grande entreprise technologique de Corée du Sud?", "Samsung", "Huawei", "Apple", "Xiaomi", 14, 0);
        ajoute_question(sqLiteDatabase, "Quel chanteur a dirigé le groupe pop des années 1970 Showaddywaddy?", "Dave Bartram", "Patrick Abrial", "Salvatore Adamo", "Pierre Bachelet", 15, 4);
        ajoute_question(sqLiteDatabase, "Quel chef de télévision désormais célèbre a commencé à cuisiner à l'âge de huit ans dans le pub de ses parents, «The Cricketers», à Clavering, Essex?", "Jamie Oliver", "Gordon Ramsay", "Philippe Etchebest", "Massimo Bottura", 16, 0);
        ajoute_question(sqLiteDatabase, "Quel joueur de fléchettes néerlandais a remporté le Championnat du monde BDO 2012 au Lakeside Country Club, Frimley Green, le 15 janvier?", "Christian Kist", "Phil Taylor", "Raymond van Barneveld", "Michael van Gerwen", 17, 2);
        ajoute_question(sqLiteDatabase, "Quel métal a été découvert par Hans Christian Oersted en 1825?", "aluminium", "fer", "cuivre", "acier", 18, 3);
        ajoute_question(sqLiteDatabase, "Quelle est la capitale du Portugal?", "Lisbonne", "Madrid", "Rio de Janeiro", "Buenos Aires", 19, 6);
        ajoute_question(sqLiteDatabase, "Combien de respirations le corps humain prend-il quotidiennement?", "20 000", "5 000", "1 000 000", "50 000", 20, 3);
        ajoute_question(sqLiteDatabase, "Qui était premier ministre de la Grande-Bretagne de 1841 à 1846?", "Robert Peel", "Winston Churchill", "Anthony Eden", "Margaret Thatcher", 21, 7);
        ajoute_question(sqLiteDatabase, "Quel est le symbole chimique de l'argent?", "Ag", "Arg", "Agt", "Si", 22, 3);
        ajoute_question(sqLiteDatabase, "Quel est le nom complet de la poupée Barbie?", "Barbara Millicent Roberts", "Barbara Denver", "Barbara Marianna Handler", "Barbara Mattel", 23, 0);
        ajoute_question(sqLiteDatabase, "Quelle est la durée de vie d'une libellule?", "24 heures", "48 heures", "12 heures", "2 heures", 24, 0);
        ajoute_question(sqLiteDatabase, "Que signifie « procrastiner » ?", "Remettre à plus tard quelque chose", "Contredire systématiquement son interlocuteur", "Étudier beaucoup en vue d'un examen", "Parler dans un langage particulièrement vulgaire", 25, 0);
        ajoute_question(sqLiteDatabase, "Qui a inventé le stéthoscope ?", "René Laennec", "Alexander Flemming", "Claude Bernard", "Albert Einstein", 26, 3);
        ajoute_question(sqLiteDatabase, "Qui a inventé la pile électrique ?", "Volta", "Edison", "Becquerel", "Galvani", 27, 3);
        ajoute_question(sqLiteDatabase, "Quelle invention a été mise au point en 1890 par Edouard Branly ?", "La Télégraphie Sans Fil (T.S.F.)", "Un quai amovible, le fameux quai Branly", "La photographie sur papier", "Le téléscope", 28, 3);
        ajoute_question(sqLiteDatabase, "Quelle est la plus vieille centrale nucléaire de France ?", "Fessenheim", "Tricastin", "Cattenon", "Yèbles", 29, 3);
        ajoute_question(sqLiteDatabase, "Qui a mis au point le premier réfrigérateur?", "Charles Tellier", "Adolphe Frigidaire", "René Laennec", "Edouard Branly", 30, 3);
        ajoute_question(sqLiteDatabase, "Qu'est-ce qui est concerné par le théorème de Pythagore ?", "Le triangle", "Le carré", "Le cercle", "Le rectangle", 31, 3);
        ajoute_question(sqLiteDatabase, "Quel mathématicien grec a découvert les rudiments de la géométrie ?", "Euclide", "Pythagore", "Aristote", "Steve Jobs", 32, 3);
        ajoute_question(sqLiteDatabase, "Quel est le titre du second album studio de Stromae, sortie en 2013 ?", "Racine carrée", "Formidable", "Cheese", "Pourquoi pas moi", 33, 4);
        ajoute_question(sqLiteDatabase, "De quel pays, les Beatles sont-ils originaires ?", "Angleterre", "Irlande", "Allemagne", "États-Unis", 34, 4);
        ajoute_question(sqLiteDatabase, "Qui interprète le tube « Andalouse » ?", "Kendji Girac", "Keen' V", "Julien Doré", "Calogero", 35, 4);
        ajoute_question(sqLiteDatabase, "Quelle chanteuse a fait sensation en 2013 avec son tube « Wrecking Ball » ?", "Miley Cyrus", "Adele", "Taylor Swift", "Rihanna", 36, 4);
        ajoute_question(sqLiteDatabase, "Dans quelle émission télé, le groupe Fréro Delavega s’est-il fait connaître ?", "The Voice", "Nouvelle Star", "Star Academy", "Popstars", 37, 4);
        ajoute_question(sqLiteDatabase, "Quel DJ a créé l’événement avec son tube «Wake me up ! » ?", "Avicii", "Nicky Romero", "Calvin Harris", "David Guetta", 38, 4);
        ajoute_question(sqLiteDatabase, "Comment était surnommé Elvis Presley ?", "The King", "The Source", "The President", "The God", 39, 4);
        ajoute_question(sqLiteDatabase, "De quelle île provient le reggae ?", "Jamaïque", "Cuba", "Guadeloupe", "Bahamas", 40, 4);
        ajoute_question(sqLiteDatabase, "À quelle catégorie d'instruments, la guitare appartient-elle ?", "À cordes", "À vent", "À percussion", "De mesure", 41, 4);
        ajoute_question(sqLiteDatabase, "Combien de médailles olympique possède le nageur américain Michael Phelps ?", "28", "27", "25", "30", 42, 2);
        ajoute_question(sqLiteDatabase, "Combien de titres de Super Bowls ont été remportés par Tom Brady au cours de sa carrière ?", "6", "5", "7", "4", 43, 2);
        ajoute_question(sqLiteDatabase, "Quel record est le temps du record du monde sur 100m du sprinteur Usain Bolt ?", "9s58", "9s65", "9s98", "10s01", 44, 2);
        ajoute_question(sqLiteDatabase, "Quel transfert est le transfert le plus coûteux de l'histoire du football avec 222 millions d'euros ?", "Neymar", "Cristiano Ronaldo", "Mbappé", "Messi", 45, 2);
        ajoute_question(sqLiteDatabase, "Quel club de football est le plus titré en Ligue des Champions ?", "Real Madrid", "FC Barcelone", "Bayern Munich", "Manchester United", 46, 2);
        ajoute_question(sqLiteDatabase, "Quel joueur de tennis a remporté le tournoi de l'US Open 2020 chez les hommes ?", "Thiem", "Djokovic", "Nadal", "Zverev", 47, 2);
        ajoute_question(sqLiteDatabase, "Comment se nomme l'équipe de football américain de la ville de Philadelphie ?", "Les Eagles", "Les Rams", "Les Steelers", "Les Giants", 48, 2);
        ajoute_question(sqLiteDatabase, "En quelle année le footbaleur Zinédine Zidane a-t-il pris sa retraite ?", "2006", "2007", "2008", "2005", 49, 2);
        ajoute_question(sqLiteDatabase, "Quel célèbre basketteur américain est tragiquement décédé d'un accident d'hélicoptère en janvier 2020 ?", "Kobe Bryant", "LeBron James", "Kyrie Irving", "James Harden", 50, 2);
        ajoute_question(sqLiteDatabase, "En quoi consiste le floorball ?", "Du hockey en salle", "Du hockey sur gazon", "Du lancer de ballon", "Une sorte de curling", 51, 2);
        ajoute_question(sqLiteDatabase, "Laquelle de ces villes n'est pas une capitale?", "Almaty", "Skopje", "Tirana", "Noursoultan", 52, 6);
        ajoute_question(sqLiteDatabase, "Quelle langue parle-t-on au Chili?", "Espagnol", "Portugais", "Italien", "Anglais", 53, 6);
        ajoute_question(sqLiteDatabase, "Quel océan borde La Réunion?", "L'océan Indien", "L'océan Atlantique", "L'océan Pacifique", "La mer noire", 54, 6);
        ajoute_question(sqLiteDatabase, "Quel est le plus petit pays du monde?", "Vatican", "Russie", "Nauru", "Tuvalu", 55, 6);
        ajoute_question(sqLiteDatabase, "Quel est la capitale du Japon?", "Tokyo", "Kyoto", "Osaka", "Hiroshima", 56, 6);
        ajoute_question(sqLiteDatabase, "Dans quel pays se trouve la ville de Prague?", "Tchéquie", "Autriche", "Slovaquie", "Hongrie", 57, 6);
        ajoute_question(sqLiteDatabase, "Quel est la capitale du Canada?", "Ottawa", "Montréal", "Québec", "Toronto", 58, 6);
        ajoute_question(sqLiteDatabase, "En quelle année, le IIIème Reich a-t-il capitulé ?", "1945", "1942", "1939", "1918", 59, 7);
        ajoute_question(sqLiteDatabase, "En quelle année, l'archiduc François-Ferdinand a-t-il été assassiné ?", "1914", "1870", "1933", "1939", 60, 7);
        ajoute_question(sqLiteDatabase, "En quelle année ont eu lieu les attentats du 11 septembre ?", "2001", "2000", "2002", "2003", 61, 7);
        ajoute_question(sqLiteDatabase, "En quelle année, JFK a-t-il été assassiné ?", "1963", "1962", "1961", "1960", 62, 7);
        ajoute_question(sqLiteDatabase, "En quelle année, Jeanne d’Arc a-t-elle péri sur le bûcher ?", "1431", "1230", "1702", "1865", 63, 7);
        ajoute_question(sqLiteDatabase, "En quelle année, l’URSS a-t-elle commencé sa dislocation ?", "1990", "1975", "1945", "1918", 64, 7);
        ajoute_question(sqLiteDatabase, "Qui est le réalisateur du film Autant en emporte le vent, sorti en 1950 ?", "Victor Fleming", "Martin Scorsese", "Charlie Chaplin", "Frank Morgan", 65, 1);
        ajoute_question(sqLiteDatabase, "Quel film est le plus gros succès au box-office mondial depuis 2019 ?", "Avengers: Endgame", "Le Roi Lion", "Avatar", "Star Wars épisode IX", 66, 1);
        ajoute_question(sqLiteDatabase, "Quel acteur est la vedette de la franchise John Wick ?", "Keanu Reeves", "Matt Madon", "Jason Statham", "Tom Cruise", 67, 1);
        ajoute_question(sqLiteDatabase, "En quelle année est sorti le premier film de l'Univers Cinématographique de Marvel ?", "2008", "2010", "2011", "2012", 68, 1);
        ajoute_question(sqLiteDatabase, "Qui a réalisé le film Hannibal ?", "Ridley Scott", "Guillermo Del Toro", "John Carpenter", "Ken Loach", 69, 1);
        ajoute_question(sqLiteDatabase, "Quel acteur est la tête d'affiche du film Drive de Nicolas Winding Refn ?", "Ryan Gosling", "Ben Affleck", "Daniel Craig", "Matt Damon", 70, 1);
        ajoute_question(sqLiteDatabase, "Quelle actrice français incarnait Shosanna Dreyfus dans le film Inglorious Bastards de Quentin Tarantino ?", "Melanie Laurent", "Lea Sedoux", "Melanie Thierry", "Berenice Bejo", 71, 1);
        ajoute_question(sqLiteDatabase, "Qui a obtenu l’Oscar du meilleur acteur en 2000 pour son rôle dans American Beauty ?", "Kevin Spacey", "Russell Crowe", "Sean Penn", "Tom Hanks", 72, 1);
        ajoute_question(sqLiteDatabase, "À quel mouvement artistique appartenaient Rembrandt, Vermeer,  Velázquez ou Rubens ?", "Le baroque", "Le rococo", "Le pop art", "Le symbolisme", 73, 5);
        ajoute_question(sqLiteDatabase, "Qui a peint le célèbre tableau « La Nuit étoilée » ?", "Vincent Van Gogh", "Pablo Picasso", "Claude Monet", "Paul Cézanne", 74, 5);
        ajoute_question(sqLiteDatabase, "À quel peintre doit-on « La Liberté guidant le peuple » ?", "Delacroix", "David", "Géricault", "Rembrandt", 75, 5);
        ajoute_question(sqLiteDatabase, "Quel architecte conçut le phare d’Alexandrie ?", "Sostrate de Cnide", "Ictinos", "Pythéos de Priène", "Celer", 76, 5);
        ajoute_question(sqLiteDatabase, "Quel architecte a conçu les Halles de Paris ?", "Victor Baltard", "Blaise Pagan", "Antoine Le Pautre", "Christopher Wren", 77, 5);
        ajoute_question(sqLiteDatabase, "Quel architecte a construit la pyramide du Louvre ?", "Ieoh Ming Pei", "Jean-Michel Wilmotte", "Philippe Starck", "Oscar Niemeyer", 78, 5);
        ajoute_question(sqLiteDatabase, "Qui a peint « La Jeune Fille à la Perle » ?", "Vermeer", "Rembrandt", "De Staël", "Picabia", 79, 5);
        ajoute_question(sqLiteDatabase, "Dans quel musée est exposé le tableau « La Joconde » ?", "Le Louvre", "Le Musée d'Orsay", "L'Ermitage", "Le British Museum", 80, 5);
        ajoute_question(sqLiteDatabase, "Qui a inventé le cinéma ?", "Les frères Lumière", "Louis de Broglie", "Louis Blériot", "Nicéphore Niepce", 81, 1);
        ajoute_question(sqLiteDatabase, "Quel acteur a été classé comme l'acteur n°1 de la légende du cinéma hollywoodien ?", "Humphrey Bogart", "Fred Astaire", "Frank Sinatra", "Rock Hudson", 82, 1);
        ajoute_question(sqLiteDatabase, "Dans quel film retrouve-t-on la célèbre réplique « Tu les aimes mes cheveux, aussi ? Et mes cuisses ? Tu vois mon derrière dans la glace ? Tu les trouves jolies, mes fesses ? » ?", "Le mépris", "La grande bouffe", "I comme Icare", "Et Dieu ... créa la femme", 83, 1);
        ajoute_question(sqLiteDatabase, "Dans quel film retrouve-t-on la célèbre réplique « Vous avez de la pâte ? Vous avez du sucre ? Avec la pâte vous faites une crêpe et vous mettez du sucre dessus ! » ?", "Les bronzés font du ski", "Les Grandes vacances", "Le Grand blond avec la chaussure noire", "Rasta Rockett", 84, 1);
        ajoute_question(sqLiteDatabase, "Quel personnage est le principal antagoniste de la saga Harry Potter ?", "Voldemort", "Dumbledore", "Gollum", "Dark Vador", 85, 1);
        ajoute_question(sqLiteDatabase, "Combien font 4 x 8 ?", "32", "44", "20", "26", 86, 0);
        ajoute_question(sqLiteDatabase, "De quelle ville française le cannelé est-il une spécialité ?", "Bordeaux", "Toulouse", "Marseille", "Nantes", 87, 0);
        ajoute_question(sqLiteDatabase, "Que fête-t-on le 1er mai ?", "Le travail", "Le printemps", "Les mamans", "Le Beaujolais", 88, 0);
        ajoute_question(sqLiteDatabase, "Quel arbre produit la noix de pécan ?", "Le pacanier", "Le noisetier", "Le macadamia", "Le pécunier", 89, 0);
        ajoute_question(sqLiteDatabase, "Quel est le nom du principal indice boursier de la place de Paris ?", "Le CAC 40", "Le Dax", "Le Nifty", "Le Footsie", 90, 0);
        ajoute_question(sqLiteDatabase, "Dans quel sport s’est illustré Michael Jordan ?", "Basket", "Base-ball", "Football américain", "Hockey", 91, 2);
        ajoute_question(sqLiteDatabase, "Dans quel sport s’est illustré Bjorn Borg ?", "Tennis", "Football", "Escrime", "Golf", 92, 2);
        ajoute_question(sqLiteDatabase, "Dans quel sport s’est illustré Jean-Claude Killy ?", "Ski", "Voile", "Football", "Escrime", 93, 2);
        ajoute_question(sqLiteDatabase, "Dans quel sport s’est illustré Jesse Owens ?", "Athlétisme", "Basket-ball", "Tennis", "Cyclisme", 94, 2);
        ajoute_question(sqLiteDatabase, "Dans quel sport s’est illustré Sergei Bubka ?", "Athlétisme", "Formule 1", "Lutte", "Biathlon", 95, 2);
        ajoute_question(sqLiteDatabase, "Qu'est-ce que le diaphragme ?", "Un muscle", "Un os", "Une vertèbre", "Un tendon", 96, 3);
        ajoute_question(sqLiteDatabase, "Quel était le prénom de l’époux de Marie Curie ?", "Pierre", "Hector", "Louis", "Jean", 97, 3);
        ajoute_question(sqLiteDatabase, "Combien de satellites naturels gravitent autour de la Terre ?", "1", "2", "3", "4", 98, 3);
        ajoute_question(sqLiteDatabase, "Quelle est la somme des angles d’un triangle ?", "180°", "120°", "90°", "360°", 99, 3);
        ajoute_question(sqLiteDatabase, "Comment nomme-t-on l’effet d’une glycémie trop élevée ?", "L’hyperglycémie", "L’hypoglycémie", "Les triglycérides", "L’aérophagie", 100, 3);
        ajoute_question(sqLiteDatabase, "Quel groupe a interprété la chanson « C.R.E.A.M.» ?","Wu-Tang Clan","Black Eyed Peas","Public Enemy","Cypress Hill",101, 4);
        ajoute_question(sqLiteDatabase, "Quel titre Robin Thicke a-t-il interprété aux côtés de T.I et Pharell Williams ?","Blurred Lines","Everytime","Call On Me","I’m Yours",102, 4);
        ajoute_question(sqLiteDatabase, "Quelle chanteuse a pris « le large » dans l’une de ses chansons ?","Tal","Amel Bent","Vitaa","Alizée",103, 4);
        ajoute_question(sqLiteDatabase, "Quel groupe est formé par Thomas Bangalter et Guy-Manuel de Homem-Christo ?","Daft Punk","Poney Poney Run Run","Phoenix","Cocoon",104, 4);
        ajoute_question(sqLiteDatabase, "Qui est le grand « maître » des valses ?","Johann Strauss","Robert Schumann","Franz Schubert","Franz Liszt",105, 4);
        ajoute_question(sqLiteDatabase, "En quel matériau était fait le Colosse de Rhodes ?", "En bronze", "En étain", "En ivoire", "En marbre", 106, 5);
        ajoute_question(sqLiteDatabase, "À quelle hauteur culmine la tour Eiffel ?", "324 mètres", "366 mètres", "478 mètres", "212 mètres", 107, 5);
        ajoute_question(sqLiteDatabase, "À quel peintre doit-on l'œuvre très célèbre, intitulée « La Laitière » ?", "Johannes Vermeer", "Rembrandt", "Peter Paul Rubens", "Le Caravage", 108, 5);
        ajoute_question(sqLiteDatabase, "Quel peintre a représenté la fameuse « Fusillade du 3 mai » ?", "Goya", "David", "Delacroix", "El Gréco", 109, 5);
        ajoute_question(sqLiteDatabase, "Dans quelle ville européenne se trouve le musée Guggenheim ?", "Bilbao", "Berlin", "Londres", "Paris", 110, 5);
        ajoute_question(sqLiteDatabase, "Dans quelle ville se trouve la Statue de la Liberté ?", "New York", "Washington", "Chicago", "Los Angeles", 111, 6);
        ajoute_question(sqLiteDatabase, "Sur quel continent le Nil coule-t-il ?", "L’Afrique", "L’Océanie", "L’Europe", "L’Amérique", 112, 6);
        ajoute_question(sqLiteDatabase, "Dans quelle région se trouve le Mont-Saint-Michel ?", "Normandie", "Pays de la Loire", "Bretagne", "Aquitaine-Limousin-Poitou-Charentes", 113, 6);
        ajoute_question(sqLiteDatabase, "Avec quel pays, la France n'a-t-elle aucune frontière ?", "Autriche", "Belgique", "Suisse", "Espagne", 114, 6);
        ajoute_question(sqLiteDatabase, "Quel est le monument principal de la ville de Reims ?", "Sa cathédrale", "Sa boulangerie", "Son musée", "Son obélisque", 115, 6);
        ajoute_question(sqLiteDatabase, "À quel siècle se déroule la Révolution Française ?","XVIIIème","XIXème","XVIIème","XVIème",116, 7);
        ajoute_question(sqLiteDatabase, "Qui commanda l'armée des colons lors de la révolution américaine ?","George Washington","William Howe","Paul Revere","Israël Putnam",117, 7);
        ajoute_question(sqLiteDatabase, "Quel philosophe a écrit : 'Il faut éclairer chaque chose à la lumière de la raison' ?","Diderot","Voltaire","Rousseau","Montesquieu",118, 7);
        ajoute_question(sqLiteDatabase, "Qui a assassiné Henri IV ?","François Ravaillac","Jacques Clément","Robert-François Damiens","François Ravachol",119, 7);
        ajoute_question(sqLiteDatabase, "Comment se nomme l'alliance entre l'Allemagne, l'Autriche-Hongrie et l'Italie durant la Première Guerre mondiale ?"," La Triple Alliance","La Triple Entente","Le Triple Saut","Les Trois Frères",120, 7);
    }

    private void ajoute_theme(SQLiteDatabase sqLiteDatabase, String nom_theme, int id_theme) {
        ContentValues tuple = new ContentValues();
        tuple.put(AccesBDInterne.THEME_ID_THEME, id_theme);
        tuple.put(AccesBDInterne.THEME_NOM_THEME, nom_theme);
        sqLiteDatabase.insert(AccesBDInterne.NOM_TABLE_THEME, null, tuple);
    }

    private void ajoute_question(SQLiteDatabase sqLiteDatabase, String intitule_question, String reponse_a, String reponse_b, String reponse_c, String reponse_d, int id_question, int id_theme) {
        ContentValues tuple;

        tuple = new ContentValues();
        tuple.put(AccesBDInterne.QUESTION_ID_QUESTION, id_question);
        tuple.put(AccesBDInterne.QUESTION_INTITULE_QUESTION, intitule_question);
        sqLiteDatabase.insert(AccesBDInterne.NOM_TABLE_QUESTION, null, tuple);

        tuple = new ContentValues();
        tuple.put(AccesBDInterne.REPONSE_ID_QUESTION, id_question);
        tuple.put(AccesBDInterne.REPONSE_INTITULE_REPONSE, reponse_a);
        tuple.put(AccesBDInterne.REPONSE_VERACITE_REPONSE, true);
        sqLiteDatabase.insert(AccesBDInterne.NOM_TABLE_REPONSE, null, tuple);

        tuple.put(AccesBDInterne.REPONSE_ID_QUESTION, id_question);
        tuple.put(AccesBDInterne.REPONSE_INTITULE_REPONSE, reponse_b);
        tuple.put(AccesBDInterne.REPONSE_VERACITE_REPONSE, false);
        sqLiteDatabase.insert(AccesBDInterne.NOM_TABLE_REPONSE, null, tuple);

        tuple.put(AccesBDInterne.REPONSE_ID_QUESTION, id_question);
        tuple.put(AccesBDInterne.REPONSE_INTITULE_REPONSE, reponse_c);
        tuple.put(AccesBDInterne.REPONSE_VERACITE_REPONSE, false);
        sqLiteDatabase.insert(AccesBDInterne.NOM_TABLE_REPONSE, null, tuple);

        tuple.put(AccesBDInterne.REPONSE_ID_QUESTION, id_question);
        tuple.put(AccesBDInterne.REPONSE_INTITULE_REPONSE, reponse_d);
        tuple.put(AccesBDInterne.REPONSE_VERACITE_REPONSE, false);
        sqLiteDatabase.insert(AccesBDInterne.NOM_TABLE_REPONSE, null, tuple);

        tuple = new ContentValues();
        tuple.put(AccesBDInterne.CONTENIR_THEME_QUESTION_ID_QUESTION, id_question);
        tuple.put(AccesBDInterne.CONTENIR_THEME_QUESTION_ID_THEME, id_theme);
        sqLiteDatabase.insert(AccesBDInterne.NOM_TABLE_CONTENIR_THEME_QUESTION, null, tuple);
    }


    /**
     * Code exécuté au changement de version de la base de données
     *
     * @param sqLiteDatabase base de données
     * @param before ancienne version de la base
     * @param now nouvelle version de la base
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int before, int now) {
        sqLiteDatabase.execSQL("drop table if exists " + AccesBDInterne.NOM_TABLE_PROFIL);
        sqLiteDatabase.execSQL("drop table if exists " + AccesBDInterne.NOM_TABLE_QUIZ);
        sqLiteDatabase.execSQL("drop table if exists " + AccesBDInterne.NOM_TABLE_CONTENIR_QUIZ_QUESTION);
        sqLiteDatabase.execSQL("drop table if exists " + AccesBDInterne.NOM_TABLE_DIFFICULTE);
        sqLiteDatabase.execSQL("drop table if exists " + AccesBDInterne.NOM_TABLE_BONUS);
        sqLiteDatabase.execSQL("drop table if exists " + AccesBDInterne.NOM_TABLE_CONTENIR_DIFFICULTE_BONUS);
        sqLiteDatabase.execSQL("drop table if exists " + AccesBDInterne.NOM_TABLE_QUESTION);
        sqLiteDatabase.execSQL("drop table if exists " + AccesBDInterne.NOM_TABLE_REPONSE);
        sqLiteDatabase.execSQL("drop table if exists " + AccesBDInterne.NOM_TABLE_THEME);
        sqLiteDatabase.execSQL("drop table if exists " + AccesBDInterne.NOM_TABLE_CONTENIR_THEME_QUESTION);
        this.onCreate(sqLiteDatabase);
    }

}
