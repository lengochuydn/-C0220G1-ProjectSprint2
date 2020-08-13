package com.codegym.web_service.Controller.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codegym.dao.DTO.AccessTimesDTO;
import com.codegym.dao.repository.AccessTimesRepository;


@RestController
@CrossOrigin(origins = "*")
public class AccessTimesController {
    @Autowired
    AccessTimesRepository accessTimesRepository;


    //    private void removeAccessTimesDTOList(){
//        accessTimesDTOList.remove(0);
//    }
    @RequestMapping(value = "/access-times", method = RequestMethod.GET)
    public ResponseEntity<List<AccessTimesDTO>> getCount() {
        List<AccessTimesDTO> accessTimesDTOList = accessTimesRepository.countAccessTimes();
        int sizeAccessTimesDTOList = accessTimesDTOList.size();
        for (int i = 0; i < sizeAccessTimesDTOList; i++) {
            if (sizeAccessTimesDTOList > 12) {
                accessTimesDTOList.remove(0);
                sizeAccessTimesDTOList--;
            } else {
                break;
            }
        }

        if (accessTimesDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accessTimesDTOList, HttpStatus.OK);
    }

}
