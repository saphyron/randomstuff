package dk.howard.resource;

import dk.howard.domain.*;
import dk.howard.resource.dto.UserDTO;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class Mapper {

    Id mapId(String id) {
        return new Id(id);
    }

    Name mapName(String id) {
        return new Name(id);
    }

    Age mapAge(Integer id) { return new Age(id); }

    IDen mapIDen(String id) {return new IDen(id); }

    UserDTO map(User user) {
        return new UserDTO(user.getId().toString(), user.getName().getName(), user.getAge().getAge(), user.getIDen().getIDen());
    }
    List <UserDTO> map(List<User> users) {
        return users.stream().map(u->map(u)).collect(Collectors.toList());
    }
    User map(UserDTO userDTO) {
        return new User(new Id(userDTO.getId()),new Name(userDTO.getName()), new Age(userDTO.getAge()), new IDen(userDTO.getIDen()));
    }
}
