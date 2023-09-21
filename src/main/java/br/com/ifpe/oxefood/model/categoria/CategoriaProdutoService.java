package br.com.ifpe.oxefood.model.categoria;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProdutoService {
    
    @Autowired
    private CategoriaProdutoRepository repository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto CategoriaProduto){

        CategoriaProduto.setHabilitado(Boolean.TRUE);
        CategoriaProduto.setVersao(1L);
        CategoriaProduto.setDataCriacao(LocalDate.now());
        return repository.save(CategoriaProduto);

    }

    public List<CategoriaProduto> findAll() {
  
        return repository.findAll();
    }

    public CategoriaProduto findById(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, CategoriaProduto CategoriaProdutoAlterado) {
 
       CategoriaProduto CategoriaProduto = repository.findById(id).get();
       CategoriaProduto.setDescricao(CategoriaProdutoAlterado.getDescricao());
         
       CategoriaProduto.setVersao(CategoriaProduto.getVersao() + 1);
       repository.save(CategoriaProduto);
   }

    @Transactional
    public void delete(Long id) {

       CategoriaProduto CategoriaProduto = repository.findById(id).get();
       CategoriaProduto.setHabilitado(Boolean.FALSE);
       CategoriaProduto.setVersao(CategoriaProduto.getVersao() + 1);

       repository.save(CategoriaProduto);
   } 
}
