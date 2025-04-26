package unoeste.fipp.mercadofipp.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.mercadofipp.entities.Erro;
import unoeste.fipp.mercadofipp.entities.Usuario;
import unoeste.fipp.mercadofipp.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("apis/usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("")
    public ResponseEntity<Object> getAll(){
        List<Usuario> usuarioList = usuarioService.getAll();
        if(usuarioList != null && !usuarioList.isEmpty())
            return ResponseEntity.ok(usuarioList);
        return ResponseEntity.badRequest().body(new Erro("usuários não encontrados"));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuarioId(@PathVariable(name = "id") Long id){
        Usuario usuario = usuarioService.getById(id);
        if (usuario == null)
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Object> addUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.save(usuario);
        if (novoUsuario!= null)
            return ResponseEntity.ok(novoUsuario);
        return ResponseEntity.badRequest().body("erro ao cadastrar a novo usuario");
    }

    @PutMapping
    public ResponseEntity<Object> updateUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.save(usuario);
        if (novoUsuario != null)
            return ResponseEntity.ok(novoUsuario);
        return ResponseEntity.badRequest().body("erro ao alterar o usuário");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable Long id){
        if (usuarioService.delete(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.badRequest().body("Erro ao apagar usuário");
    }
}
