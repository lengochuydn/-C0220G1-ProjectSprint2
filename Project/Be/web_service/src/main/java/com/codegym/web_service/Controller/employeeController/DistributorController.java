package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.Distributor;
import com.codegym.dao.entity.TypeOfDistributor;
import com.codegym.service.DistributorService;
import com.codegym.service.TypeOfDistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DistributorController {
    @Autowired
    private TypeOfDistributorService typeOfDistributorService;
    @Autowired
    private DistributorService distributorService;

    @GetMapping("/distributor/{id}")
    public ResponseEntity<Distributor> findByID(@PathVariable Integer id) {
        System.out.println(id);
        Distributor distributor = this.distributorService.findById(id);
        if (distributor == null) {
            return new ResponseEntity<Distributor>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Distributor>(distributor, HttpStatus.OK);
    }

    @PostMapping("/distributor")
    public void save(@RequestBody Distributor distributor) {
        this.distributorService.save(distributor);
    }

    @GetMapping("/type_distributor/{name}")
    public TypeOfDistributor findByName(@PathVariable String name) {
        return this.typeOfDistributorService.findByName(name);
    }

    //Show List
//    @GetMapping("/distributor/list")
//    public ResponseEntity<List<Distributor>> listDistributors(){
//        List<Distributor> distributors  = distributorService.findAll();
//        if (distributors == null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(distributors, HttpStatus.OK);
//    }
    //Create distributor
    @PostMapping("/distributor/create")
    public ResponseEntity<Distributor> createDistributor(@RequestBody Distributor distributor) {
        distributorService.save(distributor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Show list ,paging and sorting
    @GetMapping(value = "/distributor/list", params = {"page", "size", "search"})
    public ResponseEntity<Page<Distributor>> getAll(@RequestParam("page") int page,
                                                    @RequestParam("size") int size,
                                                    @RequestParam("search") String search) {
        Page<Distributor> distributorPage = distributorService.pageFindAllSearchName(PageRequest.of(page, size), search,search);
        if (distributorPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(distributorPage, HttpStatus.OK);
    }


    @PostMapping("/distributor/deleteAll")
    public ResponseEntity<String> deleteALl(@RequestBody int[] deleteIdList) {
        System.out.println(deleteIdList.length);
        for (int item : deleteIdList) {
            this.distributorService.deleteById(item);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @RequestMapping(value = "/typeDis", method = RequestMethod.GET)
    public ResponseEntity<List<TypeOfDistributor>> listAllTypeOfDistributor() {
        List<TypeOfDistributor> type = typeOfDistributorService.findAll();
        if (type.isEmpty()) {
            return new ResponseEntity<List<TypeOfDistributor>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<TypeOfDistributor>>(type, HttpStatus.OK);
    }
}
