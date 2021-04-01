package ua.mainacademy.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.mainacademy.model.Item;
import ua.mainacademy.service.ItemService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("item")
@AllArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class ItemController {

    private final ItemService itemService;

    @PutMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        try {
            return new ResponseEntity<>(itemService.create(item), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Item> update(@RequestBody Item item) {
        try {
            return new ResponseEntity<>(itemService.update(item), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findOneById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(itemService.findOneById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteById(Integer id) {
        try {
            itemService.deleteById(id);
        } catch (Exception e) {
            log.warn("Delete method was processed with exception for item with id {}", id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
