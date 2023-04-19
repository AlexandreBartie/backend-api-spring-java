package br.com.bartie.app.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository<T extends ModelEntity> extends JpaRepository<T, Long> {}