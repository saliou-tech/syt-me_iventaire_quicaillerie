package quincaillerieuserservice.quincaillerieuserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quincaillerieuserservice.quincaillerieuserservice.Entity.Adress;
@Repository
public interface AddressRepository extends JpaRepository<Adress,Long> {
}
