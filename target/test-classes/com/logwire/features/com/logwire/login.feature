Feature: connexion orangehrm

    # En tant qu'administrateur je veux pouvoir me connecter à mon dashboard via l'interface GUI
    # en spécifiant mon username et mon mot de passes
    
    Scenario: Connexion via IHM
        Given je suis sur la page de "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        When je saisi le username "Admin" et mot de passe "admin123"
        When je clique sur le bouton de connexion
        Then j accede a mon compte

    Scenario: Tentative de connexion incorrecte
        Given je suis sur la page de "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        When je saisi le username "Admin_wrong" et mot de passe "admin123"
        When je clique sur le bouton de connexion
        Then j obtient un message d erreur