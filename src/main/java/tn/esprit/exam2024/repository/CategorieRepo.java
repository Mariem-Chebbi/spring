package tn.esprit.exam2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.exam2024.entities.Categorie;
import tn.esprit.exam2024.entities.Evenement;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie, Long> {
}
