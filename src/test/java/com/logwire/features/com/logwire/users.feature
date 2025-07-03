Feature: Ajout des utilisateurs
# En tant qu'utilisatuers connecté au dashborad, je voudrais inserer de nouveau utilisateurs
# sur la plateforme
    Scenario: ajouter un utilisateur avec des informations valides
        Given je suis connecter au dashboard
        When je clique sur "Admin"
        Then le formulaire addUser s affiche
        When je sais mes infos depuis un fichier CSV
        And je clique sur save
        Then je dois trouver mon utilisatuer dans la liste des utilisateurs

    

    