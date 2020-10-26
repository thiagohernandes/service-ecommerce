package com.ecommerce.core.entrypoint;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.core.usecase.CustomerUseCase;
import com.ecommerce.core.usecase.ProductUseCase;
import com.ecommerce.core.usecase.http.CustomerHttp;
import com.ecommerce.core.usecase.http.ProductHttp;
import com.ecommerce.dataprovider.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("${ecommerce.api}/products")
public class ProductEntrypoint {

    private final ProductUseCase useCase;

    @Autowired
    public ProductEntrypoint(final ProductUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping()
    public ResponseEntity<List<ProductHttp>> listAll() {
        return ResponseEntity.ok(useCase.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductHttp> findById(@PathVariable("id") Long id)
            throws HandlerValidationException {
        return ResponseEntity.ok(useCase.findById(id));
    }

    @PostMapping()
    public ResponseEntity<ProductHttp> save(@RequestBody ProductHttp productHttp) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(useCase.saveUpdate(productHttp, false));
    }

    @PutMapping()
    public ResponseEntity<ProductHttp> update(@RequestBody ProductHttp productHttp) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.saveUpdate(productHttp, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) throws HandlerValidationException {
        try {
            useCase.delete(id);
            return ResponseEntity.ok().body(true);
        } catch (Exception e) {
            log.error(Constants.msgNotDeleted);
            throw new HandlerValidationException(Constants.msgNotDeleted);
        }

    }
}
