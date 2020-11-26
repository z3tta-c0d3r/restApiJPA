package com.inss.imv.restapi.controller.query;

import com.inss.imv.restapi.entity.MasUser;
import com.inss.imv.restapi.repository.UserRepository;
import com.inss.imv.restapi.service.UserCommandService;
import com.inss.imv.restapi.service.UserQueryService;
import com.inss.imv.restapi.util.FunctionalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "false")
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://hostname:port/api/
public class UserQueryController {

    // Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private UserRepository userRepository;

    /* Este método se hará cuando por una petición GET http://hostname:port/api//api/users */
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MasUser>> findAll(){
        return new ResponseEntity<>(userQueryService.findAll(), HttpStatus.OK);
    }

    /* Este método se hará cuando por una petición GET http://hostname:port/api/users/1 */
    @GetMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ConditionalOnProperty(
            name =  "feature-flags.old_feature",
            havingValue = "true"
    )
    public ResponseEntity<MasUser> getUser(@PathVariable int userId) throws FunctionalException{
        Optional<MasUser> masUser = userQueryService.findById(userId);

        //retornará al usuario con id pasado en la url
        return new ResponseEntity<>(masUser.get(),HttpStatus.OK);
    }
}