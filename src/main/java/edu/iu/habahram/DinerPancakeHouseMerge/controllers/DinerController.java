package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/diner")
public class DinerController {

    DinerRepository repository;

    public DinerController(DinerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterator<MenuItem> get() {
        return repository.getTheMenuIterator();
    }
}
