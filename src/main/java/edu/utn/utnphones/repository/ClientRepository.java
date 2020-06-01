package edu.utn.utnphones.repository;

import edu.utn.utnphones.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Transactional
    @Procedure(procedureName = "sp_insert_user_client")
    public void addClient(@Param("pIdCity") Integer idCity, @Param("pFirstname") String firstname, @Param("pLastname") String lastname, @Param("pDni") String dni, @Param("pPwd") String pwd, @Param("pTypeLine") String typeLine );

}
