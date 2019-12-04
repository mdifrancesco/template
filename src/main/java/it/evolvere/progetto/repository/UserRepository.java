package it.evolvere.progetto.repository;


import it.evolvere.progetto.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

        /*

        User findByTagName (String tagName);
        User findClienteById(Long id);
        void deleteClienteById (Long id);

        */
}




