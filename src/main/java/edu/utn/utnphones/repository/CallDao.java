package edu.utn.utnphones.repository;

import edu.utn.utnphones.domain.Call;
import edu.utn.utnphones.projection.ClientCallsParcial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.orm.jpa.JpaSystemException;

import java.util.List;

public interface CallDao extends JpaRepository<Call, Long> {


    @Query(value = "select * from v_calls_parcial where phone_number = ?" , nativeQuery = true)
    public List<ClientCallsParcial> getCallsByPhone(@Param("telephone_number") String telephoneNumber )throws JpaSystemException;


}
