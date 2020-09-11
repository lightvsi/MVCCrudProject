package ru.lightvsi.springmvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lightvsi.springmvcapp.entity.GoodDescription;

@Repository
public interface GoodDescriptionRepository extends JpaRepository<GoodDescription, String> {
}