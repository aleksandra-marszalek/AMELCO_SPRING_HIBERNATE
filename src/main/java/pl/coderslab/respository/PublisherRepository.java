package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    //
   // Wydawcę dla zadanego nipu
    //Wydawcę dla zadanego regonu.

    Publisher findOneByNip(String nip);
    Publisher findOneByRegon(String regon);




}
