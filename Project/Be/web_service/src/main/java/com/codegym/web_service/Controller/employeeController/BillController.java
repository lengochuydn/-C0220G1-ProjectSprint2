package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.*;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BillController {
    @Autowired
    private StorageLocationService storageLocationService;
    @Autowired
    private TransportationService transportationService;
    @Autowired
    private TypeBillService typeBillService;
    @Autowired
    private WareHouseService wareHouseService;
    @Autowired
    private PayService payService;
    @Autowired
    private BillService billService;
    @Autowired
    private DistributorService distributorService;

    //-------------------Find All StorageLocations--------------------------------------------------------

    @RequestMapping(value = "/storageLocations/", method = RequestMethod.GET)
    public ResponseEntity<List<StorageLocation>> listAllStorageLocations() {
        List<StorageLocation> storageLocations = storageLocationService.findAll();
        if (storageLocations.isEmpty()) {
            return new ResponseEntity<List<StorageLocation>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<StorageLocation>>(storageLocations, HttpStatus.OK);
    }
    //-------------------Find Single StorageLocation--------------------------------------------------------

    @RequestMapping(value = "/storageLocations/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StorageLocation> getStorageLocation(@PathVariable("id") Integer id) {
        System.out.println("Fetching StorageLocation with id " + id);
        StorageLocation storageLocation = storageLocationService.findById(id);
        if (storageLocation == null) {
            System.out.println("StorageLocation with id " + id + " not found");
            return new ResponseEntity<StorageLocation>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StorageLocation>(storageLocation, HttpStatus.OK);
    }
    //-------------------Find All Transportations--------------------------------------------------------

    @RequestMapping(value = "/transportations/", method = RequestMethod.GET)
    public ResponseEntity<List<Transportation>> listAllTransportations() {
        List<Transportation> transportation = transportationService.findAll();
        if (transportation.isEmpty()) {
            return new ResponseEntity<List<Transportation>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Transportation>>(transportation, HttpStatus.OK);
    }
    //-------------------Find Single Transportation--------------------------------------------------------

    @RequestMapping(value = "/transportations/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transportation> getTransportation(@PathVariable("id") Integer id) {
        System.out.println("Fetching Transportation with id " + id);
        Transportation transportation = transportationService.findById(id);
        if (transportation == null) {
            System.out.println("Transportation with id " + id + " not found");
            return new ResponseEntity<Transportation>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Transportation>(transportation, HttpStatus.OK);
    }
    //-------------------Find All TypeBills--------------------------------------------------------

    @RequestMapping(value = "/typeBills/", method = RequestMethod.GET)
    public ResponseEntity<List<TypeBill>> listAllTypeBills() {
        List<TypeBill> typeBills = typeBillService.findAll();
        if (typeBills.isEmpty()) {
            return new ResponseEntity<List<TypeBill>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<TypeBill>>(typeBills, HttpStatus.OK);
    }
    //-------------------Find Single TypeBill--------------------------------------------------------

    @RequestMapping(value = "/typeBills/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TypeBill> getTypeBill(@PathVariable("id") Integer id) {
        System.out.println("Fetching TypeBill with id " + id);
        TypeBill typeBill = typeBillService.findById(id);
        if (typeBill == null) {
            System.out.println("TypeBill with id " + id + " not found");
            return new ResponseEntity<TypeBill>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TypeBill>(typeBill, HttpStatus.OK);
    }
    //-------------------Find All wareHouses--------------------------------------------------------

    @RequestMapping(value = "/wareHouses/", method = RequestMethod.GET)
    public ResponseEntity<List<WareHouse>> listAllWareHouses() {
        List<WareHouse> wareHouses = wareHouseService.findAll();
        if (wareHouses.isEmpty()) {
            return new ResponseEntity<List<WareHouse>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<WareHouse>>(wareHouses, HttpStatus.OK);
    }
    //-------------------Find Single TypeBill--------------------------------------------------------

    @RequestMapping(value = "/wareHouses/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WareHouse> getWareHouse(@PathVariable("id") Integer id) {
        WareHouse wareHouse = wareHouseService.findById(id);
        if (wareHouse == null) {
            return new ResponseEntity<WareHouse>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<WareHouse>(wareHouse, HttpStatus.OK);
    }
    //-------------------Find All Pays--------------------------------------------------------

    @RequestMapping(value = "/pays/", method = RequestMethod.GET)
    public ResponseEntity<List<Pay>> listAllPays() {
        List<Pay> pays = payService.findAll();
        if (pays.isEmpty()) {
            return new ResponseEntity<List<Pay>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Pay>>(pays, HttpStatus.OK);
    }
    //-------------------Find Single Pay--------------------------------------------------------

    @RequestMapping(value = "/pays/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pay> getPay(@PathVariable("id") Integer id) {
        Pay pay = payService.findById(id);
        if (pay == null) {
            return new ResponseEntity<Pay>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pay>(pay, HttpStatus.OK);
    }


//-------------------Find All Bills--------------------------------------------------------

    @RequestMapping(value = "/bills", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> listAllBills() {
        List<Bill> bills = billService.findAllByDeleteFlagFalse();
        if (bills.isEmpty()) {
            return new ResponseEntity<List<Bill>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
    }

    //-------------------Create a Bill--------------------------------------------------------

    //    @PostMapping("/bills/create-bill")
//    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
//        billService.save(bill);
////        HttpHeaders headers = new HttpHeaders();
////        headers.setLocation(ucBuilder.path("/bill/{id}").buildAndExpand(bill.getId()).toUri());
//        return new ResponseEntity<Bill>(HttpStatus.OK);
//    }
    @RequestMapping(value = "/bills/create-bill", method = RequestMethod.POST)
    public ResponseEntity<Void> createBill(@RequestBody Bill bill, UriComponentsBuilder uriComponentsBuilder) {
        billService.save(bill);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.buildAndExpand(bill.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Bill--------------------------------------------------------

    @RequestMapping(value = "/bills/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bill> getBill(@PathVariable("id") Integer id) {
        Bill bill = billService.findById(id);
        if (bill == null) {
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Bill>(bill, HttpStatus.OK);
    }


    //------------------- Update a Bill --------------------------------------------------------

    @RequestMapping(value = "/bills/update/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Bill> updateBill(@PathVariable("id") Integer id, @RequestBody Bill bill) {

        Bill currentBill = billService.findById(id);
        if (currentBill == null) {
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }
        currentBill.setId(bill.getId());
        currentBill.setBillName(bill.getBillName());
        currentBill.setCreateDate(bill.getCreateDate());
        currentBill.setBillStatus(bill.getBillStatus());
        currentBill.setProcessingStatus(bill.getProcessingStatus());
        currentBill.setShippingStatus(bill.getShippingStatus());
        currentBill.setPaymentStatus(bill.getPaymentStatus());
        currentBill.setIdTypeBill(bill.getIdTypeBill());
        currentBill.setIdStorageLocation(bill.getIdStorageLocation());
        currentBill.setIdWareHouse(bill.getIdWareHouse());
        currentBill.setIdTransportation(bill.getIdTransportation());
        currentBill.setIdPay(bill.getIdPay());
        currentBill.setIdDistributor(bill.getIdDistributor());
        currentBill.setIdEmployee(bill.getIdEmployee());
        currentBill.setDeleteFlag(bill.getDeleteFlag());
        billService.save(currentBill);
        return new ResponseEntity<Bill>(currentBill, HttpStatus.OK);
    }

    //------------------- Delete a bill --------------------------------------------------------

    @RequestMapping(value = "/bills/delete/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Bill> deleteBill(@PathVariable("id") int id) {
        Bill currentBill = billService.findById(id);
        if (currentBill == null) {
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }
        currentBill.setDeleteFlag(true);
        billService.save(currentBill);
        return new ResponseEntity<Bill>(currentBill, HttpStatus.OK);
    }

    @RequestMapping(value = "/dist/list", method = RequestMethod.GET)
    public ResponseEntity<List<Distributor>> listAllDistributor() {
        List<Distributor> distributors = distributorService.findAll();
        if (distributors.isEmpty()) {
            return new ResponseEntity<List<Distributor>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Distributor>>(distributors, HttpStatus.OK);
    }
}
