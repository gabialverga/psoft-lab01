package ufcg.psoft.services;

import org.springframework.stereotype.Service;
import ufcg.psoft.entities.Disciplina;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplinaService {

    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Disciplina setNovaDisciplina(Disciplina novaDisciplina) {
        novaDisciplina.setId(disciplinas.size());
        this.disciplinas.add(novaDisciplina);
        return novaDisciplina;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public Disciplina getDisciplina(int id) {
        if(id >=0 && id < this.disciplinas.size()) {
            return this.disciplinas.get(id);
        }
        return null;
    }

    public Disciplina changeName(int id, Disciplina disciplina) {
        if(id >=0 && id < this.disciplinas.size()) {
            this.disciplinas.get(id).setNome(disciplina.getNome());
            return this.disciplinas.get(id);
        }
        return null;
    }

    public Disciplina changeNota(int id, Disciplina disciplina) {
        if(id >=0 && id < this.disciplinas.size()) {
            this.disciplinas.get(id).setNota(disciplina.getNota());
            return this.disciplinas.get(id);
        }
        return null;
    }

    public Disciplina delete(int id) {
        if(id >=0 && id < this.disciplinas.size()) {
            this.disciplinas.remove(id);
        }
        return null;
    }
}
