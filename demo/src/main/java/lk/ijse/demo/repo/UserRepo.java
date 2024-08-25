package lk.ijse.demo.repo;

import lk.ijse.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String> {
    @Query(value = "SELECT uid FROM User ORDER BY uid DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
