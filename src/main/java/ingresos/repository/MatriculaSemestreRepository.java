package ingresos.repository;

import ingresos.domain.MatriculaSemestre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the MatriculaSemestre entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MatriculaSemestreRepository extends ReactiveCrudRepository<MatriculaSemestre, Long>, MatriculaSemestreRepositoryInternal {
    @Query("SELECT * FROM matricula_semestre entity WHERE entity.matriculas_id = :id")
    Flux<MatriculaSemestre> findByMatriculaS(Long id);

    @Query("SELECT * FROM matricula_semestre entity WHERE entity.matriculas_id IS NULL")
    Flux<MatriculaSemestre> findAllWhereMatriculaSIsNull();

    @Query("SELECT * FROM matricula_semestre entity WHERE entity.matriculaa_id = :id")
    Flux<MatriculaSemestre> findByMatriculaA(Long id);

    @Query("SELECT * FROM matricula_semestre entity WHERE entity.matriculaa_id IS NULL")
    Flux<MatriculaSemestre> findAllWhereMatriculaAIsNull();

    @Override
    <S extends MatriculaSemestre> Mono<S> save(S entity);

    @Override
    Flux<MatriculaSemestre> findAll();

    @Override
    Mono<MatriculaSemestre> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface MatriculaSemestreRepositoryInternal {
    <S extends MatriculaSemestre> Mono<S> save(S entity);

    Flux<MatriculaSemestre> findAllBy(Pageable pageable);

    Flux<MatriculaSemestre> findAll();

    Mono<MatriculaSemestre> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<MatriculaSemestre> findAllBy(Pageable pageable, Criteria criteria);

}
