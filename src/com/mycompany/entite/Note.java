package com.mycompany.entite;


public class Note {
    private String id, matiere_id, user_id, classe_id, note;

    public Note() {
    }

    public Note(String id, String matiere_id, String user_id, String classe_id, String note) {
        this.id = id;
        this.matiere_id = matiere_id;
        this.user_id = user_id;
        this.classe_id = classe_id;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public String getMatiere_id() {
        return matiere_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getClasse_id() {
        return classe_id;
    }

    public String getNote() {
        return note;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMatiere_id(String matiere_id) {
        this.matiere_id = matiere_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setClasse_id(String classe_id) {
        this.classe_id = classe_id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", matiere_id=" + matiere_id + ", user_id=" + user_id + ", classe_id=" + classe_id + ", note=" + note + '}';
    }

}
