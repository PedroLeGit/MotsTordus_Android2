<?php
/**
 * Created by Pedro.
 * User: Home
 * Date: 07/0562019
 * Time: 13:45
 */
include "functions.php";

//Contrôle de reception de paramètre
if(isset($_REQUEST["operation"])){

    //RECUPERATION PROFIL PAR ID
    if($_REQUEST["operation"]=="getQuestionByIdConcoursAndNbQuestion"){
      print("getQuestionByIdConcoursAndNbQuestion%");
        try{
            $id_concours = $_REQUEST["id_concours"];
            $nb_question = (int)$_REQUEST["nb_question"];
            $req = $pdo->prepare("SELECT questions.id_questions, libelle_questions, choix1_questions,
              choix2_questions, choix3_questions, solution_questions, libellecategorie_questions, indice_questions
              FROM questions, association_questionsconcours
              WHERE questions.id_questions = association_questionsconcours.id_questions
              AND association_questionsconcours.id_concours = ? ORDER BY questions.id_questions ASC ");

            $req->execute(array($id_concours));
            //Formalisation du retour avec gestion de l'erreur
            if($ligne = $req->fetchAll(PDO::FETCH_ASSOC)){
                print(json_encode($ligne[$nb_question]));
            }else{
                print("InvalidResearch");
            }
            //
        }catch (PDOException $e){
            print "Erreur !: ".$e->getMessage();
        }
    }

    //Aucune operation correspondante
    else{
        print "InvalidOperation";
    }
}

?>
