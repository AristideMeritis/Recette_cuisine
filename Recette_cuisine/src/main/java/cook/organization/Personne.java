package cook.organization;

 public abstract  class Personne {

     private String nom;
     private String email;
     private long id;

     private Status status;

     public String getNom() {
         return nom;
     }

     public void setNom(String nom) {
         this.nom = nom;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public long getId() {
         return id;
     }

     public void setId(long id) {
         this.id = id;
     }

     public Status getStatus() {
         return status;
     }

     public void setStatus(Status status) {
         this.status = status;
     }
 }
