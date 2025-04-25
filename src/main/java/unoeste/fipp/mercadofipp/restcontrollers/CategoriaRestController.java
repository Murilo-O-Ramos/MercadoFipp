package unoeste.fipp.mercadofipp.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unoeste.fipp.mercadofipp.entities.Categoria;
import unoeste.fipp.mercadofipp.entities.Erro;
import unoeste.fipp.mercadofipp.services.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("apis/categoria")
public class CategoriaRestController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<Categoria> categoriaList = categoriaService.getAll();
        if(categoriaList != null && !categoriaList.isEmpty())
            return ResponseEntity.ok(categoriaList);
        return ResponseEntity.badRequest().body(new Erro("categorias não encontradas"));

    }
}
