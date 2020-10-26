package com.ecommerce.core.entrypoint;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.core.usecase.OrderUseCase;
import com.ecommerce.core.usecase.ProductUseCase;
import com.ecommerce.core.usecase.http.OrderHttp;
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
@RequestMapping("${ecommerce.api}/orders")
public class OrderEntrypoint {

    private final OrderUseCase useCase;

    @Autowired
    public OrderEntrypoint(final OrderUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping()
    public ResponseEntity<List<OrderHttp>> listAll() {
        return ResponseEntity.ok(useCase.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderHttp> findById(@PathVariable("id") Long id)
            throws HandlerValidationException {
        return ResponseEntity.ok(useCase.findById(id));
    }

    @PostMapping()
    public ResponseEntity<OrderHttp> save(@RequestBody OrderHttp orderHttp) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(useCase.saveUpdate(orderHttp, false));
    }

    @PutMapping()
    public ResponseEntity<OrderHttp> update(@RequestBody OrderHttp orderHttp) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.saveUpdate(orderHttp, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) throws HandlerValidationException {
        try {
            useCase.delete(id);
            return ResponseEntity.ok().body(true);
        } catch (Exception e) {
            log.error(Constants.msgNaoExcluido);
            throw new HandlerValidationException(Constants.msgNaoExcluido);
        }

    }
}
