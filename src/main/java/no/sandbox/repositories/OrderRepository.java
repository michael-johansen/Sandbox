package no.sandbox.repositories;

import no.sandbox.domain.LineOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<LineOrder, Long> {
}
