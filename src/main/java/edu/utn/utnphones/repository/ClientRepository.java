package edu.utn.utnphones.repository;

import edu.utn.utnphones.domain.Client;
import edu.utn.utnphones.projection.ClientCallsParcial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Transactional
    @Procedure(procedureName = "sp_insert_user_client")
    public void addClient(@Param("pIdCity") Integer idCity, @Param("pFirstname") String firstname, @Param("pLastname") String lastname, @Param("pDni") String dni, @Param("pPwd") String pwd, @Param("pTypeLine") String typeLine );


    @Query(value = "select *" + " from v_client_calls_parcial where dni = ? and call_price>=?", nativeQuery = true)
    public List<ClientCallsParcial> getClientCallsParcial(String dni,Double price);

    /*
    * En la bd cree una view v_client_calls_parcial
    * CREATE view v_client_calls_parcial
    as
    Select tel.phone_number as "Telephone Number", u.firstname, u.dni, ca.call_price
    from calls ca
    inner join telephone_lines tel on ca.id_telephone_origin = tel.id_telephone_line
    inner join users u on tel.id_user = u.id_user
    * */

}
