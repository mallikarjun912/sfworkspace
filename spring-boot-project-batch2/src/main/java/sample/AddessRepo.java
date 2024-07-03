package sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddessRepo extends JpaRepository<Address, Integer>{ 

}
