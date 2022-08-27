package ru.fiyf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiyf.entity.GeneralApplicationEntity;

/**
 * GeneralApplicationRepository.
 *
 * @author Aleksey_Brekhin
 * @since 8/18/21
 */
@Repository
public interface GeneralApplicationRepository extends JpaRepository<GeneralApplicationEntity, Long> {
}