package br.com.ifpe.oxefood.api.cupom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.model.cupom.CupomDesconto;
import br.com.ifpe.oxefood.model.cupom.CupomDescontoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/cupom")
@CrossOrigin
public class CupomDescontoController {

@Autowired
private CupomDescontoService cupomDescontoService;

@ApiOperation(value = "Serviço responsável por salvar um cupom no sistema.")
@PostMapping
public ResponseEntity<CupomDesconto> save(@RequestBody CupomDescontoRequest request) {
    CupomDesconto cupom = cupomDescontoService.save(request.build());
    return new ResponseEntity<CupomDesconto>(cupom, HttpStatus.CREATED);
 }

@ApiOperation(value = "Serviço responsável por listar todos os cupons do sistema.")
@GetMapping
public List<CupomDesconto> findAll(){    

    return cupomDescontoService.findAll();
}

@ApiOperation(value = "Serviço responsável por obter um cupom referente ao Id passado na URL.")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna  o cupom."),
        @ApiResponse(code = 401, message = "Acesso não autorizado."),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
        @ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
        @ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
}) 
@GetMapping("/{id}")
public CupomDesconto findById(@PathVariable Long id) {

    return cupomDescontoService.findById(id);
}

@ApiOperation(value = "Serviço responsável por atualizar um cupom referente ao ID específico")
@PutMapping("/{id}")
public ResponseEntity<CupomDesconto> update(@PathVariable("id") Long id, @RequestBody CupomDescontoRequest request) {
        
    cupomDescontoService.update(id, request.build());
    return ResponseEntity.ok().build();
}

@ApiOperation(value = "Serviço responsável por deletar um cupom referente ao ID específico")
@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {

    cupomDescontoService.delete(id);
    return ResponseEntity.ok().build();
}

}
