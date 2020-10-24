package com.ecommerce.core.entrypoint;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.core.usecase.CustomerUseCase;
import com.ecommerce.core.usecase.http.CustomerHttp;
import com.ecommerce.dataprovider.constants.CustomerConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("${ecommerce.api}/customers")
public class CustomerEntrypoint {

    private final CustomerUseCase useCase;

    @Autowired
    public CustomerEntrypoint(final CustomerUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping()
    public ResponseEntity<List<CustomerHttp>> listAll() {
        return ResponseEntity.ok(useCase.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerHttp> findById(@PathVariable("id") Long id)
            throws HandlerValidationException {
        return ResponseEntity.ok(useCase.findById(id));
    }

    @PostMapping()
    public ResponseEntity<CustomerHttp> save(@RequestBody CustomerHttp customerHttp) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(useCase.saveUpdate(customerHttp, false));
    }

    @PutMapping()
    public ResponseEntity<CustomerHttp> update(@RequestBody CustomerHttp customerHttp) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.saveUpdate(customerHttp, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) throws HandlerValidationException {
        try {
            useCase.delete(id);
            return ResponseEntity.ok().body(true);
        } catch (Exception e) {
            log.error(CustomerConstants.msgClienteNaoExcluido);
            throw new HandlerValidationException(CustomerConstants.msgClienteNaoExcluido);
        }

    }
}
