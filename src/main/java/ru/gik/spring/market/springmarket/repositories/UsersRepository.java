package ru.gik.spring.market.springmarket.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gik.spring.market.springmarket.entities.User;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByPhone(String phone);

    boolean existsByPhone(String phone);
}
