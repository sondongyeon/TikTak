package project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project.domain.Member;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
