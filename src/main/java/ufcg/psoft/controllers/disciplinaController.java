package ufcg.psoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufcg.psoft.entities.Disciplina;
import ufcg.psoft.services.DisciplinaService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class disciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<Disciplina> setNovaDisciplina(@RequestBody Disciplina novaDisciplina) {
        return new ResponseEntity<Disciplina>(disciplinaService.setNovaDisciplina(novaDisciplina), HttpStatus.CREATED);
    }

    @RequestMapping("/v1/api/disciplinas")
    public ResponseEntity<List<Disciplina>> getDisciplinas() {
        return new ResponseEntity<List<Disciplina>>(disciplinaService.getDisciplinas(), HttpStatus.OK);
    }

    @RequestMapping(value = "/v1/api/disciplinas/{id}", method = GET)
    public ResponseEntity<Disciplina> getDisciplina(@PathVariable("id") Integer id) {
        Disciplina d = disciplinaService.getDisciplina(id);
        if(d == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Disciplina>(d, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/v1/api/disciplinas/{id}/nome", method = PUT)
    public ResponseEntity<Disciplina> changeName(@PathVariable("id") Integer id, @RequestBody Disciplina novaDisciplina) {
        Disciplina d = disciplinaService.changeName(id, novaDisciplina);
        if(d == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Disciplina>(d, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/v1/api/disciplinas/{id}/nota", method = PUT)
    public ResponseEntity<Disciplina> changeNota(@PathVariable("id") Integer id, @RequestBody Disciplina novaDisciplina) {
        Disciplina d = disciplinaService.changeNota(id, novaDisciplina);
        if(d == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Disciplina>(d, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/v1/api/disciplinas/{id}", method = DELETE)
    public ResponseEntity<Disciplina> changeNota(@PathVariable("id") Integer id) {
        Disciplina d = disciplinaService.delete(id);
        if(d == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Disciplina>(d, HttpStatus.OK);
        }
    }
}
