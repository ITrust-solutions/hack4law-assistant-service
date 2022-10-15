package dev.itrust.assistantservice.controller;

import dev.itrust.assistantservice.hack4law_assistant_service.api.QueryUserApi;
import dev.itrust.assistantservice.hack4law_assistant_service.model.UserDto;
import dev.itrust.assistantservice.hack4law_assistant_service.model.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements QueryUserApi {
    @Override
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return ResponseEntity.ok(createTestUsers());
    }

    protected List<UserDto> createTestUsers() {
        return List.of(
                new UserDto().id(1).login("jan.adwokat").firstName("Jan").lastName("adwokat").email("jan.adwokat@p.pl").userRole(UserRole.ADWOKAT),
                new UserDto().id(2).login("jan.sedzia").firstName("Jan").lastName("sedzia").email("jan.sedzia@p.pl").userRole(UserRole.SEDZIA),
                new UserDto().id(3).login("jan.pracownik").firstName("Jan").lastName("pracownik").email("jan.pracownik@p.pl").userRole(UserRole.PRACOWNIK_KANCELARII),
                new UserDto().id(4).login("jan.prawnik").firstName("Jan").lastName("prawnik").email("jan.prawnik@p.pl").userRole(UserRole.PRAWNIK),
                new UserDto().id(5).login("jan.manager").firstName("Jan").lastName("manager").email("jan.manager@p.pl").userRole(UserRole.MANAGER),
                new UserDto().id(6).login("jan.specjalista").firstName("Jan").lastName("specjalista").email("jan.specjalista@p.pl").userRole(UserRole.SPECJALISTA),
                new UserDto().id(7).login("jan.radca").firstName("Jan").lastName("radca").email("jan.radca@p.pl").userRole(UserRole.RADCA)
        );
    }
}
