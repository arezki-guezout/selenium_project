Feature: ajouter une candidature
    Scenario: ajouter un candidat au recrutement
        Given je suis connecter au dashboard
        When je clique sur "Recruitment"
        Then le formulaire recrutement s affiche
        When je sais mes infos depuis un fichier JSON
        And je clique sur save
        Then je dois trouver mon utilisatuer dans la liste des utilisateurs