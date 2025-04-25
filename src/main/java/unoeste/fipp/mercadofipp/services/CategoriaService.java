package unoeste.fipp.mercadofipp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unoeste.fipp.mercadofipp.entities.Categoria;
import unoeste.fipp.mercadofipp.repositories.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public List<Categoria> getAll(){
        return categoriaRepository.findAll();
    }
    //inserir
    //alterar
    //getId
    //apagar
}
