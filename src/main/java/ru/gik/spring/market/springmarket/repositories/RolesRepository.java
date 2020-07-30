package ru.gik.spring.market.springmarket.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.gik.spring.market.springmarket.entities.Role;

public interface RolesRepository extends CrudRepository<Role, Long> {
    Role findOneByName(String name);
}
