<?php
/**
 * Created by PhpStorm.
 * User: Home
 * Date: 30/05/2019
 * Time: 18:34
 */
include "functions.php";

//Contrôle de reception de paramètre
if(isset($_REQUEST["operation"])){

    //RECUPERATION PROFIL PAR ID
    if($_REQUEST["operation"]=="getUtilisateurByID"){
        try{
            $id = $_REQUEST["id"];
            $req = $pdo->prepare("SELECT * FROM utilisateur WHERE id_utilisateur = ?");
            $req->execute(array($id));
            //Formalisation du retour avec gestion de l'erreur
            if($ligne = $req->fetch(PDO::FETCH_ASSOC)){
                print(json_encode($ligne));
            }else{
                print("InvalidResearch");
            }
            //
        }catch (PDOException $e){
            print "Erreur !: ".$e->getMessage();
        }
    }
    //VERIFACTION DE COMPTE
    elseif($_REQUEST["operation"]=="verificationLogin"){
        print "verificationLogin%";
        try{
            $login = $_REQUEST["login"];
            $mdp = $_REQUEST["mdp"];
            if (strpos($login, "@")){
                $req = $pdo->prepare("SELECT * FROM utilisateur WHERE email_utilisateur=? AND motdepasse_utilisateur=?");
            }elseif (!strpos($login,"@")){
                $req = $pdo->prepare("SELECT * FROM utilisateur WHERE pseudo_utilisateur=? AND motdepasse_utilisateur=?");
            }
            $req->execute(array($login,$mdp));
            $ligne = $req->fetchAll(PDO::FETCH_ASSOC);
            if (count($ligne)!=1){
                print "InvalidLogin";
            }else{
                print(json_encode($ligne));
            }

        }catch(PDOException $e){
            print "Erreur PDO !:".$e->getMessage();
        }
    }
    //RECUPERATION DU NOMBRES DE VICTOIRE ET PARTICIPATION PAR CATEGORIE
    elseif($_REQUEST["operation"]=="getVictoryAndParticipationByCategory"){
        print "getVictoryAndParticipationByCategory%";
        try{
            $categorie = $_REQUEST["categorie"];
            $userid = $_REQUEST["id_utilisateurs"];
            $req = $pdo->prepare("SELECT COUNT(*) AS paticipation FROM participation, concours WHERE utilisateurs_participations = ? AND categorie_concours = ? AND id_concours = concours_participations UNION SELECT COUNT(*) AS victory FROM concours WHERE gagnant_concours = ? AND categorie_concours = ?");
            $req->execute(array($userid, $categorie, $userid, $categorie));
            print(json_encode($req->fetchAll(PDO::FETCH_ASSOC)));
        }catch (PDOException $e){
            print "Erreur PDO !:".$e->getMessage();
        }
    }
    //Aucune operation correspondante
    else{
        print "InvalidOperation";
    }
}

?>