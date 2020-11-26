package com.inss.imv.restapi.controller.command;

import com.inss.imv.restapi.entity.MasUser;
import com.inss.imv.restapi.repository.UserRepository;
import com.inss.imv.restapi.service.UserCommandService;
import com.inss.imv.restapi.util.FunctionalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "true")
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://hostname:port/api/
public class UserCommandController {

    // Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private UserCommandService userCommandService;

    @Autowired
    private UserRepository userRepository;

    /* Este método se hará cuando por una petición POST http://hostname:port/api/users/  */
    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MasUser> addUser(@RequestBody MasUser masUser) {
        //Este metodo guardará al usuario enviado
        userCommandService.save(masUser);

        return new ResponseEntity<>(masUser,HttpStatus.OK);
    }

    /* Este método se hará cuando por una petición PUT http://127.0.0.1:8080/api/users/  */
    @PutMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MasUser> updateUser(@RequestBody MasUser masUser) {
        userCommandService.save(masUser);

        //este metodo actualizará al usuario enviado
        return new ResponseEntity<>(masUser,HttpStatus.OK);
    }

    /* Este método se hará cuando por una petición DELETE http://127.0.0.1:8080/api/users/1  */
    @DeleteMapping(value = "users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deteteUser(@PathVariable final int userId) throws FunctionalException {
        userCommandService.deleteById(userId);

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        return ResponseEntity.accepted().build();
    }
}