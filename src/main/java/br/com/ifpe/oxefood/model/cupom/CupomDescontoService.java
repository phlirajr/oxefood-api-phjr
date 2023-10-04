package br.com.ifpe.oxefood.model.cupom;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CupomDescontoService {

    @Autowired
    private CupomDescontoRepository repository;

    @Transactional
    public CupomDesconto save(CupomDesconto cupom) {
        cupom.setHabilitado(Boolean.TRUE);
        cupom.setVersao(1L);
        cupom.setDataCriacao(LocalDate.now());
        return repository.save(cupom);
    }

    public List<CupomDesconto>findAll(){
        return repository.findAll();
    }

    public CupomDesconto findById(long id){
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, CupomDesconto cupomAlterado) {
 
       CupomDesconto cupom = repository.findById(id).get();
       cupom.setCodigoDesconto(cupomAlterado.getCodigoDesconto());
       cupom.setPercentualDesconto(cupomAlterado.getPercentualDesconto());
       cupom.setValorDesconto(cupomAlterado.getValorDesconto());
       cupom.setValorMinimoPedidoPermitido(cupomAlterado.getValorMinimoPedidoPermitido());
       cupom.setQuantidadeMaximaUso(cupomAlterado.getQuantidadeMaximaUso());
       cupom.setInicioVigencia(cupomAlterado.getInicioVigencia());
       cupom.setFimVigencia(cupomAlterado.getFimVigencia());
         
       cupom.setVersao(cupom.getVersao() + 1);
       repository.save(cupom);
    }

    @Transactional
    public void delete(Long id) {

       CupomDesconto cupom = repository.findById(id).get();
       cupom.setHabilitado(Boolean.FALSE);
       cupom.setVersao(cupom.getVersao() + 1);

       repository.save(cupom);
    }

}
