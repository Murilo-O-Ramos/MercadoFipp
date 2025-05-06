package unoeste.fipp.mercadofipp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unoeste.fipp.mercadofipp.entities.Anuncio;
import unoeste.fipp.mercadofipp.repositories.AnuncioRepository;

import java.util.List;

@Service
public class AnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;
    public List<Anuncio> getAll(){
        return anuncioRepository.findAll();
    }
    public Anuncio add(Anuncio anuncio)
    {
        Anuncio novoAnuncio=anuncioRepository.save(anuncio);
        //agora grave as fotos na tabela de fotos
        //for...
        //   anuncioRepository.addFoto(....)
        return novoAnuncio;
    }

    public boolean addPergunta(Long id_anuncio, String texto){
        try{
            anuncioRepository.addPergunta(texto, id_anuncio);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
