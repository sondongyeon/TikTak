package project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project.domain.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    int countAllBy();
}
