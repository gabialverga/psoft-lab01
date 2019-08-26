package ufcg.psoft.entities;

import java.util.Objects;

public class Disciplina {
    private int id;
    private String nome;
    private double nota;

    public Disciplina (int id, String nome, double nota) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome () {
        return this.nome;
    }

    public double getNota () {
        return this.nota;
    }

    public int getId () {
        return this.id;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public void setNota (double nota) {
        this.nota = nota;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return id == that.id &&
                Double.compare(that.nota, nota) == 0 &&
                Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nota);
    }
}
