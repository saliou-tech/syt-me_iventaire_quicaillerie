package quincaillerieuserservice.quincaillerieuserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quincaillerieuserservice.quincaillerieuserservice.Entity.UserDetail;

import java.util.Optional;
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetail, Long> {
    Optional<UserDetail> findByUserUsername(String username);

}
