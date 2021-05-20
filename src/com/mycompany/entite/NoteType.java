package com.mycompany.entite;

public class NoteType {
    public String id , note ;

    public NoteType() {
    }

    public NoteType(String id, String note) {
        this.id = id;
        this.note = note;
    }

    @Override
    public String toString() {
        return "NoteType{" +
                "id='" + id + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
