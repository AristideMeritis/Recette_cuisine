package cook.organization;

import cook.organization.dao.PersonneDao;

public class Main {
    public static void main(String[] args) {

        Personne user = new Utilisateur();
        user.setNom("Aristide");
        user.setEmail("aristide@yahoo.fr");

        PersonneDao perDao = new PersonneDao();

        perDao.save(user);
    }
}