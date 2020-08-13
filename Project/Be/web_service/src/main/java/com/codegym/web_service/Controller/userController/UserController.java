package com.codegym.web_service.Controller.userController;

import com.codegym.dao.DTO.AddressCount;
import com.codegym.dao.DTO.AgeCount;
import com.codegym.dao.DTO.BuyCount;
import com.codegym.dao.entity.User;
import com.codegym.dao.repository.OrderRepository;
import com.codegym.dao.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(value = "*")
@Controller
class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderRepository orderRepository;
    //-------------------Retrieve All Customers--------------------------------------------------------

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Page<User>> listAllUserByDeleteFlagIsFalse(Pageable pageable) {
        Page<User> users = userService.findAllUserByDeleteFlagIsFalse(pageable);
        if (users.isEmpty()) {
            return new ResponseEntity<Page<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Page<User>>(users, HttpStatus.OK);
    }

    //-------------------Retrieve Single Customer--------------------------------------------------------

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getCustomer(@PathVariable("id") int id) {
        System.out.println("Fetching Customer with id " + id);
        User user = userService.findGetId(id);
        if (user == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //-------------------Create a Customer--------------------------------------------------------

    @RequestMapping(value = "/customers/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Customer " + user.getUserName());
        userService.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //-------------------Edit a Customer--------------------------------------------------------

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<User> updateCustomer(@PathVariable("id") int id, @RequestBody User user) {
        System.out.println("Updating Customer " + id);
        User currentUser = userService.findGetId(id);

        if (currentUser == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        currentUser.setId(user.getId());
        currentUser.setUserName(user.getUserName());
        currentUser.setBirthday(user.getBirthday());
        currentUser.setGender(user.getGender());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhone(user.getPhone());
        currentUser.setImageUrl(user.getImageUrl());

        userService.save(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    //------------------- Delete a Customer --------------------------------------------------------

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Customer with id " + id);

        User user = userService.findGetId(id);
        if (user == null) {

            System.out.println("Unable to delete Customer with id " + id + " not found");

            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    //-------------------Retrieve Single Customer--------------------------------------------------------

    @RequestMapping(value = "/customer-account/{accountName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getCustomerByAccount(@PathVariable("accountName") String accountName) {
        System.out.println("Fetching Customer with accountName " + accountName);
        User user = userService.findUserByAccountName(accountName);
        if (user == null) {
            System.out.println("Customer with accountName " + accountName + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @RequestMapping(value = "/addressCount", method = RequestMethod.GET)
    public ResponseEntity<List<AddressCount>> getCount() {
        List<AddressCount> addressCountList = userRepository.countAddress();
        if (addressCountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addressCountList, HttpStatus.OK);
    }

    @RequestMapping(value = "/ageCount", method = RequestMethod.GET)
    public ResponseEntity<List<AgeCount>> getCountAge() {
        List<AgeCount> addressCountList = userRepository.countAge();
        if (addressCountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addressCountList, HttpStatus.OK);
    }

    @RequestMapping(value = "/buyCounts", method = RequestMethod.GET)
    public ResponseEntity<List<BuyCount>> getCountBuy() {
        List<BuyCount> buyCounts = orderRepository.getBuyCounts();
        if (buyCounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(buyCounts, HttpStatus.OK);
    }
}
