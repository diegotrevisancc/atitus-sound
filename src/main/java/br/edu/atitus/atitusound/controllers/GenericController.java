package br.edu.atitus.atitusound.controllers;

import br.edu.atitus.atitusound.entities.GenericEntity;
import br.edu.atitus.atitusound.services.GenericService;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid Requisition or Validation Error",
        content = @Content, headers = @Header(name = "error", description = "error description", schema= @Schema(implementation =  String.class))),
        @ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN", content=@Content)
})
public abstract class GenericController<TEntidade extends GenericEntity, TDTO> {

    abstract GenericService<TEntidade> getService();

    abstract TEntidade convertDTO2Entity(TDTO dto);

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        try {
            getService().deleteById(uuid);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("error", e.getMessage()).build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<TEntidade> put(@PathVariable UUID uuid, @RequestBody TDTO dto) {
        TEntidade entidade = convertDTO2Entity(dto);
        entidade.setUuid(uuid);
        try {
            getService().save(entidade);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("error", e.getMessage()).build();
        }
        return ResponseEntity.ok(entidade);
    }

    @GetMapping("/{uuid}")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<TEntidade> getByUuid(@PathVariable UUID uuid) {
        Optional<TEntidade> entidade;
        try {
            entidade = getService().findById(uuid);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("error", e.getMessage()).build();
        }
        if (entidade.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(entidade.get());
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<Page<List<TEntidade>>> getAll(@PageableDefault(page = 0, size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
                                                        @RequestParam String name) {
        Page<List<TEntidade>> entidades;
        try {
            entidades = getService().findByNameContainingIgnoreCase(pageable, name);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("error", e.getMessage()).build();
        }
        return ResponseEntity.ok(entidades);
    }

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Object registered with success")
    public ResponseEntity<TEntidade> save(@RequestBody TDTO dto) {
        TEntidade entidade = convertDTO2Entity(dto);
        try {
            getService().save(entidade);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("error", e.getMessage()).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(entidade);
    }
}
